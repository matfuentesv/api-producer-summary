package cl.hospital.apiproducersummary.controller;


import cl.hospital.apiproducersummary.model.VitalSigns;
import cl.hospital.apiproducersummary.service.ProducerAlertResumenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class ProducerAlertResumenController {

    @Autowired
    private ProducerAlertResumenService producerAlertService;



    @PostMapping("/send")
    public ResponseEntity<String> sendVitalSigns(@RequestBody VitalSigns vitalSigns) {
            producerAlertService.sendMessage(vitalSigns);
            return ResponseEntity.ok("Alerta enviada a RabbitMQ.");
    }

}
