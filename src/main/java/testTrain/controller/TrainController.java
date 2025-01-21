package testTrain.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import testTrain.dto.TrainDto;
import testTrain.entity.Train;
import testTrain.mappper.MapperTrainDto;
import testTrain.repository.TrainRepository;
import testTrain.service.Excelimport;
import testTrain.service.TrainService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/trains")
public class TrainController {

    private final TrainService trainService;

    private final MapperTrainDto mapperTrainDto;

    private final TrainRepository trainRepository;

    private final Excelimport excelimport;

    public TrainController(
            TrainService trainService,
            MapperTrainDto mapperTrainDto,
            TrainRepository trainRepository,
            Excelimport excelimport
    ) {
        this.trainService = trainService;
        this.mapperTrainDto = mapperTrainDto;
        this.trainRepository = trainRepository;
        this.excelimport = excelimport;
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



    @PostMapping("/parseStatic")
    public ResponseEntity<?> parseStaticExcelFile(@RequestParam("file") MultipartFile file) {
        try {
            List<List<String>> excelData = excelimport.readCsvFile(file);
            return ResponseEntity.ok(excelData);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erreur : " + e.getMessage());
        }
    }
    }




