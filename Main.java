import java.time.LocalDate;

import Magasin.Model.*;
import Magasin.Vue.*;

public class Main {
        public static void main(String[] args) {

                Magasin monMagasin = new Magasin("RoCoorp", "1 rue des JO");
                VuePrincipale vuePrincipaleMagasin = new VuePrincipale(monMagasin);

                Client johnn = new Client("John", "Johnn", "johnn.john@gmail.com",
                                monMagasin);
                Client dimitri = new Client("Le prince", "Dimitri",
                                "leprice.dimitri@gmail.com", monMagasin);

                vuePrincipaleMagasin.show();
                vuePrincipaleMagasin.pack();

                Fournisseur abc = new Fournisseur("ABC Coorp", "1 Rue de l'Alphabet", monMagasin);
                Fournisseur fournisseur2 = new Fournisseur("Les Seconds", "2 Rue des Perdants", monMagasin);

                Rayon football = new Rayon("football", 100, monMagasin);
                Rayon tennis = new Rayon("tennis", 150, monMagasin);
                Rayon natation = new Rayon("natation", 20, monMagasin);

                Materiel ballonFootball = new Materiel(
                                "Ballon de foot", 10.0, 10, "Football",
                                monMagasin, football, fournisseur2,
                                0.400, 20.0, 20.0);

                Vetement maillotFoot = new Vetement("Maillot de foot", 90, 10,
                                "Football", football, abc, monMagasin,
                                "L", "Bleu");

                Vendeur vendeur1 = new Vendeur("A", "Bea", "98049409", monMagasin);
                Vendeur vendeur2 = new Vendeur("Dupond", "Patrick", "0123654456",
                                monMagasin);

                Vente vente1 = new Vente(LocalDate.now(), dimitri, vendeur2, monMagasin);
                vente1.ajouterProduit(ballonFootball, 2);
                vente1.ajouterProduit(maillotFoot, 1);

                // vente1.toString();
                // vente1.validerVente();
                // vendeur2.calculCA();

                // Article top = monMagasin.articlePlusVendu();
                // System.out.println("Le meilleur produit : " + top.getNomProduit()
                // + " avec " + top.calculerQuantiteVendue() + " unités vendues.");

                // Article pire = monMagasin.articleMoinsVendu();

                // System.out.println("Le pire produit : " + pire.getNomProduit()
                // + " avec " + pire.calculerQuantiteVendue() + " unités vendues.");

                // monMagasin.affichageMagasin();

        }
}
