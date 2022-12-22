package jms;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import java.time.LocalDateTime;

@Component
public class SendScheduledEmail {
	private static Logger logger = LogManager.getLogger(SendScheduledEmail.class);
	@Autowired
	ConfigurableApplicationContext context;
	@Bean
	public int getCronValue()
	{
		return LocalDateTime.now().getSecond();
	}
	//Sender
	@Scheduled(cron="#{@getCronValue} * * * * *")
	public void sendEmail() {
		logger.info("creating email messages");
		//sending a message
		MessageCreator messageCreator = new MessageCreator() {
			@Override
			public Message createMessage(Session session) throws JMSException {
				return session.createTextMessage(String.format("email message"));

			}
		};
		JmsTemplate jmsTemplate = context.getBean(JmsTemplate.class);
		logger.info("sending a new message...");
		jmsTemplate.send("email", messageCreator);
		System.out.println("Message sent");
		logger.info("message sent...");
	}
}