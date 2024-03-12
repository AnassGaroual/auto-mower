# auto-mower
## Tondeuse Automatique - Version 1.0.0

## Description
Ce projet offre une solution au kata de la tondeuse automatique, visant à automatiser les mouvements d'une tondeuse dans une zone rectangulaire prédéfinie grâce à des commandes spécifiques. Il adopte une architecture hexagonale pour séparer clairement la logique métier des interactions externes, améliorant ainsi la scalabilité et la maintenabilité.

## Points Forts
Architecture Hexagonale : Facilite les évolutions futures en séparant le cœur de l'application des adaptateurs d'entrée/sortie.
Spring Boot : permet la scalabilité et l'extension avec une configuration rapide et simplifiée.
Pratiques de Développement : L'application suit les méthodologies TDD et BDD, assurant une haute qualité de code et facilitant la maintenance et l'évolution.

## Configuration et éxecution
Spécifiez le chemin du fichier d'instructions dans application.properties pour une démonstration facile.
L'application lira automatiquement les instructions du fichier spécifié, les traitera et affichera les positions finales des tondeuses.
Java 21 est recommandé pour exécuter ce projet.

## Conclusion
Cette première version jette les bases d'une application scalable et maintenable, respectant les bonnes pratiques de développement logiciel. 
