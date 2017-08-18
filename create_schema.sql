
    drop table tb_bookmark;

    drop table tb_files;

    drop table tb_user;

    create table tb_bookmark (
        id int identity not null,
        username varchar(255) null,
        bm_url varchar(255) null,
        primary key (id)
    );

    create table tb_files (
        id int identity not null,
        filename varchar(255) null,
        notes varchar(255) null,
        type varchar(255) null,
        content varbinary(255) null,
        primary key (id)
    );

    create table tb_user (
        id int identity not null,
        username varchar(255) null,
        passwd varchar(255) null,
        email varchar(255) null,
        primary key (id)
    );
