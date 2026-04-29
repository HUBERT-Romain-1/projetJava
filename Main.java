import java.time.LocalDate;

import Magasin.Model.*;
import Magasin.Vue.*;

public class Main {
        public static void main(String[] args) {

                Magasin monMagasin = new Magasin("RoCoorp", "1 rue des JO");
                VuePrincipale vuePrincipaleMagasin = new VuePrincipale(monMagasin);

                // VueConsulterRayon consulter = new VueConsulterRayon(monMagasin);
                // consulter.show();
                // consulter.pack();

                // VueConsulterClient consulterC = new VueConsulterClient(monMagasin);
                // consulterC.show();
                // consulterC.pack();
                // VueConsulterFournisseur consulterF = new VueConsulterFournisseur(monMagasin);
                // consulterF.show();
                // consulterF.pack();
                // VueConsulterVendeur consulterVD = new VueConsulterVendeur(monMagasin);
                // consulterVD.show();
                // consulterVD.pack();

                // VueConsulterVente consulterVT = new VueConsulterVente(monMagasin);
                // consulterVT.show();
                // consulterVT.pack();

                Client johnn = new Client("John", "Johnn", "johnn.john@gmail.com",
                                monMagasin);
                Client dimitri = new Client("Le prince", "Dimitri",
                                "leprice.dimitri@gmail.com", monMagasin);

                // vuePrincipaleMagasin.show();
                // vuePrincipaleMagasin.pack();

                // VueAjoutClient vueAjoutClient = new VueAjoutClient(monMagasin);

                // vueAjoutClient.show();
                // vueAjoutClient.pack();

                // VueAjoutVendeur vueAjoutVendeur = new VueAjoutVendeur(monMagasin);

                // vueAjoutVendeur.show();
                // vueAjoutVendeur.pack();

                VueAjoutVente vueAjouteVente = new VueAjoutVente(monMagasin);
                vueAjouteVente.show();
                vueAjouteVente.pack();

                // VueAjoutFournisseur vueAjoutFournisseur = new
                // VueAjoutFournisseur(monMagasin);
                // vueAjoutFournisseur.show();
                // vueAjoutFournisseur.pack();

                // VueAjoutRayon rayon = new VueAjoutRayon(monMagasin);
                // rayon.show();
                // rayon.pack();

                VueAjoutArticle article = new VueAjoutArticle(monMagasin);
                article.show();
                article.pack();

                // Rayon football = new Rayon("football", monMagasin, 50);
                // Rayon tennis = new Rayon("tennis", monMagasin, 100);
                // Rayon natation = new Rayon("natation", monMagasin, 75);

                // Article ballonFootball = new Article("Ballon de foot", 10, 10, "Football",
                // monMagasin);
                // Article maillotFoot = new Article("Maillot de foot", 90, 10, "Football",
                // monMagasin);

                // Vendeur vendeur1 = new Vendeur("A", "Bea", "98049409", monMagasin);
                // Vendeur vendeur2 = new Vendeur("Dupond", "Patrick", "0123654456",
                // monMagasin);

                // Materiel velo = new Materiel("Velo VTT", 250, 10, "Cyclisme", monMagasin, 10,
                // 150, 100);
                // Materiel tablePing = new Materiel("Table de ping-pong", 300, 12, "Ping-Pong",
                // monMagasin, 25, 100, 100);
                // Nourriture barreDeChocolat = new Nourriture("Barre de chocolat", 10, 10,
                // "fitness", monMagasin,
                // "chocolat", LocalDate.parse("2026-05-01"));

                // Vente vente1 = new Vente(null, dimitri, vendeur2, monMagasin);
                // vente1.ajouterProduit(ballonFootball, 2);
                // vente1.ajouterProduit(velo, 1);
                // vente1.ajouterProduit(barreDeChocolat, 8);

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
