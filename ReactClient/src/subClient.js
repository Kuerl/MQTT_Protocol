const MQTT_TOPIC_HOST = 'ws://hcmiuiot.tech:1883';

import mqtt from 'mqtt/dist/mqtt';

let client = mqtt.connect(MQTT_TOPIC_HOST);

getSubscribe = (topic) => {
    client.on('connect', () => {
        client.subscribe(topic);
    })
}

getMessage = () => {
    client.on('message', (topic, message) => {
        message = message.toString();
        console.log(message);
    })
}