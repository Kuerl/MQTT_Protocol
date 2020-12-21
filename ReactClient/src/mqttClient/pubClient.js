import host from '../Constants';
import mqtt from 'mqtt/dist/mqtt';

let client = mqtt.connect(host); // Remove? if the subClient doesn's need to close the connection to the server

console.log('connected to: ' + host);

function pubCore(topic, message) {  // Add Id? Here is player name
    client.publish(topic, message); // The message must be defined already by ../Constants/index.js file to send to the Java Game client.
}

export {pubCore};