--dbo.ticket_type
INSERT INTO event_type([name]) VALUES('Movie')
INSERT INTO event_type([name]) VALUES('Music')
INSERT INTO event_type([name]) VALUES('Drama')
INSERT INTO event_type([name]) VALUES('Sport')


--dbo.city ------------------------------- 
INSERT INTO city([name]) VALUES('Sandiego')
INSERT INTO city([name]) VALUES('Macau')
INSERT INTO city([name]) VALUES('Las Vegas')
INSERT INTO city([name]) VALUES('Ho Chi Minh')
INSERT INTO city([name]) VALUES('Ha Noi')
INSERT INTO city([name]) VALUES('New York')
INSERT INTO city([name]) VALUES('London')



--dbo.payment_type

INSERT INTO payment_type([name]) VALUES('Credit Card')
INSERT INTO payment_type([name]) VALUES('Debit Card')

--dbo.role

INSERT INTO [role]([name]) VALUES('Customer')
INSERT INTO [role]([name]) VALUES('Administrator')

-- account table

insert into account values ('ducviet','ducviet','Nguyen Duc Viet','012345678','161-165 Nguyen Chi Thanh Q10', 'ducviet@gmail.com', getdate(),'1-1-1990', '0122238458', 1)
insert into account values ('hongtam','hongtam','pham Hong Tam','0123456789','141-142 Nguyen Trai Q1', 'hongtam@gmail.com', getdate(),'3-2-1990', '0122238458', 2)
insert into account values ('huusang','huusang','Nguyen Huu sang','012345678125','111-115 Nguyen Van Cu Q5', 'huusang@gmail.com', getdate(),'8-1-1992', '012223845812', 2)
insert into account values('quochai','quochai','Tran Phan Quoc Hai','1234567809','90-92 Nguyen Van Dau Q TB','quochai@gmail.com',getdate(),'6-2-1990','10987654w234',2)

--- venue
INSERT INTO [venue]([name],[address]) VALUES(' Nha Hat Hoa Binh','240 ,3 thang 2, Q 10')
INSERT INTO [venue]([name],[address]) VALUES('San Van Dong Thong Nhat','75, Hoang Van THu ,Q Tan PHu')
INSERT INTO [venue]([name],[address]) VALUES('Nha Thi Dau Phu Tho','25 Ly Thuong Kiet ,Q 10 ')
INSERT INTO [venue]([name],[address]) VALUES('San Quan Khu 7','Nguyen Van Dau , Q Binh Thanh')
---- event
INSERT INTO [event]([title],[content],[artist],[image],[event_typeID],[venueID],[cityID]) 
VALUES('Football','MU-Inter','','',4,2,6)
INSERT INTO [event]([title],[content],[artist],[image],[event_typeID],[venueID],[cityID]) 
VALUES('Football','VN-ThaiLan','','',4,1,5)
INSERT INTO [event]([title],[content],[artist],[image],[event_typeID],[venueID],[cityID]) 
VALUES('Football','Real-Baces','','',4,4,3)
INSERT INTO [event]([title],[content],[artist],[image],[event_typeID],[venueID],[cityID]) 
VALUES('Movie','Co Be Quang Khan Do','','',1,1,5)
INSERT INTO [event]([title],[content],[artist],[image],[event_typeID],[venueID],[cityID]) 
VALUES('Movie','Ong Ba Smith','','',1,4,3)
INSERT INTO [event]([title],[content],[artist],[image],[event_typeID],[venueID],[cityID]) 
VALUES('Movie','Kinh Kong','','',1,2,7)
INSERT INTO [event]([title],[content],[artist],[image],[event_typeID],[venueID],[cityID]) 
VALUES('Music','Buc Tuong','','',2,3,6)
INSERT INTO [event]([title],[content],[artist],[image],[event_typeID],[venueID],[cityID]) 
VALUES('Music','Michael Jackson','','',2,4,5)
INSERT INTO [event]([title],[content],[artist],[image],[event_typeID],[venueID],[cityID]) 
VALUES('Music','Britney Spear','','',3,2,4)
INSERT INTO [event]([title],[content],[artist],[image],[event_typeID],[venueID],[cityID]) 
VALUES('Drama','Hoai Linh','','',2,4,5)
INSERT INTO [event]([title],[content],[artist],[image],[event_typeID],[venueID],[cityID]) 
VALUES('Drama','Hamlet','','',2,1,6)
INSERT INTO [event]([title],[content],[artist],[image],[event_typeID],[venueID],[cityID]) 
VALUES('Drama','Salo','','',2,3,2)
---ticket
INSERT INTO [ticket]([Promotion],[discount],[price],[ticket_total],[create_date],[view_date],[create_username],[eventID])
VALUES ('mua 1 tang 1',15,75,20,14-7,20-7,'ducviet',1)