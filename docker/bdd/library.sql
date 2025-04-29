
DROP TABLE IF EXISTS image, book, author cascade;

CREATE TABLE image (
  id SERIAL PRIMARY KEY,
  content TEXT NULL
);

CREATE TABLE author (
  id SERIAL PRIMARY KEY,
  last_name VARCHAR (50) NOT NULL,
  first_name VARCHAR(50) NULL,
  nationality VARCHAR (50),
  image_id Int NULL,

  FOREIGN KEY (image_id) REFERENCES image(id)
);

CREATE TABLE book (
  id SERIAL PRIMARY KEY,
  title VARCHAR(250) NOT NULL,
  description TEXT NULL,
  author_id Int NOT NULL,
  isbn INT NOT NULL,
  FOREIGN KEY (author_id) REFERENCES author(id)
);
INSERT INTO image (content) VALUES
    (''),
    (''),
    (''),
    ('');

INSERT INTO author (last_name,first_name, nationality, image_id) VALUES
    ('chattam','maxime','francaise',1),
    ('martin-lugand','agnes','fransaise',2),
    ('musso,','guillaume', 'francais', 3);


INSERT INTO book (title, description,isbn, author_id) VALUES
  ('rebelle','description en cours','1',1),
  ('livre2','description2','2',1),
  ('livre3','description3','3',2),
  ('livre4','description4','4',2),
  ('livre5','description5','5',3),
  ('livre6','description6','6', 3),





