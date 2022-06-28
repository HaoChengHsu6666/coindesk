package com.example.coindesk.service;

import com.example.coindesk.entity.Cryptocoin;
import org.springframework.stereotype.Service;

@Service
public interface CryptocoinService {

    Cryptocoin getCoinById(Integer id);

    Cryptocoin insertCryptocoin(Cryptocoin cryptocoin);

    Cryptocoin updateCryptocoinById(Cryptocoin cryptocoin);

    void deleteCryptocoinById(Integer id);
}
