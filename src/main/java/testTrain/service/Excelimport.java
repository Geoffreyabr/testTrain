package testTrain.service;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

//blallalal//
@Service
public class Excelimport {

    // Méthode pour lire un fichier CSV envoyé via multipart
    public List<List<String>> readCsvFile(MultipartFile file) {
        List<List<String>> data = new ArrayList<>(); // Stockage des données CSV

        try {
            // Utilisez l'input stream du fichier MultipartFile envoyé dans la requête
            BufferedReader reader = new BufferedReader(new InputStreamReader(file.getInputStream()));

            String line;
            while ((line = reader.readLine()) != null) {
                // Découper chaque ligne en colonnes
                String[] columns = line.split(",");

                // Convertir les colonnes en liste et ajouter à la liste principale
                List<String> row = new ArrayList<>();
                for (String column : columns) {
                    row.add(column);
                }
                data.add(row);
            }
            System.out.println("Fichier CSV traité avec succès !");
        } catch (IOException e) {
            System.err.println("Erreur lors du chargement du fichier : " + e.getMessage());
            e.printStackTrace();
        }

        return data; // Retourner les données sous forme de liste
    }
}



