package testTrain.service;

import org.springframework.stereotype.Service;
import testTrain.dto.AgentDto;
import testTrain.entity.Agent;
import testTrain.entity.Train;
import testTrain.repository.AgentRepository;

import java.util.List;

@Service
public class AgentService {

    private final AgentRepository agentRepository;

    public AgentService(AgentRepository agentRepository) {
        this.agentRepository = agentRepository;
    }

    public Agent addAgent(
            String nom,
            String prenom,
            String numMatricule,
            String specialite,
            List<Train> trains
    ) {

        Agent newAgent = new Agent();
        newAgent.setNom(nom);
        newAgent.setPrenom(prenom);
        newAgent.setNumMatricule(numMatricule);
        newAgent.setSpecialite(specialite);
        newAgent.setTrains(trains);

        return agentRepository.save(newAgent);
    };

    public void saveAgents(List<Agent> agents) {
        for (Agent agent : agents) {
            agentRepository.save(agent);
        }
    }
}
