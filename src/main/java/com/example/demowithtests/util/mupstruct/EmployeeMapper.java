package com.example.demowithtests.util.mupstruct;

import com.example.demowithtests.domain.Employee;
import com.example.demowithtests.dto.Employee.EmployeeRequestDto;
import com.example.demowithtests.dto.Employee.EmployeeResponseDto;
import org.mapstruct.Mapping;

@org.mapstruct.Mapper(componentModel = "spring")
public interface EmployeeMapper {

    //    @Mapping(target="name", source="employeeRequestDto.name")
//    @Mapping(target="country", source="employeeRequestDto.country")
//    @Mapping(target="email", source="employeeRequestDto.email")
//    @Mapping(target="fotos", source="employeeRequestDto.fotos")
//    @Mapping(target="addresses", source="employeeRequestDto.addresses")
//    @Mapping(target="isDeleted", source="employeeRequestDto.isDeleted")
    Employee employeeDtoToEmployee(EmployeeRequestDto employeeRequestDto);

    //    @Mapping(target="name", source="employee.name")
//    @Mapping(target="country", source="employee.country")
//    @Mapping(target="email", source="employee.email")
//    @Mapping(target="fotos", source="employee.fotos")
//    @Mapping(target="addresses", source="employee.addresses")
    EmployeeRequestDto employeeToEmployeeDto(Employee employee);

//    @Mapping(target = "name", source = "employee.name")
//    @Mapping(target = "email", source = "employee.email")
//    @Mapping(target = "fotos", source = "employee.fotos")
//    @Mapping(target = "addresses", source = "employee.addresses")
//    @Mapping(target = "passport", source = "employee.passport")
    EmployeeResponseDto employeeToEmployeeReadDto(Employee employee);

    //    @Mapping(target="name", source="employeeResponseDto.name")
//    @Mapping(target="email", source="employeeResponseDto.email")
    Employee employeeReadDtoToEmployee(EmployeeResponseDto employeeResponseDto);
}
