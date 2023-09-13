create table promoter(
promoterid int primary key auto_increment,
promotitemadministratorusernameername varchar(32) not null,
phone varchar(15) not null,
age int not null,
gender varchar(10) NOT NULL,
username varchar(32) not null,
ppassword varchar(32) not null
);

create table administrator(
username varchar(32) not null,
ppassword varchar(32) not null
);


create table gift(
gid int primary key auto_increment,
gname varchar(32) not null
);

create table product(
productid  int primary key auto_increment,
productname varchar(32) not null,
price int not null
);


create table costumer(
cid int primary key auto_increment,
cname varchar(32) not null,
phone varchar(15) not null,
age int not null,
gender varchar(10) NOT NULL,
gid int, 
promoterid int,
foreign key(promoterid) references promoter(promoterid),
foreign key(gid) references gift(gid)
);


create table sales(
productid int,
promoterid int,
cid int,
quantity int not null,
foreign key(cid) references costumer(cid),
foreign key(promoterid) references promoter(promoterid),
foreign key(productid) references product(productid)
);
 


insert into administrator (username, ppassword) values 
("zaid", "123");






select * from costumer;