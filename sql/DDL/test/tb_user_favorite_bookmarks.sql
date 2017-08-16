create table test.dbo.tb_user_favorite_bookmarks (
    [user_id] int not null,
	[bm_id] int not null,
	description varchar(100),
	position int not null,
    primary key ([user_id],position)
);

 
 