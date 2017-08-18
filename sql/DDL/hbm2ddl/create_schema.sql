
    drop table tb_bookmark;

    drop table tb_files;

    drop table tb_user;

    create table tb_bookmark (
        id int identity not null,
        username varchar(16) not null,
        bm_url varchar(255) null,
        primary key (id)
    );

    create table tb_files (
        id int identity not null,
        filename varchar(100) null,
        notes varchar(100) null,
        type varchar(40) null,
        content varbinary(255) null,
        primary key (id)
    );

    create table tb_user (
        id int identity not null,
        username varchar(16) not null,
        passwd varchar(16) null,
        email varchar(100) null,
        primary key (id)
    );
