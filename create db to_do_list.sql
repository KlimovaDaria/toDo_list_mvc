create database to_do_list;
use to_do_list;

create table users ( 
id int not null auto_increment,
name varchar(15),
email varchar(100),
PRIMARY KEY (id));

create table tasks (
id int not null auto_increment,
name varchar(100),
details varchar(255),
user_id int not null,
PRIMARY KEY (id),
FOREIGN KEY (user_id) REFERENCES users(id));



