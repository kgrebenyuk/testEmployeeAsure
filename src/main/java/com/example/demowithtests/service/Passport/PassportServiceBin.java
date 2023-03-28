package com.example.demowithtests.service.Passport;

import com.example.demowithtests.domain.Passport;
import com.example.demowithtests.repository.PassportRepositiry;
import com.example.demowithtests.util.IdIsNotExistException;
import com.example.demowithtests.util.UserIsNotExistException;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
//@NoArgsConstructor
@Service
@Slf4j
public class PassportServiceBin implements PassportService {

    private final PassportRepositiry passportRepositiry;


    @Override
    public Passport create(Passport passport) {
        return passportRepositiry.save(passport);
    }

    @Override
    public List<Passport> getAll() {
        return passportRepositiry.findAll();
    }

    @Override
    public Passport getById(Integer id) {
        return passportRepositiry.findById(id).orElseThrow(IdIsNotExistException::new);
    }

    @Override
    public Passport updateById(Integer id, Passport plane) {
        Passport entity = passportRepositiry.findById(id).orElseThrow(IdIsNotExistException::new);
        entity.setFirstName(entity.getFirstName());
        entity.setSecondName(entity.getSecondName());
        Passport updatePassport = passportRepositiry.save(entity);

        return updatePassport;
    }
}
