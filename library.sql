 
CREATE TABLE book (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  title VARCHAR(250) NOT NULL,
  description VARCHAR(250) NULL,
  author(250) NOT NULL,
  isbn INT NOT NULL
);
 
INSERT INTO book (title, description, description, author,isbn) VALUES
  ('rebelle', 'description en cours', 'untel', '1'),
  ('livre2', 'description2', 'auteur2', '2'),
  ('livre3', 'description3', 'auteur3', '3');
  ('livre4', 'description4', 'auteur4', '3');
  ('livre5', 'description5', 'auteur5', '3');
  ('livre6', 'description6', 'auteur6', '3');