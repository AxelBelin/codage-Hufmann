# Codage Hufmann

## Mode d'emploi

### Comment lancer le programme :
Après avoir ouvert les fichiers Java dans un éditeur ou un IDE, il faut compiler la classe ListeArbreHuffman pour utiliser le programme. Le texte à encoder et à décoder est saisi dans une variable et sa table de codage est unique. Cela limite la portabilité du programme. Nous avons mis un certain nombre de commentaires pour détailler toutes étapes que nous avons réalisées.

### Rôle des classes :
ListeArbreHuffman = Cette classe doit être compilée pour tester le programme, tous les affichages sont dedans.
Huffman = Cette casse contient les méthodes de codage, encodage et décodage
ArbreHuffman = Elles contient les méthodes et champs des arbres de Huffmann.

### Lors de l’exécution le programme affiche :
1) La Liste d'arbres de Huffman triée par ordre croissant de fréquence
2) L’Arbre de codage de Huffman
3) Le codage de chaque lettres du texte : la table de codage de tous les caractères dans l’arbre de Huffman
4) Quelques tests d'encodage et de décodage de valeurs pour tester (ex : Toto)
5) Le texte à encoder
6) Le texte encodé sous forme d’encodage
7) Le texte décodé, la version finale du texte identique à ma version initiale
