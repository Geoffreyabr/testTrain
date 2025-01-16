package testTrain.mappper;


import org.springframework.stereotype.Service;
import testTrain.dto.AgentDto;
import testTrain.entity.Agent;

@Service
public class MapperAgentDto {

     public AgentDto agentToAgentDto(Agent agent) {
        AgentDto agentDto = new AgentDto();
        agentDto.setNom(agent.getNom());
        agentDto.setPrenom(agent.getPrenom());
        agentDto.setNumMatricule(agent.getNumMatricule());
        agentDto.setSpecialite(agent.getSpecialite());
        return agentDto;
}
}
