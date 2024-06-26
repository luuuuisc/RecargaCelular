package com.luiz.RecargaAlgar.Repository;

import com.luiz.RecargaAlgar.Entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
    Client findByPhoneNumber(String phoneNumber);
}
