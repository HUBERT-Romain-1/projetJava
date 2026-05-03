package Magasin.Vue.VueConsulter;

import Magasin.Model.*;
import Magasin.Controleur.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.util.Vector;

public class VueConsulterVente extends JFrame {

    public String[] colonnes = Vente.getCriteresRecherche();

    public JLabel categorieLabel = new JLabel("Rechercher par :");
    public JComboBox<String> comboType = new JComboBox<>(colonnes);

    public JLabel recherche = new JLabel("Valeur : ");
    public JTextField zoneRecherche = new JTextField(15);

    public DefaultTableModel modeleTable = new DefaultTableModel(colonnes, 0);
    public JTable tableVente = new JTable(modeleTable);

    // Boutons spécifiques à la consultation
    JButton btnChercher = new JButton("Chercher");
    JButton btnEnregistrerModification = new JButton("Enregistrer les Modifications");
    JButton btnAnnuler = new JButton("Annuler");

    public Magasin magasin;

    public VueConsulterVente(Magasin m) {

        this.magasin = m;

        this.setPreferredSize(new Dimension(800, 600));
        setTitle("Rechercher / Modification - Vente " + m.getNomMagasin());
        this.setLayout(new BorderLayout(15, 15));

        // recherche Nord
        JPanel recherchePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));

        recherchePanel.add(categorieLabel);
        recherchePanel.add(comboType);

        recherchePanel.add(recherche);
        recherchePanel.add(zoneRecherche);

        JScrollPane scrollPane = new JScrollPane(tableVente);
        scrollPane.setBorder(BorderFactory.createTitledBorder("Liste des Ventes"));

        JPanel tableau = new JPanel(new BorderLayout(0, 10));
        tableau.setBorder(BorderFactory.createEmptyBorder(0, 30, 0, 30));

        tableau.add(scrollPane);

        JPanel boutons = new JPanel();
        boutons.add(btnAnnuler);
        boutons.add(btnChercher);
        boutons.add(btnEnregistrerModification);

        this.add(recherchePanel, BorderLayout.NORTH);
        this.add(tableau, BorderLayout.CENTER);
        this.add(boutons, BorderLayout.SOUTH);

        // pour affichage au démarage de la vue
        this.majTableau(magasin.getListeVente());

        ControleurBoutonAnnuler cont = new ControleurBoutonAnnuler(this);
        btnAnnuler.addActionListener(cont);

    }

    public void majTableau(Vector<Vente> liste) {
        modeleTable.setRowCount(0);

        for (int i = 0; i < liste.size(); i++) {
            Vente v = liste.get(i);
            modeleTable.addRow(v.getLigneTableau());
        }

    }
}