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
        // IMqttToken
        IMqttToken subToken = subClient.connect();
        subToken.waitForCompletion(1000);
        // subscribe topic and use QoS: 0
        subClient.subscribe(subTopic, 0);
    }

    class CallBack implements MqttCallback {

        @Override
        public void connectionLost(Throwable throwable) {

        }

        @Override
        public void messageArrived(String s, MqttMessage mqttMessage) throws Exception {
            System.out.println(s+"\t"+mqttMessage);
            System.exit(0);
        }

        @Override
        public void deliveryComplete(IMqttDeliveryToken iMqttDeliveryToken) {

        }
    }
}
