package cl.hospital.apiproducersummary.service;


import cl.hospital.apiproducersummary.model.VitalSigns;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProducerAlertResumenService {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendMessage(VitalSigns vitalSigns){
        rabbitTemplate.convertAndSend("summaryQueue",vitalSigns);
    }

}
