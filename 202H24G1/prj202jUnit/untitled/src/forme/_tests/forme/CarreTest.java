package forme;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class CarreTest {
    private Carre cMin;
    private Carre cMax;
    private Carre c5;
    private Carre c1;
    private Carre cNull;
    @BeforeEach
    void testCarre() {
        initCarres();
    }

    private void initCarres() {
        cMin = new Carre(Carre.DIM_MIN);
        cMax = new Carre(Carre.DIM_MAX);
        c1 = new Carre(1);
        c5 = new Carre(5);
        cNull = null;
    }

    @Test
    void coustructeur_instencieQueDesCarresValides() {
        assertEquals(Carre.DIM_MIN, new Carre(Carre.DIM_MIN).getCote());
        assertEquals(Carre.DIM_MAX, new Carre(Carre.DIM_MAX).getCote());

        assertThrows(IllegalArgumentException.class, () -> {new Carre(Carre.DIM_MIN - 1);}); //
        assertThrows(IllegalArgumentException.class, () -> {new Carre(Carre.DIM_MAX + 1);});
    }

    @Test
    void getSurface_retourneLaSurfaceDuCarre() {
        assertEquals(Carre.DIM_MIN * Carre.DIM_MIN, cMin.getSurface());
        assertEquals(Carre.DIM_MAX * Carre.DIM_MAX, cMax.getSurface());
        assertEquals(1, c1.getSurface());
        assertEquals(25, c5.getSurface());
    }

    @Test
    void estPlusGrand_retounreVraiSiPlusGrand() {
        assertTrue(c1.estPlusGrand(cMin));
        assertTrue(c5.estPlusGrand(c1));
    }
    @Test
    void estPlusGrand_retounreFauxSiPlusPlusPetitOuEgal() {
        assertFalse(c1.estPlusGrand(new Carre(1)));
        assertFalse(c1.estPlusGrand(c5));
    }
    @Test
    void estPlusGrand_ProvoqueExceptionPourCarreNull() {
        assertThrows(NullPointerException.class, () -> {c5.estPlusGrand(cNull);});
    }
}