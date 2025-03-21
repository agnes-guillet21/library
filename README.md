### 📚 Projet Librairie ###
Un outil d'administration de bibliothèque permettant de gérer les livres, les auteurs, les clients et les prêts. Ce projet m'a permis de monter en compétences sur Spring Boot et Angular.
Review fait par un lead Tech Java

### 🚀 Technologies utilisées
Back : Spring Boot / Front : Angular 17 / BDD : PostgreSql


-----------------------------------------------------

### Back

## 🏗️ Architecture
API Rest avec Spring Boot <br>
Architecture en couches (Controller, Service, Repository) <br>
Utilisation des DTO pour la communication entre les couches <br>
Encodage des images en Base64 (expérimentation) <br>
Tests


## 📊 Modèle de données

Relation :<br>
 Book -> Image :  ManyToMany 
  peut etre pas forcement le plus adapté mais je voulais experimenter cette relation.
 Le but etant de pouvoir afficher une image dans la page de liste des livres et plusieurs images lors de la consultation de la page de detail d'un livre

Book -> Author : ManytoOne 

-----------------------------------------------------


### Front
Creation des maquettes , intégration 

### Coté fonctionnel 
-> UsersStories : <br>
1 : En tant qu'administrateur de bibliothèque, j'ai besoin de pouvoir ajouter un nouveau livre, afin d'augmenter le nombre de livres dans le système.<br>
2 : En tant qu'administrateur de bibliothèque, je dois pouvoir rechercher un livre par isbn ou par une partie ou la totalité de son titre, afin de visualiser toutes ses informations.<br>
3 : En tant qu'administrateur de bibliothèque, je dois pouvoir rechercher un livre, puis le modifier ou le supprimer de la liste qui s'affiche.<br>
4 : En tant qu'administrateur de bibliothèque, je dois pouvoir ajouter un nouveau client, afin d'augmenter le nombre de clients dans le système.<br>
5 : En tant qu'administrateur de bibliothèque, j'ai besoin de pouvoir rechercher un client par email ou par une partie ou la totalité de son nom de famille, afin de voir toutes ses informations.<br>
6 : En tant qu'administrateur de bibliothèque, je dois pouvoir rechercher des clients, puis les modifier ou les supprimer de la liste qui s'affiche.<br>
7 : En tant qu'administrateur de bibliothèque, je dois pouvoir ajouter un nouveau prêt, afin de faire le lien entre un livre emprunté à la bibliothèque et son emprunteur (client enregistré).<br>
8 : En tant qu'administrateur de bibliothèque, je dois pouvoir rechercher la liste des prêts d'un client par email, et la liste des prêts effectués jusqu'à une certaine date, afin de voir l'historique.<br>
