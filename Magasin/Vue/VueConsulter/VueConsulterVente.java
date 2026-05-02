package Magasin.Vue.VueConsulter;

import Magasin.Model.*;
import javax.swing.*;
import java.awt.*;

public class VueConsulterVente extends JFrame {

    Magasin magasin;

    JComboBox<Client> comboClients;
    JComboBox<Vendeur> comboVendeurs;

    // Date
    JTextField txtJ = new JTextField(2);
    JTextField txtM = new JTextField(2);
    JTextField txtA = new JTextField(4);

    JButton btnChercher = new JButton("Chercher");
    JButton btnModifier = new JButton("Enregistrer les Modifications");
    JButton btnAnnuler = new JButton("Annuler");
    JButton btnVoirListeClient = new JButton("Voir Liste Client");

    public VueConsulterVente(Magasin m) {
        this.magasin = m;

        this.setTitle("Consulter / Modifier Vente - " + magasin.getNomMagasin());

        this.setPreferredSize(new Dimension(800, 250));

        JPanel formulaire = new JPanel(new GridLayout(3, 2, 20, 20));
        formulaire.setBorder(BorderFactory.createEmptyBorder(20, 30, 20, 30));

        formulaire.add(new JLabel("Choisir le Client :"));
        comboClients = new JComboBox<>(magasin.getListeClient());
        formulaire.add(comboClients);

        formulaire.add(new JLabel("Choisir le Vendeur :"));
        comboVendeurs = new JComboBox<>(magasin.getListeVendeur());
        formulaire.add(comboVendeurs);

        formulaire.add(new JLabel("Date de vente (JJ/MM/AAAA) :"));
        JPanel pDate = new JPanel();
        pDate.add(txtJ);
        pDate.add(new JLabel("/"));
        pDate.add(txtM);
        pDate.add(new JLabel("/"));
        pDate.add(txtA);
        formulaire.add(pDate);

        JPanel boutons = new JPanel();
        boutons.add(btnAnnuler);
        boutons.add(btnChercher);
        boutons.add(btnModifier);
        boutons.add(btnVoirListeClient);

        getContentPane().add(formulaire, BorderLayout.CENTER);
        getContentPane().add(boutons, BorderLayout.SOUTH);
    }
}