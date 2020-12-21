import host from '../Constants';
import mqtt from 'mqtt/dist/mqtt';

let client = mqtt.connect(host);

console.log('connected to: ' + host);

function getSubscribe(topic) {
    client.on('connect', () => {
        client.subscribe(topic);
    })
}

function getMessage(topic) {
    client.on('message', (topic, message) => {
        message = message.toString();
        console.log(`topic: ${topic}, message: ${message}`);

        // Handle message fucntion: Callback?

        // Close connection fucntion?
    })
}

export {getSubscribe};

export {getMessage};