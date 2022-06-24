package com.example.coindesk.service;

import com.example.coindesk.entity.Cryptocoin;

import java.util.Optional;


public interface CryptocoinService {

    Optional<Cryptocoin> getCoinById(Integer id);

    Integer insertCryptocoin(Cryptocoin cryptocoin);
}
