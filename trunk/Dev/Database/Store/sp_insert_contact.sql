/*
 -- Purpose: insert contact
 --Author : Tran Phan Quoc Hai
 --Date: 7/26/2011
 --Note:
*/
IF EXISTS (SELECT * FROM dbo.sysobjects WHERE NAME='sp_insert_contact' AND xtype='P')
BEGIN
	DROP PROCEDURE sp_insert_contact
END
GO
CREATE PROCEDURE sp_insert_contact
	@ID INT OUTPUT,
	@title VARCHAR(200),
	@content VARCHAR(500),
	@email VARCHAR(100)
AS
BEGIN
	BEGIN TRANSACTION
		BEGIN TRY
			INSERT INTO contact(title, [content], email, create_date) VALUES (@title,@content, @email,GETDATE())
			SELECT TOP 1 @ID = ID FROM contact ORDER BY ID DESC
		END TRY
		BEGIN CATCH
			ROLLBACK
		END CATCH
	COMMIT
END
