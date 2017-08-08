create table test.dbo.tb_files (
    id int not null identity(1,1),
    filename varchar(100) not null,
    notes varchar(100) ,
    type  varchar(40) ,
	content varbinary(max),
    primary key (id)
);