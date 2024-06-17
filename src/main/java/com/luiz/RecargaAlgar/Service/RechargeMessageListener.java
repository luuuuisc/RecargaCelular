package com.luiz.RecargaAlgar.Service;

import com.luiz.RecargaAlgar.RabbitMQConfig.RabbitMQConfig;
import com.luiz.RecargaAlgar.dto.RechargeDTO;
import jakarta.transaction.Transactional;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RechargeMessageListener {

    @Autowired
    private RechargeService rechargeService;

    @RabbitListener(queues = RabbitMQConfig.QUEUE)
    @Transactional
    public void receiveMessage(RechargeDTO recharge) {
        System.out.println("Received recharge request for: " + recharge.getPhoneNumber());

        // Validação do valor da Recarga
        if (recharge.getAmount() <= 0) {
            System.out.println("Invalid recharge amount");
            return;
        }

        // Validação do número do telefone
        String phoneNumber = recharge.getPhoneNumber().replaceAll("\\s+", ""); // Remove espaços
        if (!phoneNumber.matches("\\(\\d{2}\\)9\\d{8}")) {
            System.out.println("Invalid phone number format");
            return;
        }

        try {
            // Processa a recarga
            rechargeService.processRecharge(recharge);
            System.out.println("Recharge processed successfully");
        } catch (Exception e) {
            System.out.println("Error processing recharge: " + e.getMessage());
        }
    }
}

