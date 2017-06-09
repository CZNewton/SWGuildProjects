DROP DATABASE IF EXISTS Register;

CREATE DATABASE Register;

CREATE TABLE Supers (
	SuperID INT NOT NULL auto_increment,
    Hero BOOL NOT NULL,
    SuperName VARCHAR(20) NULL,
    Height INT NULL,
    WeightKilos Decimal(7,2) NULL,
    Power TINYTEXT NULL,
    PowerLevel INT NOT NULL DEFAULT 00000,
    PRIMARY KEY(SuperID));
    
CREATE TABLE Location (
	LocationID INT NOT NULL auto_increment,
    Address VARCHAR(50) NULL,
    LatitudeDMS DECIMAL(8,2) NOT NULL,
    LatitudeDir CHAR NOT NULL,
    LongitudeDMS DECIMAL(8,2) NOT NULL,
    LongitudeDir CHAR NOT NULL,
    PRIMARY KEY(LocationID));
    
CREATE TABLE Sighting (
	SightingID INT NOT NULL auto_increment,
	LocationID INT NOT NULL,
    SightDate DATE NOT NULL,
    SightTime TIME NULL,
	PRIMARY KEY(SightingID),
    FOREIGN KEY(LocationID)
		REFERENCES Location(LocationID)
);

CREATE TABLE Organization (
	OrgID INT NOT NULL auto_increment,
    OrgName VARCHAR(50) NULL,
    Description TINYTEXT NULL,
	Alignment VARCHAR(15) NOT NULL,
    Mail VARCHAR(50) NULL,
    HQLocation TINYTEXT NULL,
    PRIMARY KEY(OrgID));
    
CREATE TABLE Super_x_Organization (
	SuperID INT NOT NULL,
    OrgID INT NOT NULL,
    Relation TINYTEXT NULL,
    PRIMARY KEY(SuperID, OrgID),
    FOREIGN KEY(SuperID)
		REFERENCES Supers(SuperID),
	FOREIGN KEY(OrgID)
		REFERENCES Organization(OrgID)
);

CREATE TABLE Super_x_Sighting (
	SuperID INT NOT NULL,
    SightingID INT NOT NULL,
    PRIMARY KEY(SuperID, SightingID),
    FOREIGN KEY(SuperID)
		REFERENCES Supers(SuperID),
	FOREIGN KEY(SightingID)
		REFERENCES Sighting(SightingID)
);
