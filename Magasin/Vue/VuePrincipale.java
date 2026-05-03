package Magasin.Vue;

import Magasin.Controleur.ControleurPagePrincipale;
import Magasin.Model.*;
import javax.swing.*;
import java.awt.*;

public class VuePrincipale extends JFrame {

    JButton ajouteClient = new JButton("Ajouter Client");
    JButton ajouteVendeur = new JButton("Ajouter Vendeur");
    JButton ajouteVente = new JButton("Ajouter Vente");
    JButton ajouteArticle = new JButton("Ajouter Article");
    JButton ajouteFournisseur = new JButton("Ajouter Fournisseur");
    JButton ajouteRayon = new JButton("Ajouter Rayon");

    JButton consulterClient = new JButton("Consulter Client");
    JButton consulterVendeur = new JButton("Consulter Vendeur");
    JButton consulterVente = new JButton("Consulter Vente");
    JButton consulterArticle = new JButton("Consulter Article");
    JButton consulterFournisseur = new JButton("Consulter Fournisseur");
    JButton consulterRayon = new JButton("Consulter Rayon");

    JButton statistique = new JButton("Statistique");

    Magasin magasin;

    public VuePrincipale(Magasin m) {

        this.magasin = m;
        this.setTitle("Nom du Magasin : " + magasin.getNomMagasin());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.getContentPane().setLayout(new BorderLayout());

        Dimension tailleBouton = new Dimension(400, 80);

        JPanel boutonsAjouter = new JPanel(new GridLayout(6, 1, 20, 20));
        boutonsAjouter.setBorder(BorderFactory.createEmptyBorder(25, 50, 25, 50));
        configurerBouton(ajouteClient, tailleBouton, boutonsAjouter);
        configurerBouton(ajouteVendeur, tailleBouton, boutonsAjouter);
        configurerBouton(ajouteVente, tailleBouton, boutonsAjouter);
        configurerBouton(ajouteArticle, tailleBouton, boutonsAjouter);
        configurerBouton(ajouteFournisseur, tailleBouton, boutonsAjouter);
        configurerBouton(ajouteRayon, tailleBouton, boutonsAjouter);

        JPanel boutonsConsulter = new JPanel(new GridLayout(6, 1, 20, 20));

        boutonsConsulter.setBorder(BorderFactory.createEmptyBorder(25, 50, 25, 50));
        configurerBouton(consulterClient, tailleBouton, boutonsConsulter);
        configurerBouton(consulterVendeur, tailleBouton, boutonsConsulter);
        configurerBouton(consulterVente, tailleBouton, boutonsConsulter);
        configurerBouton(consulterArticle, tailleBouton, boutonsConsulter);
        configurerBouton(consulterFournisseur, tailleBouton, boutonsConsulter);
        configurerBouton(consulterRayon, tailleBouton, boutonsConsulter);

        JPanel centreLayout = new JPanel(new GridLayout(1, 2));

        JPanel wrapG = new JPanel(new GridBagLayout());
        wrapG.add(boutonsAjouter);

        JPanel wrapD = new JPanel(new GridBagLayout());
        wrapD.add(boutonsConsulter);

        centreLayout.add(wrapG);
        centreLayout.add(wrapD);

        // 4. Zone du bas : Statistique
        JPanel sudPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        sudPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 50, 0)); // Marge en bas
        statistique.setPreferredSize(new Dimension(610, 60));
        sudPanel.add(statistique);

        // 5. Assemblage final
        this.add(centreLayout, BorderLayout.CENTER);
        this.add(sudPanel, BorderLayout.SOUTH);

        this.setPreferredSize(new Dimension(1100, 800));

        ControleurPagePrincipale cont = new ControleurPagePrincipale(m);
        ajouteClient.addActionListener(cont);
        ajouteVendeur.addActionListener(cont);
        ajouteVente.addActionListener(cont);
        ajouteArticle.addActionListener(cont);
        ajouteFournisseur.addActionListener(cont);
        ajouteRayon.addActionListener(cont);

        consulterClient.addActionListener(cont);
        consulterVendeur.addActionListener(cont);
        consulterVente.addActionListener(cont);
        consulterArticle.addActionListener(cont);
        consulterFournisseur.addActionListener(cont);
        consulterRayon.addActionListener(cont);

        statistique.addActionListener(cont);

    }

    private void configurerBouton(JButton b, Dimension d, JPanel p) {
        b.setPreferredSize(d);
        p.add(b);
    }
}
