/*
 -- Purpose: ispositivenumber
 --Author : Nhung
 --Date: 14/1/2011
 --Note:
*/


IF EXISTS (SELECT * FROM dbo.sysobjects WHERE NAME='ispositivenumber' AND xtype='FN')
BEGIN
	DROP FUNCTION ispositivenumber
END
GO
CREATE FUNCTION ispositivenumber(@str VARCHAR(MAX))
RETURNS INT
AS
BEGIN
	DECLARE @str1 VARCHAR(MAX)
	DECLARE @count int
	SET @count=1
	WHILE(@count<=LEN(@str))
	BEGIN
		SET @str1=SUBSTRING(@str,@count,1)
		IF(@str1='0' OR @str1='1' OR @str1='2' OR @str1='3' OR @str1='4' OR @str1='5'
			OR @str1='6' OR @str1='7' OR @str1='8' OR @str1='9')
		BEGIN
			SET @count=@count+1
		END
		ELSE
		BEGIN
			RETURN 0
		END
	END

	RETURN 1
END
