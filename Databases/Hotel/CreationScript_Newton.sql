DROP DATABASE IF EXISTS Hotel;

CREATE DATABASE Hotel;

CREATE TABLE Hotel.roomTypes (
	TypeID INT NOT NULL,
	roomTypes VARCHAR(10) NOT NULL,
	PRIMARY KEY(TypeID));

CREATE TABLE Hotel.rooms (
	RoomNumber INT NOT NULL,
    RoomFloor INT NOT NULL,
    RoomLimit INT NOT NULL,
    TypeID INT NOT NULL,
    Occupied BOOL NOT NULL,
	PRIMARY KEY(RoomNumber),
    FOREIGN KEY (TypeID)
		REFERENCES Hotel.roomTypes(TypeID));

CREATE TABLE Hotel.rates (
	RateID INT NOT NULL auto_increment,
    TypeID INT NOT NULL,
    RateName VARCHAR(20) NOT NULL,
    PerDay DECIMAL(7,2) NOT NULL,
    PerWeek DECIMAL(7,2) NOT NULL,
    PerMonth DECIMAL(7,2) NOT NULL,
    PRIMARY KEY(RateID),
    FOREIGN KEY(TypeID)
		REFERENCES Hotel.roomTypes(TypeID));
    
CREATE TABLE Hotel.extras (
	ItemID INT NOT NULL auto_increment,
	ItemName VARCHAR(20) NOT NULL,
	PRIMARY KEY(ItemID));
    
CREATE TABLE Hotel.extraPrices (
	PriceID INT NOT NULL auto_increment,
    ItemID INT NOT NULL,
    PriceStart DATE NOT NULL,
    PriceEnd DATE NOT NULL,
    PRIMARY KEY(PriceID),
    FOREIGN KEY(ItemID)
		REFERENCES Hotel.extras(ItemID));
    
CREATE TABLE Hotel.promoCode (
	PromoCodeID INT NOT NULL auto_increment,
    PromoCodeName TINYTEXT NOT NULL,
    PromoCodeDiscount DECIMAL(5,2) NOT NULL,
    PromoCodeTarget VARCHAR(30),
	PRIMARY KEY(PromoCodeID));
    
CREATE TABLE Hotel.bills (
	BillID INT NOT NULL auto_increment,
    PromoCodeID INT NULL,
	PRIMARY KEY(BillID),
    FOREIGN KEY(PromoCodeID)
		REFERENCES Hotel.promoCode(PromoCodeID)
);
    
CREATE TABLE Hotel.customers (
	CustomerID INT NOT NULL auto_increment,
    CustomerName VARCHAR(30) NOT NULL,
    CustomerPhone VARCHAR(10) NOT NULL,
    CustomerEMAIL VARCHAR(30) NOT NULL,
	PRIMARY KEY(CustomerID));

CREATE TABLE Hotel.reservations (
	ReservationNumber INT NOT NULL auto_increment,
	CustomerID INT NOT NULL, /*pulled from customer*/
    StartDate Date NOT NULL,
    EndDate Date NOT NULL,
	BillID INT NOT NULL, /*pulled from hotel.bills*/
	PRIMARY KEY(ReservationNumber),
	FOREIGN KEY(BillID)
		REFERENCES Hotel.bills(BillID),
	FOREIGN KEY(CustomerID)
		REFERENCES Hotel.customers(CustomerID));

CREATE TABLE Hotel.guests (
	GuestID INT NOT NULL,
	FirstName VARCHAR(20) NOT NULL,
    LastName VARCHAR(20) NOT NULL,
    MedicalData TINYTEXT NOT NULL,
	PRIMARY KEY(GuestID));

CREATE TABLE Hotel.amenities (
	AmenityID INT NOT NULL,
    AmenityName VARCHAR(30) NOT NULL,
    AmenityPrice DECIMAL(7,2) NOT NULL,
	PRIMARY KEY(AmenityID));

CREATE TABLE Hotel.roomAndAmenity (
	RoomNumber INT,
    AmenityID INT,
	PRIMARY KEY(RoomNumber, AmenityID),
    FOREIGN KEY (RoomNumber)
		REFERENCES Hotel.rooms(RoomNumber),
	FOREIGN KEY (AmenityID)
		REFERENCES Hotel.amenities(AmenityID));

CREATE TABLE Hotel.reservationAndRoom (
	ReservationNumber INT NOT NULL,
    RoomNumber INT NOT NULL,
	PRIMARY KEY(ReservationNumber, RoomNumber),
	FOREIGN KEY(ReservationNumber) 
		REFERENCES Hotel.reservations(ReservationNumber),
	FOREIGN KEY(RoomNumber)
		REFERENCES Hotel.rooms(RoomNumber));

CREATE TABLE Hotel.ReservationAndGuests (
	ReservationNumber INT NOT NULL,
    GuestID INT NOT NULL,
	PRIMARY KEY(ReservationNumber, GuestID),
    FOREIGN KEY(ReservationNumber)
		REFERENCES Hotel.reservations(ReservationNumber),
	FOREIGN KEY(GuestID)
		REFERENCES Hotel.guests(GuestID));
    
CREATE TABLE Hotel.BillAndExtras (
	BillID INT NOT NULL,
    ItemID INT NOT NULL,
	PRIMARY KEY(BillID, ItemID),
    FOREIGN KEY(BillID)
		REFERENCES Hotel.bills(BillID),
	FOREIGN KEY(ItemID)
		REFERENCES Hotel.extras(ItemID));

/*Need to create bridge tables for:
Rooms<->Ameneties -check
Reservation<->Rooms -check
Reservation<->Guests -check
Bill#<->extras -check
*/