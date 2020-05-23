package com.football_field.football_field.Servicies.Impl;

import com.football_field.football_field.Entities.Wallet;
import com.football_field.football_field.Repositories.WalletRepository;
import com.football_field.football_field.Servicies.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WalletServiceImpl implements WalletService {

    @Autowired
    WalletRepository walletRepository;

    @Override
    public Wallet getById(Long id) {
        return walletRepository.getOne(id);
    }

    @Override
    public List<Wallet> getAll() {
        return walletRepository.findAll();
    }

    @Override
    public Wallet save(Wallet item) {
        return walletRepository.save(item);
    }
}
