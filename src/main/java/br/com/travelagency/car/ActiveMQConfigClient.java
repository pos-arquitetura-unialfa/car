package br.com.travelagency.car;

import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;

@EnableJms
@Configuration
public class ActiveMQConfigClient {

    public static final String PAYMENT_RESERVE_CAR = "PagamentoReservaCarro";
    
    //@Bean
    //public MessageConverter messageConverter() {
      //  MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
        //converter.setTargetType(MessageType.TEXT);
        //converter.setTypeIdPropertyName("");
        //return converter;
    //}
}
