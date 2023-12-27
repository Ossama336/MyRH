package os.place.recruterpro.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import os.place.recruterpro.dtos.OffreDTO;
import os.place.recruterpro.entities.Offre;

import java.util.List;

@Mapper
public interface OffreMapper {
    OffreMapper INSTANCE = Mappers.getMapper(OffreMapper.class);

    Offre toEntity(OffreDTO offreDTO);

    OffreDTO toDTO(Offre offre);
    List<OffreDTO> toDtoList(List<Offre> offers);

}
