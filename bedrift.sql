-- Skript for å opprette databasen og legge inn litt data
   -- Skjema = bedrift
        -- Tabell(er) = Ansatt, Prosjekt og avdeling 

-- MERK!!! DROP SCHEMA ... CASCADE sletter alt !!!
DROP SCHEMA IF EXISTS bedrift CASCADE;
CREATE SCHEMA bedrift;
SET search_path TO bedrift;
    
-- Ikke nødvendig å slette tabellen(e) siden vi har tomt skjema, men ...
-- DROP TABLE IF EXISTS person CASCADE;


CREATE TABLE Ansatt
(
    ansatt_id SERIAL PRIMARY KEY,
    brukernavn VARCHAR(10) NOT NULL,
    fornavn VARCHAR(255) NOT NULL,
    etternavn VARCHAR(255) NOT NULL,
    datoForAnsettelse DATE NOT NULL,
    stilling VARCHAR(100) NOT NULL,
    maanedsLonn INT NOT NULL,
    avdelings_id INT
 -- Midlertidig uten NOT NULL og constraint
 -- dette er på grunn av at vi kan møte på en sirkulær avhengighet viss vi lager en constraint som er avhenig av avdeling
);
	
CREATE TABLE Avdeling 
	
(
	avdelings_id SERIAL PRIMARY KEY,
	navn VARCHAR(100) NOT NULL,
	ansatt_sjef INT NOT NULL,
	CONSTRAINT fk_ansatt_sjef FOREIGN KEY (ansatt_sjef) REFERENCES Ansatt(ansatt_id) ON DELETE RESTRICT
	--avdeling blir avhengig av ansatt
	
);




-- teoretisk sett så trenger vi ikkje å gjøre dette siden en avdeling trenger teknisk sett ikkje ansatte for at det skal være en avdeling, men her blir det gjort bare for selve kompetansen
-- no legges det til en foreign key constraint i Ansatt som gjør ansatt avhengig i avdeling
	



CREATE TABLE Prosjekt
(	
	prosjekt_id SERIAL PRIMARY KEY,
	navn VARCHAR(100) NOT NULL,
	Beskrivelse TEXT NOT NULL
	
	
);


CREATE TABLE Ansatt_Prosjekt
(
	ansatt_id INT NOT NULL,
	prosjekt_id INT NOT NULL,
	rolle VARCHAR(100) NOT NULL,
	antall_jobbtimer INT NOT NULL,
	PRIMARY KEY (ansatt_id, prosjekt_id),
	CONSTRAINT fk_ansatt FOREIGN KEY (ansatt_id) REFERENCES Ansatt(ansatt_id) ON DELETE RESTRICT,
    CONSTRAINT fk_prosjekt FOREIGN KEY (prosjekt_id) REFERENCES Prosjekt(prosjekt_id) ON DELETE RESTRICT
	
);


INSERT INTO ansatt (brukernavn, fornavn, etternavn, datoForAnsettelse,stilling, maanedsLonn, avdelings_id)


VALUES
	('cstr','christopher','strandheim','2024-02-01','Utvikler',50000,null),
	('dkron','daniel','kronheim','2024-02-01','Utviklrt',60000,2);
	
INSERT INTO Avdeling (navn, ansatt_sjef)
VALUES ('IT-avdelingen', 1);
VALUES ('PT-avdelingen',2);




	

UPDATE Ansatt SET avdelings_id = 1 WHERE ansatt_id = 1;

ALTER TABLE Ansatt ALTER COLUMN avdelings_id SET NOT NULL;

INSERT INTO Prosjekt (navn, beskrivelse)
VALUES
    ('Webutvikling', 'Utvikling av ny webapplikasjon for intern kommunikasjon.');


INSERT INTO Ansatt_Prosjekt(ansatt_id, prosjekt_id, rolle, antall_jobbtimer)
VALUES
	(1,1,'Prosjektleder',120);



SELECT * FROM Ansatt;

