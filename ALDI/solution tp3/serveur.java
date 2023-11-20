import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.*;
import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import jade.core.AID;

public class serveur extends Agent {
    Fenetre fenetre;
    Map<String, AID> clients;

    protected void setup() {
        System.out.println("Je suis l'agent : " + getLocalName());
        fenetre = new Fenetre(getLocalName());
        clients = new HashMap<>();
        addBehaviour(new ConsulterBoite());
    }

    public class Fenetre extends JFrame {
        JTextField textFieldContenuMsg;
        JComboBox<String> comboBox;
        JButton buttonEnvoyer;
        JTextArea textAreaMsgAffichage;
        JScrollPane scrollPane;

        public Fenetre(String nom) {
            setTitle("Serveur - " + nom);
            setSize(400, 300);

            textFieldContenuMsg = new JTextField("");
            textFieldContenuMsg.setPreferredSize(new Dimension(200, 20));

            comboBox = new JComboBox<>();
            comboBox.setPreferredSize(new Dimension(200, 20));

            buttonEnvoyer = new JButton("Envoyer");
            textAreaMsgAffichage = new JTextArea("Messages reçus : ");
            textAreaMsgAffichage.setEditable(false);

            scrollPane = new JScrollPane(textAreaMsgAffichage);
            scrollPane.setPreferredSize(new Dimension(350, 200));

            JPanel panel = new JPanel();
            panel.add(new JLabel("Saisir le message à envoyer"));
            panel.add(textFieldContenuMsg);
            panel.add(new JLabel("Choisir le nom du client"));
            panel.add(comboBox);
            panel.add(buttonEnvoyer);
            panel.add(scrollPane);

            buttonEnvoyer.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    envoyerMessage();
                }
            });

            add(panel);
            setVisible(true);
        }

        public void afficherMsgRecu(String msg) {
            textAreaMsgAffichage.append("\n" + msg);
        }

        public void mettreAJourListeClients(Map<String, AID> clients) {
            SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    comboBox.removeAllItems();
                    for (String client : clients.keySet()) {
                        comboBox.addItem(client);
                    }
                    // Force la mise à jour du rendu du JComboBox
                    comboBox.revalidate();
                    comboBox.repaint();
                }
            });
        }

        private void envoyerMessage() {
            String contenu = textFieldContenuMsg.getText();
            String destinataire = (String) comboBox.getSelectedItem();

            // Ajoutez la vérification si le destinataire n'est pas nul ou vide
            if (destinataire != null && !destinataire.isEmpty()) {
                ACLMessage msgEnvoi = new ACLMessage(ACLMessage.INFORM);
                msgEnvoi.setContent(contenu);
                msgEnvoi.addReceiver(clients.get(destinataire));
                send(msgEnvoi);

                System.out.println("Agent " + getLocalName() + " : j'ai envoyé '" + contenu + "' à l'agent " + destinataire);
                textFieldContenuMsg.setText(""); // Effacer le champ de saisie après l'envoi
            } else {
                System.out.println("Erreur : Nom du destinataire nul ou vide");
            }
        }
    }

    public class ConsulterBoite extends CyclicBehaviour {
        public void action() {
            ACLMessage msgRecu = receive();
            if (msgRecu != null) {
                final String contenu = msgRecu.getContent();
                final String nomEmetteur = msgRecu.getSender().getLocalName();

                if (!clients.containsKey(nomEmetteur)) {
                    clients.put(nomEmetteur, msgRecu.getSender());
                    fenetre.mettreAJourListeClients(clients);
                }

                // Utiliser SwingUtilities.invokeLater pour mettre à jour l'interface graphique depuis un thread non-EDT
                SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        fenetre.afficherMsgRecu(nomEmetteur + ": " + contenu);
                    }
                });

                System.out.println("Agent " + getLocalName() + " j'ai reçu '" + contenu +
                        "' de la part de l'agent " + nomEmetteur);
            } else {
                block(); // Bloquer le comportement s'il n'y a pas de message
            }
        }
    }
}
