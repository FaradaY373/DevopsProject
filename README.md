# DevopsProject

## Authors
![ByI](https://badgen.net/badge/made%20by/Ivan/cyan)
![ByC](https://badgen.net/badge/made%20by/Corentin/cyan)

## Made with
![Git](https://img.shields.io/badge/GitHub-100000?style=for-the-badge&logo=github&logoColor=white)
![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)
![Maven](https://badgen.net/badge/made%20with/maven/purple)
![Science](	http://ForTheBadge.com/images/badges/built-with-science.svg)






## Compte Rendu

Les fonctionnalités de notre projet:
-Parser et lire un fichier .csv
-Affichage d’un fichier .csv
-Affichages des n premiers/derniers lignes d’un fichier .csv
-Création d’un nouveau fichier .csv avec les colonnes/lignes choisi
-Sélection de toutes les colonnes/lignes qui contiennent l’objet recherché
-Les opérations arithmétiques sur les colonnes(min/max/moyenne)

Les étapes de notre projet:
-Création d’un projet de base en utilisant maven
-Création d’un répertoire Git et l’ajout de notre projet avec le workflow
Dans pom.xml on a plusieurs fonctionnalités:
 -Génération de javadoc dans le dossier target
 -Génération d’un exécutable .jar dans le dossier target
 -Deux plugins junit qui fait les tests et jacoco qui vérifie la couverture de code (fixe à 80% min pour notre projet)
On a partagé le code en différentes parties. Pour travailler en parallèle on crée une branche par fonctionnalité et si on veut mettre notre code dans la branche main on doit faire un pull request et l’autre binôme doit le vérifier et accepter ou ne pas accepter.

Les commandes:
Création de javadoc - mvn javadoc:javadoc
Faire les tests - mvn test
Créer le .jar - mvn package
Compiler - mvn compile

Les commentaires:
	Pour les tests des le depart on a pris une mauvaise stratégie et on a testé directement dans le code sans être obligé passer par les exceptions. On s’est rendu compte à la fin de ce problème. On a corrigé une fonction min pour donner un exemple de comment il fallait faire mais on a pas eu assez de temps pour réécrire de la même façon dans tout le reste du coude mais la logique est la même.




## Feedback
### *"Ask me anything"* in English
[![Ask Me Anything !](https://img.shields.io/badge/Ask%20me-anything-1abc9c.svg)](https://GitHub.com/Naereen/ama)
On a trouvé ce projet très intéressant et surtout utile pour notre future intégration dans une entreprise et déjà connaître les outils de travail dans une équipe.
On a eu certains soucis au niveau de débogage de maven et également au niveau de temps.

