create table test.dbo.tb_user_favorites (
    [user_id] int not null,
	[bm_id] int not null,
	position int not null,
    primary key ([user_id],position)
);
 