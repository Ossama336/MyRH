package os.place.recruterpro.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import os.place.recruterpro.dtos.SocieteDTO;
import os.place.recruterpro.entities.Societe;

@Mapper
public interface SocieteMapper {
    SocieteMapper INSTANCE = Mappers.getMapper(SocieteMapper.class);

    Societe toEntity(SocieteDTO societeDTO);

    SocieteDTO toDto(Societe societe);

}
