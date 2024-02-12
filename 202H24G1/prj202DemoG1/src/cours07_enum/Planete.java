package cours06_enumEnrichi;

public enum Planete {
    MERCURE(3.303e+23, 2.4397e6),
    VENUS(4.869e+24, 6.0518e6),
    TERRE(5.976e+24, 6.37814e6),
    MARS(6.421e+23, 3.3972e6),
    JUPITER(1.9e+27, 7.1492e7),
    SATURNE(5.688e+26, 6.0268e7),
    URANUS(8.686e+25, 2.5559e7),
    NEPTUNE(1.024e+26, 2.4746e7);

    private final double masse;   // en Kg
    private final double rayon; // en mètres

    Planete(double masse, double rayon) {
        this.masse = masse;
        this.rayon = rayon;
    }

    private double getMasse() {
        return masse;
    }

    private double getRayon() {
        return rayon;
    }

    // constante gravitationnelle universelle  (m3 kg-1 s-2)
    public static final double G = 6.67300E-11;

    double calculerLaGravite() {
        return G * masse / (rayon * rayon);
    }

    double calculerPoidsDeSurface(double autreMasse) {
        return autreMasse * calculerLaGravite();
    }

    public static void main(String[] args) {
        double poidsSurLaTerre = 70; //En kg
        double masse = poidsSurLaTerre / TERRE.calculerLaGravite();

        //Planete p1 = new Planete(1,1); // un type enum n'est pas instanciable

        System.out.println("Il y a " + Planete.values().length + " planètes enregistrées.");
        for (Planete p : Planete.values())
            System.out.printf("Sur la planète %s votre poids est de %f%n kg.",
                    p, p.calculerPoidsDeSurface(masse));
    }
}

