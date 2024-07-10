package Question5;

public class Carte {
    private static final int TAILLE_CARTE = 10;
    private Ressource[][] grille;

    public Carte() {
        this.grille = new Ressource[TAILLE_CARTE][TAILLE_CARTE];
    }

    public boolean estPositionValide(int x, int y) {
        return x >= 0 && x < TAILLE_CARTE && y >= 0 && y < TAILLE_CARTE;
    }

}
