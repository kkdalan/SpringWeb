drop table test.dbo.tb_bookmark;
create table test.dbo.tb_bookmark (
    id int not null identity(1,1),
    username varchar(16) ,
    bm_url varchar(255) ,
    primary key (id)
);