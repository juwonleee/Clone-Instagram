use madang;

create table if not exists User
(
    userIdx       int auto_increment
        primary key,
    name          varchar(10)                           not null comment '이름',
    nickName      varchar(45)                           not null comment '유저 이름(닉네임)',
    email         varchar(255)                          not null comment '이메일',
    pwd           varchar(20)                           not null comment '비밀번호',
    profileImgUrl text                                  not null comment '프로필 사진',
    introduction  varchar(100)                          null comment '소개',
    status        varchar(10) default 'ACTIVE'          not null comment 'ACTIVE: 활성화 INACTIVE: 비활성화 DELETED: 삭제된 계정',
    createdAt     timestamp   default CURRENT_TIMESTAMP not null,
    updateAt      timestamp   default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP
);

create table if not exists Post
(
    postIdx   int auto_increment
        primary key,
    userIdx   int                                   not null comment '유저 식별자',
    content   varchar(300)                          not null comment '게시물 내용',
    status    varchar(10) default 'ACTIVE'          not null comment 'ACTIVE: 활성화 INACTIVE: 비활성화 DELETED: 삭제된 계정',
    createdAt timestamp   default CURRENT_TIMESTAMP not null,
    updateAt  timestamp   default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP,
    foreign key (userIdx) references User(userIdx)
);

create table if not exists Comment
(
    commentIdx       int auto_increment
        primary key,
    userIdx          int                                   not null comment '유저 식별자',
    postIdx          int                                   not null comment '게시물 식별자',
    content          varchar(100)                          not null comment '댓글 냥ㅅㅇ',
    createdAt        timestamp   default CURRENT_TIMESTAMP not null,
    tagUser			 int								   comment '누구를 태그했는지 체크. 없으면 null (@user)',
    foreign key (postIdx) references Post(postIdx),
    foreign key (userIdx) references User(userIdx),
    foreign key (tagUser) references User(userIdx)
);

create table if not exists CommentLike
(
    commentLikeIdx int auto_increment
        primary key,
    commentIdx     int                                   not null comment '댓글 식별자',
    userIdx        int                                   not null comment '유저 식별자',
    status         varchar(10) default 'ACTIVE'          not null comment 'ACTIVE: 활성화 INACTIVE: 비활성화',
    createdAt      timestamp   default CURRENT_TIMESTAMP not null,
    updateAt       timestamp   default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP,
    foreign key (commentIdx) references Comment(commentIdx)
);

create table if not exists Follow
(
    followIdx   int auto_increment
        primary key,
    followerIdx int                                   not null comment '팔로우 하는 유저 식별자',
    followeeIdx int                                   not null comment '팔로우 당하는 유저 식별자',
    status      varchar(10) default 'ACTIVE'          not null comment 'ACTIVE: 팔로우 INACTIVE: 언팔',
    createdAt   timestamp   default CURRENT_TIMESTAMP not null,
    updateAt    timestamp   default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP,
    foreign key (followerIdx) references User(userIdx),
    foreign key (followeeIdx) references User(userIdx)
);



create table if not exists PostImgUrl
(
    postImgUrlIdx int auto_increment
        primary key,
    postIdx       int                                   not null comment '게시물 식별자',
    imgUrlIdx     text                                  not null comment '사진',
    status        varchar(10) default 'ACTIVE'          not null comment 'ACTIVE: 활성화 INACTIVE: 비활성화 DELETED: 삭제된 계정',
    createdAt     timestamp   default CURRENT_TIMESTAMP not null,
    updateAt      timestamp   default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP,
    foreign key(postIdx) references Post(postIdx)
);

create table if not exists PostLike
(
    postLikeIdx int auto_increment
        primary key,
    userIdx     int                                   not null comment '유저 식별자',
    postIdx     int                                   not null comment '게시물 식별자',
    status      varchar(45) default 'ACTIVE'          not null comment 'ACTIVE: 활성화 INACTIVE: 비활성화',
    createdAt   timestamp   default CURRENT_TIMESTAMP not null,
    updateAt    timestamp   default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP,
    foreign key(postIdx) references Post(postIdx),
    foreign key(userIdx) references User(userIdx)
);


use madang;

delete from comment;
delete from post;
delete from user;


insert into user values(1, '해리포터', 'harry_porter', 'harry@naver.com', 'test11', 'testurl', 'male', '2002-03-21', 'mysite', 'introduction', 'active', default, default);
insert into user values(2, '김철수', 'kim0203', 'kim0203@naver.com', 'test11', 'testurl', 'female', '2002-04-20', 'mysite', 'introduction', 'active', default, default);
insert into user values(3, '박지성', 'park777', 'park777@naver.com', 'test11', 'testurl', 'male', '2002-09-28', 'mysite', 'introduction', 'active', default, default);

insert into post values(1, 1, '첫 게시글', 'active', default, default);
insert into post values(2, 2, 'kim0203의 게시글입니다', 'active', default, default);
insert into post values(3, 1, '두 번재 게시글', 'active', default, default);
insert into post values(4, 3, '테스트 게시글', 'active', default, default);

insert into comment values(1, 2, 1, 'kim0203에 달린 harry_porter의 댓글 예시', default, null);
insert into comment values(2, 1, 1, '자신의 게시글에 달린 댓글', default, null);
insert into comment values(3, 1, 3, '@kim0203 hi', default, 2);

select * from comment;
select * from user;
select * from post;
