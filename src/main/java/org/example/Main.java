package org.example;

public class Main {
    public static void main(String[] args) {

        // Création des candidats avec leur parti (ou sans parti)
        Candidat riri = new Candidat("Riri", "Duck", "Parti A");
        Candidat fifi = new Candidat("Fifi", "Duck", "Parti B");
        Candidat loulou = new Candidat("Loulou", "Duck", "Parti C");

        // Affichage des candidats
        System.out.println(riri);
        System.out.println(fifi);
        System.out.println(loulou);

        // Création de la circonscription de Picsouville avec 75 inscrits
        Circonscription picsouville = new Circonscription("Picsouville", 75);

        // Ajout des candidats à la circonscription
        picsouville.ajouterCandidat(riri);
        picsouville.ajouterCandidat(fifi);
        picsouville.ajouterCandidat(loulou);

        // Ajout des voix directement dans la circonscription (pas deux fois)
        picsouville.ajouterVoix("Riri", 12);
        picsouville.ajouterVoix("Fifi", 5);
        picsouville.ajouterVoix("Loulou", 37);

        // Vérification du taux de participation
        picsouville.calculTauxParticipation();

        // Clore l'élection dans la circonscription
        picsouville.terminerElect();

        // Recherche du vainqueur de l'élection
        picsouville.rechercherVainqueur();

    }

}