package Magasin.Controleur.AjoutVente;

import Magasin.Model.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.time.LocalDate;
import java.util.Vector;

public class ControleurValiderVente implements ActionListener {
    Magasin magasin;
    JComboBox<Client> cbClient;
    JComboBox<Vendeur> cbVendeur;
    DefaultTableModel modele;
    JFrame fenetre;

    public ControleurValiderVente(Magasin m, JComboBox<Client> comboxClient, JComboBox<Vendeur> comboxVendeur,
            DefaultTableModel mod, JFrame f) {
        this.magasin = m;
        this.cbClient = comboxClient;
        this.cbVendeur = comboxVendeur;
        this.modele = mod;
        this.fenetre = f;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (modele.getRowCount() == 0) {
            JOptionPane.showMessageDialog(fenetre, "Erreur : Le tableau est vide !");
            return;
        }

        int choix = JOptionPane.showConfirmDialog(fenetre,
                "Valider vous la commande?",
                "Confirmation",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.WARNING_MESSAGE);

        if (choix == JOptionPane.YES_OPTION) {

            LocalDate dateSaisie = LocalDate.now();

            // Client + vente
            Client leClient = (Client) cbClient.getSelectedItem();
            Vendeur leVendeur = (Vendeur) cbVendeur.getSelectedItem();

            Vente nouvelleVente = new Vente(dateSaisie, leClient, leVendeur, magasin);

            for (int i = 0; i < modele.getRowCount(); i++) {

                String selArt = (String) modele.getValueAt(i, 0);
                int idArt = Integer.parseInt(selArt.split(" - ")[0]);
                Vector<Article> resultats = magasin.rechercherArticle((idArt + ""), "ID");

                if (!resultats.isEmpty()) {
                    Article lArt = resultats.get(0); // Recup 1er elm
                    int qte = Integer.parseInt(modele.getValueAt(i, 3).toString());

                    nouvelleVente.ajouterProduit(lArt, qte);
                }
            }

            nouvelleVente.validerVente();

            JOptionPane.showMessageDialog(fenetre, "Vente enregistrée avec succès !");
            fenetre.dispose();
        }
    }
}