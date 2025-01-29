package cl.hospital.apiproducersummary.service;

import cl.hospital.apiproducersummary.model.Summary;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class SummaryService {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Scheduled(fixedRate = 300000)
    public void sendSummary() {
        Summary summary = new Summary("Resumen periódico de signos vitales.", LocalDateTime.now().toString());
        System.out.println("Registrando signos vitales" + summary);
        rabbitTemplate.convertAndSend("summaryQueue", summary);
    }

}
