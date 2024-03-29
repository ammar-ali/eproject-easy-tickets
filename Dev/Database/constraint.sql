
-------------------------------------------Constraint------------------------------------------------

	CREATE UNIQUE INDEX ix_ticket_booking_payment_detailID ON ticket_booking(payment_detailID)

	ALTER TABLE account
	ADD CONSTRAINT chk_account_create_date CHECK (create_date>birth_date)
	
	ALTER TABLE account
	ADD CONSTRAINT chk_account_phone CHECK (dbo.ispositivenumber(phone)=1)

	ALTER TABLE account
	ADD CONSTRAINT chk_account_person_card_number CHECK (dbo.ispositivenumber(person_card_number)=1)
	
	ALTER TABLE ticket_booking
	ADD CONSTRAINT chk_ticket_booking_discount CHECK (discount<=price_total)

	ALTER TABLE ticket_booking
	ADD CONSTRAINT chk_ticket_booking_accept_status CHECK (accept_status='1' or accept_status='0')
		
	ALTER TABLE ticket_booking
	ADD CONSTRAINT chk_ticket_booking_ticket_total CHECK (ticket_total>0)
	
	ALTER TABLE ticket_booking
	ADD CONSTRAINT chk_ticket_booking_price_total CHECK (price_total>0)
	
	ALTER TABLE ticket
	ADD CONSTRAINT chk_ticket_discount CHECK (discount<price)
	
	ALTER TABLE ticket
	ADD CONSTRAINT chk_ticket_ticket_total CHECK (ticket_total>=0)
	
	ALTER TABLE ticket
	ADD CONSTRAINT chk_ticket_price CHECK (price>0)
	
	ALTER TABLE ticket
	ADD CONSTRAINT chk_ticket_create_date CHECK (create_date<=view_date)
	
	ALTER TABLE payment_detail
	ADD CONSTRAINT chk_payment_detail_card_number CHECK (dbo.ispositivenumber(card_number)=1)

