package cours18_hash;

/*
420-202 – TP2 – Traitement de données orienté objet
TP2 – jeu de mémoire
Groupe : 2 (mardi – vendredi)
Nom : Aubé, Robert; 1234567
Nom : Musk, Elise; 5671234
Lien GIT Hub : https://github.com/robertAube/TP2/commits/main
*/
public class TestHcode {
    private Liquide l1 = new Liquide("eau", 1000);
    private Liquide l2 = new Liquide("eau", 1000);
    private Liquide l3 = new Liquide("eau", 1001);
    public TestHcode() {
        System.out.println(l1 + " : " + l1.hashCode());
        System.out.println(l2 + " : " + l2.hashCode());
        System.out.println(l3 + " : " + l3.hashCode());
    }

    public static void main(String[] args) {
        new TestHcode();
    }
}
