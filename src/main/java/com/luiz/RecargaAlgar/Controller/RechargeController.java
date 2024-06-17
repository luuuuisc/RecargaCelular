package com.luiz.RecargaAlgar.Controller;

import com.luiz.RecargaAlgar.Entity.Recharge;
import com.luiz.RecargaAlgar.Service.RechargeService;
import com.luiz.RecargaAlgar.dto.RechargeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/recharge")
public class RechargeController {
    @Autowired
    private RechargeService rechargeService;

    @PostMapping
    public Recharge rechargePhone(@RequestBody RechargeDTO rechargeDTO) throws Exception {
        return rechargeService.processRecharge(rechargeDTO);
    }
}

