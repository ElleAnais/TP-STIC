const net = require('net');

const server = net.createServer((socket) => {
  console.log('Client connecté');

  // Événement lorsque le serveur reçoit des données du client
  socket.on('data', (data) => {
    const receivedMessage = data.toString();
    console.log(`Reçu du client : ${receivedMessage}`);

    // Vérifier si le message reçu est la commande "quit"
    if (receivedMessage.trim().toLowerCase() === 'quit') {
      console.log('Le client a demandé à quitter. Fermeture de la connexion.');
      socket.end();
    } else {
      // Ajouter au message qu'il a été renvoyé par le serveur
      const responseMessage = `Serveur : votre message est bien reçu ---> ${receivedMessage} <-- (Renvoyé par le serveur)`;

      // Transmettre la réponse uniquement au client qui a envoyé le message
      socket.write(responseMessage);
    }
  });

  // Événement lorsque la connexion est fermée
  socket.on('end', () => {
    console.log('Client déconnecté');
  });
});

// Laissez le serveur écouter sur le port 3000
server.listen(3000, () => {
  console.log('Serveur à l\'écoute sur le port 3000');
});