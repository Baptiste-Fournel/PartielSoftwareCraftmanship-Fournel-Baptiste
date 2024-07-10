package Question5;

public class Survivant {
    private int x;
    private int y;
    private Orientation orientation;
    private int health;
    private Inventaire inventaire;

    public Survivant(int x, int y, Orientation orientation) {
        this.x = x;
        this.y = y;
        this.orientation = orientation;
        this.health = 100;
        this.inventaire = new Inventaire();
    }

    public void explorer(Carte carte, Commande commande) {
        switch (commande) {
            case AVANCER:
                avancer(carte);
                break;
            case RECULER:
                reculer(carte);
                break;
            case TOURNER_GAUCHE:
                tournerGauche();
                break;
            case TOURNER_DROITE:
                tournerDroite();
                break;
        }
        rencontrerZombie(carte);
    }

    public void avancer(Carte carte) {
        int newX = x;
        int newY = y;

        switch (orientation) {
            case NORD:
                newY++;
                break;
            case SUD:
                newY--;
                break;
            case EST:
                newX++;
                break;
            case OUEST:
                newX--;
                break;
        }

        if (carte.estPositionValide(newX, newY)) {
            x = newX;
            y = newY;
        }
    }


    public void reculer(Carte carte) {
        int newX = x;
        int newY = y;

        switch (orientation) {
            case NORD:
                newY--;
                break;
            case SUD:
                newY++;
                break;
            case EST:
                newX--;
                break;
            case OUEST:
                newX++;
                break;
        }

        if (carte.estPositionValide(newX, newY)) {
            x = newX;
            y = newY;
        }
    }



    public void tournerGauche() {
        switch (orientation) {
            case NORD:
                orientation = Orientation.OUEST;
                break;
            case SUD:
                orientation = Orientation.EST;
                break;
            case EST:
                orientation = Orientation.NORD;
                break;
            case OUEST:
                orientation = Orientation.SUD;
                break;
        }
    }

    public void tournerDroite() {
        switch (orientation) {
            case NORD:
                orientation = Orientation.EST;
                break;
            case SUD:
                orientation = Orientation.OUEST;
                break;
            case EST:
                orientation = Orientation.SUD;
                break;
            case OUEST:
                orientation = Orientation.NORD;
                break;
        }
    }

    private void rencontrerZombie(Carte carte) {
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Orientation getOrientation() {
        return orientation;
    }
}
