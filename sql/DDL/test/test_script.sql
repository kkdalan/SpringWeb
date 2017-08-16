use test;

select * from test.dbo.tb_user
select * from test.dbo.tb_bookmark
select * from test.dbo.tb_user_bookmarks
select * from test.dbo.tb_bookmark_comments
select * from test.dbo.tb_user_favorite_bookmarks

select * 
from tb_bookmark b
left join tb_user_bookmarks ub on b.id = ub.[bm_id]
left join tb_user u on u.id = ub.[user_id]
left join tb_bookmark_comments bc on b.id = bc.[bm_id] 
left join tb_user_favorites uf on b.id = uf.[bm_id]
 
 
select * 
from test.dbo.tb_user u 
left join  tb_user_favorites uf on u.id = uf.[user_id]
left join tb_bookmark b on b.id =uf.[bm_id] 
 
select * 
from test.dbo.tb_user u 
left join  tb_user_favorite_bookmarks ufb on u.id = ufb.[user_id]
left join tb_bookmark b on b.id =ufb.[bm_id] 

delete from test.dbo.tb_user;
delete from test.dbo.tb_bookmark_comments; 
delete from test.dbo.tb_user_bookmarks;
delete from test.dbo.tb_bookmark;
delete from test.dbo.tb_user_favorite_bookmarks;

   
