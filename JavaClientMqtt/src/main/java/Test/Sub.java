package Test;

import org.eclipse.paho.client.mqttv3.*;

import java.util.UUID;

public class Sub {

    // Information about the subscribe server, topic and ...
    private String protocolServer = "tcp://";
    private String subServer;
    private final String subPort = "1883";
    private String subTopic;
    private MqttAsyncClient subClient;
    private CallBack subCallBack;

    // Output Msg to modify
    protected String modifyMsg;

    // constructor
    public Sub(String subServer, String subTopic) {
        this.subServer = subServer;
        this.subTopic = subTopic;
    }

    public String getModifyMsg() {
        return modifyMsg;
    }

    public void setModifyMsg(String modifyMsg) {
        this.modifyMsg = modifyMsg;
    }

    public void subCore() throws MqttException {
        // create AsyncClient, tcp protocol, subServer: localhost for this project, final subPort: 1883
        subClient = new MqttAsyncClient(protocolServer+subServer+":"+subPort, UUID.randomUUID().toString());
        // CallBack to use messageArrived
        subCallBack = new CallBack();
        // .setCallback
        subClient.setCallback(subCallBack);
        // put the connection Alert here!
        System.out.println("Create the connection");
        // IMqttToken
        IMqttToken subToken = subClient.connect();
        // put the connected Alert here!
        System.out.println("Connected to the broker");
        subToken.waitForCompletion();
        // subscribe topic and use QoS: 0
        subClient.subscribe(subTopic, 0);
    }

    class CallBack implements MqttCallback {

        @Override
        public void connectionLost(Throwable throwable) {

        }

        @Override
        public void messageArrived(String subTopic, MqttMessage mqttMessage) throws Exception {
            // put the published Alert here!
            System.out.println("Received message, subTopic: "+subTopic);
            System.out.println(subTopic+"\t"+mqttMessage);
            // put the exit Alert!
            System.out.println("Exit the Sub function");
            System.exit(0);
        }

        @Override
        public void deliveryComplete(IMqttDeliveryToken iMqttDeliveryToken) {

        }
    }
}
