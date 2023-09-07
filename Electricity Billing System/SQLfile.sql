create database ebs;

use ebs;

create table login(meterno varchar(20), username varchar(30), name varchar(30), password varchar(20), user varchar(20));

create table customer(name varchar(20),meterno varchar(20), address varchar(50),state varchar(20),city varchar(20),email varchar(30),phone varchar(15));

create table meterinfo(meternumber varchar(20), meterLocation varchar(20),metertype varchar(20),phasecode varchar(20),billtype varchar(20),days varchar(20));

create table tax(cost_per_unit varchar(20), meter_rent varchar(20), service_charge varchar(20), service_tax varchar(20), swacch_bharat_cess varchar(20), fixed_tax varchar(20));

insert into tax values('9','47','22','57','6','18');

create table bill(meterno varchar(20), month varchar(30), units varchar(20), totalbill varchar(20), status varchar(20));

truncate table login;
truncate table tax;
truncate table meterinfo;
truncate table bill;
truncate table customer;

select * from bill;
select * from tax;
