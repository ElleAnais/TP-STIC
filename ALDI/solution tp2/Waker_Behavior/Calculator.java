import jade.core.Agent;
import jade.core.behaviours.WakerBehaviour;

public class Calculator extends Agent {
    public void setup() {
        System.out.println("Agent : "+getLocalName());
        addBehaviour(new Addition(this,5000));
    }//setup
    private class Addition extends WakerBehaviour {
        int a, b, c;
        public Addition(Agent a, int durée) {
            super(a, durée);
        }
        protected void onWake () {

            a = (int)(Math.random() * 100);
            b = (int)(Math.random() * 100);
            c = a + b;
            System.out.println("Agent "+getLocalName()+": j’ai calculé :"+a+"+"+b+"="+c);
        } // onWake
    } // class Addition



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
