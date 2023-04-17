package com.example.demowithtests.util.mupstruct;

import com.example.demowithtests.domain.Registration;
import com.example.demowithtests.dto.Passport.RegistrationRequestDto;
import com.example.demowithtests.dto.Passport.RegistrationResponseDto;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-04-17T18:53:55+0300",
    comments = "version: 1.5.1.Final, compiler: javac, environment: Java 17.0.6 (Oracle Corporation)"
)
@Component
public class RagistrationMapperImpl implements RagistrationMapper {

    @Override
    public Registration fromRequestRegistrationDto(RegistrationRequestDto registrationRequestDto) {
        if ( registrationRequestDto == null ) {
            return null;
        }

        Registration registration = new Registration();

        registration.setInfo( registrationRequestDto.info );
        registration.setIsActive( registrationRequestDto.isActive );
        registration.setCreationTime( registrationRequestDto.creationTime );

        return registration;
    }

    @Override
    public RegistrationResponseDto toResponseRegistrationDto(Registration registration) {
        if ( registration == null ) {
            return null;
        }

        RegistrationResponseDto registrationResponseDto = new RegistrationResponseDto();

        registrationResponseDto.info = registration.getInfo();
        registrationResponseDto.isActive = registration.getIsActive();
        registrationResponseDto.creationTime = registration.getCreationTime();

        return registrationResponseDto;
    }
}
