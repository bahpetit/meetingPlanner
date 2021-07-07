"# meetingPlanner" 
###algorithme de traitement exemple: Algo de colonies de fournis (*Toutes combinaisons possible et optimale*)

Algo colonie de fournie


Tant que(Liste_reunion pas vide)
	Salles_capacites = getSallesParCapacite(reunion, capacite);
	salle_optimale = getSalleOptimale(Salles_capacites) // Algo voisin proche
	ajouter(salle et equipement possible); 
	locker la plage horaires
fin Tanque

###[Voir l'algo Implementer dans](src/main/java/org/example/domain/MeetingsSchedule.java)

Lancer l'application 
 
 mvn clean install  ou executer le main.
 
 Pour voir le resultat  
 1- localhost:8080/api/events  
 2- http://localhost:8080/h2-console
 
 Resultat attendu:
 
 | ID | MEETING_ID | ROOM_NAME   |
 | -------- | ---- |----|
 |	1	|   18	|   E2001	|	
 |	2	|   8	|   E2002	|	
|	3	|   14	|   E2003	|	
|	4	|   3	|   E2003	|
|	5	|   15	|   E1004	|
|	6	|   2	|   E2004	|
|	7	|   4	|   E1004	|
|	8	|   6	|   E1002	|
|	9	|   9	|   E1003	|
|	10	|   13	|   E1003	|
|	11	|   7	|   E3001	|
|	12	|   16	|   E1001	|
|	13	|   5	|   E3001	|
|	14	|   12	|   E1001	|
 


 
 
 
