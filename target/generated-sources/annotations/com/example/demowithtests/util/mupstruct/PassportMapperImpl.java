package com.example.demowithtests.util.mupstruct;

import com.example.demowithtests.domain.Passport;
import com.example.demowithtests.domain.Registration;
import com.example.demowithtests.dto.Passport.PassportRequestDto;
import com.example.demowithtests.dto.Passport.PassportResponseDto;
import com.example.demowithtests.dto.Passport.RegistrationRequestDto;
import java.util.LinkedHashSet;
import java.util.Set;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-04-17T18:53:56+0300",
    comments = "version: 1.5.1.Final, compiler: javac, environment: Java 17.0.6 (Oracle Corporation)"
)
@Component
public class PassportMapperImpl implements PassportMapper {

    @Override
    public Passport fromRequestPassportDto(PassportRequestDto passportRequestDto) {
        if ( passportRequestDto == null ) {
            return null;
        }

        Passport.PassportBuilder passport = Passport.builder();

        passport.firstName( passportRequestDto.firstName );
        passport.secondName( passportRequestDto.secondName );
        passport.birthDate( passportRequestDto.birthDate );
        passport.registrations( registrationRequestDtoSetToRegistrationSet( passportRequestDto.registrations ) );

        return passport.build();
    }

    @Override
    public PassportResponseDto toResponsePassportDto(Passport passport) {
        if ( passport == null ) {
            return null;
        }

        PassportResponseDto passportResponseDto = new PassportResponseDto();

        passportResponseDto.id = passport.getId();
        passportResponseDto.firstName = passport.getFirstName();
        passportResponseDto.secondName = passport.getSecondName();
        passportResponseDto.birthDate = passport.getBirthDate();
        passportResponseDto.registrations = registrationSetToRegistrationRequestDtoSet( passport.getRegistrations() );

        return passportResponseDto;
    }

    protected Registration registrationRequestDtoToRegistration(RegistrationRequestDto registrationRequestDto) {
        if ( registrationRequestDto == null ) {
            return null;
        }

        Registration registration = new Registration();

        registration.setInfo( registrationRequestDto.info );
        registration.setIsActive( registrationRequestDto.isActive );
        registration.setCreationTime( registrationRequestDto.creationTime );

        return registration;
    }

    protected Set<Registration> registrationRequestDtoSetToRegistrationSet(Set<RegistrationRequestDto> set) {
        if ( set == null ) {
            return null;
        }

        Set<Registration> set1 = new LinkedHashSet<Registration>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( RegistrationRequestDto registrationRequestDto : set ) {
            set1.add( registrationRequestDtoToRegistration( registrationRequestDto ) );
        }

        return set1;
    }

    protected RegistrationRequestDto registrationToRegistrationRequestDto(Registration registration) {
        if ( registration == null ) {
            return null;
        }

        RegistrationRequestDto registrationRequestDto = new RegistrationRequestDto();

        registrationRequestDto.info = registration.getInfo();
        registrationRequestDto.isActive = registration.getIsActive();
        registrationRequestDto.creationTime = registration.getCreationTime();

        return registrationRequestDto;
    }

    protected Set<RegistrationRequestDto> registrationSetToRegistrationRequestDtoSet(Set<Registration> set) {
        if ( set == null ) {
            return null;
        }

        Set<RegistrationRequestDto> set1 = new LinkedHashSet<RegistrationRequestDto>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( Registration registration : set ) {
            set1.add( registrationToRegistrationRequestDto( registration ) );
        }

        return set1;
    }
}
