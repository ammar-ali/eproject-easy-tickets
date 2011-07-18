/*
 -- Purpose: Get ticket
 --Author : Pham Hong Tam
 --Date: 7/14/2011
 --Note: Get ticket
*/


IF EXISTS (SELECT * FROM dbo.sysobjects WHERE NAME='sp_get_ticket' AND xtype='P')
BEGIN
	DROP PROCEDURE sp_get_ticket
END
GO
CREATE PROCEDURE sp_get_ticket
	@event_typeID INT,
	@cityID INT,
    @index_start INT,
	@total_record INT
AS
BEGIN
	DECLARE @cityIDTEMP VARCHAR(10)
	SET @cityIDTemp=@cityID
	IF  @cityID=0
	BEGIN
		SET @cityIDTemp=''
	END

	SELECT ticket.ID AS ID,promotion,discount,price,ticket_total,create_date,view_date,view_time,create_username,eventID
			title,[content], artist,[image],event_typeID,venueID,cityID,city.name AS city_name,venue.name AS venue_name,venue.address AS venue_address INTO #temp
	FROM [ticket],[event],[city],[venue]
	WHERE [ticket].eventID=[event].ID AND [event].event_typeID=@event_typeID AND event.cityID=city.ID AND event.venueID=venue.ID AND event.cityID like '%'+@cityIDTemp+'%'
	ORDER BY ticket.ID DESC

	IF @index_start = '' OR  ISNULL(@index_start,'')='' OR @index_start=0    
	BEGIN    
		SET @index_start=1    
	END 
	IF @index_start <> 1
	BEGIN
		SET @index_start=(@index_start-1)*@total_record+1
	END
	
	SELECT ROW_NUMBER() OVER(ORDER BY ISNULL('','')) AS number,* INTO #temp2 FROM #temp 
	SELECT *  FROM #temp2 WHERE #temp2.number BETWEEN @index_start AND (@index_start+@total_record-1)
END