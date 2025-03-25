import jakarta.persistence.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "Prosjekt",schema = "bedrift")
public class Prosjekt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer prosjekt_id; // Primærnøkkel
    
    @Column(nullable=false, unique = true)
    private String navn;
    
    @Column(nullable=false)
    private String beskrivelse;
    
    @ManyToMany
    @JoinTable(
    		name = "Ansatt_Prosjet",
    		joinColumns = @JoinColumn(name = "prosjekt_id"),
    		inverseJoinColumns = @JoinColumn(name= "ansatt_id")
    )
    
    private Set<Ansatt> ansatte = new HashSet<>();
    
    public Prosjekt() {}

    public Prosjekt(String navn, String beskrivelse) {
        this.navn = navn;
        this.beskrivelse = beskrivelse;
    }

    public Integer getProsjekt_id() {
        return prosjekt_id;
    }

    public void setProsjekt_id(Integer prosjekt_id) {
        this.prosjekt_id = prosjekt_id;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public String getBeskrivelse() {
        return beskrivelse;
    }

    public void setBeskrivelse(String beskrivelse) {
        this.beskrivelse = beskrivelse;
    }

    @Override
    public String toString() {
        return String.format("Prosjekt{id=%d, navn='%s', beskrivelse='%s'}", prosjekt_id, navn, beskrivelse);
    }
}
