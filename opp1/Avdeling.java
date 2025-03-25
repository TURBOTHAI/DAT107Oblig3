
import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name ="Avdeling", schema= "bedrift")

public class Avdeling {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer avdelings_id;
	
	@Column(nullable = false, unique = true) //den kan ikkje ha en verdi, blir true når den har
	private String navn;
	
	@OneToOne
	@JoinColumn(name =" ansatt_sjef", nullable=false)
	private Ansatt sjef;
	
	@OneToMany(mappedBy = "avdeling")
	private Set<Ansatt> ansatte = new HashSet<>();
	
	
	public Avdeling(){ }

	public Avdeling(String navn, Ansatt sjef) {
		this.navn=navn;
		this.sjef = sjef;
		
		
	}

	
	
	public Integer getAvdelings_id() {
		return avdelings_id;
	}

	public void setAvdelings_id(Integer avdelings_id) {
		this.avdelings_id = avdelings_id;
	}
	
	
	//trenger vi getNavn() og setNavn(), samme med ansatt?
	public String getNavn() {
		return navn;
	}

	public void setNavn(String navn) {
		this.navn = navn;
	}

	public String getAnsatt_sjef() {
		return getAnsatt_sjef();
	}

	public void setAnsatt_sjef(Ansatt sjef) {
		this.sjef = sjef;
	}
	
	
	@Override
	public String toString() {
	    return String.format(
	        "Avdeling{id=%d, navn='%s', ansatt_sjef='%s'}", 
	        avdelings_id, navn, sjef
	    );
	}

	
	

}
