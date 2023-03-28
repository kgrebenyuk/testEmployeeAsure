package com.example.demowithtests.web.Passport;

import com.example.demowithtests.domain.Passport;
import com.example.demowithtests.dto.Passport.RequestDto;
import com.example.demowithtests.dto.Passport.ResponseDto;
import com.example.demowithtests.service.Passport.PassportService;
import com.example.demowithtests.util.mupstruct.PassportMapper;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Passport", description = "Passport API")
public class PassportControllerBean implements PassportController {
    private final PassportService passportService;
    private final PassportMapper passportMapper;


//    public PassportControllerBean(PassportService passportService, PassportMapper passportMapper) {
//        this.passportService = passportService;
//        this.passportMapper = passportMapper;
//    }

    @Override
    @PostMapping("/passports")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseDto savePassport(RequestDto requestDto) {
        log.info("----> savePassport - start: requestDto = {}", requestDto);
        Passport passport = passportMapper.fromRequestDto(requestDto);
        ResponseDto responseDto = passportMapper.toResponseDto(passportService.create(passport));
        log.info("----> savePassport - end: ResponseDto = {}", responseDto);
        return responseDto;
    }

    @Override
    @GetMapping(value = "/passports/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseDto getPassportById(Integer id) {
        log.info("----> getPassportById - start: id = {}", id);
        Passport passport = passportService.getById(id);
        ResponseDto responseDto = passportMapper.toResponseDto(passport);
        log.info("----> getPassportById - end: ResponseDto = {}", responseDto);
        return responseDto;
    }

    @Override
    @GetMapping("/passports")
    @ResponseStatus(HttpStatus.OK)
    public List<ResponseDto> getAllPassports() {
        log.info("----> getAllPassports() - start: ");
        List<Passport> passports = passportService.getAll();
        List<ResponseDto> responseDtos = new ArrayList<>();
        for (Passport passport : passports) {
            responseDtos.add(passportMapper.toResponseDto(passport));
        }
        log.info("----> getAllPassports()  - end:  responseDto =  {}", responseDtos);
        return responseDtos;
    }

    @Override
    //  @SneakyThrows
    @PutMapping("/passports/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseDto refreshPassport(Integer id, RequestDto  requestDto) {
        log.info("----> refreshPassport() - start: {}",  id ,  requestDto );
        ResponseDto responceDto = passportMapper.toResponseDto(
                passportService.updateById(id, passportMapper.fromRequestDto( requestDto)));
        log.info("----> refreshPassport() - start: {}",  id ,  responceDto );
        return responceDto;
    }
}
