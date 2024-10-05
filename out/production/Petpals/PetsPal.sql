-- 1. Provide a SQL script that initializes the database for the Pet Adoption Platform ”PetPals”.

CREATE DATABASE IF NOT EXISTS PETPALS;
USE PETPALS;

-- 2. Create tables for pets, shelters, donations, adoption events, and participants.
-- 3. Define appropriate primary keys, foreign keys, and constraints.
-- 4. Ensure the script handles potential errors, such as if the database or tables already exist.

CREATE TABLE IF NOT EXISTS Pets(
PetID INT PRIMARY KEY,
Name VARCHAR(50),
Age INT,
Breed VARCHAR(50),
Type VARCHAR(50),
AvailableForAdoption BIT
);

CREATE TABLE IF NOT EXISTS Shelters(
ShelterID INT PRIMARY KEY,
Name VARCHAR(50),
Location VARCHAR(100)
);

CREATE TABLE IF NOT EXISTS Donations(
DonationID INT PRIMARY KEY,
DonorName VARCHAR(50),
DonationType VARCHAR(50),
DonationAmount DECIMAL(10,2),
DonationItem VARCHAR(50),
DonationDate datetime
);

CREATE TABLE IF NOT EXISTS AdoptionEvents (
    EventID INT PRIMARY KEY,
    EventName VARCHAR(50),
    EventDate DATETIME,
    Location VARCHAR(100)
);

CREATE TABLE IF NOT EXISTS Participants (
    ParticipantID INT PRIMARY KEY,
    ParticipantName VARCHAR(50),
    ParticipantType VARCHAR(50),
    EventID INT,
    FOREIGN KEY (EventID) REFERENCES AdoptionEvents(EventID)
);

SHOW TABLES;

-- INSERTING DATA IN TABLES

INSERT INTO Pets (PetID, Name, Age, Breed, Type, AvailableForAdoption)
VALUES
(1, 'Buddy', 3, 'Golden Retriever', 'Dog', 1),
(2, 'Whiskers', 2, 'Persian', 'Cat', 1),
(3, 'Charlie', 5, 'Beagle', 'Dog', 0),
(4, 'Simba', 1, 'Maine Coon', 'Cat', 1),
(5, 'Max', 7, 'Labrador', 'Dog', 0),
(6, 'Milo', 2, 'Shih Tzu', 'Dog', 1),
(7, 'Luna', 4, 'Siamese', 'Cat', 1),
(8, 'Coco', 3, 'Poodle', 'Dog', 1),
(9, 'Shadow', 6, 'German Shepherd', 'Dog', 0),
(10, 'Bella', 3, 'Ragdoll', 'Cat', 1);

INSERT INTO Shelters (ShelterID, Name, Location)
VALUES
(1, 'Happy Paws Shelter', 'New York'),
(2, 'Furry Friends Home', 'Los Angeles'),
(3, 'Pets Haven', 'Chicago'),
(4, 'Safe Haven Shelter', 'Houston'),
(5, 'Paw Rescue Center', 'Phoenix'),
(6, 'Animal Shelter', 'Philadelphia'),
(7, 'Adopt a Paw', 'San Diego'),
(8, 'The Rescue Corner', 'Dallas'),
(9, 'Cozy Pet Haven', 'San Jose'),
(10, 'Second Chance Shelter', 'Austin');

INSERT INTO Donations (DonationID, DonorName, DonationType, DonationAmount, DonationItem, DonationDate)
VALUES
(1, 'John Doe', 'Cash', 150.00, NULL, '2024-08-15 10:30:00'),
(2, 'Jane Smith', 'Item', NULL, 'Dog Food', '2024-07-21 14:45:00'),
(3, 'Paul Brown', 'Cash', 200.00, NULL, '2024-06-12 09:15:00'),
(4, 'Emily Davis', 'Item', NULL, 'Cat Toys', '2024-05-18 12:00:00'),
(5, 'Michael Wilson', 'Cash', 100.00, NULL, '2024-08-25 11:00:00'),
(6, 'Sarah Lee', 'Item', NULL, 'Dog Beds', '2024-06-25 16:30:00'),
(7, 'Chris Johnson', 'Cash', 250.00, NULL, '2024-09-02 08:45:00'),
(8, 'Nancy Green', 'Item', NULL, 'Blankets', '2024-07-30 17:15:00'),
(9, 'Tom White', 'Cash', 300.00, NULL, '2024-08-05 09:30:00'),
(10, 'Rebecca Clark', 'Item', NULL, 'Pet Carriers', '2024-08-12 14:00:00');

INSERT INTO AdoptionEvents (EventID, EventName, EventDate, Location)
VALUES
(1, 'Summer Adoption Fair', '2024-06-05 10:00:00', 'Central Park, New York'),
(2, 'Pet Fest', '2024-07-15 09:30:00', 'Los Angeles Convention Center'),
(3, 'Adopt-a-thon', '2024-08-20 11:00:00', 'Millennium Park, Chicago'),
(4, 'Paws for Cause', '2024-09-10 12:00:00', 'Houston City Hall'),
(5, 'Adoption Day', '2024-08-25 10:30:00', 'Phoenix Fairgrounds'),
(6, 'Furry Friends Fest', '2024-07-30 09:00:00', 'San Diego Beach Park'),
(7, 'Rescue Rally', '2024-08-15 14:00:00', 'Dallas Event Center'),
(8, 'Shelter Pets Day', '2024-06-20 13:00:00', 'Philadelphia Downtown'),
(9, 'Adoption Carnival', '2024-09-05 10:00:00', 'San Jose Square'),
(10, 'Adopt-a-Pet Day', '2024-09-18 11:00:00', 'Austin City Park');

