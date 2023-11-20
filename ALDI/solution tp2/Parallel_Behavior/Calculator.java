package tp2.Parallel_Behavior;

import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import jade.core.behaviours.OneShotBehaviour;
import jade.core.behaviours.ParallelBehaviour;

public class Calculator extends Agent {

    private static final long serialVersionUID = 1L;

    protected void setup(){
        System.out.println("je suis l'agent:"+getLocalName());
        addBehaviour(new Addition());
    }//setup
    public class Addition extends OneShotBehaviour {
        /**
         *
         */
        private static final long serialVersionUID = 1L;

        public void action(){
            int a =(int)(Math.random()*100);
            int b =(int)(Math.random()*100);

            int c = a+b;
            System.out.println("Agent"+getLocalName()+":j\'ai calculé : "+a+"+"+b+"="+c);

        }
//        public boolean done(){
//            return c==100;
//        }
    }public class Calculateur extends Agent {
        protected void setup() {
            System.out.println("Je suis l'agent : " + getLocalName());
            ParallelBehaviour ComportParallel = new
                    ParallelBehaviour(ParallelBehaviour.WHEN_ANY);
            ComportParallel.addSubBehaviour(new Addition());
            ComportParallel.addSubBehaviour(new Soustraction());
            ComportParallel.addSubBehaviour(new Produit());
            addBehaviour(ComportParallel);
        }

        public class Addition extends Behaviour {
            public void action() {
                int c;
                System.out.println("le 1er sous-comportement");
                int a = (int) (Math.random() * 100);
                int b = (int) (Math.random() * 100);
                c = a + b;
                System.out.println("Je suis l'agent " + getLocalName() + ": j’ai calculé :" + a + "+" + b + "=" + c);
            } //action

            public boolean done() {
                int c = 0;
                return c == 100;
            } //done
        }//addition


        public class Soustraction extends Behaviour {
            int c;

            public void action() {
                System.out.println("le 2ième sous-comportement");
                int a = (int) (Math.random() * 100);
                int b = (int) (Math.random() * 100);
                c = a - b;
                System.out.println("Je suis l'agent " + getLocalName() + ": j’ai calculé :" + a + "-" + b + "=" + c);
            } //action

            public boolean done() {
                return c < 0;
            }//done
        }//soustraction

        public class Produit extends OneShotBehaviour {
            public void action() {
                System.out.println("le 3ième sous-comportement");
                int a = (int) (Math.random() * 100);
                int b = (int) (Math.random() * 100);
                int c = a * b;
                System.out.println("Je suis l'agent " + getLocalName() + ": j’ai calculé :" + a + "*" + b + "=" + c);
            } // action
        }// class Produit
    }

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

