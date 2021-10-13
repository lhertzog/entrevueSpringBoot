package com.example.entrevueSpringBoot.mapper;


import com.example.entrevueSpringBoot.dto.FilmDTO;
import com.example.entrevueSpringBoot.entity.FilmEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface FilmMapper {

    FilmMapper INSTANCE = Mappers.getMapper(FilmMapper.class);

    FilmDTO filmEntityToFilmDTO(final FilmEntity filmEntity);

    FilmEntity filmDTOToFilmEntity(final FilmDTO filmDTO);
}
