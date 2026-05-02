package Magasin.Vue.VueAjout;

import Magasin.Controleur.*;
import Magasin.Controleur.AjoutVente.ControleurAjoutLigneVente;
import Magasin.Controleur.AjoutVente.ControleurValiderVente;
import Magasin.Model.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.util.Vector;

public class VueAjoutVente extends JFrame {

    Magasin magasin;
    Vente venteEncours = null;
    Vector<LigneVente> panier = new Vector<>();

    // Formulaire en haut

    JLabel zoneClient = new JLabel("Choisir le Client :");
    JLabel zoneVendeur = new JLabel("Choisir le Vendeur :");
    JLabel zoneArticle = new JLabel("Sélectionner l'Article :");
    JLabel zoneQuantite = new JLabel("Quantité :");
    JLabel zoneDate = new JLabel("Date de vente (JJ/MM/AAAA) :");

    JComboBox<Client> comboClients;
    JComboBox<Vendeur> comboVendeurs;
    JComboBox<Article> comboArticles;
    JTextField quantite = new JTextField(4);

    // Table
    String[] titres = { "ID", "Article", "Prix Unitaire", "Quantité", "Total" };
    public DefaultTableModel modeleTable = new DefaultTableModel(titres, 0) {
        @Override
        public boolean isCellEditable(int row, int column) {
            // Cell non modifiable
            return false;
        }
    };

    public JTable tableLignes = new JTable(modeleTable);

    JLabel total = new JLabel("Total :");
    JTextField zonetotal = new JTextField(10);

    JButton btnAnnuler = new JButton("Annuler");
    JButton btnAjouterLigne = new JButton("Ajouter l'article au tableau");
    JButton btnEnregistrer = new JButton("Enregistrer la Vente");

    public VueAjoutVente(Magasin m) {
        this.magasin = m;

        this.setTitle("Créer une Vente - " + magasin.getNomMagasin());

        this.setPreferredSize(new Dimension(800, 600));
        this.setLayout(new BorderLayout(15, 15));

        JPanel formulaire = new JPanel(new GridLayout(4, 2, 20, 20));
        formulaire.setBorder(BorderFactory.createEmptyBorder(20, 30, 20, 30));

        // CLient
        formulaire.add(zoneClient);
        comboClients = new JComboBox<>(magasin.getListeClient());
        formulaire.add(comboClients);

        // Vendeur
        formulaire.add(zoneVendeur);
        comboVendeurs = new JComboBox<>(magasin.getListeVendeur());
        formulaire.add(comboVendeurs);

        // Article
        formulaire.add(zoneArticle);
        comboArticles = new JComboBox<>(magasin.getListeArticle());
        formulaire.add(comboArticles);

        // Quantite
        formulaire.add(zoneQuantite);
        formulaire.add(quantite);

        JScrollPane scrollPane = new JScrollPane(tableLignes);
        scrollPane.setBorder(BorderFactory.createTitledBorder("Articles ajoutés"));

        JPanel tableau = new JPanel(new BorderLayout(0, 10));
        tableau.setBorder(BorderFactory.createEmptyBorder(0, 30, 0, 30));

        tableau.add(scrollPane);

        JPanel boutons = new JPanel(new GridLayout(2, 2, 20, 20));
        boutons.setBorder(BorderFactory.createEmptyBorder(0, 30, 20, 30));

        JPanel ptotal = new JPanel();
        zonetotal.setEditable(false);
        ptotal.add(total);
        ptotal.add(zonetotal);

        boutons.add(ptotal);
        boutons.add(btnAnnuler);
        boutons.add(btnAjouterLigne);
        boutons.add(btnEnregistrer);

        getContentPane().add(formulaire, BorderLayout.NORTH);
        getContentPane().add(boutons, BorderLayout.SOUTH);
        getContentPane().add(tableau, BorderLayout.CENTER);

        ControleurBoutonAnnuler cont = new ControleurBoutonAnnuler(this);
        btnAnnuler.addActionListener(cont);

        ControleurAjoutLigneVente ctrlAdd = new ControleurAjoutLigneVente(comboArticles, comboClients, comboVendeurs,
                quantite, m, modeleTable, panier, zonetotal, this);
        btnAjouterLigne.addActionListener(ctrlAdd);

        ControleurValiderVente ctrVal = new ControleurValiderVente(m, comboClients, comboVendeurs, modeleTable, this);

        btnEnregistrer.addActionListener(ctrVal);
    }
}