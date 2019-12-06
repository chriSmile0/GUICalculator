

							Rapport du Projet : Calculatrice Graphique

1ere étape : Avoir une interface avec affichage des chiffres sur l'ecran 
Avec Clean de l'ecran inclut et affichage du resultat
Load: //######################### 100% ##########################//

2eme étape : Gerer le cas des parentheses 
Load://############################50% ########################//
J'ai le code mais pas encore appliqué pour le meoment 

3eme étape : Calcul binaire et affichage binaire
Load://############################ 100% #######################//

4eme étape : Calcul en octal et affichage en octal
Load://############################ 100% #######################//

5eme étape : Calcul en hexadecimal et affichage en hexadecimal
Load://############################ 100% #######################//

6eme étape : Calcul en decimal et affichage en decimal 
Load://############################ 100% #######################//

7eme étape : Passer de l'octal en binaire et hexa en binaire et le tout en decimal
Load://########################### 100% #########################//
On pouvait le faire avant mais maintenant il faut modifier le code et faire des conditions car il va falloir traduire
le code sur l'ecran qui est déja affiché pour pouvoir ou sinon etre sur qu'il  a un resultat avec 'upd' qui es a true pour pouvoir 
modifier le contenu de l'ecran 


On a pour le moment creer la calculatrice scientifique avec les 4 modes : hexadecimal, decimal , binaire, octal
Notre parser est maintenant en double car on gere aussi les nombres decimal mais aussi les entiers.

Suivrons ici la représentation en arbre d'héritage du projet calculatrice graphique :









Puis ici les algorithmes expliquer avec du pseudo code ou de manière habile et simple : 






Puis enfin des explications des choix d'implémentations et de pourquoi ces méthodes là :





Ne pas oublier de commenter le code et d'effacer les méthodes inutiles meme si une trace de nos travaux sera nécessaire 
mais on pourrait la mettre dans un fichier commentaire comme celui si que l'on joindra pour bien montrer la mise en oeuvre du projet
et son aboutissement final. Expliquez aussi l'interface graphique et comment cela marche t'il et savoir ce que fait chaque ligne de notre code.
Il ne faut pas tout commenter juste le necessaire et ce qui parait un peu abstrait. Les fonctions certifiés JAVA ne sont pas a commenter,
ni les lignes de codes qui utilisent les 'ActionListener' l'explication va de sois. Bien comprendre l'arbre d'héritage et commenter aussi le code du PARSER c'est a dire la premiere partie de ce projet qui était le TP3 calculatrice.




Pour le moment on affiche le resultat quand on clique sur les B H et O et on
l'affiche dans la base demandé et cela fait donc aussi le result 
Alors que l'on pourrait tenter de creer de passer en binaire pendant un moment
pour creer des additions binaire et etc...



Voir le fichier 'String_Methods' qui sert de brouillon et qui nous a servit de brouillon pour l'élaboration des fonctions a placer dans le fichier 'Fenetre'
Il faudrait mettre toutes ses fonctions là dans un package afin de pas inonder le fichier 'Fenetre' mais on va d'abord essayer comme tel dans le fichier 'Fenetre' 
