drop database if exists cms;

create database cms;

create table cms.category (
	categoryId int auto_increment,
    categoryName varchar(20) not null,
    primary key(categoryId)
);

create table cms.`user` (
	userId int not null auto_increment,
    userName varchar(50) not null,
    UserPass varchar(30) not null,
    userType varchar(10) not null,
    primary key(userId)
);

create table cms.`page` (
	pageId int not null auto_increment,
    title tinytext not null,
    body text not null,
    primary key(pageId)
);

create table cms.post (
	blogId int not null auto_increment,
    userId int not null,
    content text not null,
	categoryId int not null,
    postDate date null,
    image tinytext null,
    video tinytext null,
    primary key(blogId),
    constraint fk_blog_user
    foreign key(userId)
		references cms.`user`(userId),
	foreign key(categoryId)
		references cms.category(categoryId)
);

create table cms.tag (
	tagId int not null auto_increment,
    tag varchar(20) not null,
    primary key(tagId)
);

create table cms.tag_blog (
	tagId int not null,
    blogId int not null,
    primary key(tagId, blogId),
    foreign key(tagId)
		references cms.tag(tagId),
	foreign key(blogId)
		references cms.blog(blogId)
);