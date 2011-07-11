--dbo.ticket_type
INSERT INTO ticket_type([name]) VALUES('Movie')
INSERT INTO ticket_type([name]) VALUES('Music')
INSERT INTO ticket_type([name]) VALUES('Drama')
INSERT INTO ticket_type([name]) VALUES('Sport')


--dbo.city ------------------------------- 
INSERT INTO city([name]) VALUES('Sandiego')
INSERT INTO city([name]) VALUES('Macau')
INSERT INTO city([name]) VALUES('Las Vegas')
INSERT INTO city([name]) VALUES('Ho Chi Minh')
INSERT INTO city([name]) VALUES('Ha Noi')
INSERT INTO city([name]) VALUES('New York')
INSERT INTO city([name]) VALUES('London')


--dbo.card_type

INSERT INTO card_type([name]) VALUES('Visa Card')
INSERT INTO card_type([name]) VALUES('Master Card')


--dbo.payment_type

INSERT INTO payment_type([name]) VALUES('Credit Card')
INSERT INTO payment_type([name]) VALUES('Debit Card')

--dbo.role

INSERT INTO [role]([name]) VALUES('Customer')
INSERT INTO [role]([name]) VALUES('Administrator')

