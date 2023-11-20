const dgram = require('dgram');

const client = dgram.createSocket('udp4');
const serverPort = 3000;

process.stdin.setEncoding('utf-8');
console.log('Type a message and press Enter to send it to the server (type "quit" to disconnect, "connect" to reconnect):');

process.stdin.on('data', (input) => {
  const message = input.trim();
  const serverAddress = '127.0.0.1'; // Change this to the actual server address

  client.send(message, serverPort, serverAddress, (err) => {
    if (err) console.error(err);
  });

  if (message.toLowerCase() === 'quit') {
    console.log('Disconnected from server');
    client.close();
  } else if (message.toLowerCase() === 'connect') {
    console.log('Attempting to reconnect...');
  } else {
    console.log('Type another message and press Enter (type "quit" to disconnect, "connect" to reconnect):');
  }
});

client.on('message', (message, remote) => {
  const receivedMessage = message.toString();
  console.log(`Received from server: ${receivedMessage}`);
});

client.on('close', () => {
  console.log('Disconnected from server');
});
