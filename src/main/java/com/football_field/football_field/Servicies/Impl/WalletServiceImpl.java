package com.football_field.football_field.Servicies.Impl;

import com.football_field.football_field.Repositories.WalletRepository;
import com.football_field.football_field.Servicies.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WalletServiceImpl implements WalletService {

    @Autowired
    WalletRepository walletRepository;


}
