--Book
CREATE TABLE BOOK(title  varchar(400) NOT NULL, author varchar(400) NOT NULL,isbn_num varchar(600), typeOfAvailability varchar(400),book_id  INT NOT NULL AUTO_INCREMENT,total_copies_available int,current_available_copies int, PRIMARY KEY (book_id));
--Member
CREATE TABLE MEMBER(member_id int NOT NULL AUTO_INCREMENT, name varchar(800) not null, isAdmin tinyint(1) default 0, PRIMARY KEY (member_id));
-- Pending Book Requests
CREATE TABLE PENDING_BOOK_REQUESTS(request_id int not null AUTO_INCREMENT,requested_on DATETIME, member_id int not null, book_id int not null, primary key(request_id) );
Currently Reserved Books
CREATE TABLE CURRENTLY_RESERVED_BOOKS(reservation_id int not null auto_increment, issued_on datetime, actual_return_date datetime, return_date datetime,member_id int not null, book_id int not null, primary key(reservation_id));