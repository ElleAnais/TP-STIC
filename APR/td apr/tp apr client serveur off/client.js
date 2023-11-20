const net = require('net');

// Créer une instance du client
const client = net.createConnection({ port: 3000 }, () => {
  console.log('Connecté au serveur');

  // Lire l'entrée de l'utilisateur depuis la console et l'envoyer au serveur
  process.stdin.setEncoding('utf-8');
  console.log('Tapez un message et appuyez sur Entrée pour l\'envoyer au serveur (tapez "quit" pour déconnecter) :');

  process.stdin.on('data', (input) => {
    // Envoyer l'entrée de l'utilisateur au serveur
    client.write(input.trim());

    // Vérifier si l'utilisateur veut quitter
    if (input.trim().toLowerCase() === 'quit') {
      console.log('Déconnecté du serveur');
      // Fermer la connexion de manière élégante
      client.end();
    } else {
      // Demander à l'utilisateur le prochain message
      console.log('Tapez un autre message et appuyez sur Entrée (tapez "quit" pour déconnecter) :');
    }
  });
});

// Événement lorsque le client reçoit des données du serveur
client.on('data', (data) => {
  const receivedMessage = data.toString();
  console.log(`Reçu du serveur : ${receivedMessage}`);
});

// Événement lorsque la connexion est fermée
client.on('end', () => {
  console.log('Déconnecté du serveur');
});