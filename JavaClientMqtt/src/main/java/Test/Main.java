package Test;

import org.eclipse.paho.client.mqttv3.MqttException;

public class Main {
    public static void main(String[] args) throws MqttException {
        Sub testSubClient = new Sub("hcmiuiot.tech", "test");
        testSubClient.subCore();
    }
}
