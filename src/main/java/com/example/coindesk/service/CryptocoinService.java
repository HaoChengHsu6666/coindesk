package com.example.coindesk.service;

import com.example.coindesk.entity.Cryptocoin;
import org.springframework.stereotype.Service;

@Service
public interface CryptocoinService {

    Cryptocoin getCoinById(Integer id);

    Cryptocoin insertCryptocoin(Cryptocoin cryptocoin);

    Cryptocoin updateCryptocoin(Cryptocoin cryptocoin);

    void deleteCryptocoinById(Integer id);
}
