# Networking Lab: Basic Client-Server Usage

This lab provides two JavaScript files that demonstrate basic client-server communication using the Node.js `net` module. The lab aims to familiarize you with fundamental networking concepts and the interaction between clients and servers.

## 1. server.js

### Overview:

The `server.js` file contains the server-side code demonstrating a simple server setup. It listens on port 3000 and handles incoming connections from clients. The server stores information about connected clients and processes messages received from them. It also periodically checks for connected clients and displays their status.

### Instructions:

1. Run the server using Node.js: `node server.js`
2. The server listens on port 3000.
3. Connected clients can send and receive messages.

## 2. client.js

### Overview:

The `client.js` file contains the client-side code demonstrating a basic client setup. It connects to the server, reads user input from the console, and facilitates communication with the server. The client allows users to send messages, disconnect from the server, or attempt to reconnect.

### Instructions:

1. Run the client using Node.js: `node client.js`
2. Type messages in the console to send them to the server.
3. Type "quit" to disconnect from the server.
4. Type "connect" to attempt to reconnect to the server.

## Contributors:

- [DADDIOUAMER Redouane](mailto:redouane.daddiouamer@univ-constantine2.dz)
- [BAKTACHE Kaouther](mailto:kaouther.baktache@univ-constantine2.dz)
- [Anaïs Morjaine Belakehal](mailto:anais.belakehal1@univ-constantine2.dz)

## traduction fr

# Laboratoire de réseau : Utilisation basique d'un client-serveur

Ce laboratoire fournit deux fichiers JavaScript qui illustrent la communication basique entre un client et un serveur en utilisant le module Node.js `net`. L'objectif du laboratoire est de vous familiariser avec les concepts fondamentaux de réseau et l'interaction entre les clients et les serveurs.

## 1. server.js

### Aperçu :

Le fichier `server.js` contient le code côté serveur illustrant une configuration simple d'un serveur. Il écoute sur le port 3000 et gère les connexions entrantes des clients. Le serveur stocke des informations sur les clients connectés et traite les messages reçus. Il vérifie également périodiquement les clients connectés et affiche leur état.

### Instructions :

1. Exécutez le serveur avec Node.js : `node server.js`
2. Le serveur écoute sur le port 3000.
3. Les clients connectés peuvent envoyer et recevoir des messages.

## 2. client.js

### Aperçu :

Le fichier `client.js` contient le code côté client illustrant une configuration de base d'un client. Il se connecte au serveur, lit les entrées utilisateur depuis la console et facilite la communication avec le serveur. Le client permet aux utilisateurs d'envoyer des messages, de se déconnecter du serveur ou de tenter une reconnexion.

### Instructions :

1. Exécutez le client avec Node.js : `node client.js`
2. Tapez des messages dans la console pour les envoyer au serveur.
3. Tapez "quit" pour vous déconnecter du serveur.
4. Tapez "connect" pour tenter de vous reconnecter au serveur.

## Contributeurs :

- [DADDIOUAMER Redouane](mailto:redouane.daddiouamer@univ-constantine2.dz)
- [BAKTACHE Kaouther](mailto:kaouther.baktache@univ-constantine2.dz)
- [Anaïs Morjaine Belakehal](mailto:anais.belakehal1@univ-constantine2.dz)