INSERT INTO Participants (ParticipantID, ParticipantName, ParticipantType, EventID)
VALUES
(1, 'Happy Paws Shelter', 'Shelter', 1),
(2, 'Furry Friends Home', 'Shelter', 2),
(3, 'Paul Brown', 'Adopter', 3),
(4, 'Safe Haven Shelter', 'Shelter', 4),
(5, 'Emily Davis', 'Adopter', 5),
(6, 'Paw Rescue Center', 'Shelter', 6),
(7, 'Animal Shelter', 'Shelter', 7),
(8, 'Nancy Green', 'Adopter', 8),
(9, 'Adopt a Paw', 'Shelter', 9),
(10, 'Tom White', 'Adopter', 10);

SELECT * FROM Pets;
SELECT * FROM Shelters;
SELECT * FROM Donations;
SELECT * FROM AdoptionEvents;
SELECT * FROM Participants;

-- 5. Write an SQL query that retrieves a list of available pets (those marked as available for adoption)from the "Pets" table. Include the pet's name, age, breed, and type in the result set. Ensure thatthe query filters out pets that are not available for adoption.

SELECT Name, Age, Breed, Type FROM Pets WHERE AvailableForAdoption = 1;

-- 6. Write an SQL query that retrieves the names of participants (shelters and adopters) registeredfor a specific adoption event. Use a parameter to specify the event ID. Ensure that the queryjoins the necessary tables to retrieve the participant names and types.

SELECT ParticipantName, ParticipantType
FROM Participants
INNER JOIN AdoptionEvents ON Participants.EventID = AdoptionEvents.EventID
WHERE AdoptionEvents.EventID = 7;

-- 7. Create a stored procedure in SQL that allows a shelter to update its information (name and location) in the "Shelters" table. Use parameters to pass the shelter ID and the new information. Ensure that the procedure performs the update and handles potential errors, such as an invalid shelter ID.

DELIMITER //

CREATE PROCEDURE UpdateShelterInfo (
    IN p_ShelterID INT,            
    IN NewName VARCHAR(50),     
    IN NewLocation VARCHAR(100)  
)
BEGIN
    IF EXISTS (SELECT 1 FROM Shelters WHERE ShelterID = ShelterID) THEN
        UPDATE Shelters
        SET Name = NewName, Location = NewLocation
        WHERE ShelterID = p_ShelterID;
        SELECT 'Shelter information updated successfully.' AS Message;
    ELSE
        SELECT 'Error: Invalid ShelterID.' AS ErrorMessage;
    END IF;
END //
DELIMITER ;

CALL UpdateShelterInfo(4, 'Austin Homes', 'London');
SET SQL_SAFE_UPDATES = 0;

-- 8 Write an SQL query that calculates and retrieves the total donation amount for each shelter (by shelter name) from the "Donations" table. The result should include the shelter name and the total donation amount. Ensure that the query handles cases where a shelter has received no donations.

SELECT Name, 
SUM(DonationAmount) AS TotalDonation
FROM Shelters 
LEFT JOIN Donations  ON Shelters.ShelterID = Donations.DonationID
GROUP BY Name;

-- 9.Write an SQL query that retrieves the names of pets from the "Pets" table that do not have an owner (i.e., where "OwnerID" is null). Include the pet's name, age, breed, and type in the result set.

-- The query is wrong as no attribute such as OwnerId exists.

-- 10. Write an SQL query that retrieves the total donation amount for each month and year (e.g., January 2023) from the "Donations" table. The result should include the month-year and the corresponding total donation amount. Ensure that the query handles cases where no donations were made in a specific month-year.

SELECT DATE_FORMAT(DonationDate, '%Y-%m') AS MonthYear, SUM(DonationAmount) AS TotalDonations
FROM Donations
GROUP BY DATE_FORMAT(DonationDate, '%Y-%m');

-- 11. Retrieve a list of distinct breeds for all pets that are either aged between 1 and 3 years or older than 5 years.

SELECT DISTINCT Breed
FROM Pets
WHERE (Age BETWEEN 1 AND 3) OR Age > 5;

-- 12. Retrieve a list of pets and their respective shelters where the pets are currently available for adoption.

-- Wrong query as there is no connection between pets and their respective shelters

-- 13 Find the total number of participants in events organized by shelters located in specific city. Example: City=Chennai

SELECT COUNT(ParticipantID) AS TotalParticipants
FROM Participants
JOIN AdoptionEvents ON Participants.EventID = AdoptionEvents.EventID
JOIN Shelters ON AdoptionEvents.Location = Shelters.Location
WHERE ParticipantType = "Shelter" AND Shelters.Location="Phoenix";

-- 14. Retrieve a list of unique breeds for pets with ages between 1 and 5 years.

SELECT DISTINCT Breed
FROM Pets
WHERE Age BETWEEN 1 AND 5;

-- 15 Find the pets that have not been adopted by selecting their information from the 'Pet' table.

SELECT * FROM Pets
WHERE AvailableForAdoption = 0;

-- 16. Retrieve the names of all adopted pets along with the adopter's name from the 'Adoption' and 'User' tables.

-- No such tables- Adoption and User are available or asked to create


-- 17. Retrieve a list of all shelters along with the count of pets currently available for adoption in each shelter.

-- No such connection is there in both shelter and pet table that specify No of pets in each shelter.

-- 18. Find pairs of pets from the same shelter that have the same breed.

-- No such connection is there in both shelter and pet table that specify No of pets in each shelter or breed.

-- 19. List all possible combinations of shelters and adoption events.

SELECT Shelters.Name AS ShelterName, AdoptionEvents.EventName
FROM Shelters
cross join AdoptionEvents;

-- 20. Determine the shelter that has the highest number of adopted pets.

-- No such connection is there in both shelter and pet table that specify No of pets in each shelter or breed.


