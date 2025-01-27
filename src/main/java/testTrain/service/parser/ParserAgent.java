package testTrain.service.parser;

import org.springframework.stereotype.Component;
import testTrain.entity.Agent;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class ParserAgent {

    public List<Agent> importAgentsFromCsv(String filePath) throws IOException {
        List<Agent> agents = new ArrayList<>();
        File file = new File(filePath);

        System.out.println("Reading file: " + filePath);
        try (FileInputStream fis = new FileInputStream(file)) {
            byte[] data = fis.readAllBytes();
            String content = new String(data);
            System.out.println("File content:\n" + content);

            String[] lines = content.split("\n");
            for (String line : lines) {
                if (line.trim().isEmpty()) continue;

                String[] columns = line.split(";");
                if (columns.length >= 4) {
                    Agent agent = new Agent();
                    agent.setNom(columns[1].trim());
                    agent.setPrenom(columns[2].trim());
                    agent.setNumMatricule(columns[3].trim());
                    agent.setSpecialite(columns[4].trim());
                    agents.add(agent);
                    System.out.println("Parsed agent: " + agent.getNom() + " " + agent.getPrenom());
                }
            }
        }
        return agents;
    }
}
