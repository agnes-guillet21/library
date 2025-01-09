DROP TABLE IF EXISTS books;
 
CREATE TABLE book (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  title VARCHAR(250) NOT NULL,
  description VARCHAR(1000) NOT NULL,
  author VARCHAR(250) NOT NULL,
);
 
INSERT INTO employees (first_name, last_name, mail, password) VALUES
  ('LUX', 'Elle va transformer pour toujours le quotidien du monde entier, en particulier l'existence d'une mère et de sa fille.
Tout en posant la question qui nous obsède tous... Nos vies ont-elles un sens ', 'Chattam'),
  ('BABEL', '1828. Un jeune orphelin chinois est recueilli à Canton par un professeur et conduit à Londres. Rebaptisé Robin Swift, le jeune garçon consacre ses journées à l'étude des langues dans l'optique d'intégrer le prestigieux Institut royal de traduction de l'Université d'Oxford, plus connu sous le nom de Babel. Berceau de l'argentogravure, 
les étudiants y exploitent le sens perdu des mots à l'aide de barres d'argent enchantées.', 'Kuang'),
  ('Bourbon Kid', 'Imaginez que vous décidiez un jour de percer le secret des Dead Hunters, impitoyable confrérie de justiciers sanguinaires installés dans le Cimetière du Diable. Et, pendant que vous y êtes, d'éliminer le serial killer le plus insaisissable de tous les temps : le Bourbon Kid.
Peut-être y réfléchiriez-vous à deux fois.Lui, non.Son nom est Caïn.Et c'est avec une allégresse presque contagieuse qu'il va s'atteler à la tâche.On lui souhaite bien du courage.', 'anonyme');