package tp2.Ticker_Behavior;

import jade.core.Agent;
import jade.core.behaviours.TickerBehaviour;

public class Calculator extends Agent {

     protected void setup() {
     System.out.println("Je suis l'agent : "+getLocalName());
     addBehaviour(new Addition(this,5000));
     } //setup
     private class Addition extends TickerBehaviour {
     public Addition(Agent a, int durée){
     super(a, durée);
     }
    protected void onTick() {
        int a = (int) (Math.random() * 100);
        int b = (int) (Math.random() * 100);
        int c = a + b;
        System.out.println("Je suis l'agent " + getLocalName() + ":j’ai calculé:" + a + "+" + b + "=" + c);
    }
}// class Addition

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

