package tp2.FSM_Behavior;

import jade.core.Agent;
import jade.core.behaviours.FSMBehaviour;
import jade.core.behaviours.OneShotBehaviour;

public class Calculator extends Agent {

    protected void setup() {
        System.out.println("Je suis l'agent : " + getLocalName());
        FSMBehaviour ComportCalcul = new FSMBehaviour(this);
        ComportCalcul.registerFirstState(new Addition(), "Somme");
        ComportCalcul.registerState(new Multiplication(), "Produit");
        ComportCalcul.registerLastState(new Soustraction(), "Difference");
        ComportCalcul.registerDefaultTransition("Somme", "Produit");
        ComportCalcul.registerTransition("Produit", "Produit", 0);
        ComportCalcul.registerTransition("Produit", "Difference", 1);
        addBehaviour(ComportCalcul);
    }

    private class Addition extends OneShotBehaviour {
        public void action() {
            System.out.println("Agent" + getLocalName() + ": Etat Initial");
            System.out.println("Agent" + getLocalName() + ":execution de l'etat:" +
                    getBehaviourName());
            int a = (int) (Math.random() * 100);
            int b = (int) (Math.random() * 100);
            int c = a + b;
            System.out.println("Agent " + getLocalName() + " : j’ai calculé : " + a + "+" + b + "=" + c);
        }
    }

    private class Multiplication extends OneShotBehaviour {
        int c;

        public void action() {
            System.out.println("Agent" + getLocalName() + ":execution de l'etat:" +
                    getBehaviourName());
            int a = (int) (Math.random() * 100);
            int b = (int) (Math.random() * 100);
            c = a * b;
            System.out.println("Agent " + getLocalName() + " : j’ai calculé : " + a + "*" + b + "=" + c);
        }

        public int onEnd() {
            int valTransition = (int) (Math.random() * 2); //générer une valeur qui sera égale à 0
            return valTransition; // ou bien elle sera égale à 1
        }
    }

    private class Soustraction extends OneShotBehaviour {
        public void action() {
            System.out.println("Agent" + getLocalName() + ":Etat Finale");
            System.out.println("Agent" + getLocalName() + ":execution de l'etat:" + getBehaviourName());
            int a = (int) (Math.random() * 100);
            int b = (int) (Math.random() * 100);
            int c = a - b;
            System.out.println("Agent " + getLocalName() + " : j’ai calculé : " + a + "-" + b + "=" + c);
//arrêt de l’agent
            myAgent.doDelete();
        }// action
    }// Soustraction


        public static void main(String[] args) {
        String[] commande = new String[3];
        String agent1Name = "agent1";
        String agentClass = "OneshotBehavior.Calculator()"; // Specify the full class name with the package.
        String argument = agent1Name + ":" + agentClass;

        commande[0] = "-cp";
        commande[1] = "jade.boot";
        commande[2] = argument;
        jade.Boot.main(commande);
    }
}

