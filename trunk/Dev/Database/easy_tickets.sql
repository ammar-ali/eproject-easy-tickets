
--------------------------------------------DATABASE--------------------------------------------
---Name: easy_tickets
---Date: 7/10/2011 (mm/dd/yyyy)
------------------------------------------------------------------------------------------------
--CREATE DATABASE easy_tickets

USE easy_tickets

---------------------------------------------CREATE TABLE---------------------------------------

CREATE TABLE [account]
(
	[username] VARCHAR(50) PRIMARY KEY,
	[password] VARCHAR(50) NOT NULL,
	[fullname] NVARCHAR(50) NOT NULL,
	[phone] VARCHAR(15),
	[address] VARCHAR(100) NOT NULL,
	[email] VARCHAR(100),
	[create_date] DATETIME,
	[birth_date] DATETIME,
	[roleID] INT	
)


CREATE TABLE [role]
(
	[roleID] INT IDENTITY(1,1) PRIMARY KEY,
	[name] NVARCHAR(50) NOT NULL
)

CREATE TABLE [contact]
(
	[ID] INT IDENTITY(1,1) PRIMARY KEY,
	[title] NVARCHAR(200) NOT NULL,
	[content] NVARCHAR(500) NOT NULL,
	[answer] NVARCHAR(500),
	[email] VARCHAR(100) NOT NULL,
	[create_date] DATETIME,
	[username] VARCHAR(50)	
)

CREATE TABLE [FAQ]
(
	[ID] INT IDENTITY(1,1) PRIMARY KEY,
	[question] NVARCHAR(200) NOT NULL,
	[answer] NVARCHAR(500) NOT NULL,
	[create_date] DATETIME,
	[username] VARCHAR(50)	
)

--
CREATE TABLE [city]
(
	[ID] INT IDENTITY(1,1) PRIMARY KEY,
	[name] NVARCHAR(50) NOT NULL
)

CREATE TABLE [ticket]
(
	[ticketID] INT IDENTITY(1,1) PRIMARY KEY,
	[image] VARCHAR(100),
	[promotion] NVARCHAR(300),
	[discount] MONEY,
	[price] MONEY NOT NULL,
	[ticket_total] INT DEFAULT 1 NOT NULL,
	[create_date] DATETIME NOT NULL,
	[view_date] DATETIME NOT NULL,
	[view_time] TIMESTAMP NOT NULL,
	[ticket_typeID] INT, --fk
	[cityID] INT, --fk
	[address] NVARCHAR(100) NOT NULL,
	[create_username] VARCHAR(50),	
	[categoryID] INT
)

CREATE TABLE [movie_ticket]
(
	[ID] INT IDENTITY (1,1) PRIMARY KEY,
	[ticketID] INT, --fk
	[title] NVARCHAR(200) NOT NULL,
	[content] NVARCHAR(1000),
	[director] NVARCHAR(200),
	[actor] NVARCHAR(200)
)

CREATE TABLE [music_ticket]
(
	[ID] INT IDENTITY (1,1) PRIMARY KEY,
	[ticketID] INT, -- fk
	[song] NVARCHAR(100) NOT NULL,
	[singer] NVARCHAR(200),
	[content] NVARCHAR(1000)
)

CREATE TABLE [drama_ticket]
(
	[ID] INT IDENTITY (1,1) PRIMARY KEY,
	[ticketID] INT, --fk
	[title]  NVARCHAR(100) NOT NULL,
	[content] NVARCHAR(1000),
	[artist] NVARCHAR(200)
)

CREATE TABLE [sport_ticket]
(
	[ID] INT IDENTITY (1,1) PRIMARY KEY,
	[ticketID] INT, --fk
	[title] NVARCHAR(100) NOT NULL,
	[content] NVARCHAR(1000)
)

CREATE TABLE [area]
(
	[ID] INT IDENTITY (1,1) PRIMARY KEY,
	[name] NVARCHAR(100) NOT NULL,
)

CREATE TABLE [category]
(
	[ID] INT IDENTITY (1,1) PRIMARY KEY,
	[name] NVARCHAR(100) NOT NULL,
	[areaID] INT
)

CREATE TABLE [ticket_type]
(
	[ID] INT IDENTITY(1,1) PRIMARY KEY,
	[name] NVARCHAR(100) NOT NULL
)

CREATE TABLE [card_type]
(
	[ID] INT IDENTITY(1,1) PRIMARY KEY,
	[name] NVARCHAR(100) NOT NULL
)

