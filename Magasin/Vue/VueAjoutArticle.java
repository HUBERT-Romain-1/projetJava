package Magasin.Vue;

import Magasin.Controleur.ControleurAjoutArticleSuivant;
import Magasin.Controleur.ControleurRetourArticle;
import Magasin.Model.*;
import javax.swing.*;
import java.awt.*;

public class VueAjoutArticle extends JFrame {

    // Formulaire P1
    JLabel nom = new JLabel("Nom de L'article:");
    JLabel prix = new JLabel("Prix de L'article :");
    JLabel stock = new JLabel("Quantité :");
    JLabel sport = new JLabel("Sport :");

    JTextField zoneNom = new JTextField();
    JTextField zonePrix = new JTextField();
    JTextField zoneStock = new JTextField();
    JTextField zoneSport = new JTextField();

    JLabel typeLabel = new JLabel("Type d'article :");
    String[] types = { "Nourriture", "Vêtement", "Matériel" };
    JComboBox<String> comboType = new JComboBox<>(types);

    // Bouton P1
    JButton btnSuivant = new JButton("Suivant >");
    JButton btnAnnuler = new JButton("Annuler");

    // Formulaire P2
    JLabel saveur = new JLabel("Saveur :");
    JLabel taille = new JLabel("Tailles :");
    JLabel Longueur = new JLabel("Longueur (Cm) :");
    JLabel Largeur = new JLabel("Largeur (Cm) :");
    JLabel poids = new JLabel("Poids (KG) :");

    JTextField zoneSaveur = new JTextField();
    JTextField zoneTaille = new JTextField();
    JTextField zoneLongueur = new JTextField();
    JTextField zoneLargeur = new JTextField();
    JTextField zonePoids = new JTextField();

    // CardLayout
    CardLayout cardLayoutP1 = new CardLayout();
    JPanel conteneurPrincipale = new JPanel(cardLayoutP1);

    CardLayout cardLayoutP2 = new CardLayout();
    JPanel panelP2 = new JPanel(cardLayoutP2);

    Magasin magasin;

    public VueAjoutArticle(Magasin m) {

        this.magasin = m;

        setTitle("Ajout d'un nouvel Article - " + m.getNomMagasin());
        setPreferredSize(new Dimension(800, 350));

        JPanel page1 = new JPanel();
        page1.setLayout(new BorderLayout());

        // Formulaire P1
        JPanel formulaire = new JPanel(new GridLayout(5, 2, 20, 20));
        formulaire.setBorder(BorderFactory.createEmptyBorder(30, 30, 20, 30));

        formulaire.add(nom);
        formulaire.add(zoneNom);

        formulaire.add(prix);
        formulaire.add(zonePrix);

        formulaire.add(stock);
        formulaire.add(zoneStock);

        formulaire.add(sport);
        formulaire.add(zoneSport);

        formulaire.add(typeLabel);
        formulaire.add(comboType);

        // Bouton p1
        JPanel boutons = new JPanel(new GridLayout(1, 2, 20, 20));
        boutons.setBorder(BorderFactory.createEmptyBorder(0, 30, 20, 30));

        btnSuivant.setPreferredSize(new Dimension(200, 40));
        btnAnnuler.setPreferredSize(new Dimension(100, 40));

        boutons.add(btnAnnuler);
        boutons.add(btnSuivant);

        JPanel page2 = new JPanel();
        page2.setLayout(new BorderLayout());

        // formulaire P2
        panelP2.add(creerPanelNourriture(), "Nourriture");
        panelP2.add(creerPanelMateriel(), "Matériel");
        panelP2.add(creerPanelVetement(), "Vêtement");

        // Bouton P2
        JPanel boutonsP2 = new JPanel();

        JButton btnRetour = new JButton("< Retour");
        JButton btnEnregistrer = new JButton("Enregistrer l'Article");
        boutonsP2.add(btnRetour);
        boutonsP2.add(btnEnregistrer);

        // ajout dans le Grand Panel
        page1.add(formulaire, BorderLayout.CENTER);
        page1.add(boutons, BorderLayout.SOUTH);

        page2.add(panelP2, BorderLayout.CENTER);
        page2.add(boutonsP2, BorderLayout.SOUTH);

        conteneurPrincipale.add(page1, "P1");
        conteneurPrincipale.add(page2, "P2");
        this.getContentPane().add(conteneurPrincipale);

        ControleurAjoutArticleSuivant ctrlSuivant = new ControleurAjoutArticleSuivant(
                conteneurPrincipale,
                panelP2,
                comboType,
                zoneNom,
                zonePrix,
                zoneStock,
                zoneSport,
                this);

        btnSuivant.addActionListener(ctrlSuivant);

        ControleurRetourArticle ctrlRetour = new ControleurRetourArticle(conteneurPrincipale);
        btnRetour.addActionListener(ctrlRetour);
    }

    public JPanel creerPanelNourriture() {
        JPanel p = new JPanel(new GridLayout(2, 2, 10, 10));
        p.setBorder(BorderFactory.createTitledBorder("Détails Nourriture"));
        p.add(saveur);
        p.add(zoneSaveur);
        p.add(new JLabel("Date Exp. :"));
        p.add(new JTextField("JJ/MM/AAAA"));
        return p;
    }

    public JPanel creerPanelVetement() {
        JPanel p = new JPanel(new GridLayout(2, 2, 10, 10));
        p.setBorder(BorderFactory.createTitledBorder("Détails Vêtement"));
        p.add(taille);
        p.add(new JComboBox<>(new String[] { "S", "M", "L", "XL" }));
        p.add(new JLabel("Couleur :"));
        p.add(new JTextField());
        return p;
    }

    public JPanel creerPanelMateriel() {
        JPanel p = new JPanel(new GridLayout(3, 2, 10, 10));
        p.setBorder(BorderFactory.createTitledBorder("Détails Matériel"));
        p.add(poids);
        p.add(zonePoids);
        p.add(Largeur);
        p.add(zoneLargeur);
        p.add(Longueur);
        p.add(zoneLongueur);
        return p;
    }

}
