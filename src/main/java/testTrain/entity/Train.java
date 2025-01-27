package testTrain.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Entity
public class Train {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String numeroTrain;
    private String gareDepart;
    private String gareArrivee;

    private String  heureDepart;
    private String  heureArrivee;

    @ManyToMany
    @JoinTable(
            name = "train_agent",
            joinColumns = @JoinColumn(name = "train_id"),
            inverseJoinColumns = @JoinColumn(name = "agent_id")
    )
    private List<Agent> agents;

    public Train() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumeroTrain() {
        return numeroTrain;
    }

    public void setNumeroTrain(String numeroTrain) {
        this.numeroTrain = numeroTrain;
    }

    public String getGareDepart() {
        return gareDepart;
    }

    public void setGareDepart(String gareDepart) {
        this.gareDepart = gareDepart;
    }

    public String getGareArrivee() {
        return gareArrivee;
    }

    public void setGareArrivee(String gareArrivee) {
        this.gareArrivee = gareArrivee;
    }

    public String getHeureDepart() {
        return heureDepart;
    }

    public void setHeureDepart(String  heureDepart) {
        this.heureDepart = heureDepart;
    }

    public String getHeureArrivee() {
        return heureArrivee;
    }

    public void setHeureArrivee(String heureArrivee) {
        this.heureArrivee = heureArrivee;
    }

    public List<Agent> getAgents() {
        return agents;
    }

    public void setAgents(List<Agent> agents) {
        this.agents = agents;
    }

    @Override
    public String toString() {
        return "Train{" +
                "numeroTrain='" + numeroTrain + '\'' +
                ", gareDepart='" + gareDepart + '\'' +
                ", gareArrivee='" + gareArrivee + '\'' +
                ", heureDepart='" + heureDepart + '\'' +
                ", heureArrivee='" + heureArrivee + '\'' +
                '}';
    }

}
