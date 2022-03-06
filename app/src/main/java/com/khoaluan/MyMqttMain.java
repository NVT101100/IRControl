package  com.khoaluan;
import com.hivemq.client.mqtt.MqttClient;
import com.hivemq.client.mqtt.mqtt5.Mqtt5BlockingClient;

import static com.hivemq.client.mqtt.MqttGlobalPublishFilter.ALL;
import static java.nio.charset.StandardCharsets.UTF_8;

import android.os.Build;
import android.support.annotation.RequiresApi;

import java.util.UUID;

public class MyMqttMain {


        final String host = "fd3b3ad84b6246349a56fabb5dfbc4dc.s1.eu.hivemq.cloud";
        final String username = "nvt123";
        final String password = "Nvt101120";
        public String topic = "";
        Mqtt5BlockingClient client;
        @RequiresApi(api = Build.VERSION_CODES.N)
        public MyMqttMain(String topic) {
            this.topic = topic;
            try {
                this.client = MqttClient.builder()
                        .identifier(UUID.randomUUID().toString())
                        .useMqttVersion5()
                        .serverHost(host)
                        .serverPort(8883)
                        .sslWithDefaultConfig()
                        .buildBlocking();
                //connect to HiveMQ Cloud with TLS and username/pw
                this.client.connectWith()
                        .simpleAuth()
                        .username(username)
                        .password(UTF_8.encode(password))
                        .applySimpleAuth()
                        .send();

                System.out.println("Connected successfully");

                //subscribe to the topic "my/test/topic"
                this.client.subscribeWith()
                        .topicFilter(this.topic)
                        .send();
                System.out.println("Subscribeb with "+topic+" successfully");
                /*//set a callback that is called when a message is received (using the async API style)
               client.toAsync().publishes(ALL, publish -> {
                    System.out.println("Received message: " + publish.getTopic() + " -> " + UTF_8.decode(publish.getPayload().get()));

                    //disconnect the client after a message was received
                    client.disconnect();
                });*/

                /*//publish a message to the topic "my/test/topic"
                client.publishWith()
                        .topic("my/test/topic")
                        .payload(UTF_8.encode(message))
                        .send();*/
                //client.disconnect();
            } catch(Exception e) {
                System.out.print(e);
            }
        }

        public void sendMqttMessage(String message) {
            if(this.client.getState().isConnected()) {
                this.client.publishWith()
                        .topic(this.topic)
                        .payload(UTF_8.encode(message))
                        .send();
            }
            else {
                System.out.println("Client disconnected");
            }
        }
        @RequiresApi(api = Build.VERSION_CODES.N)
        public  void asyncData(){
            client.toAsync().publishes(ALL,
                    publish -> {
                        System.out.println("Received message: " + publish.getTopic() + " -> " + UTF_8.decode(publish.getPayload().get()));
                    });
        }

        public void mqttDisconnect(){
            this.client.disconnect();
            System.out.println("Client disconnected");
        }
}