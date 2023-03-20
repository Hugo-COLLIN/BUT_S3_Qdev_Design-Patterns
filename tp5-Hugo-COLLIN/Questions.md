# Questions 

## Exercice 2 (Singleton - Aéroport)
1. Fait.
2. La méthode start() permet d'activer les thread 
   avant de lancer les instructions avec run().
3. Ce n'est pas suffisant car, s'il y a plusieurs threads, on risque de tester 
   2 fois la condition d'existence de l'aéroport dans 2 threads différents, 
   puis ensuite de créer un aéroport dans chacun des threads.
4. Fait.