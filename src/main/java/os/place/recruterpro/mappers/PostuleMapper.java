package os.place.recruterpro.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import os.place.recruterpro.dtos.AgentDTO;
import os.place.recruterpro.dtos.PostuleDto;
import os.place.recruterpro.entities.Agent;
import os.place.recruterpro.entities.Postule;

@Mapper
public interface PostuleMapper {
    PostuleMapper INSTANCE = Mappers.getMapper(PostuleMapper.class);

    Postule toEntity(PostuleDto postuleDto);

    PostuleDto toDto(Postule postule);
}
