DROP DATABASE IF EXISTS Register;

CREATE DATABASE Register;

CREATE TABLE Register.Supers (
	SuperID INT NOT NULL auto_increment,
    Hero BOOL NOT NULL,
    SuperName VARCHAR(20) NULL,
    Height INT NULL,
    WeightKilos Decimal(7,2) NULL,
    Power TINYTEXT NULL,
    PowerLevel INT NOT NULL DEFAULT 00000,
    PRIMARY KEY(SuperID));
    
CREATE TABLE Register.Location (
	LocationID INT NOT NULL auto_increment,
    Address VARCHAR(50) NULL,
    LatitudeDMS DECIMAL(8,2) NOT NULL,
    LatitudeDir VARCHAR(1) NOT NULL,
    LongitudeDMS DECIMAL(8,2) NOT NULL,
    LongitudeDir VARCHAR(1) NOT NULL,
    PRIMARY KEY(LocationID));
    
CREATE TABLE Register.Sighting (
	SightingID INT NOT NULL auto_increment,
	LocationID INT NOT NULL,
    SightDate DATE NOT NULL,
    SightTime TIME NOT NULL,
	PRIMARY KEY(SightingID),
    FOREIGN KEY(LocationID)
		REFERENCES Register.Location(LocationID)
);

CREATE TABLE Register.Organization (
	OrgID INT NOT NULL auto_increment,
    OrgName VARCHAR(50) NULL,
    Description TINYTEXT NULL,
	Alignment VARCHAR(15) NOT NULL,
    Mail VARCHAR(50) NULL,
    HQLocation TINYTEXT NULL,
    PRIMARY KEY(OrgID));
    
CREATE TABLE Register.Super_x_Organization (
	SuperID INT NOT NULL,
    OrgID INT NOT NULL,
    Relation TINYTEXT NOT NULL DEFAULT "Unknown at this time",
    PRIMARY KEY(SuperID, OrgID),
    FOREIGN KEY(SuperID)
		REFERENCES Register.Supers(SuperID),
	FOREIGN KEY(OrgID)
		REFERENCES Register.Organization(OrgID)
);

CREATE TABLE Register.Super_x_Sighting (
	SuperID INT NOT NULL,
    SightingID INT NOT NULL,
    PRIMARY KEY(SuperID, SightingID),
    FOREIGN KEY(SuperID)
		REFERENCES Register.Supers(SuperID),
	FOREIGN KEY(SightingID)
		REFERENCES Register.Sighting(SightingID)
);
