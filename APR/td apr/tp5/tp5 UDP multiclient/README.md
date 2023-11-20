# Networking Lab: Basic UDP Client-Server Usage

This lab provides two JavaScript files that demonstrate basic client-server communication using the Node.js `dgram` module for UDP (User Datagram Protocol). The lab aims to familiarize you with fundamental networking concepts and the interaction between clients and servers using the connectionless nature of UDP.

## 1. udp_server.js

### Overview:

The `udp_server.js` file contains the server-side code demonstrating a simple UDP server setup. It binds to port 3000 and handles incoming messages from clients. The server stores information about connected clients and processes messages received from them. It also periodically checks for connected clients and displays their status.

### Instructions:

1. Run the server using Node.js: `node udp_server.js`
2. The server binds to port 3000.
3. Connected clients can send and receive messages.

## 2. udp_client.js

### Overview:

The `udp_client.js` file contains the client-side code demonstrating a basic UDP client setup. It sends messages to the server, reads user input from the console, and facilitates communication with the server. The client allows users to send messages, disconnect from the server, or attempt to reconnect.

### Instructions:

1. Run the client using Node.js: `node udp_client.js`
2. Type messages in the console to send them to the server.
3. Type "quit" to disconnect from the server.
4. Type "connect" to attempt to reconnect to the server.

## Contributors:

- [DADDIOUAMER Redouane](mailto:redouane.daddiouamer@univ-constantine2.dz)
- [BAKTACHE Kaouther](mailto:kaouther.baktache@univ-constantine2.dz)
- [Anaïs Morjaine Belakehal](mailto:anais.belakehal1@univ-constantine2.dz)

## traduction fr:

# Laboratoire de réseau : Utilisation basique d'un client-serveur UDP

Ce laboratoire propose deux fichiers JavaScript qui illustrent la communication basique entre un client et un serveur en utilisant le module Node.js `dgram` pour l'UDP (User Datagram Protocol). L'objectif du laboratoire est de vous familiariser avec les concepts fondamentaux de réseau et l'interaction entre les clients et les serveurs en exploitant la nature sans connexion de l'UDP.

## 1. udp_server.js

### Aperçu :

Le fichier `udp_server.js` contient le code côté serveur illustrant une configuration simple d'un serveur UDP. Il se lie au port 3000 et gère les messages entrants des clients. Le serveur stocke des informations sur les clients connectés et traite les messages reçus. Il vérifie également périodiquement les clients connectés et affiche leur état.

### Instructions :

1. Exécutez le serveur avec Node.js : `node udp_server.js`
2. Le serveur se lie au port 3000.
3. Les clients connectés peuvent envoyer et recevoir des messages.

## 2. udp_client.js

### Aperçu :

Le fichier `udp_client.js` contient le code côté client illustrant une configuration de base d'un client UDP. Il envoie des messages au serveur, lit les entrées utilisateur depuis la console et facilite la communication avec le serveur. Le client permet aux utilisateurs d'envoyer des messages, de se déconnecter du serveur ou de tenter une reconnexion.

### Instructions :

1. Exécutez le client avec Node.js : `node udp_client.js`
2. Tapez des messages dans la console pour les envoyer au serveur.
3. Tapez "quit" pour vous déconnecter du serveur.
4. Tapez "connect" pour tenter de vous reconnecter au serveur.

## Contributeurs :

- [DADDIOUAMER Redouane](mailto:redouane.daddiouamer@univ-constantine2.dz)
- [BAKTACHE Kaouther](mailto:kaouther.baktache@univ-constantine2.dz)
- [Anaïs Morjaine Belakehal](mailto:anais.belakehal1@univ-constantine2.dz)
