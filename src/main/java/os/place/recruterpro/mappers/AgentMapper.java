package os.place.recruterpro.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import os.place.recruterpro.dtos.AgentDTO;
import os.place.recruterpro.entities.Agent;
@Mapper
public interface AgentMapper {
    AgentMapper INSTANCE = Mappers.getMapper(AgentMapper.class);

    Agent toEntity(AgentDTO agentDTO);

    AgentDTO toDto(Agent agent);
}
