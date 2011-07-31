/*
 -- Purpose: insert ticket booking
 --Author : Pham Hong Tam
 --Date: 19/7/2011
 --Note:
*/
IF EXISTS (SELECT * FROM dbo.sysobjects WHERE NAME='sp_insert_event' AND xtype='P')
BEGIN
	DROP PROCEDURE sp_insert_event
END
GO
CREATE PROCEDURE sp_insert_event
	@ID INT OUTPUT,
	@title NVARCHAR(200),
	@content NVARCHAR(1000),
	@artist NVARCHAR(200),
	@image VARCHAR(100),
	@eventTypeID INT,
	@venueID INT,
	@cityID INT
AS
BEGIN
	BEGIN TRANSACTION
	BEGIN TRY
		INSERT INTO [event](
			title,
			[content],
			artist,
			[image],
			event_typeID,
			venueID,
			cityID
		)
		VALUES(
			@title,
			@content,
			@artist,
			@image,
			@eventTypeID,
			@venueID,
			@cityID
		)
		SELECT TOP 1 @ID=ID  FROM [event] ORDER BY ID DESC
	END TRY
	BEGIN CATCH
		ROLLBACK
	END CATCH
	COMMIT
END




