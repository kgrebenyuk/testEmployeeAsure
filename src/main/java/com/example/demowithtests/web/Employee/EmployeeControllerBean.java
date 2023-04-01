package com.example.demowithtests.web.Employee;

import com.example.demowithtests.domain.Employee;
import com.example.demowithtests.dto.Employee.EmployeeRequestDto;
import com.example.demowithtests.dto.Employee.EmployeeResponseDto;
import com.example.demowithtests.service.Employee.EmployeeService;
//import com.example.demowithtests.employeeService.EmployeeServiceBean;
//import com.example.demowithtests.util.UserIsNotExistException;
import com.example.demowithtests.util.mupstruct.EmployeeMapper;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
//import java.util.logging.Logger;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Employee", description = "Employee API")
public class EmployeeControllerBean implements EmployeeController {

    private final EmployeeService employeeService;
    private final EmployeeMapper employeeMapper;

    //   private static final Logger log = Logger.getLogger(EmployeeServiceBean.class.getName());

//    public EmployeeControllerBean(EmployeeService employeeService, EmployeeMapper employeeMapper) {
//        this.employeeService = employeeService;
//        this.employeeMapper = employeeMapper;
//    }

    //Операция сохранения юзера в базу данных
    @PostMapping("/users")
    @ResponseStatus(HttpStatus.CREATED)
    @Override
    //   public EmployeeRequestDto saveEmployee(@RequestBody EmployeeRequestDto employeeRequestDto) {
    public EmployeeResponseDto saveEmployee(@RequestBody EmployeeRequestDto employeeRequestDto) {
        log.info("----> saveEmployee - start: EmployeeRequestDto = {}", employeeRequestDto);
        Employee employee = employeeMapper.employeeDtoToEmployee(employeeRequestDto);
        //   EmployeeRequestDto dto = employeeMapper.employeeToEmployeeDto(employeeService.create(employee));
        EmployeeResponseDto dto = employeeMapper.employeeToEmployeeReadDto(employeeService.create(employee));
        log.info("----> saveEmployee - end: EmployeeRequestDto = {}", dto);
        return dto;
    }

    //Получение списка юзеров
    @Override
    @GetMapping("/users")
    @ResponseStatus(HttpStatus.OK)
    public List<EmployeeResponseDto> getAllUsers() {
        log.info("----> getAllUsers() - start: ");
        List<Employee> employees = employeeService.getAll();
        List<EmployeeResponseDto> employeesReadDto = new ArrayList<>();
        for (Employee employee : employees) {
            employeesReadDto.add(
                    employeeMapper.employeeToEmployeeReadDto(employee));
        }
        log.info("----> getAllUsers()  - end:  employeesReadDto =  {}", employeesReadDto);
        return employeesReadDto;
    }

    //Получения юзера по id
    @Override
    @GetMapping(value = "/users/{id}")
    @ResponseStatus(HttpStatus.OK)
    public EmployeeResponseDto getEmployeeById(@PathVariable Integer id) {
        log.info("----> getEmployeeById() - start: id = {}" + id);
        EmployeeResponseDto eRDTO = employeeMapper.employeeToEmployeeReadDto(employeeService.getById(id));
        log.info("----> getEmployeeById() - end: EmployeeResponseDto = {}", eRDTO);
        return eRDTO;
    }

    //Обновление юзера
    @Override
    @SneakyThrows
    @PutMapping("/users/{id}")
    @ResponseStatus(HttpStatus.OK)
    public EmployeeResponseDto refreshEmployee(@PathVariable("id") String id, @RequestBody EmployeeRequestDto employeeRequestDto) {
        log.info("----> refreshEmployee() - start: ");
        Integer parseId = Integer.parseInt(id);
        log.info("----> refreshEmployee() -  end: ");
        return employeeMapper.employeeToEmployeeReadDto(
                employeeService.updateById(parseId, employeeMapper.employeeDtoToEmployee(employeeRequestDto))
        );
    }

    //Удаление по id
    @Override
    @PatchMapping("/users/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeEmployeeById(@PathVariable String id) {
        log.info("----> removeEmployeeById - start: id = {}" + id);
        Integer parseId = Integer.parseInt(id);
        employeeService.removeById(parseId);
        log.info("----> removeEmployeeById - end: id = {}" + id);
    }

