package com.football_field.football_field.Controllers;

import com.football_field.football_field.Entities.Wallet;
import com.football_field.football_field.Servicies.UserService;
import com.football_field.football_field.Servicies.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/wallet")
public class WalletContoller {

    @Autowired
    WalletService walletService;

    @Autowired
    UserService userService;

    @CrossOrigin
    @GetMapping("/{id}")
    public Wallet getWalletByUserId(@PathVariable Long id) {
        Long walletId = userService.getById(id).getWallet().getId();
        return walletService.getById(walletId);
    }

//    @PostMapping
//    public BigDecimal fillBalance(Long id) {
//
//    }
}
