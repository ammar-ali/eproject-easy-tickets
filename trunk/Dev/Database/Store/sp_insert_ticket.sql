/*
 -- Purpose: insert ticket
 --Author : Pham Hong Tam
 --Date: 19/7/2011
 --Note:
*/
IF EXISTS (SELECT * FROM dbo.sysobjects WHERE NAME='sp_insert_ticket' AND xtype='P')
BEGIN
	DROP PROCEDURE sp_insert_ticket
END
GO
CREATE PROCEDURE sp_insert_ticket
	@ID INT OUTPUT,
	@promotion NVARCHAR(300),
	@discount MONEY,
	@price MONEY,
	@ticket_total INT,
	@create_date DATETIME,
	@view_date DATETIME,
	@view_time VARCHAR(5),
	@create_username VARCHAR(50),
	@eventID INT
AS
BEGIN
	BEGIN TRANSACTION
	BEGIN TRY
		INSERT INTO ticket(
			promotion,
			discount,
			price,
			ticket_total,
			create_date,
			view_date,
			view_time,
			create_username,
			eventID
		)
		VALUES(
			@promotion,
			@discount,
			@price MONEY,
			@ticket_total,
			@create_date,
			@view_date,
			@view_time,
			@create_username,
			@eventID
		)
		SELECT TOP 1 @ID=ID  FROM [ticket] ORDER BY ID DESC
	END TRY
	BEGIN CATCH
		ROLLBACK
	END CATCH
	COMMIT
END




