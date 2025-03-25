import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


@Entity
@Table(schema="bedrift")
public class Ansatt {

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ansatt_id;//primerNøkkel
	
	@Column(unique = true, nullable = false)
	private String brukernavn;
	
	@Column(nullable = false)
	private String fornavn;
	
	@Column(nullable = false)
	private String etternavn;
	
	@Column(nullable = false)
	private String datoForAnsettelse;
	
	@Column(nullable = false)
	private String stilling;
	
	@Column(nullable = false)
	private int maanendsLonn;
	
	
	@ManyToOne
	@JoinColumn(name = "avdelings_id", nullable =false)
	private Avdeling avdeling; // hver ansatt jobber i en avdeling
	
	 @ManyToMany(mappedBy = "ansatt")
	 private List<AnsattProsjekt> prosjekter;
	 
	public Ansatt() {}
	
	

	public Ansatt(String brukernavn, String fornavn, String etternavn, Avdeling avdeling) {
		this.brukernavn = brukernavn;
		this.fornavn = fornavn;
		this.etternavn = etternavn;
		this.avdeling = avdeling;
	}



	public Integer getAnsatt_id() {
		return ansatt_id;
	}

	public void setAnsatt_id(Integer ansatt_id) {
		this.ansatt_id = ansatt_id;
	}

	public String getBrukernavn() {
		return brukernavn;
	}

	public void setBrukernavn(String brukernavn) {
		this.brukernavn = brukernavn;
	}

	public String getFornavn() {
		return fornavn;
	}

	public void setFornavn(String fornavn) {
		this.fornavn = fornavn;
	}

	public String getEtternavn() {
		return etternavn;
	}

	public void setEtternavn(String etternavn) {
		this.etternavn = etternavn;
	}

	public String getDatoForAnsettelse() {
		return datoForAnsettelse;
	}

	public void setDatoForAnsettelse(String datoForAnsettelse) {
		this.datoForAnsettelse = datoForAnsettelse;
	}

	public String getStilling() {
		return stilling;
	}

	public void setStilling(String stilling) {
		this.stilling = stilling;
	}

	public int getMaanendsLonn() {
		return maanendsLonn;
	}

	public void setMaanendsLonn(int maanendsLonn) {
		this.maanendsLonn = maanendsLonn;
	}

	public Avdeling getAvdeling() {
		return avdeling;
	}

	public void setAvdeling(Avdeling avdeling) {
		this.avdeling = avdeling;
	}

	


	
	
}




