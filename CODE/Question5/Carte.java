package Question5;

public class Carte {
    private static final int TAILLE_CARTE = 10;
    private Ressource[][] grille;

    public Carte() {
        this.grille = new Ressource[TAILLE_CARTE][TAILLE_CARTE];
        // Initialisation de la carte avec des ressources et des zombies
    }

    public boolean estPositionValide(int x, int y) {
        return x >= 0 && x < TAILLE_CARTE && y >= 0 && y < TAILLE_CARTE;
    }

    // Méthodes pour ajouter des ressources, des zombies, etc.
}
