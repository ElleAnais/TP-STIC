package tp1.deuxagents;

import jade.core.Agent;

public class firstagent extends Agent {
    protected void setup() {
        System.out.println("Je suis l'agent : " + this.getLocalName());//this.getLocalName()-->nom de l agent
        System.out.println("Je suis l'agent : " + this.getName());//this.getName())-->nom d l agent @ipadresse:port qui toutjours 1099
        Object[] argms = getArguments();//getArguments tejbed les arguments et Object[] argms  c la declaration du tableau ou de la liste d arguments qui est un tableau d objets donc chaque elem du tab est de type objet 
        if (argms != null) {
            System.out.println("Mes Arguments: ");
            for (int i = 0; i < argms.length; i++) {//
                System.out.println(argms[i]);//affichage des arguments
            }
        }
    }
    public static void main(String[] args) {
        String[] commande = new String[3];
        String argument="agent1:deuxagents.firstagent(ca c est la description d un agent ,en ecrivant le nom de l agent :localisation de l agent parrport le root de projet(src),si j ai la classe directement f la src je l appelle avec le nom de la classe ,sinon si je l ai dans le package ou dans les packages on fait le nom du package .package.....selon le nbr de packages imbriqués .le nom de la classe (firstagent))";
        commande[0] = "-cp";
        commande[1] = "jade.boot";
        commande[2] = argument;
        jade.Boot.main(commande);
    }
}
