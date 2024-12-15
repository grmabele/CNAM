package org.example;

public class Candidat {

    private String nom;
    private String prenom;
    private String parti;
    private Integer voix;

    public Candidat(String nom, String prenom, String parti) {
        this.nom = nom;
        this.prenom = prenom;
        this.parti = parti;
        this.voix = null;
    }

    public Candidat(String nom, String prenom) {
        this(nom, prenom, null);
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getParti() {
        return parti;
    }

    public Integer getVoix() {
        return voix;
    }

    public void setVoix(Integer voix) {
        if (voix == null || voix >= 0 ) {
            this.voix = voix;
        } else {throw new IllegalArgumentException("Le nombre de voix ne peut pas être négatif.");
        }
    }

    @Override
    public String toString() {
       String resultvoix = (voix == null) ? "résultat non enregistré" : voix + "voix";

       return String.format(
               "Candidat : %s %s, Parti: %s, Resultat : %s",
               prenom, nom, getParti(), resultvoix
       );
    }
}
