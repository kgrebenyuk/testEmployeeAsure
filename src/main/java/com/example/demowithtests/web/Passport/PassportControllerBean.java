package com.example.demowithtests.web.Passport;

import com.example.demowithtests.domain.Passport;
import com.example.demowithtests.dto.Passport.PassportRequestDto;
import com.example.demowithtests.dto.Passport.PassportResponseDto;
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

    @Override
    @PostMapping("/passports")
    @ResponseStatus(HttpStatus.CREATED)
    public PassportResponseDto savePassport(PassportRequestDto passportRequestDto) {
        log.info("----> savePassport - start: passportRequestDto = {}", passportRequestDto);
        Passport passport = passportMapper.fromRequestDto(passportRequestDto);
        PassportResponseDto passportResponseDto = passportMapper.toResponseDto(passportService.create(passport));
        log.info("----> savePassport - end: PassportResponseDto = {}", passportResponseDto);
        return passportResponseDto;
    }

    @Override
    @GetMapping(value = "/passports/{id}")
    @ResponseStatus(HttpStatus.OK)
    public PassportResponseDto getPassportById(Integer id) {
        log.info("----> getPassportById - start: id = {}", id);
        Passport passport = passportService.getById(id);
        PassportResponseDto passportResponseDto = passportMapper.toResponseDto(passport);
        log.info("----> getPassportById - end: PassportResponseDto = {}", passportResponseDto);
        return passportResponseDto;
    }

    @Override
    @GetMapping("/passports")
    @ResponseStatus(HttpStatus.OK)
    public List<PassportResponseDto> getAllPassports() {
        log.info("----> getAllPassports() - start: ");
        List<Passport> passports = passportService.getAll();
        List<PassportResponseDto> PassportResponseDtos = new ArrayList<>();
        for (Passport passport : passports) {
            PassportResponseDtos.add(passportMapper.toResponseDto(passport));
        }
        log.info("----> getAllPassports()  - end:  responseDto =  {}", PassportResponseDtos);
        return PassportResponseDtos;
    }

    @Override
    @PutMapping("/passports/{id}")
    @ResponseStatus(HttpStatus.OK)
    public PassportResponseDto refreshPassport(Integer id, PassportRequestDto passportRequestDto) {
        log.info("----> refreshPassport() - start: {}", id, passportRequestDto);
        PassportResponseDto responceDto = passportMapper.toResponseDto(
                passportService.updateById(id, passportMapper.fromRequestDto(passportRequestDto)));
        log.info("----> refreshPassport() - start: {}", id, responceDto);
        return responceDto;
    }

}
