package Magasin.Controleur;

import Magasin.Model.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.time.LocalDate;
import java.util.Vector;

public class ControleurAjoutLigneVente implements ActionListener {
    JComboBox<Article> cbArt;
    JComboBox<Client> cbClient;
    JComboBox<Vendeur> cbVendeur;
    JTextField txtQte;
    JTextField txtTotalGeneral;
    DefaultTableModel modele;

    Magasin magasin;
    Vente venteActuelle;
    Vector<LigneVente> panierTemporaire;
    JFrame fenetre;

    public ControleurAjoutLigneVente(JComboBox<Article> cbArt, JComboBox<Client> cbC, JComboBox<Vendeur> cbV,
            JTextField txtQte, Magasin m, DefaultTableModel mod, Vector<LigneVente> panier, JTextField total,
            JFrame fenetre) {
        this.cbArt = cbArt;
        this.cbClient = cbC;
        this.cbVendeur = cbV;
        this.txtQte = txtQte;
        this.magasin = m;
        this.modele = mod;
        this.panierTemporaire = panier;
        this.txtTotalGeneral = total;
        this.venteActuelle = null; // On commence à vide
        this.fenetre = fenetre;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        Article articleSelectioner = (Article) cbArt.getSelectedItem();
        String qteStr = txtQte.getText();

        if (qteStr.isEmpty() || !qteStr.matches("\\d+")) {
            JOptionPane.showMessageDialog(null, "Erreur : La quantité doit être un nombre !");
            return;
        }

        int qte = Integer.parseInt(qteStr);

        if (qte <= 0) {
            JOptionPane.showMessageDialog(null, "Erreur : La quantité doit être supérieure à 0 !");
            return;
        }

        if (qte > articleSelectioner.getStock()) {
            JOptionPane.showMessageDialog(null, "Stock insuffisant ! Disponible : " + articleSelectioner.getStock());
            return;
        }

        if (this.venteActuelle == null) {
            Client c = (Client) cbClient.getSelectedItem();
            Vendeur v = (Vendeur) cbVendeur.getSelectedItem();

            this.venteActuelle = new Vente(LocalDate.now(), c, v, magasin);

            // Verouillage de Interface
            cbClient.setEnabled(false);
            cbVendeur.setEnabled(false);
        }

        LigneVente maLigne = new LigneVente(qte, articleSelectioner, venteActuelle);
        this.venteActuelle.ajouterProduit(articleSelectioner, qte);
        panierTemporaire.add(maLigne);
        String[] ligne = new String[5];
        // String[] titres = { "ID", "Article", "Prix Unitaire", "Quantité", "Total" };

        ligne[0] = articleSelectioner.getIdArticle() + "";
        ligne[1] = articleSelectioner.getNomProduit() + "";
        ligne[2] = articleSelectioner.getPrix() + "";
        ligne[3] = qteStr;
        ligne[4] = maLigne.CalculTotalLigne() + "";

        modele.addRow(ligne);

        // modifier le total

        double somme = 0;
        for (int i = 0; i < panierTemporaire.size(); i++) {
            somme += maLigne.CalculTotalLigne();
        }

        txtTotalGeneral.setText(somme + "");
        txtQte.setText("");
    }
}
