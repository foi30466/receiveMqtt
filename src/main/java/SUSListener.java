package src.main.java;

import org.eclipse.paho.client.mqttv3.*;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

public class SUSListener implements IMqttMessageListener {
    public void messageArrived(String arg0, MqttMessage arg1) throws Exception {
        System.out.println("Kanal:" + arg0);
        System.out.println("Nachricht:" + arg1.toString());
    }
}
