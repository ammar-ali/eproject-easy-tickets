USE [master]
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
	[person_card_number] VARCHAR(20) NOT NULL,
	[roleID] INT
)


CREATE TABLE [role]
(
	[ID] INT IDENTITY(1,1) PRIMARY KEY,
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
	[ID] INT IDENTITY(1,1) PRIMARY KEY,
	[promotion] NVARCHAR(300),
	[discount] MONEY,
	[price] MONEY NOT NULL,
	[ticket_total] INT DEFAULT 1 NOT NULL,
	[create_date] DATETIME NOT NULL,
	[view_date] DATETIME NOT NULL,
	[view_time] TIMESTAMP NOT NULL,
	[create_username] VARCHAR(50),	
	[eventID] INT --fk
)

CREATE TABLE [venue]
(
	[ID] INT IDENTITY (1,1) PRIMARY KEY,
	[name] NVARCHAR(100) NOT NULL,
	[address] NVARCHAR(100) NOT NULL
)

CREATE TABLE [event]
(
	[ID] INT IDENTITY (1,1) PRIMARY KEY,
	[title] NVARCHAR(200) NOT NULL,
	[content] NVARCHAR(1000),
	[artist] NVARCHAR(200),
	[image] VARCHAR(100),
	[event_typeID] INT, --fk
	[venueID] INT, --fk
	[cityID] INT --fk
)

CREATE TABLE [event_type]
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
	[card_number] VARCHAR(20) NOT NULL,
	[payment_typeID] INT --fk
)

CREATE TABLE [ticket_booking]	
(	
	[ID] INT IDENTITY(1,1) PRIMARY KEY,
	[ticketID] INT, -- fk
	[username] VARCHAR(50), -- fk,
	[admin] VARCHAR(50), -- fk
	[ticket_total] INT DEFAULT 1 NOT NULL ,
	[price_total] MONEY NOT NULL,
	[discount] MONEY,
	[accept_status] CHAR DEFAULT '0' NOT NULL, --1 ACCEPT , 0 NOT YET,
	[payment_detailID] INT, -- fk,
	[delivery_date] DATETIME
)


-----------------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------------


---CONSTRAINT----------------------------------------------------------------------------------
------------------------------------------FOREIGN KEY------------------------------------------

ALTER TABLE [account]
ADD CONSTRAINT fk_account_roleID FOREIGN KEY([roleID]) REFERENCES [role]([ID])

ALTER TABLE [contact]
ADD CONSTRAINT fk_contact_username FOREIGN KEY([username]) REFERENCES [account]([username])

ALTER TABLE [FAQ]
ADD CONSTRAINT fk_FAQ_username FOREIGN KEY([username]) REFERENCES [account]([username])

ALTER TABLE [ticket] 
ADD CONSTRAINT fk_ticket_create_user FOREIGN KEY([create_username]) REFERENCES [account]([username]);

ALTER TABLE [ticket] 
ADD CONSTRAINT fk_ticket_eventID FOREIGN KEY([eventID]) REFERENCES [event]([ID])

ALTER TABLE [event] 
ADD CONSTRAINT fk_event_cityID FOREIGN KEY([cityID]) REFERENCES [city]([ID])

ALTER TABLE [event] 
ADD CONSTRAINT fk_event_venueID FOREIGN KEY([venueID]) REFERENCES venue([ID])

ALTER TABLE [event] 
ADD CONSTRAINT fk_event_type_event_typeID FOREIGN KEY([event_typeID]) REFERENCES [event_type]([ID])

ALTER TABLE [payment_detail] 
ADD CONSTRAINT fk_payment_detail_payment_typeID FOREIGN KEY([payment_typeID]) REFERENCES [payment_type]([ID])

ALTER TABLE [ticket_booking] 
ADD CONSTRAINT fk_ticket_booking_ticketID FOREIGN KEY([ticketID]) REFERENCES [ticket]([ID])

ALTER TABLE [ticket_booking] 
ADD CONSTRAINT fk_ticket_booking_username FOREIGN KEY([username]) REFERENCES [account]([username])

ALTER TABLE [ticket_booking] 
ADD CONSTRAINT fk_ticket_booking_usercheck FOREIGN KEY([admin]) REFERENCES [account]([username])

ALTER TABLE [ticket_booking] 
ADD CONSTRAINT fk_ticket_booking_payment_detailID FOREIGN KEY([payment_detailID]) REFERENCES [payment_detail]([ID])


-----------------------------------------------------------------------------------------------