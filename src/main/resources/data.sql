CREATE TABLE IF NOT EXISTS users (
                                     id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                     login VARCHAR(255) NOT NULL,
                                     email VARCHAR(255) NOT NULL,
                                     password VARCHAR(255) NOT NULL
);
CREATE TABLE IF NOT EXISTS available_books (
                                     id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                     title VARCHAR(255) NOT NULL,
                                     author VARCHAR(255) NOT NULL,
                                     price FLOAT NOT NULL,
                                     image VARCHAR(255) NOT NULL,
                                     description VARCHAR(255) NOT NULL
);
INSERT INTO available_books(title,author,price,image,description) VALUES
( 'lavenir dune illusion','freud',40.0,'/images/illusion.jpg','this is the description about the book freud'),
( 'BEYOND GOOD AND EVIL','NIETSCHE',35.0,'/images/BeyondGoodAndEvil.jpg','this is the description about the book beyond'),
( '12 RULES FOR LIFE','JORDON PETERSON',45.0,'/images/12.jpg','this is the description about the book 12 RULES FOR LIFE')





