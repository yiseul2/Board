CREATE DATABASE IF NOT EXISTS board_database;
DROP TABLE IF EXISTS board_database.users;
CREATE TABLE board_database.users(
       id BIGINT(20) UNSIGNED AUTO_INCREMENT,
       account_id VARCHAR(50) NOT NULL,
       password VARCHAR(100) NOT NULL,
       nickname VARCHAR(20) NOT NULL,
       created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
       updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
       PRIMARY KEY(id),
       UNIQUE(account_id)
       );

DROP TABLE IF EXISTS board_database.board;
CREATE TABLE board_database.board(
     id BIGINT(20) UNSIGNED AUTO_INCREMENT,
     title VARCHAR(100) NOT NULL,
     content VARCHAR(2000) NOT NULL,
     user_id VARCHAR(50) NOT NULL,
     created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
     updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
     PRIMARY KEY(id)
     );