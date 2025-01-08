package ie.atu.yr4project_2;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQListener {
    @RabbitListener(queues = "userQueues")
    public void TaskListener(User user){
        System.out.println(("Received message from User Service: " + user));
    }
}
