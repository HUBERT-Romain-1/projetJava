package Magasin.Vue.VueStatistique;

import Magasin.Model.*;
import Magasin.Controleur.*;
import Magasin.Controleur.Statistique.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.util.Vector;

public class VueStatArticle extends JFrame {

    public String[] criteresCombo = Article.getCriteresStats();
    public String[] titresTableau = Article.getCriteresRechercheStat();

    public JLabel categorieLabel = new JLabel("Filtre par :");
    public JComboBox<String> comboType = new JComboBox<>(criteresCombo);

    public JLabel recherche = new JLabel("Nombre de jours / Quantité : ");
    public JTextField zoneRecherche = new JTextField(15);

    public DefaultTableModel modeleTable = new DefaultTableModel(titresTableau, 0) {
        @Override
        public boolean isCellEditable(int rowIndex, int columnIndex) {
            // rien modifiable
            return false;
        }
    };

    public JTable tableArticle = new JTable(modeleTable);

    // Boutons spécifiques à la consultation
    JButton btnFilter = new JButton("Filtre");
    JButton btnAnnuler = new JButton("Annuler");

    public Magasin magasin;

    public VueStatArticle(Magasin m) {

        this.magasin = m;

        this.setPreferredSize(new Dimension(800, 600));
        setTitle("Statistique - Articles " + m.getNomMagasin());
        this.setLayout(new BorderLayout(15, 15));

        // recherche Nord
        JPanel recherchePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));

        recherchePanel.add(categorieLabel);
        recherchePanel.add(comboType);

        recherchePanel.add(recherche);
        recherchePanel.add(zoneRecherche);

        JScrollPane scrollPane = new JScrollPane(tableArticle);
        scrollPane.setBorder(BorderFactory.createTitledBorder("Liste des Articles"));

        JPanel tableau = new JPanel(new BorderLayout(0, 10));
        ajusterLargeurColonnes(tableArticle);
        tableau.setBorder(BorderFactory.createEmptyBorder(0, 30, 0, 30));

        tableau.add(scrollPane);

        JPanel boutons = new JPanel();
        boutons.add(btnAnnuler);
        boutons.add(btnFilter);

        this.add(recherchePanel, BorderLayout.NORTH);
        this.add(tableau, BorderLayout.CENTER);
        this.add(boutons, BorderLayout.SOUTH);

        // pour affichage au démarage de la vue
        this.majTableau(magasin.getListeArticle());

        ControleurBoutonAnnuler cont = new ControleurBoutonAnnuler(this);
        btnAnnuler.addActionListener(cont);

        ControleurStatArticle ctrl = new ControleurStatArticle(comboType, zoneRecherche, modeleTable, m);
        btnFilter.addActionListener(ctrl);

    }

    public void majTableau(Vector<Article> liste) {
        modeleTable.setRowCount(0);

        for (int i = 0; i < liste.size(); i++) {
            Article a = liste.get(i);
            modeleTable.addRow(a.getLigneTableauStat());
        }

    }

    public void ajusterLargeurColonnes(JTable tableau) {
        // modèle des colonnes
        javax.swing.table.TableColumnModel columnModel = tableau.getColumnModel();

        // ID
        columnModel.getColumn(0).setPreferredWidth(50);
        columnModel.getColumn(0).setMaxWidth(80);

        // Nom
        columnModel.getColumn(1).setPreferredWidth(150);

        // Prix
        columnModel.getColumn(2).setPreferredWidth(70);
        columnModel.getColumn(2).setMaxWidth(100);

        // Stock
        columnModel.getColumn(3).setPreferredWidth(60);
        columnModel.getColumn(3).setMaxWidth(80);

        // Sport
        columnModel.getColumn(4).setPreferredWidth(100);

        // Fournisseur
        columnModel.getColumn(5).setPreferredWidth(120);

        // Caractéristiques
        columnModel.getColumn(6).setPreferredWidth(400);
    }
}