    //Удаление всех юзеров
    @Override
    @DeleteMapping("/users")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeAllUsers() {
        log.info("----> removeAllUsers() - start: ");
        employeeService.removeAll();
        log.info("----> removeAllUsers() - end: ");
    }


    @Override
    @PostMapping("/sendEmailByCountry")
    @ResponseStatus(HttpStatus.OK)
    public void sendEmailByCountry(@RequestParam String country, @RequestParam String text) {
        log.info("----> endEmailByCountry() - start: ");
        employeeService.sendEmailByCountry(country, text);
        log.info("----> endEmailByCountry() - end: ");
    }

    @Override
    @PostMapping("/sendEmailByCity")
    @ResponseStatus(HttpStatus.OK)
    public void sendEmailByCity(@RequestParam String cities, @RequestBody String text) {
        log.info("----> sendEmailByCity() - start: ");
        employeeService.sendEmailByCity(cities, text);
        log.info("----> sendEmailByCity() - end: ");
    }

    @Override
    @PostMapping("/updateBaseByCountryFully")
    @ResponseStatus(HttpStatus.OK)
    public void updateByCountryFully(@RequestParam String countries) {
        log.info("----> updateByCountryFully() - start: ");
        employeeService.updaterByCountryFully(countries);
        log.info("----> updateByCountryFully() - end: ");
    }

    @Override
    @PostMapping("/replaceNull")
    @ResponseStatus(HttpStatus.OK)
    public void replaceNull() {
        log.info("----> replaceNull() - start: ");
        employeeService.processor();
        log.info("----> replaceNull() - end: ");
    }

    @Override
    @GetMapping("/fillDB")
    @ResponseStatus(HttpStatus.OK)
    public void fillDB(@RequestParam int numberOfTimes, @RequestParam String countriesList) {
        log.info("----> fillDB() - start: ");
        employeeService.fillDB(numberOfTimes, countriesList);
        log.info("----> fillDB() - end: ");
    }

    @Override
    @GetMapping("/updateAllByCountry")
    @ResponseStatus(HttpStatus.OK)
    public void updateAllByCountry(@RequestParam String newCountry) {
        log.info("----> updateAllByCountry() - start: ");
        employeeService.updateAllByCountry(newCountry);
        log.info("----> updateAllByCountry() - end: ");
    }

    @Override
    @GetMapping("/updateAllByCountrySmart")
    @ResponseStatus(HttpStatus.OK)
    public void updateAllByCountrySmart(@RequestParam String oldCountry, @RequestParam String newCountry) {
        log.info("----> updateAllByCountrySmart() - start: ");
        employeeService.updateAllByCountrySmart(oldCountry, newCountry);
        log.info("----> updateAllByCountrySmart() - end: ");
    }

    @Override
    @PostMapping("/sendEmailOldFoto")
    @ResponseStatus(HttpStatus.OK)
    public List<Employee> sendEmailOldFoto(@RequestParam String text) {
        log.info("----> sendEmailOldFoto() - start: ");
        log.info("----> sendEmailOldFoto() - end: ");
        return employeeService.sendEmailOldFoto(text);
    }

    @Override
    @GetMapping("/metricsByCountry")
    @ResponseStatus(HttpStatus.OK)
    public void metricsByCountry(@RequestParam String fromCountry, @RequestParam String toCountry, @RequestParam String text) {
        log.info("----> metricsByCountry() - start: ");
        employeeService.metricsByCountry(fromCountry, toCountry, text);
        log.info("----> metricsByCountry() - end: ");
    }

    @Override
    @PatchMapping("/addPassport")
    @ResponseStatus(HttpStatus.OK)
    public EmployeeResponseDto addPassport(@RequestParam Integer employeeId, @RequestParam Integer passportId) {
        Employee  employee = employeeService.addPassport(employeeId, passportId);
        EmployeeResponseDto employeeResponseDto = employeeMapper.employeeToEmployeeReadDto(employee);
        return employeeResponseDto;
    }
    @Override
    @PatchMapping("/users/{uid}/passports/{pid}")
    @ResponseStatus(HttpStatus.OK)
    public EmployeeResponseDto addPassportSafe(@PathVariable Integer uid, @PathVariable Integer pid) {
        Employee  employee = employeeService.addPassport(uid, pid);
        EmployeeResponseDto employeeResponseDto = employeeMapper.employeeToEmployeeReadDto(employee);
        return employeeResponseDto;
    }



}