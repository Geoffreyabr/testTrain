package testTrain.service;

import org.springframework.stereotype.Service;
import testTrain.entity.Agent;
import testTrain.entity.Train;
import testTrain.repository.AgentRepository;
import testTrain.repository.TrainRepository;

import java.util.List;

@Service
public class AgentService {

    private final AgentRepository agentRepository;

    private final TrainRepository trainRepository;

    public AgentService(AgentRepository agentRepository, TrainRepository trainRepository) {
        this.agentRepository = agentRepository;
        this.trainRepository = trainRepository;
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

}
