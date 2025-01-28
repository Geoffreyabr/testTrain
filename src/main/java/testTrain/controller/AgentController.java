package testTrain.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import testTrain.dto.AgentDto;
import testTrain.entity.Agent;
import testTrain.mappper.MapperAgentDto;
import testTrain.repository.AgentRepository;
import testTrain.service.AgentService;
import testTrain.service.parser.ParserAgent;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/agents")
public class AgentController {

    private final AgentService agentService;

    private final AgentRepository agentRepository;

    private final MapperAgentDto mapperAgentDto;
    private final ParserAgent parserAgent;

    public AgentController(AgentService agentService, AgentRepository agentRepository, MapperAgentDto mapperAgentDto, ParserAgent parserAgent) {
        this.agentService = agentService;
        this.agentRepository = agentRepository;
        this.mapperAgentDto = mapperAgentDto;
        this.parserAgent = parserAgent;
    }

    @GetMapping("/getAllAgents")
    public List<AgentDto> getAllAgents() {
                return agentRepository.findAll()
                .stream()
                .map(mapperAgentDto::agentToAgentDto)
                .collect(Collectors.toList());
    }

    @PostMapping("/newAgent")
    public ResponseEntity<Agent> createAgent(@RequestBody Agent agent) {
        Agent newAgent = this.agentService.addAgent(
                agent.getNom(),
                agent.getPrenom(),
                agent.getNumMatricule(),
                agent.getSpecialite(),
                agent.getTrains()
        );
        return ResponseEntity.ok(newAgent);
    }

    @PostMapping("/import")
    public String importAgents(@RequestParam String filePath) {
        try {
            List<Agent> agents = parserAgent.importAgentsFromCsv(filePath);
            agentService.saveAgents(agents);
            return "Agents importés avec succès !";
        } catch (IOException e) {
            return "Erreur lors de l'importation des agents : " + e.getMessage();
        }
    }
}