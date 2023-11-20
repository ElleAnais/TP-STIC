const net = require('net');

const clients = {};

const server = net.createServer((socket) => {
  // Store the client information when connected
  const clientId = `${socket.remoteAddress}:${socket.remotePort}`;
  clients[clientId] = { socket, isConnected: true };
  console.log(`Client connected: ${clientId}`);

  // Event when the server receives data from the client
  socket.on('data', (data) => {
    const receivedMessage = data.toString();
    console.log(`Received from client ${clientId}: ${receivedMessage}`);

    // Check if the received message is the quit command
    if (receivedMessage.trim().toLowerCase() === 'quit') {
      console.log(`Client ${clientId} requested to quit. Closing connection.`);
      socket.end();
    } else if (receivedMessage.trim().toLowerCase() === 'connect') {
      console.log(`Client ${clientId} requested to reconnect.`);
      clients[clientId].isConnected = true;
    } else {
      // Add to the message that it was sent back by the server
      const responseMessage = `Server: your message is well received ---> ${receivedMessage} <-- (Sent back by the server)`;

      // Transmit the response only to the client who sent the message
      socket.write(responseMessage);
    }
  });

  // Event when the connection is closed
  socket.on('end', () => {
    console.log(`Client ${clientId} disconnected`);
    // Update client status when disconnected
    clients[clientId].isConnected = false;
  });
});

// Let the server listen on port 3000
server.listen(3000, () => {
  console.log('Server listening on port 3000');
});

// Function to get a list of connected clients
function getConnectedClients() {
  const connectedClients = Object.entries(clients)
    .filter(([_, client]) => client.isConnected)
    .map(([clientId, _]) => clientId);
  return connectedClients;
}

// Interval to check and display connected clients
setInterval(() => {
  const connectedClients = getConnectedClients();
  if (connectedClients.length > 0) {
    console.log('Connected clients:', connectedClients.join(', '));
  } else {
    console.log('No connected clients.');
  }
}, 5000); // Check every 5 seconds
