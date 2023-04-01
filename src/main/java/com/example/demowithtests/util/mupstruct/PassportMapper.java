package com.example.demowithtests.util.mupstruct;

import com.example.demowithtests.domain.Passport;
import com.example.demowithtests.dto.Passport.PassportRequestDto;
import com.example.demowithtests.dto.Passport.PassportResponseDto;

@org.mapstruct.Mapper(componentModel = "spring")
public interface PassportMapper {

//    @Mapping(target="name", source="employeeDto.name")
//    @Mapping(target="country", source="employeeDto.country")
//    @Mapping(target="email", source="employeeDto.email")
//    @Mapping(target="fotos", source="employeeDto.fotos")
//    @Mapping(target="addresses", source="employeeDto.addresses")
//    @Mapping(target="isDeleted", source="employeeDto.isDeleted")
    Passport fromRequestDto(PassportRequestDto passportRequestDto);

//    @Mapping(target="name", source="employee.name")
//    @Mapping(target="country", source="employee.country")
//    @Mapping(target="email", source="employee.email")
//    @Mapping(target="fotos", source="employee.fotos")
//    @Mapping(target="addresses", source="employee.addresses")
    PassportRequestDto passportToRequestDto(Passport passport);

//    @Mapping(target="name", source="employee.name")
//    @Mapping(target="email", source="employee.email")
    PassportResponseDto toResponseDto(Passport passport);

//    @Mapping(target="name", source="employeeReadDto.name")
//    @Mapping(target="email", source="employeeReadDto.email")
    Passport responseDtoToPassport(PassportResponseDto passportResponseDto);
}
