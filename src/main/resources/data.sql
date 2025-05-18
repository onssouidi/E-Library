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
                                               description VARCHAR(500) NOT NULL
);

INSERT INTO available_books(title, author, price, image, description) VALUES
                                                                          ('L’Avenir d’une Illusion', 'Sigmund Freud', 40.0, '/images/illusion.jpg', 'Une analyse profonde de la religion comme construction psychologique de l’humanité.'),
                                                                          ('Par-delà le Bien et le Mal', 'Friedrich Nietzsche', 35.0, '/images/BeyondGoodAndEvil.jpg', 'Un chef-d’œuvre philosophique qui remet en cause la morale traditionnelle occidentale.'),
                                                                          ('12 Règles pour une Vie', 'Jordan Peterson', 45.0, '/images/12.jpg', 'Un guide psychologique pour mener une vie pleine de sens et de responsabilité.'),
                                                                          ('Le Mythe de Sisyphe', 'Albert Camus', 30.0, '/images/sisyphe.jpg', 'Une réflexion sur l’absurde et la quête de sens dans une existence dénuée de réponses.'),
                                                                          ('Éthique à Nicomaque', 'Aristote', 38.0, '/images/ethique.jpg', 'Un texte fondamental sur la vertu, la morale et le bonheur selon la pensée grecque.'),
                                                                          ('Le Prince', 'Machiavel', 32.0, '/images/prince.jpg', 'Une œuvre politique majeure explorant le pouvoir, la ruse et la gouvernance.'),
                                                                          ('Critique de la Raison Pure', 'Immanuel Kant', 50.0, '/images/kant.jpg', 'Un ouvrage complexe qui fonde la philosophie critique et la connaissance humaine.'),
                                                                          ('Ainsi parlait Zarathoustra', 'Friedrich Nietzsche', 40.0, '/images/zarathoustra.jpg', 'Une œuvre poétique et prophétique sur le surhomme et la volonté de puissance.'),
                                                                          ('Les Méditations Métaphysiques', 'René Descartes', 36.0, '/images/descartes.jpg', 'Un traité fondamental qui explore la certitude, le doute et l’existence.');
