CREATE DATABASE soundflow
DEFAULT CHARACTER SET utf8mb4
DEFAULT COLLATE utf8mb4_general_ci;

USE soundflow;
DROP DATABASE soundflow;

CREATE TABLE track(
id int PRIMARY KEY NOT NULL AUTO_INCREMENT,
title varchar(100) NOT NULL,
release_title varchar(100) NOT NULL,
artist_name varchar(100) NOT NULL,
track_length varchar(10) NOT NULL,
audio_file tinytext NOT NULL,
cover_image_path tinytext NOT NULL
)DEFAULT CHARSET=utf8mb4;

SELECT * FROM track;