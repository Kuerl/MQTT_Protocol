package Test;

import org.eclipse.paho.client.mqttv3.IMqttToken;
import org.eclipse.paho.client.mqttv3.MqttAsyncClient;
import org.eclipse.paho.client.mqttv3.MqttException;

import java.util.UUID;

public class Sub {

    // Information about the subscribe server, topic and ...
    private String protocolServer = "tcp://";
    private String subServer;
    private final String subPort = "1883";
    private String subTopic;
    private MqttAsyncClient subClient;
    private CallBack subCallBack;

    // constructor
    public Sub(String subServer, String subTopic) {
        this.subServer = subServer;
        this.subTopic = subTopic;
    }

    public void subCore() throws MqttException {
        // create AsyncClient, tcp protocol, subServer: localhost for this project, final subPort: 1883
        subClient = new MqttAsyncClient(protocolServer+subServer+":"+subPort, UUID.randomUUID().toString());
        // CallBack to use messageArrived
        subCallBack = new CallBack();
        // .setCallback
        subClient.setCallback(subCallBack);
        // IMqttToken
        IMqttToken subToken = subClient.connect();
        subToken.waitForCompletion();
        // subscribe topic and use QoS: 0
        subClient.subscribe(subTopic, 0);
    }

}
