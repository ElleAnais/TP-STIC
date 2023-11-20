const net = require('net');

// Function to create a new instance of the client
function createClient() {
  const client = net.createConnection({ port: 3000 }, () => {
    console.log('Connected to server');

    // Read user input from the console and send it to the server
    process.stdin.setEncoding('utf-8');
    console.log('Type a message and press Enter to send it to the server (type "quit" to disconnect, "connect" to reconnect):');

    process.stdin.on('data', (input) => {
      // Send the user input to the server
      client.write(input.trim());

      // Check if the user wants to quit
      if (input.trim().toLowerCase() === 'quit') {
        console.log('Disconnected from server');
        // Close the connection gracefully
        client.end();
      } else if (input.trim().toLowerCase() === 'connect') {
        console.log('Attempting to reconnect...');
        // Create a new client instance for reconnection
        createClient();
      } else {
        // Prompt the user for the next message
        console.log('Type another message and press Enter (type "quit" to disconnect, "connect" to reconnect):');
      }
    });
  });

  // Event when the client receives data from the server
  client.on('data', (data) => {
    const receivedMessage = data.toString();
    console.log(`Received from server: ${receivedMessage}`);
  });

  // Event when the connection is closed
  client.on('end', () => {
    console.log('Disconnected from server');
  });
}

// Create the initial client instance
createClient();
