/*
 -- Purpose: insert ticket booking
 --Author : Pham Hong Tam
 --Date: 19/7/2011
 --Note:
*/
IF EXISTS (SELECT * FROM dbo.sysobjects WHERE NAME='sp_insert_ticketbooking' AND xtype='P')
BEGIN
	DROP PROCEDURE sp_insert_ticketbooking
END
GO
CREATE PROCEDURE sp_insert_ticketbooking
	@ID INT OUTPUT,
	@ticketID INT,
	@username VARCHAR(50),
	@admin VARCHAR(50),
	@ticket_total INT,
	@price_total MONEY,
	@discount MONEY,
	@payment_detailID nvarchar(50),
	@card_number VARCHAR(20),
	@payment_typeID INT
AS
BEGIN
	BEGIN TRANSACTION
		BEGIN TRY
			DECLARE @IDPaymentDetailFirst INT
			DECLARE @IDPaymentDetailLast INT
			DECLARE @IDTicketBookingFirst INT
			DECLARE @IDTicketBookingLast INT
			
			SET @IDPaymentDetailFirst=0
			SET @IDPaymentDetailLast=0
			SET @IDTicketBookingFirst=0
			SET @IDTicketBookingLast=0
			
			SELECT TOP 1 @IDPaymentDetailFirst=ID FROM payment_detail ORDER BY ID DESC 			
			SELECT TOP 1 @IDTicketBookingFirst=ID FROM ticket_booking ORDER BY ID DESC 			

			INSERT INTO payment_detail(card_number,payment_typeID) VALUES(@card_number,@payment_typeID)

			SELECT TOP 1 @IDPaymentDetailLast=ID FROM payment_detail ORDER BY ID DESC
			IF(@IDPaymentDetailLast>@IDPaymentDetailFirst)
			BEGIN
				INSERT INTO ticket_booking(ticketID,username,[admin],ticket_total,price_total,discount,payment_detailID)
				VALUES (@ticketID,@username,@admin,@ticket_total,@price_total,@discount,@payment_detailID)
			END		
			
			SELECT TOP 1 @IDTicketBookingLast=ID FROM ticket_booking ORDER BY ID DESC 			
			IF(@IDTicketBookingLast>@IDTicketBookingFirst)
			BEGIN
				SET @ID=@IDTicketBookingLast
			END
			ELSE
			BEGIN
				SET @ID=0
			END
		END TRY
		BEGIN CATCH
			ROLLBACK
		END CATCH
	COMMIT
END
