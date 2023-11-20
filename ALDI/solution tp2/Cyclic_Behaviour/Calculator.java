package tp2.Cyclic_Behaviour;

import jade.core.Agent;
import jade.core.behaviours.OneShotBehaviour;

public class Calculator extends Agent {

    protected void setup() {
        System.out.println("I am the agent: " + getLocalName());
        addBehaviour(new Addition());
    }

    public class Addition extends OneShotBehaviour {
        public void action() {
            int a = (int) (Math.random() * 100);
            int b = (int) (Math.random() * 100);

            int c = a + b;
            System.out.println("Agent " + getLocalName() + ": I have calculated: " + a + " + " + b + " = " + c);
        }
    }

    public static void main(String[] args) {
        String[] commande = new String[4];
        String agent1Name = "agent1";

        // Specify the full class name with the package.
        String agentClass = "tp2.Cyclic_Behaviour.Calculator";

        commande[0] = "-gui"; // This flag launches the JADE GUI
        commande[1] = agent1Name + ":" + agentClass;
        commande[2] = "-agents";
        commande[3] = commande[1];

        jade.Boot.main(commande);
    }
}
