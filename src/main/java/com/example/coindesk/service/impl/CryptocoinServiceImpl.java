package com.example.coindesk.service.impl;

import com.example.coindesk.dao.CryptocoinDao;

import com.example.coindesk.entity.Cryptocoin;
import com.example.coindesk.service.CryptocoinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CryptocoinServiceImpl implements CryptocoinService {

    @Autowired
    private CryptocoinDao cryptocoinDao;

    public Cryptocoin getCoinById(Integer id){
      return cryptocoinDao.findById(id).orElse(null);
    }

    public Cryptocoin insertCryptocoin(Cryptocoin cryptocoin){
        //會回傳新增進去的"實體物件"
        return cryptocoinDao.save(cryptocoin);
    }

    public Cryptocoin updateCryptocoin(Cryptocoin cryptocoin){
        return cryptocoinDao.save(cryptocoin);
    }

    public void deleteCryptocoinById(Integer id){
        cryptocoinDao.deleteById(id);
    }

}
