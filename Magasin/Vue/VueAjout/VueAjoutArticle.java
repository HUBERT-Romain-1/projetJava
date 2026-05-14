package Magasin.Vue.VueAjout;

import Magasin.Controleur.AjoutArticle.*;
import Magasin.Controleur.*;
import Magasin.Model.*;
import javax.swing.*;
import java.awt.*;

public class VueAjoutArticle extends JFrame {

    // Formulaire P1
    public JLabel nom = new JLabel("Nom de L'article:");
    public JLabel prix = new JLabel("Prix de L'article :");
    public JLabel stock = new JLabel("Quantité :");
    public JLabel marque = new JLabel("Marque :");
    public JLabel rayon = new JLabel("Rayon :");

    public JTextField zoneNom = new JTextField();
    public JTextField zonePrix = new JTextField();
    public JTextField zoneStock = new JTextField();
    public JTextField zoneMarque = new JTextField();

    public JComboBox<Rayon> comboRayon;

    public JLabel typeLabel = new JLabel("Type d'article :");
    public String[] types = { "Nourriture", "Vêtement", "Matériel" };
    public JComboBox<String> comboType = new JComboBox<>(types);

    public JLabel fournisseur = new JLabel("Fournisseur :");
    public JComboBox<Fournisseur> comboFournisseur;

    // Bouton P1
    public JButton btnSuivant = new JButton("Suivant >");
    public JButton btnAnnuler = new JButton("Annuler");

    // Formulaire P2
    public JLabel saveur = new JLabel("Saveur :");
    public JLabel taille = new JLabel("Tailles :");
    public JLabel couleur = new JLabel("Couleur :");
    public JLabel Longueur = new JLabel("Longueur (Cm) :");
    public JLabel Largeur = new JLabel("Largeur (Cm) :");
    public JLabel poids = new JLabel("Poids (KG) :");

    public JTextField zoneSaveur = new JTextField();
    public JComboBox<String> comboTaille = new JComboBox<>(new String[] { "S", "M", "L", "XL" });
    public JTextField zoneCouleur = new JTextField();
    public JTextField zoneLongueur = new JTextField();
    public JTextField zoneLargeur = new JTextField();
    public JTextField zonePoids = new JTextField();

    public JTextField txtJ = new JTextField(2);
    public JTextField txtM = new JTextField(2);
    public JTextField txtA = new JTextField(4);

    // CardLayout
    public CardLayout cardLayoutP1 = new CardLayout();
    public JPanel conteneurPrincipale = new JPanel(cardLayoutP1);

    public CardLayout cardLayoutP2 = new CardLayout();
    public JPanel panelP2 = new JPanel(cardLayoutP2);

    public Magasin magasin;

    public VueAjoutArticle(Magasin m) {

        this.magasin = m;

        setTitle("Ajout d'un nouvel Article - " + m.getNomMagasin());
        this.setPreferredSize(new Dimension(600, 400));

        JPanel page1 = new JPanel();
        page1.setLayout(new BorderLayout());

        // Formulaire P1
        JPanel formulaire = new JPanel(new GridLayout(7, 2, 20, 20));
        formulaire.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        formulaire.add(nom);
        formulaire.add(zoneNom);

        formulaire.add(prix);
        formulaire.add(zonePrix);

        formulaire.add(stock);
        formulaire.add(zoneStock);

        formulaire.add(marque);
        formulaire.add(zoneMarque);

        formulaire.add(typeLabel);
        formulaire.add(comboType);

        formulaire.add(rayon);
        comboRayon = new JComboBox<>(magasin.getListeRayon());
        formulaire.add(comboRayon);

        formulaire.add(fournisseur);
        comboFournisseur = new JComboBox<>(magasin.getListeFournisseur());
        formulaire.add(comboFournisseur);

        // Bouton p1
        JPanel boutons = new JPanel(new GridLayout(1, 2, 20, 20));
        boutons.setBorder(BorderFactory.createEmptyBorder(0, 20, 20, 20));

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
                zoneMarque,
                comboFournisseur,
                this);

        btnSuivant.addActionListener(ctrlSuivant);

        ControleurEnregistrerArticle ctrEnregistre = new ControleurEnregistrerArticle(m, this);
        btnEnregistrer.addActionListener(ctrEnregistre);

        ControleurRetourArticle ctrlRetour = new ControleurRetourArticle(conteneurPrincipale);
        btnRetour.addActionListener(ctrlRetour);

        ControleurBoutonAnnuler ctrAnnuler = new ControleurBoutonAnnuler(this);
        btnAnnuler.addActionListener(ctrAnnuler);
    }

    public JPanel creerPanelNourriture() {
        JPanel p = new JPanel(new GridLayout(2, 2, 10, 10));
        p.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        // Panel date
        JPanel pDate = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 0));
        pDate.add(txtJ);
        pDate.add(new JLabel("/"));
        pDate.add(txtM);
        pDate.add(new JLabel("/"));
        pDate.add(txtA);

        p.add(saveur);
        p.add(zoneSaveur);

        // pour la date
        p.add(new JLabel("Date Exp. : (jj/MM/AAAA)"));
        p.add(pDate);
        return p;
    }

    public JPanel creerPanelVetement() {
        JPanel p = new JPanel(new GridLayout(2, 2, 10, 10));

        p.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        p.add(taille);
        p.add(comboTaille);
        p.add(couleur);
        p.add(zoneCouleur);
        return p;
    }

    public JPanel creerPanelMateriel() {
        JPanel p = new JPanel(new GridLayout(3, 2, 10, 10));
        p.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        p.add(poids);
        p.add(zonePoids);
        p.add(Largeur);
        p.add(zoneLargeur);
        p.add(Longueur);
        p.add(zoneLongueur);
        return p;
    }

}
