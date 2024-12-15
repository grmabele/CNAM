package org.example;

import java.util.ArrayList;
import java.util.List;

public class Circonscription {

    private String nom;
    private Integer nbrInscrit;
    private List<Candidat> candidats;
    private Boolean electionTerminee;

    public Circonscription(String nom, Integer nbrInscrit ) {
        this.nom = nom;
        this.nbrInscrit = nbrInscrit;
        this.candidats = new ArrayList<>();
        this.electionTerminee = false;
    }

    public void ajouterCandidat(Candidat candidat) {
        if(electionTerminee){
            System.out.println("Impossible d'ajouter un candiat : election terminée");
            return;
        }
        candidats.add(candidat);
        System.out.println("Candidat ajouter : " + candidat);
    }

    public void ajouterVoix(String nomCand, int voix) {
        // Vérification du nombre total de voix avant d'ajouter
        int totalVoix = 0;
        for (Candidat candidat : candidats) {
            totalVoix += (candidat.getVoix() != null ? candidat.getVoix() : 0);  // On gère le cas où les voix sont nulles
        }

        if (totalVoix + voix > nbrInscrit) {
            System.out.println("Erreur : le nombre de voix dépasse le nombre d'inscrits.");
            return;
        }

        // Si tout est ok, ajouter les voix
        for (Candidat candidat : candidats) {
            if (candidat.getNom().equalsIgnoreCase(nomCand)) {
                // Si voix initiale est nulle, on les initialise à zéro
                if (candidat.getVoix() == null) {
                    candidat.setVoix(0);  // Initialisation des voix à zéro si elles sont nulles
                }
                // Ajouter les voix
                candidat.setVoix(candidat.getVoix() + voix);
                System.out.println("Ajouté " + voix + " voix à " + candidat.getNom());
                return;
            }
        }
    }

    public void terminerElect(){
        int totalVoix = 0;
        for (Candidat candidat : candidats){
            if(candidat.getVoix() != null) {
                totalVoix += candidat.getVoix();
            }
        }

        // vérif de la cohérence nbre voix et des inscrits
        if (totalVoix <= nbrInscrit) {
            this.electionTerminee = true;
            System.out.println("Élection terminée dans la circonscription : " + nom);
        } else  {
            System.out.println("Erreur : le nombre de voix dépasse le nombre d'inscrits.");
        }
    }

    public void calculTauxParticipation(){
        int totalVoix = 0;
        for (Candidat candidat : candidats){
            if (candidat.getVoix() != null) {
                totalVoix += candidat.getVoix();
            }
        }

        double tauxParticipation = (double) totalVoix / nbrInscrit * 100;
        System.out.println("Total des voix enregistrées : " + totalVoix + " / " + nbrInscrit);
        System.out.println("Taux de participation : " + tauxParticipation + " %");
    }

    public List<Candidat> rechercherVainqueur(){
        if(electionTerminee == false){
            System.out.println("L'élection n'est pas encore terminée.");
            return null;
        }
        // Maxi des voix obtenus par les candidats
        int maxVoix = 0;
        for (Candidat candidat : candidats) {
            if (candidat.getVoix() != null && candidat.getVoix() > maxVoix) {
                maxVoix = candidat.getVoix();
            }
        }

        // recherhe des candidats ex-aequo
        List<Candidat> vainqueurs = new ArrayList<>();
        for (Candidat candidat : candidats){
            if(candidat.getVoix() != null && candidat.getVoix() == maxVoix) {
                vainqueurs.add(candidat);
            }
        }

        // Affichage et retour du ou des candidats vainqueurs
        if ( vainqueurs.size() == 1){
            System.out.println("Le vainqueur de l'élection est : " + vainqueurs.get(0).getNom() + " " + vainqueurs.get(0).getPrenom());
        } else {
            System.out.println("Il y a une égalité entre les candidats suivants :");
            for (Candidat candidat : vainqueurs) {
                System.out.println(candidat.getNom() + " " + candidat.getPrenom());
            }
        }

        return vainqueurs;
    }

    public List<Candidat> getCandidats() {
        return candidats;
    }

    public Boolean getElectionTerminee() {
        return electionTerminee;
    }
}
