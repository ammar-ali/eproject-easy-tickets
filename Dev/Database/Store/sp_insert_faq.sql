/*
 -- Purpose: insert faq
 --Author : Tran Phan Quoc Hai
 --Date: 7/26/2011
 --Note:
*/
IF EXISTS (SELECT * FROM dbo.sysobjects WHERE NAME='sp_insert_faq' AND xtype='P')
BEGIN
	DROP PROCEDURE sp_insert_faq
END
GO
CREATE PROCEDURE sp_insert_faq
	@ID INT OUTPUT,
	@question VARCHAR(200),
	@answer VARCHAR(500),
AS
BEGIN
	BEGIN TRANSACTION
		BEGIN TRY
			INSERT INTO FAQ(question, answer, create_date) VALUES (@question, @answer,GETDATE())
			SELECT TOP 1 @ID = ID FROM FAQ ORDER BY ID DESC
		END TRY
		BEGIN CATCH
			ROLLBACK
		END CATCH
	COMMIT
END
