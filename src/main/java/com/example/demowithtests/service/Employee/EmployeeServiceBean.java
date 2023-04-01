package com.example.demowithtests.service.Employee;

import com.example.demowithtests.domain.Employee;
import com.example.demowithtests.domain.Passport;
import com.example.demowithtests.repository.EmployeeRepository;
import com.example.demowithtests.repository.PassportRepository;
import com.example.demowithtests.util.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;

import java.util.Date;
import java.util.List;

//import static java.lang.System.Logger.Level.DEBUG;
//import static org.apache.logging.log4j.util.LowLevelLogUtil.log;


@Slf4j
@AllArgsConstructor
//@NoArgsConstructor
@Data
@Service
public class EmployeeServiceBean implements EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final PassportRepository passportRepository;

    //  private static final Logger log = Logger.getLogger(EmployeeServiceBean.class.getName());

//    public EmployeeServiceBean(EmployeeRepository employeeRepository) {
//        this.employeeRepository = employeeRepository;
//    }


    // @SneakyThrows
    @Override
    public Employee create(Employee employee) {
        if (employee.getEmail() == null) throw new EmailAbsentException();
//      if (repository.findEmployeeByEmail(employee.getEmail()) != null) throw new EmailDoubledException();

        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getAll() {
        if (employeeRepository.findAll().size() > 0) {
            if (employeeRepository.findAll().size() == employeeRepository.findEmployeeByIsDeletedIsTrue().size()) {
                throw new ListWasDeletedException();
            }
            return employeeRepository.findAll();
        }
        throw new ListHasNoAnyElementsException();

    }

    @Override
    public Employee getById(Integer id) {
        // log.debug("----> getById() - start: id = {}", id);

        try {
            // Integer employeeId = Integer.parseInt(id);
            Employee employee = employeeRepository.findById(id)
                    .orElseThrow(IdIsNotExistException::new);
            if (employee.getIsDeleted()) {
                throw new ResourceWasDeletedException();
            }

            //  log.debug("----> getById() -try  employee = {}", employee);

            return employee;
        } catch (NumberFormatException exception) {

            //  log.debug("----> getById() - end: employee = {}", exception);

            throw new WrongDataException();

        }

    }

    //@SneakyThrows
    @Override
    public Employee updateById(Integer id, Employee employee) throws UserIsNotExistException {
        return employeeRepository.findById(id)
                .map(entity -> {
                    entity.setName(employee.getName());
                    entity.setEmail(employee.getEmail());
                    entity.setCountry(employee.getCountry());
                    return employeeRepository.save(entity);
                })
                .orElseThrow(UserIsNotExistException::new);
    }

    @Override
    public void removeById(Integer id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(IdIsNotExistException::new);
        if (employee.getDeleted()) throw new UserAlreadyDeletedException();
        employee.setIsDeleted(true);
        employeeRepository.save(employee);
    }

    @Override
    public void removeAll() {

        if (employeeRepository.findAll().size() > 0) {
            if (employeeRepository.findAll().size() == employeeRepository.findEmployeeByIsDeletedIsTrue().size()) {
                throw new ListWasDeletedException();
            }
            List<Employee> base = employeeRepository.findAll();
            for (Employee employee : base) {
                employee.setIsDeleted(true);
            }
        }
        throw new ListHasNoAnyElementsException();
    }


    public void mailSender(List<String> emails, String text) {
        log.info("---->> mailSender ->  Text: '" + text + "' was sent to: " + emails);
    }

    @Override
    public List<Employee> sendEmailByCountry(String country, String text) {
        List<Employee> employees = employeeRepository.findEmployeeByCountry(country);
        mailSender(getterEmailsOfEmployees(employees), text);
        return employees;
    }

    public List<Employee> sendEmailByCity(String citiesString, String text) {
        String[] citiesArray = citiesString.split(",");
        List<String> citiesList = Arrays.asList(citiesArray);
        List<Employee> employees = new ArrayList<>();
        for (String city : citiesList) {
            List<Employee> employeesByCity = employeeRepository.findEmployeeByAddresses(city);
            employees.addAll(employeesByCity);
        }
        mailSender(getterEmailsOfEmployees(employees), text);

        return employees;
    }

/*    @Override
    public void fillingDataBase(String quantityString) {
        int quantity = Integer.parseInt(quantityString);
        for (int i = 0; i <= quantity; i++) {
            repository.save(createrEmployee("name", "country", "email"));
        }
    }
  */

    //   @Override
//    public void fillDB(int numberOfTimes) {
//        for (int i = 0; i <= numberOfTimes; i++) {
//            Employee employee = new Employee("name", "Ukraine", "email.gmail.com");
//            // repository.save(createrEmployee("name", "country", "email"));
//            create(employee);
//        }
//    }
//


    @Override
    public void updaterByCountryFully(String countries) {
        List<Employee> employees = employeeRepository.findAll();
        for (Employee employee : employees) {
            employee.setCountry(randomCountry(countries));
            employeeRepository.save(employee);
        }
    }

//    @Override
//    @Transactional
//    public void updaterByCountrySmart(String countries) {
//        List<Employee> employees = repository.findAll();
//        for (Employee employee : employees) {
//            String newCountry = randomCountry(countries);
//            if (!employee.getCountry().equals(newCountry)) {
//                employee.setCountry(newCountry);
//                repository.save(employee);
//            }
//        }
//    }

    @Override
    public List<Employee> processor() {
        //log.info("replace null  - start");
        List<Employee> replaceNull = employeeRepository.findEmployeeByIsDeletedNull();
        //log.info("replace null after replace: " + replaceNull);
        for (Employee emp : replaceNull) {
            emp.setIsDeleted(Boolean.FALSE);
        }
        //log.info("replaceNull = {} ", replaceNull);
        //log.info("replace null  - end:");
        return employeeRepository.saveAll(replaceNull);
    }


    private static List<String> getterEmailsOfEmployees(List<Employee> employees) {
        List<String> emails = new ArrayList<>();
        for (Employee employee : employees) {
            emails.add(employee.getEmail());
        }
        return emails;
    }

    @Override
    public Employee createrEmployee(String name, String country, String email) {
        return new Employee(name, country, email);
    }


    @Override
    public String randomCountry(String countriesList) {
        List<String> countries = List.of(countriesList.split(","));
        int randomIndex = (int) (Math.random() * countries.size());
        return countries.get(randomIndex);
        //  return countriesList;
    }

    @Override
    public void fillDB(int numberOfTimes, String countriesList) {
        for (int i = 0; i <= numberOfTimes; i++) {
            Employee employee = new Employee("name", randomCountry(countriesList), "email.gmail.com");
            employeeRepository.save(employee);
        }
    }

    @Override
    @Transactional
    public void updateAllByCountry(String newCountry) {
        List<Employee> employees = employeeRepository.findAll();
        for (Employee employee : employees)
            employee.setCountry(newCountry);
        employeeRepository.saveAll(employees);

    }

    @Override
    @Transactional
    public void updateAllByCountrySmart(String oldCountry, String newCountry) {
        List<Employee> employees = employeeRepository.findAll();
        for (Employee employee : employees)
            if (employee.getCountry().equals(oldCountry)) {
                employee.setCountry(newCountry);
                employeeRepository.save(employee);
            }
    }

    @Override
    public List<Employee> sendEmailOldFoto(String text) {
        Date data = Date.from(Instant.now());
        data.setYear(data.getYear() - 1);

        List<Employee> employees = employeeRepository.findEmployeeOldFoto(data);
        mailSender(getterEmailsOfEmployees(employees), text);

        log.info(" --->> List of employees with old foto: " + employees);

        return employees;
    }

    @Override
    public void metricsByCountry(String fromCountry, String toCountry, String text) {
//    public List<Employee> metricsByCountry(String fromCountry, String toCountry) {
//        List<Employee> allEmployee = repository.findEmployeeChangedCountry(country);
//
//         allEmployee.stream()
//                .filter(employee -> employee.getAddresses().stream()
//                        .anyMatch(address -> address.getCountry().equals(country)))
//                .collect(Collectors.toList());

        mailSender(employeeRepository.findEmployeeChangedCountry(fromCountry, toCountry), text);
    }

    @Override
    public Employee addPassport(Integer employeeId, Integer passportId) {
        log.info("----> addPassport() - start: ", employeeId, passportId);
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(IdIsNotExistException::new);
        Passport passport = passportRepository.findById(passportId).orElseThrow(IdIsNotExistException::new);
        employee.setPassport(passport);
        log.info("----> addPassport() - end: EmployeeReadDto = {}", employeeId, passportId);
        return employeeRepository.save(employee);
    }

    @Override
    public Employee addPassport(Integer employeeId) {
        log.info("----> addPassport() - start: ", employeeId);
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(IdIsNotExistException::new);

        Passport passport = passportRepository.findAll().stream()
                .filter(e ->e.getIsFree())
                .findFirst().orElseThrow(IdIsNotExistException::new);

//        Passport passport = passportRepository.findById(passportId).orElseThrow(IdIsNotExistException::new);
//        employee.setPassport(passport);
        log.info("----> addPassport() - end: EmployeeReadDto = {}", employeeId);
        return employeeRepository.save(employee);
    }

}
