package Magasin.Vue;

import Magasin.Model.*;
import javax.swing.*;
import java.awt.*;

public class VueAjoutVente extends JFrame {

    private Magasin magasin;

    private JComboBox<String> comboClients;
    private JComboBox<Vendeur> comboVendeurs;

    // Date
    private JTextField txtJ = new JTextField(2);
    private JTextField txtM = new JTextField(2);
    private JTextField txtA = new JTextField(4);

    private JButton btnEnregistrer = new JButton("Enregistrer la Vente");
    private JButton btnAnnuler = new JButton("Annuler");

    public VueAjoutVente(Magasin m) {
        this.magasin = m;

        this.setTitle("Créer une Vente - " + magasin.getNomMagasin());

        this.setPreferredSize(new Dimension(800, 250));

        JPanel formulaire = new JPanel(new GridLayout(3, 2, 20, 20));
        formulaire.setBorder(BorderFactory.createEmptyBorder(20, 30, 20, 30));

        formulaire.add(new JLabel("Choisir le Client :"));
        comboClients = new JComboBox<>(magasin.getNomPrenomClientTab());
        formulaire.add(comboClients);

        formulaire.add(new JLabel("Choisir le Vendeur :"));
        comboVendeurs = new JComboBox<>(magasin.getListeVendeur()); // Méthode getNomPrenomVendeurTab()
        formulaire.add(comboVendeurs);

        formulaire.add(new JLabel("Date de vente (JJ/MM/AAAA) :"));
        JPanel pDate = new JPanel();
        pDate.add(txtJ);
        pDate.add(new JLabel("/"));
        pDate.add(txtM);
        pDate.add(new JLabel("/"));
        pDate.add(txtA);
        formulaire.add(pDate);

        JPanel panelBoutons = new JPanel(new GridLayout(1, 2, 20, 20));
        panelBoutons.setBorder(BorderFactory.createEmptyBorder(0, 30, 20, 30));
        panelBoutons.add(btnEnregistrer);
        panelBoutons.add(btnAnnuler);

        getContentPane().add(formulaire, BorderLayout.CENTER);
        getContentPane().add(panelBoutons, BorderLayout.SOUTH);
    }
}