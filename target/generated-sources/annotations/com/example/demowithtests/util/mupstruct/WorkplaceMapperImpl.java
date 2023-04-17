package com.example.demowithtests.util.mupstruct;

import com.example.demowithtests.domain.Workplace;
import com.example.demowithtests.dto.Workplace.WorkplaceRequestDto;
import com.example.demowithtests.dto.Workplace.WorkplaceResponseDto;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-04-17T18:53:56+0300",
    comments = "version: 1.5.1.Final, compiler: javac, environment: Java 17.0.6 (Oracle Corporation)"
)
@Component
public class WorkplaceMapperImpl implements WorkplaceMapper {

    @Override
    public Workplace fromRequestWorkplaceDto(WorkplaceRequestDto workplaceRequestDto) {
        if ( workplaceRequestDto == null ) {
            return null;
        }

        Workplace.WorkplaceBuilder workplace = Workplace.builder();

        workplace.id( workplaceRequestDto.id );
        workplace.name( workplaceRequestDto.name );
        workplace.address( workplaceRequestDto.address );

        return workplace.build();
    }

    @Override
    public WorkplaceResponseDto toResponseWorkplaceDto(Workplace workplace) {
        if ( workplace == null ) {
            return null;
        }

        WorkplaceResponseDto workplaceResponseDto = new WorkplaceResponseDto();

        workplaceResponseDto.name = workplace.getName();
        workplaceResponseDto.address = workplace.getAddress();

        return workplaceResponseDto;
    }
}
