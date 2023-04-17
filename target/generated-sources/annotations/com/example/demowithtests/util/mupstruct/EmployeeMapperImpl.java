package com.example.demowithtests.util.mupstruct;

import com.example.demowithtests.domain.Address;
import com.example.demowithtests.domain.Employee;
import com.example.demowithtests.domain.Foto;
import com.example.demowithtests.domain.Passport;
import com.example.demowithtests.domain.Registration;
import com.example.demowithtests.domain.Workplace;
import com.example.demowithtests.dto.Employee.AddressDto;
import com.example.demowithtests.dto.Employee.EmployeeRequestDto;
import com.example.demowithtests.dto.Employee.EmployeeResponseDto;
import com.example.demowithtests.dto.Employee.FotoDto;
import com.example.demowithtests.dto.Passport.PassportResponseDto;
import com.example.demowithtests.dto.Passport.RegistrationRequestDto;
import com.example.demowithtests.dto.Workplace.WorkplaceResponseDto;
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
public class EmployeeMapperImpl implements EmployeeMapper {

    @Override
    public Employee fromRequestEmployeeDTO(EmployeeRequestDto employeeRequestDto) {
        if ( employeeRequestDto == null ) {
            return null;
        }

        Employee.EmployeeBuilder employee = Employee.builder();

        employee.name( employeeRequestDto.name );
        employee.country( employeeRequestDto.country );
        employee.email( employeeRequestDto.email );
        employee.isDeleted( employeeRequestDto.isDeleted );
        employee.addresses( addressDtoSetToAddressSet( employeeRequestDto.addresses ) );
        employee.fotos( fotoDtoSetToFotoSet( employeeRequestDto.fotos ) );

        return employee.build();
    }

    @Override
    public EmployeeResponseDto toResponseEmployeeDTO(Employee employee) {
        if ( employee == null ) {
            return null;
        }

        EmployeeResponseDto employeeResponseDto = new EmployeeResponseDto();

        employeeResponseDto.name = employee.getName();
        employeeResponseDto.email = employee.getEmail();
        employeeResponseDto.fotos = fotoSetToFotoDtoSet( employee.getFotos() );
        employeeResponseDto.addresses = addressSetToAddressDtoSet( employee.getAddresses() );
        employeeResponseDto.passport = passportToPassportResponseDto( employee.getPassport() );
        employeeResponseDto.workplaces = workplaceSetToWorkplaceResponseDtoSet( employee.getWorkplaces() );

        return employeeResponseDto;
    }

    protected Address addressDtoToAddress(AddressDto addressDto) {
        if ( addressDto == null ) {
            return null;
        }

        Address address = new Address();

        address.setCountry( addressDto.country );
        address.setCity( addressDto.city );
        address.setStreet( addressDto.street );

        return address;
    }

    protected Set<Address> addressDtoSetToAddressSet(Set<AddressDto> set) {
        if ( set == null ) {
            return null;
        }

        Set<Address> set1 = new LinkedHashSet<Address>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( AddressDto addressDto : set ) {
            set1.add( addressDtoToAddress( addressDto ) );
        }

        return set1;
    }

    protected Foto fotoDtoToFoto(FotoDto fotoDto) {
        if ( fotoDto == null ) {
            return null;
        }

        Foto foto = new Foto();

        foto.setLink( fotoDto.link );
        foto.setLength( fotoDto.length );
        foto.setWidth( fotoDto.width );
        foto.setCreationTime( fotoDto.creationTime );
        foto.setIsVisible( fotoDto.isVisible );

        return foto;
    }

    protected Set<Foto> fotoDtoSetToFotoSet(Set<FotoDto> set) {
        if ( set == null ) {
            return null;
        }

        Set<Foto> set1 = new LinkedHashSet<Foto>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( FotoDto fotoDto : set ) {
            set1.add( fotoDtoToFoto( fotoDto ) );
        }

        return set1;
    }

    protected FotoDto fotoToFotoDto(Foto foto) {
        if ( foto == null ) {
            return null;
        }

        FotoDto fotoDto = new FotoDto();

        fotoDto.link = foto.getLink();
        fotoDto.length = foto.getLength();
        fotoDto.width = foto.getWidth();
        fotoDto.isVisible = foto.getIsVisible();
        fotoDto.creationTime = foto.getCreationTime();

        return fotoDto;
    }

    protected Set<FotoDto> fotoSetToFotoDtoSet(Set<Foto> set) {
        if ( set == null ) {
            return null;
        }

        Set<FotoDto> set1 = new LinkedHashSet<FotoDto>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( Foto foto : set ) {
            set1.add( fotoToFotoDto( foto ) );
        }

        return set1;
    }

    protected AddressDto addressToAddressDto(Address address) {
        if ( address == null ) {
            return null;
        }

        AddressDto addressDto = new AddressDto();

        addressDto.country = address.getCountry();
        addressDto.city = address.getCity();
        addressDto.street = address.getStreet();

        return addressDto;
    }

    protected Set<AddressDto> addressSetToAddressDtoSet(Set<Address> set) {
        if ( set == null ) {
            return null;
        }

        Set<AddressDto> set1 = new LinkedHashSet<AddressDto>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( Address address : set ) {
            set1.add( addressToAddressDto( address ) );
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

    protected PassportResponseDto passportToPassportResponseDto(Passport passport) {
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

    protected WorkplaceResponseDto workplaceToWorkplaceResponseDto(Workplace workplace) {
        if ( workplace == null ) {
            return null;
        }

        WorkplaceResponseDto workplaceResponseDto = new WorkplaceResponseDto();

        workplaceResponseDto.name = workplace.getName();
        workplaceResponseDto.address = workplace.getAddress();

        return workplaceResponseDto;
    }

    protected Set<WorkplaceResponseDto> workplaceSetToWorkplaceResponseDtoSet(Set<Workplace> set) {
        if ( set == null ) {
            return null;
        }

        Set<WorkplaceResponseDto> set1 = new LinkedHashSet<WorkplaceResponseDto>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( Workplace workplace : set ) {
            set1.add( workplaceToWorkplaceResponseDto( workplace ) );
        }

        return set1;
    }
}
