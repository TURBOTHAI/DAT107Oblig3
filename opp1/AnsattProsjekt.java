import jakarta.persistence.*;

@Entity
@Table(schema = "bedrift")
public class AnsattProsjekt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "ansatt_id", nullable = false)
    private Ansatt ansatt;

    @ManyToOne
    @JoinColumn(name = "prosjekt_id", nullable = false)
    private Prosjekt prosjekt;

    private String rolle;
    private int antallTimer;

    public AnsattProsjekt() {}

    public AnsattProsjekt(Ansatt ansatt, Prosjekt prosjekt, String rolle, int antallTimer) {
        this.ansatt = ansatt;
        this.prosjekt = prosjekt;
        this.rolle = rolle;
        this.antallTimer = antallTimer;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Ansatt getAnsatt() {
        return ansatt;
    }

    public void setAnsatt(Ansatt ansatt) {
        this.ansatt = ansatt;
    }

    public Prosjekt getProsjekt() {
        return prosjekt;
    }

    public void setProsjekt(Prosjekt prosjekt) {
        this.prosjekt = prosjekt;
    }

    public String getRolle() {
        return rolle;
    }

    public void setRolle(String rolle) {
        this.rolle = rolle;
    }

    public int getAntallTimer() {
        return antallTimer;
    }

    public void setAntallTimer(int antallTimer) {
        this.antallTimer = antallTimer;
    }

    @Override
    public String toString() {
        return String.format("AnsattProsjekt{ansatt=%s, prosjekt=%s, rolle='%s', antallTimer=%d}",
                ansatt.getBrukernavn(), prosjekt.getNavn(), rolle, antallTimer);
    }
}
