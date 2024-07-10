package Question5.Test;

import Question5.Carte;
import Question5.Orientation;
import Question5.Survivant;
import org.junit.Test;
import static org.junit.Assert.*;

public class SurvivantTest {

    @Test
    public void testAvancerDeUneCase() {
        Carte carte = new Carte();
        Survivant survivant = new Survivant(0, 0, Orientation.NORD);

        survivant.avancer(carte);

        assertEquals(0, survivant.getX());
        assertEquals(1, survivant.getY());
    }

    @Test
    public void testReculerDeUneCase() {
        Carte carte = new Carte();
        Survivant survivant = new Survivant(0, 1, Orientation.SUD);

        survivant.avancer(carte);

        assertEquals(0, survivant.getX());
        assertEquals(0, survivant.getY());
    }

    @Test
    public void testTournerDeUneCaseVersLaDroite() {
        Carte carte = new Carte();
        Survivant survivant = new Survivant(1, 0, Orientation.EST);

        survivant.reculer(carte);

        assertEquals(0, survivant.getX());
        assertEquals(0, survivant.getY());
    }

    @Test
    public void testTournerDeUneCaseVersLaGauche() {
        Carte carte = new Carte();
        Survivant survivant = new Survivant(0, 0, Orientation.OUEST);

        survivant.reculer(carte);

        assertEquals(1, survivant.getX());
        assertEquals(0, survivant.getY());
    }
}

