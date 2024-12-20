
# 기타 쿼리 최적화 문법

## 필요한 데이터만 조회
	SELECT * FROM member WHERE idx < 10;
    SELECT idx, email FROM member WHERE idx < 10;
	SHOW PROFILES;
    
## LIMIT 및 페이지 활용
	SELECT * FROM post ORDER BY createdAt DESC;
    SELECT * FROM post ORDER BY createdAt DESC LIMIT 0, 10;
    SHOW PROFILES;
    
## 서브쿼리 대신 JOIN 사용
	SELECT 
		post.idx, 
		(SELECT email FROM member WHERE idx = post.writerIdx) AS writer,
		contents,
		post.createdAt
	FROM post;

	SELECT post.idx, member.email AS writer, contents, post.createdAt
	FROM post
	JOIN member ON post.writerIdx = member.idx;

	SHOW PROFILES;

#각 게시글별 좋아요의 수를 확인하는 SQL
#	[게시글 번호] [게시글 작성자] [게시글 내용] [게시글 작성 시간] [게시글 좋아요 수]

SELECT postIdx, COUNT(idx) FROM likes
GROUP BY postIdex;

select * from pst
inner join member on member.idx = post.writerIdx
left join likes on post.idx = likes.postIdx;

