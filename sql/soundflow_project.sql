CREATE DATABASE soundflow
DEFAULT CHARACTER SET utf8mb4
DEFAULT COLLATE utf8mb4_general_ci;

USE soundflow;

CREATE TABLE artist(
id int PRIMARY KEY NOT NULL AUTO_INCREMENT,
name varchar(100) NOT NULL,
description text NOT NULL,
genre varchar(50) NOT NULL,
image_path TINYTEXT NOT NULL
)DEFAULT CHARSET=utf8mb4;

CREATE TABLE artistRelease(
id int PRIMARY KEY NOT NULL AUTO_INCREMENT,
title varchar(100) NOT NULL,
release_date varchar(100) NOT NULL,
track_number tinyint NOT NULL,
release_length varchar(10) NOT NULL,
image_path tinytext NOT NULL,
artist_id int NOT NULL
)DEFAULT CHARSET=utf8mb4;

CREATE TABLE track(
id int PRIMARY KEY NOT NULL AUTO_INCREMENT,
title varchar(100) NOT NULL,
track_length varchar(10) NOT NULL,
artist_id int NOT NULL,
release_id int NOT NULL,
image_path tinytext NOT NULL
)DEFAULT CHARSET=utf8mb4;