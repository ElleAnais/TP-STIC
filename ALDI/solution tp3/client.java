import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import jade.core.Agent;
import jade.core.AID;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;

public class client extends Agent {

    Fenetre fenetre;
    String nomServeur;

    protected void setup() {
        System.out.println("Je suis l'agent : " + getLocalName());

        // Récupérer la liste des arguments
        Object[] args = getArguments();

        if (args != null && args.length > 0) {
            nomServeur = args[0].toString();
            fenetre = new Fenetre(getLocalName());
            addBehaviour(new ConsulterBoite());
        }
    }

    public class Fenetre extends JFrame {
        JLabel label;
        JTextField textFieldContenuMsg;
        JButton buttonEnvoyer;
        JTextArea textAreaMsgAffichage;
        JScrollPane scrollPane;

        public Fenetre(String nom) {
            setTitle("Client - " + nom);
            setSize(400, 300);

            label = new JLabel("Saisir le message à envoyer");
            textFieldContenuMsg = new JTextField("");
            textFieldContenuMsg.setPreferredSize(new Dimension(200, 20));

            buttonEnvoyer = new JButton("Envoyer");
            textAreaMsgAffichage = new JTextArea("Messages reçus : ");
            textAreaMsgAffichage.setEditable(false);

            scrollPane = new JScrollPane(textAreaMsgAffichage);
            scrollPane.setPreferredSize(new Dimension(350, 200));

            JPanel panel = new JPanel();
            panel.add(label);
            panel.add(textFieldContenuMsg);
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

        private void envoyerMessage() {
            String contenu = textFieldContenuMsg.getText();

            ACLMessage msgEnvoi = new ACLMessage(ACLMessage.INFORM);
            msgEnvoi.setContent(contenu);
            msgEnvoi.addReceiver(new AID(nomServeur, AID.ISLOCALNAME));
            send(msgEnvoi);

            System.out.println("Agent " + getLocalName() + " : j'ai envoyé '" + contenu + "' à l'agent " + nomServeur);
            textFieldContenuMsg.setText(""); // Effacer le champ de saisie après l'envoi
        }
    }

    public class ConsulterBoite extends CyclicBehaviour {
        public void action() {
            ACLMessage msgRecu = receive();
            if (msgRecu != null) {
                final String contenu = msgRecu.getContent();
                final String nomEmetteur = msgRecu.getSender().getLocalName();

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
