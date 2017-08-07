create table test.dbo.tb_user (
    id int not null identity(1,1),
    username varchar(16) ,
    passwd varchar(16) not null,
    email  varchar(100) not null,
    primary key (id)
);