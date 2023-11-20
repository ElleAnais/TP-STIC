public class test {
    public static void main(String[] args) {
        String[] commande = new String[3];
        String argument = "";

        argument = argument + "serveur:serveur"; // 1er agent
        argument = argument + ";client1:client(serveur)"; // 2e agent
        argument = argument + ";client2:client(serveur)"; // 3e agent
        argument = argument + ";client3:client(serveur)"; // 4e agent

        commande[0] = "-cp";
        commande[1] = "jade.boot";
        commande[2] = argument;

        jade.Boot.main(commande);
    }
}
