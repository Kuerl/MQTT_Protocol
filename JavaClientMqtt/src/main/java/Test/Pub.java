package Test;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

public class Pub {
    // Information about the publish server, topic and ...
    private String protocolServer = "tcp://";
    private String pubServer;
    private final String pubPort = "1883";
    private String pubTopic;
    private  final String pubId = "MonopolyGamePCPublishClient";
    private String pubMsg;
    // core
    private MqttClient pubClient;
    private MqttConnectOptions pubConnOpts;
    private MqttMessage pubMessage;
    // ??
    MemoryPersistence persistence = new MemoryPersistence();

    // constructor
    public Pub(String pubServer, String pubTopic, String pubMsg) {
        this.pubServer = pubServer;
        this.pubTopic = pubTopic;
        this.pubMsg = pubMsg;
    }

    // Function to publish the message to the topic
    public void pubCore() throws MqttException {
        // create publish client MqttClient
        pubClient = new MqttClient(protocolServer+pubServer+":"+pubPort, pubId, persistence);
        // setCleanSession??
        pubConnOpts = new MqttConnectOptions();
        pubConnOpts.setCleanSession(true);
        // put the connection Alert here!
        // connect method
        pubClient.connect(pubConnOpts);
        // put the connected Alert here!
        // Publish the message content
        pubMessage = new MqttMessage(pubMsg.getBytes());
        pubMessage.setQos(2);
        pubClient.publish(pubTopic, pubMessage);
        // disconnect the broker
        pubClient.disconnect();
        // put the disconnected Alert here!
        System.exit(0);
    }
}