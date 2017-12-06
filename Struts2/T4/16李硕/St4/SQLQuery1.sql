create database db_user

create table users(
  uid int primary key identity(1,1),
  name varchar(20) ,
  password varchar(20),
  sex int,
  education varchar(20),
  love varchar(20)
)
