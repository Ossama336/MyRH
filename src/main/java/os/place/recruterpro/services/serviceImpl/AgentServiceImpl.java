package os.place.recruterpro.services.serviceImpl;

import org.springframework.stereotype.Service;
import os.place.recruterpro.repositories.AgentRepository;
import os.place.recruterpro.services.AgentService;

@Service
public class AgentServiceImpl implements AgentService {
    private AgentRepository agentRepository;

    public AgentServiceImpl(AgentRepository agentRepository) {
        this.agentRepository = agentRepository;
    }
}
