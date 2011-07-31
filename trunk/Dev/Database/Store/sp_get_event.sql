/*
 -- Purpose: Get event
 --Author : Pham Hong Tam
 --Date: 7/21/2011
 --Note: Get event
*/


IF EXISTS (SELECT * FROM dbo.sysobjects WHERE NAME='sp_get_event' AND xtype='P')
BEGIN
	DROP PROCEDURE sp_get_event
END
GO
CREATE PROCEDURE sp_get_event
	@index_start INT,
	@total_record INT
AS
BEGIN

	SELECT ID INTO #temp FROM [event]
	ORDER BY [event].ID DESC

	IF @index_start = '' OR  ISNULL(@index_start,'')='' OR @index_start=0    
	BEGIN    
		SET @index_start=1    
	END 
	IF @index_start <> 1
	BEGIN
		SET @index_start=(@index_start-1)*@total_record+1
	END
	
	SELECT ROW_NUMBER() OVER(ORDER BY ISNULL('','')) AS number,* INTO #temp2 FROM #temp 
	SELECT ID  FROM #temp2 WHERE #temp2.number BETWEEN @index_start AND (@index_start+@total_record-1)
END