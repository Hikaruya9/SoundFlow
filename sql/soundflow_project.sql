CREATE DATABASE soundflow
DEFAULT CHARACTER SET utf8mb4
DEFAULT COLLATE utf8mb4_general_ci;

USE soundflow;

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

SELECT id,title,release_title,artist_name,track_length,audio_file,cover_image_path FROM track WHERE title = "Second Chance" AND release_title = "The Sound Of Madness" AND artist_name = "Shinedown";





DROP DATABASE soundflow;