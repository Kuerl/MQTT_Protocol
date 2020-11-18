package Test;

import org.eclipse.paho.client.mqttv3.IMqttToken;
import org.eclipse.paho.client.mqttv3.MqttAsyncClient;
import org.eclipse.paho.client.mqttv3.MqttException;

import java.util.UUID;

public class App {
    private static MqttAsyncClient myClient;

    public static void main(String[] args) throws MqttException {
        myClient = new MqttAsyncClient("tcp://localhost:1883", UUID.randomUUID().toString());
        CallBack myCallBack = new CallBack();
        myClient.setCallback(myCallBack);

        IMqttToken token = myClient.connect();
        token.waitForCompletion();

        myClient.subscribe("K/Topic", 0);
    }
}
