package br.com.travelagency.car;

import static br.com.travelagency.car.ActiveMQConfigClient.PAYMENT_RESERVE_CAR;

import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;

import br.com.travelagency.car.dto.CarFilterDTOActive;
import br.com.travelagency.car.service.ReserveServiceImpl;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@Configuration
public class ConfigConsumer   {
	
	@Autowired
	private ReserveServiceImpl reserveService;
	
	@JmsListener(destination = PAYMENT_RESERVE_CAR)
    public void receiveMessage(@Payload String payladPaymentCar) {
				
        if(!payladPaymentCar.equals(null)) {
        	try {
        		
        		Gson convert = new Gson();
        		
        		payladPaymentCar = payladPaymentCar.replace("[", "");
        		
        		payladPaymentCar = payladPaymentCar.replace("]", "");
        		
        		System.out.println(payladPaymentCar);
        		
        		CarFilterDTOActive objectConverted = convert.fromJson(payladPaymentCar, CarFilterDTOActive.class);
        		
        		System.out.println(objectConverted);
        		
        		reserveService.updateServiceStatus(objectConverted.getId());
        		
        		System.out.println(payladPaymentCar);
			} catch (Exception e) {
				log.error("Erro ao processar..", e);
			}
        }else {
        	
        	log.info("nada encontrado");
        }
    }
}
