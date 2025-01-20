package testTrain.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import testTrain.dto.TrainDto;
import testTrain.entity.Train;
import testTrain.mappper.MapperTrainDto;
import testTrain.repository.TrainRepository;
import testTrain.service.TrainService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/trains")
public class TrainController {

    private final TrainService trainService;

    private final MapperTrainDto mapperTrainDto;

    private final TrainRepository trainRepository;

    public TrainController(
            TrainService trainService,
            MapperTrainDto mapperTrainDto, TrainRepository trainRepository
    ) {
        this.trainService = trainService;
        this.mapperTrainDto = mapperTrainDto;
        this.trainRepository = trainRepository;
    };

    @GetMapping("/getAlltrains")
    public List<TrainDto> getAllTrains() {
        return trainRepository.findAll()
                .stream()
                .map(train -> mapperTrainDto.trainToTrainDto(train))
                .collect(Collectors.toList());
    }

    @PostMapping("/newTrain")
        public ResponseEntity<Train> createNewTrain(@RequestBody Train train) {
            Train savedTrain = trainService.addTrain(
                 train.getNumeroTrain(),
                 train.getGareDepart(),
                 train.getGareArrivee(),
                 train.getHeureDepart(),
                 train.getHeureArrivee()
            );
            return ResponseEntity.ok(savedTrain);
        }
    }

