package jms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class EmailListener {
    @Autowired
    ConfigurableApplicationContext context;
    //Receiver
    @JmsListener(destination="email", containerFactory = "myJmsContainerFactory")
    public void receiveMessage(String message){
        System.out.println("Received <"+ message + ">");
    }
}

