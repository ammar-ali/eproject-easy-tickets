IF EXISTS (SELECT * FROM dbo.sysobjects WHERE NAME='tg_subtraction_tickettotal' AND xtype='TR')
BEGIN
	DROP TRIGGER tg_subtraction_tickettotal
END
GO
CREATE TRIGGER tg_subtraction_tickettotal
ON [dbo].[ticket_booking] FOR INSERT AS
BEGIN
IF EXISTS (SELECT * FROM Inserted)
	BEGIN
		DECLARE @ticketID INT
		DECLARE @number INT
		SET @number=0
		SELECT @ticketID=ticketID,@number=ticket_total FROM [Inserted]
			
		UPDATE ticket SET ticket_total=ticket_total-@number WHERE ID=@ticketID
	END
END 



