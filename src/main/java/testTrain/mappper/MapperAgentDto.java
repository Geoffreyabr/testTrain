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
        return agentDto;
     }

    public Agent agentDtoToAgent(AgentDto agentDto) {
        Agent agent = new Agent();
        agent.setNom(agentDto.getNom());
        agent.setPrenom(agentDto.getPrenom());
        return agent;
    }
}
