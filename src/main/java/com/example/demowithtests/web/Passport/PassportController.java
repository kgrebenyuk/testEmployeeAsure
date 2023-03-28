package com.example.demowithtests.web.Passport;

import com.example.demowithtests.domain.Employee;
import com.example.demowithtests.dto.Passport.RequestDto;
import com.example.demowithtests.dto.Passport.ResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface PassportController {

    @Operation(summary = "This is endpoint to add a new passport.", description = "Create request to add a new passport.", tags = {"Passport"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "CREATED. The new passport is successfully created and added to database."),
            @ApiResponse(responseCode = "400", description = "Invalid input"),
            @ApiResponse(responseCode = "404", description = "NOT FOUND. Specified passport request not found."),
            @ApiResponse(responseCode = "409", description = "Employee already exists")})
    ResponseDto savePassport(@RequestBody RequestDto passportDto);


    @Operation(summary = "This is endpoint to get an passport by id.", description = "Create request to get an passport by id.", tags = {"Passport"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "SELECTED. The requested passport is successfully returned."),
            @ApiResponse(responseCode = "400", description = "Invalid input"),
            @ApiResponse(responseCode = "404", description = "NOT FOUND. Specified passport request not found.")})
    ResponseDto getPassportById(@PathVariable Integer id);

    @Operation(summary = "This is endpoint to get all passport.", description = "Create request to get all passport.", tags = {"Passport"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "SELECTED. The requested passport are returned successfully."),
            @ApiResponse(responseCode = "400", description = "Invalid input")})
    List<ResponseDto> getAllPassports();

    @Operation(summary = "This is endpoint to update an passport by id.", description = "Update request to update an passport by id.", tags = {"Passport"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "UPTADED. The requested passport is updateded successfully."),
            @ApiResponse(responseCode = "400", description = "Invalid input"),
            @ApiResponse(responseCode = "404", description = "NOT FOUND. Specified employee request not found.")})
    ResponseDto refreshPassport(Integer id, RequestDto  requestDto);

}
