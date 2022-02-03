package src.main.java;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

public class receiveMqtt {

    public static void main(String[] args) {
        // Localhost
        String broker = "tcp://192.168.178.83:1883";
        String clientId = "SUSSender";
        String topic = "test_topic";
        MemoryPersistence persistence = new MemoryPersistence();

        try {
            MqttClient sampleClient = new MqttClient(broker, clientId, persistence);
            MqttConnectOptions connOpts = new MqttConnectOptions();
            connOpts.setCleanSession(true);
            System.out.println("Connecting to broker: "+broker);
            sampleClient.connect(connOpts);
            System.out.println("Connected");


            SUSListener myListener = new SUSListener();
            // For defined String topic (15)
            sampleClient.subscribe(topic, myListener);

            // Listening to any topic: #-Filter (Multi-Layer Wildcard) -> all channels
            // sampleClient.subscribe("any_topic/#", myListener);

            // Listening to a specific topic: +-Filter (Single-Level Wildcard) -> one channel
            // sampleClient.subscribe("test_topic/+", myListener);

            while (1==1){
                try {Thread.sleep(1000);
                    System.out.println("X");}
                catch (InterruptedException e) {}
            }



        } catch (MqttException me) {
            System.out.println("reason "+me.getReasonCode());
            System.out.println("msg "+me.getMessage());
            System.out.println("loc "+me.getLocalizedMessage());
            System.out.println("cause "+me.getCause());
            System.out.println("excep "+me);
            me.printStackTrace();
        }
    }


}
