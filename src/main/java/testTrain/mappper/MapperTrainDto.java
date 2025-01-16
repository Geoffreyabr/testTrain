package testTrain.mappper;

import org.springframework.stereotype.Service;
import testTrain.dto.TrainDto;
import testTrain.entity.Train;
@Service
public class MapperTrainDto {

    public TrainDto trainToTrainDto(Train train) {
        TrainDto trainDto = new TrainDto();
        trainDto.setNumeroTrain(train.getNumeroTrain());
        trainDto.setGareDepart(train.getGareDepart());
        trainDto.setGareArrivee(train.getGareArrivee());
        trainDto.setHeureDepart(train.getHeureDepart());
        trainDto.setHeureArrivee(train.getHeureArrivee());
        return trainDto;
    }
}
