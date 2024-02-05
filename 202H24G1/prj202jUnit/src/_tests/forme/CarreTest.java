package forme;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarreTest {
    private Carre c5;
    private Carre c10;
    private Carre cMin;
    private Carre cMax;
    private Carre cNull;

    @BeforeEach
    void setUp() {
        init();
    }

    private void init() {
        c5 = new Carre(5);
        c10 = new Carre(10);
        cMin = new Carre(Carre.DIM_MIN);
        cMax = new Carre(Carre.DIM_MAX);
        cNull = null;
    }

    @Test
    void constructeur_intencieQueDesCarresValides() {
        assertEquals(Carre.DIM_MIN, new Carre(Carre.DIM_MIN).getCote());
        assertEquals(Carre.DIM_MAX, new Carre(Carre.DIM_MAX).getCote());

        assertThrows(IllegalArgumentException.class, () -> {
            new Carre(Carre.DIM_MIN - 1);
        }); //nom de la classe d'Exception attendu comme argument 1; lambda expression comme 2e argument
        assertThrows(IllegalArgumentException.class, () -> {
            new Carre(Carre.DIM_MAX + 1);
        }); //nom de la classe d'Exception attendu comme argument 1; lambda expression comme 2e argument
    }

    @Test
        //annotation qui indique que c'est une méthode de teste
    void getSurface_retourneLaBonneSurfaceDuCarre() {
        assertEquals(25, c5.getSurface());
        assertEquals(100, c10.getSurface());
        assertEquals(c10.getSurface(), 100); //pas bon!!!!!!!!!!
        assertEquals(Carre.DIM_MIN * Carre.DIM_MIN, cMin.getSurface());
        assertEquals(Carre.DIM_MAX * Carre.DIM_MAX, cMax.getSurface());
    }

    @Test
    void estPlusGrand_retourneVraiSiPlusGrand() {
        assertTrue(c10.estPlusGrand(c5));
    }

    @Test
    void estPlusGrand_retourneFauxSiPlusPetitOuEgal() {
        assertFalse(c10.estPlusGrand(new Carre(10)));
        assertFalse(c10.estPlusGrand(new Carre(c10.getCote() + 1)));
    }

    @Test
    void estPlusGrand_provoqueExceptionPourCarreNull() {
        assertThrows(NullPointerException.class, () -> {
            c5.estPlusGrand(cNull);
        });
    }
}