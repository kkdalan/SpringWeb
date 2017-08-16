create table test.dbo.tb_bookmark_comments (
	[bm_id] int not null,
	comment varchar(255),
	constraint fk_bookmark_comments_bookmark foreign key (bm_id) references tb_bookmark(id)
);

select * 
from tb_bookmark b
left join tb_bookmark_comments bc on b.id = bc.[bm_id] 


 