const dgram = require('dgram');

const server = dgram.createSocket('udp4');

const clients = {};

server.on('message', (message, remote) => {
  const clientId = `${remote.address}:${remote.port}`;
  clients[clientId] = { address: remote.address, port: remote.port, isConnected: true };

  const receivedMessage = message.toString();
  console.log(`Received from client ${clientId}: ${receivedMessage}`);

  if (receivedMessage.trim().toLowerCase() === 'quit') {
    console.log(`Client ${clientId} requested to quit. Closing connection.`);
    delete clients[clientId];
  } else if (receivedMessage.trim().toLowerCase() === 'connect') {
    console.log(`Client ${clientId} requested to reconnect.`);
    clients[clientId].isConnected = true;
  } else {
    const responseMessage = `Server: your message is well received ---> ${receivedMessage} <-- (Sent back by the server)`;
    server.send(responseMessage, remote.port, remote.address, (err) => {
      if (err) console.error(err);
    });
  }
});

server.on('listening', () => {
  const address = server.address();
  console.log(`UDP Server listening on ${address.address}:${address.port}`);
});

server.bind(3000);
