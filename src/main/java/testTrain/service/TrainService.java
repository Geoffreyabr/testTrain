package testTrain.service;

import org.springframework.stereotype.Service;
import testTrain.entity.Train;
import testTrain.repository.TrainRepository;

import java.time.LocalDateTime;

@Service
public class TrainService {

    private final TrainRepository  trainRepository;

    public TrainService(TrainRepository trainRepository) {
        this.trainRepository = trainRepository;
    }

    public Train addTrain(
            String numeroTrain,
            String gareDepart,
            String gareArrivee,
            String  heureDepart,
            String heureArrivee
    ) {
        Train newTrain = new Train();
        newTrain.setNumeroTrain(numeroTrain);
        newTrain.setGareDepart(gareDepart);
        newTrain.setGareArrivee(gareArrivee);
        newTrain.setHeureDepart(heureDepart);
        newTrain.setHeureArrivee(heureArrivee);

        return trainRepository.save(newTrain);
    };

}
