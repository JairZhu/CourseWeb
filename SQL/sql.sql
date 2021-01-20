create database courseWeb;

use courseweb;

create table `user` (
    `name` varchar(50) not null ,
    `password` varchar(50) not null ,
    `type` bool not null ,
    primary key (name)
);

create table `ppt` (
    `id` int auto_increment not null ,
    `title` varchar(50) not null ,
    `writer` varchar(50) not null ,
    `time` timestamp not null ,
    primary key (id),
    foreign key (writer) references user(name) on delete cascade on update cascade
);

create table `news` (
    `id` int auto_increment not null ,
    `title` varchar(100) not null ,
    `content` varchar(1000) not null ,
    `writer` varchar(50) not null ,
    `time` timestamp not null ,
    primary key (id),
    foreign key (writer) references user(name) on delete cascade on update cascade
);


create table `notification` (
    `id` int auto_increment not null ,
    `title` varchar(100) not null ,
    `content` varchar(1000) not null ,
    `writer` varchar(50) not null ,
    `time` timestamp not null ,
    primary key (id),
    foreign key (writer) references user(name) on delete cascade on update cascade
);

create table `assignment` (
    `id` int auto_increment not null ,
    `title` varchar(100) not null ,
    `content` varchar(1000) not null ,
    `writer` varchar(50) not null ,
    `time` timestamp not null ,
    primary key (id),
    foreign key (writer) references user(name) on delete cascade on update cascade
);

create table `homework` (
  `id` int auto_increment not null ,
  `title` varchar(100) not null ,
  `content` varchar(1000) not null ,
  `fileName` varchar(1000) not null ,
  `writer` varchar(50) not null ,
  `time` timestamp not null ,
  `score` int ,
  primary key (id),
  foreign key (writer) references user(name) on delete cascade on update cascade
);

create table `courseInformation` (
    `id` int auto_increment not null ,
    `title` varchar(100) not null ,
    `content` varchar(1000) not null ,
    `writer` varchar(50) not null ,
    `time` timestamp not null ,
    primary key (id),
    foreign key (writer) references user(name) on delete cascade on update cascade
)

