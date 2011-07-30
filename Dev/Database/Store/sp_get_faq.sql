/*
 -- Purpose: Get faq
 --Author : Tran Phan Quoc Hai
 --Date: 7/25/2011
 --Note: Get faq
*/


IF EXISTS (SELECT * FROM dbo.sysobjects WHERE NAME='sp_get_faq' AND xtype='P')
BEGIN
	DROP PROCEDURE sp_get_faq
END
GO
CREATE PROCEDURE sp_get_faq
    @index_start INT,
	@total_record INT
AS
BEGIN

	SELECT * INTO #temp
	FROM [FAQ]
	ORDER BY FAQ.ID DESC

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