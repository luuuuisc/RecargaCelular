package com.luiz.RecargaAlgar.Service;

import com.luiz.RecargaAlgar.Entity.Client;
import com.luiz.RecargaAlgar.Entity.Recharge;
import com.luiz.RecargaAlgar.Exception.ClientNotFoundException;
import com.luiz.RecargaAlgar.Exception.InvalidRechargeAmountException;
import com.luiz.RecargaAlgar.RabbitMQConfig.RabbitMQConfig;
import com.luiz.RecargaAlgar.Repository.ClientRepository;
import com.luiz.RecargaAlgar.Repository.RechargeRepository;
import com.luiz.RecargaAlgar.dto.RechargeDTO;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class RechargeService {
    @Autowired
    private RechargeRepository rechargeRepository;

    @Autowired
    private ClientRepository clientRepository;  // Suponha que isso já esteja definido

    private RabbitTemplate rabbitTemplate;

    public void sendRechargeRequest(RechargeDTO recharge) {
        rabbitTemplate.convertAndSend(RabbitMQConfig.EXCHANGE, RabbitMQConfig.ROUTING_KEY, recharge);
        System.out.println("Recharge request sent to the queue.");
    }

    @Transactional
    public Recharge processRecharge(RechargeDTO rechargeDTO) throws InvalidRechargeAmountException, ClientNotFoundException {
        // Validar a recarga
        if (rechargeDTO.getAmount() <= 0) {
            throw new InvalidRechargeAmountException("Invalid recharge amount");
        }

        // Encontrar cliente baseado no número do telefone
        Client client = clientRepository.findByPhoneNumber(rechargeDTO.getPhoneNumber());
        if (client == null) {
            throw new ClientNotFoundException("Client not found with phone number: " + rechargeDTO.getPhoneNumber());
        }

        // Converter DTO para Entidade
        Recharge recharge = new Recharge();
        recharge.setAmount(rechargeDTO.getAmount());
        recharge.setPhoneNumber(rechargeDTO.getPhoneNumber());
        recharge.setStatus("PENDING");
        rechargeRepository.save(recharge);

        // Atualizar saldo do cliente, se necessário
        updateClientBalance(client, rechargeDTO.getAmount());

        // Log de sucesso
        System.out.println("Recharge processed successfully for: " + recharge.getPhoneNumber());

        return recharge;
    }

    private void updateClientBalance(Client client, double amount) {
        client.setBalance(client.getBalance() + amount);
        clientRepository.save(client);
    }
}


