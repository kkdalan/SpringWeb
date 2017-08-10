use security;

--==========================
--       drop tables
--==========================
--user authentication
if object_id('security.dbo.authorities' , 'U') is not null 
    drop table security.dbo.authorities;
	
if object_id('security.dbo.users' , 'U') is not null
    drop table security.dbo.users;
	
--group authentication
if object_id('security.dbo.group_members' , 'U') is not null 
    drop table security.dbo.group_members;
	
if object_id('security.dbo.group_authorities' , 'U') is not null 
    drop table security.dbo.group_authorities;

if object_id('security.dbo.groups' , 'U') is not null
    drop table security.dbo.groups;

--==========================
--      create tables
--==========================
--user authentication
create table security.dbo.users (
    username varchar(50) not null,
    password varchar(50) not null,
    enabled  int not null  default 1,
    constraint pk_username primary key (username)
);

create table security.dbo.authorities (
    user_authority_id int not null identity(1,1),
	username varchar(50) not null,
    authority varchar(50) not null,
    constraint pk_user_authority_id primary key (user_authority_id),
	constraint fk_username foreign key (username) references users(username)
);

--group authentication
create table security.dbo.groups (
    id int not null identity(1,1),
    group_name varchar(50) not null,
    constraint pk_group primary key (id)
);

create table security.dbo.group_authorities (
    group_id int not null,
    authority varchar(50) not null,
 	constraint fk_group_authorities_group foreign key (group_id) references groups(id)
);

create table security.dbo.group_members (
    id int not null identity(1,1),
    username varchar(50) not null,
	group_id int not null,
	constraint pk_group_members primary key (id),
 	constraint fk_group_members_group foreign key (group_id) references groups(id),
	constraint fk_group_members_username foreign key (username) references users(username)
);

--==========================
--      insert data
--==========================
--user authentication
insert into security.dbo.users(username,password,enabled) values ('Tom','Tom', 1);
insert into security.dbo.users(username,password,enabled) values ('John','John', 1);
insert into security.dbo.users(username,password,enabled) values ('Susan','Susan', 1);
insert into security.dbo.users(username,password,enabled) values ('Alan','Alan', 1); 

insert into security.dbo.authorities (username, authority) values ('Tom', 'ROLE_USER');
insert into security.dbo.authorities (username, authority) values ('John', 'ROLE_USER');
insert into security.dbo.authorities (username, authority) values ('Susan', 'ROLE_USER');
insert into security.dbo.authorities (username, authority) values ('Alan', 'ROLE_USER');
insert into security.dbo.authorities (username, authority) values ('Alan', 'ROLE_ADMIN');

--group authentication
insert into security.dbo.groups(group_name) values ('account');
insert into security.dbo.groups(group_name) values ('accountoffer');
insert into security.dbo.groups(group_name) values ('riskteam');
insert into security.dbo.groups(group_name) values ('opadmin');

insert into security.dbo.group_authorities (group_id, authority) values (1,'ROLE_OPERATOR');
insert into security.dbo.group_authorities (group_id, authority) values (2,'ROLE_OPERATOR');
insert into security.dbo.group_authorities (group_id, authority) values (3,'ROLE_OPERATOR');
insert into security.dbo.group_authorities (group_id, authority) values (4,'ROLE_OPERATOR');
insert into security.dbo.group_authorities (group_id, authority) values (2,'ROLE_SUPERVISOR');
insert into security.dbo.group_authorities (group_id, authority) values (4,'ROLE_SUPERVISOR');

insert into security.dbo.group_members (username, group_id) values ('Tom',1);
insert into security.dbo.group_members (username, group_id) values ('John',2);
insert into security.dbo.group_members (username, group_id) values ('Susan',3);
insert into security.dbo.group_members (username, group_id) values ('Alan',4); 

--==========================
--     select command
--==========================
--select * from groups
--select * from group_authorities
--select * from group_members

--select * from users
--select * from authorities



 