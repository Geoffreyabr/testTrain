package testTrain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import testTrain.entity.Train;
import testTrain.repository.TrainRepository;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@Service
public class Excelimport {

    @Autowired
    private TrainRepository trainRepository;

    @Transactional
    public List<Train> processAndSaveCsvFile(MultipartFile file) {
        List<Train> savedTrains = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
            String line;
            boolean isHeader = true;

            while ((line = reader.readLine()) != null) {
                if (isHeader) {
                    isHeader = false;
                    continue;
                }

                // Utiliser la virgule comme séparateur. Si nécessaire, changez-le en ";"
                String[] columns = line.split(";");

                if (columns.length >= 3) { // Vérifiez qu'il y a bien au moins 3 colonnes dans le CSV
                    Train train = new Train();

                    train.setNumeroTrain(columns[1].trim());
                    train.setGareDepart(columns[2].trim());
                    train.setGareArrivee(columns[3].trim());
                    train.setHeureDepart(columns[4].trim());
                    train.setHeureArrivee(columns[5].trim());

                    savedTrains.add(train);

                    // Log pour vérifier chaque objet Train parsé
                    System.out.println("Train parsé : " + train);
                } else {
                    // Log pour les lignes incorrectes
                    System.err.println("Ligne ignorée, colonnes insuffisantes : " + line);
                }
            }

            // Sauvegarder les trains en base
            savedTrains = trainRepository.saveAll(savedTrains);

            // Log après sauvegarde
            System.out.println("Trains sauvegardés : " + savedTrains);
        } catch (IOException e) {
            System.err.println("Erreur lors du traitement du fichier : " + e.getMessage());
            e.printStackTrace();
        }

        return savedTrains;
    }

}