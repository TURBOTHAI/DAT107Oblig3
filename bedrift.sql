-- Skript for å opprette databasen og legge inn litt data
    -- Skjema = bedrift
        -- Tabell(er) = Ansatt, Prosjekt og avdeling 

-- MERK!!! DROP SCHEMA ... CASCADE sletter alt !!!
DROP SCHEMA IF EXISTS bedrift CASCADE;
CREATE SCHEMA bedrift;
SET search_path TO bedrift;
    
-- Ikke nødvendig å slette tabellen(e) siden vi har tomt skjema, men ...
-- DROP TABLE IF EXISTS person CASCADE;

	private Integer avdelings_id;
	private String navn;
	private String ansatt_sjef;
	
CREATE TABLE Avdeling 
	
(
	avdelings_id SERIAL PRIMARY KEY,
	navn VARCHAR(100) NOT NULL,
	ansatt_sjeff INT NOT NULL,
	CONSTRAINT fk_ansatt_sjef FOREIGN KEY (ansatt_sjef) REFERENCES Ansatt(ansatt_id) ON DELTE RESTRICT
	
	
);

	
CREATE TABLE Ansatt
(
    ansatt_id SERIAL PRIMARY KEY,
    brukernavn VARCHAR(10) NOT NULL,
    fornavn VARCHAR(255) NOT NULL,
    etternavn VARCHAR(255) NOT NULL,
    datoForAnsettelse DATE NOT NULL,
    stilling VARCHAR(100) NOT NULL;
    maanendsLonn INT NOT NULL;
    avdelings_id INT NOT NULL;
    CONSTRAINT fk_avdeling FOREIGN KEY (avdelings_id) REFERENCES Avdeling(Avdelings_id) ON DELETE RESTRICT
    
);


CREATE TABLE Prosjekt
(	
	prosjekt_id SERIAL PRIMARY KEY,
	navn; VARCHAR(100) NOT NULL,
	Beskrivelse TEXT NOT NULL
	
	
);


CREATE TABLE Ansatt_Prosjekt(
	ansatt_id INT NOT NULL,
	prosjekt_id INT NOT NULL,
	rolle VARCHAR(100) NOT NULL,
	antall_jobbtimer INT NOT NULL,
	PRIMARY KEY (ansatt_id, prosjekt_id),
	CONSTRAINT fk_ansatt FOREIGN KEY (ansatt_id) REFERENCES Ansatt(ansatt_id) ON DELETE RESTRICT,
    CONSTRAINT fk_prosjekt FOREIGN KEY (prosjekt_id) REFERENCES Prosjekt(prosjekt_id) ON DELETE RESTRICT
	
);



INSERT INTO ansatt (brukernavn, fornavn, etternavn, datoForAnsettelse,stilling, maanendsLonn, avdelings_id)
VALUES
	('cstr',"christopher","strandheim",'2024-02-01','Utvikler',50000,1);

INSERT INTO Prosjekt (navn, beskrivelse)
VALUES
    ('Webutvikling', 'Utvikling av ny webapplikasjon for intern kommunikasjon.');


INSERT INTO Ansatt_Prosjekt(ansatt_id, prosjekt_id, rolle, antall:jobbtimer)
VALUES
	(1,1,'Prosjektleder',120);

SELECT * FROM ansatt;