CREATE TABLE [payment_type]
(
	[ID] INT IDENTITY(1,1) PRIMARY KEY,
	[name] NVARCHAR(100) NOT NULL
)

CREATE TABLE [payment_detail]
(
	[ID] INT IDENTITY(1,1) PRIMARY KEY,
	[cc_number] VARCHAR(20) NOT NULL,
	[cvv] VARCHAR(20) NOT NULL,
	[security_number] VARCHAR(20) NOT NULL,
	[expiration_date] DATETIME,
	[payment_typeID] INT, --fk
	[card_typeID] INT -- fk
)

CREATE TABLE [ticket_booking]	
(	
	[ID] INT IDENTITY(1,1) PRIMARY KEY,
	[ticketID] INT, -- fk
	[username] VARCHAR(50), -- fk,
	[usercheck] VARCHAR(50), -- fk
	[ticket_total] INT DEFAULT 1 NOT NULL ,
	[price_total] MONEY NOT NULL,
	[promotion] NVARCHAR(300),
	[discount] MONEY,
	[accept_status] CHAR DEFAULT '0' NOT NULL, --1 ACCEPT , 0 NOT YET,
	[person_card_number] VARCHAR(20) NOT NULL,
	[payment_detailID] INT, -- fk,
	[receiver_name] NVARCHAR(50),
	[receive_date] DATETIME
)


-----------------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------------


---CONSTRAINT----------------------------------------------------------------------------------
------------------------------------------FOREIGN KEY------------------------------------------

ALTER TABLE [account]
ADD CONSTRAINT fk_account_roleID FOREIGN KEY([roleID]) REFERENCES [role]([roleID])

ALTER TABLE [contact]
ADD CONSTRAINT fk_contact_username FOREIGN KEY([username]) REFERENCES [account]([username])

ALTER TABLE [FAQ]
ADD CONSTRAINT fk_FAQ_username FOREIGN KEY([username]) REFERENCES [account]([username])

ALTER TABLE [ticket] 
ADD CONSTRAINT fk_ticket_ticket_typeID FOREIGN KEY(ticket_typeID) REFERENCES ticket_type(ID)

ALTER TABLE [ticket] 
ADD CONSTRAINT fk_ticket_cityID FOREIGN KEY(cityID) REFERENCES city(ID)

ALTER TABLE [ticket] 
ADD CONSTRAINT fk_ticket_create_user FOREIGN KEY(create_username) REFERENCES account(username);

ALTER TABLE [ticket] 
ADD CONSTRAINT fk_ticket_categoryID FOREIGN KEY(categoryID) REFERENCES category(ID)

ALTER TABLE [movie_ticket] 
ADD CONSTRAINT fk_movie_ticket_ticketID FOREIGN KEY(ticketID) REFERENCES ticket(ticketID)

ALTER TABLE [music_ticket] 
ADD CONSTRAINT fk_music_ticket_ticketID FOREIGN KEY(ticketID) REFERENCES ticket(ticketID)

ALTER TABLE [drama_ticket] 
ADD CONSTRAINT fk_drama_ticket_ticketID FOREIGN KEY(ticketID) REFERENCES ticket(ticketID)

ALTER TABLE [sport_ticket] 
ADD CONSTRAINT fk_sport_ticket_ticketID FOREIGN KEY(ticketID) REFERENCES ticket(ticketID)

ALTER TABLE [payment_detail] 
ADD CONSTRAINT fk_payment_detail_payment_typeID FOREIGN KEY(payment_typeID) REFERENCES payment_type(ID)

ALTER TABLE [payment_detail] 
ADD CONSTRAINT fk_payment_detail_card_typeID FOREIGN KEY(card_typeID) REFERENCES card_type(ID)

ALTER TABLE [ticket_booking] 
ADD CONSTRAINT fk_ticket_booking_ticketID FOREIGN KEY(ticketID) REFERENCES ticket(ticketID)

ALTER TABLE [ticket_booking] 
ADD CONSTRAINT fk_ticket_booking_username FOREIGN KEY(username) REFERENCES account(username)

ALTER TABLE [ticket_booking] 
ADD CONSTRAINT fk_ticket_booking_usercheck FOREIGN KEY(username) REFERENCES account(username)

ALTER TABLE [ticket_booking] 
ADD CONSTRAINT fk_ticket_booking_payment_detailID FOREIGN KEY(payment_detailID) REFERENCES payment_detail(ID)

ALTER TABLE [category] 
ADD CONSTRAINT fk_category_areaID FOREIGN KEY(areaID) REFERENCES area(ID)

-----------------------------------------------------------------------------------------------