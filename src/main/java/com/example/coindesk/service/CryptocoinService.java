package com.example.coindesk.service;

import com.example.coindesk.entity.Cryptocoin;

public interface CryptocoinService {

    Cryptocoin getCoinById(Integer id);

    Cryptocoin insertCryptocoin(Cryptocoin cryptocoin);

    Cryptocoin updateCryptocoinById(Cryptocoin cryptocoin,
                                    Integer id);

    void deleteCryptocoinById(Integer id);
}
