
 drop table test.dbo.tb_user;
 create table test.dbo.tb_user (
    id int not null identity(1,1),
    username varchar(16) ,
    passwd varchar(16) ,
    email  varchar(100) ,
	actual_id int,
	last_id int,
    primary key (id)
);