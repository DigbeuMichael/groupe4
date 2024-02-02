# Objectifs du projet

Vous devez réaliser un projet qui consiste à créer un site d'e-commerce

# Les entités

Pour gérer ce projet vous aurez besoin de quelques entités ...

## User

Un utilisateur identifié sera capable de s'identifier sur la plateforme et pourra créer renseigner ses informations personnelles.

## Product

Un produit représente un produit vendu sur le plateforme, on y retrouvera toutes les informations classiques d'un produit en vente.

## Basket

Il s'agit d'un panier, voué à contenir des produits

## Basket Item

Il s'agit d'une "copie" du produit, que l'on insèrera dans le panier.

## Category

Il s'agit d'une catégorie, une catégorie peut être racine ou non, elle peut avoir des sous catégories, la profondeur est théoriquement illimitée.

## Illustration

Il s'agit simplement d'une illustration, une image, identifiée par un simple nom de fichier, ce nom de fichier sera utilisé en conjonction avec des chemins stockés dans les fichiers de configuration pour composer le chemin interne (path) et le chemin externe (url).


# Ce qui est attendu

Vous avez deux choix pour la partie réalisation ... vous pouvez alternativement faire ...

## Un Backend (une interface d'administration)

Qui permettra de gérer tout le CRUD sur les entités :

- User
- Product
- Basket
- Category

Pour les illustrations, un upload de fichier est attendu

## Un Frontend (un site de vente)

Qui permettra de :

- S'identifier
- Parcourir les catégories
- Voir des produits
- Gérer le panier (modifier les quantités, supprimer un article ...)

# Livraison

La livraison se fera **impérativement** sur un Github Classroom qui vous sera communiqué, la date de rendu sera précisée dans l'assignment que vous rejoindrez, aucune livraison ne sera acceptée par mail ou autre

La livraison contiendra :
- Le code de votre projet
- Un readme clair qui expliquera ce que vous avez fait, ce que vous n'avez pas pu faire et qui donnera des précisions sur le projet (versions utilisées) ainsi que les manipulations à effectuer afin que je puisse faire tourner votre projet sans problème
- La restitution se fera soit sous la forme d'une soutenance soit via une vidéo de démonstration qui présentera les réalisations.


# Notation

Vous partez d'un capital de 20 points et vous pourrez en perdre pour plusieurs raison :
- Le code est de mauvaise qualité (jusqu'à -5 points)
- L'ergonomie est franchement mauvaise (jusqu'à -3 points)
- Le rendu est franchement mauvais (jusqu'à -3 points)
- Vous n'avez pas fourni de readme avec votre projet (-5 points)
- Vous n'avez pas fourni un des éléments demandés dans la section du dessus (-1 à -5 points par élément)
- Plagiat (-10 à -25 points), vous avez le droit de prendre du code en ligne tant que vous le comprenez mais ne prenez pas le code d'un camarade, la sentence vaut pour les deux groupes

Si vous réalisez des fonctionnalités non demandées, je rajoute des bonus, par exemple :
- Un formulaire d'upload drag & drop en ajax avec preview pour les illustrations
- La gestion de déclinaison de produit / Upselling / Xselling
- ...