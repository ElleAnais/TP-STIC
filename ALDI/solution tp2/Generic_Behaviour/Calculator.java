package tp2.Generic_Behaviour;

import jade.core.Agent;
import jade.core.behaviours.Behaviour;

public class Calculator extends Agent {
    protected void setup() {
        System.out.println("Je suis l'agent : "+getLocalName());
        addBehaviour(new Addition());
    } //setup
    public class Addition extends Behaviour {
        public void action() {
            int a = (int) (Math.random() * 100);
            int b = (int) (Math.random() * 100);
            int c = a + b;
            System.out.println("Agent " + getLocalName() + " : j’ai calculé : " + a + "+" + b + "=" + c);
        }
        public boolean done(){
            int c=0 ;
            return c == 100;
        } //done
    } // class Addition


    public static void main(String[] args) {
        String[] commande = new String[3];
        String agent1Name = "agent1";
        String agentClass = "tp2.Generic_Behaviour.Calculator()"; // Specify the full class name with the package.
        String argument = agent1Name + ":" + agentClass;

        commande[0] = "-cp";
        commande[1] = "jade.boot";
        commande[2] = argument;
        jade.Boot.main(commande);
    }
}
