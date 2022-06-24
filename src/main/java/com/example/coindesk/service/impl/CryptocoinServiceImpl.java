package com.example.coindesk.service.impl;

import com.example.coindesk.dao.CryptocoinDao;
//import com.example.coindesk.dao.impl.CryptocoinDaoImpl;
import com.example.coindesk.entity.Cryptocoin;
import com.example.coindesk.service.CryptocoinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CryptocoinServiceImpl implements CryptocoinService {

    @Autowired
    private CryptocoinDao cryptocoinDao;

    public Optional<Cryptocoin> getCoinById(Integer id){
      return cryptocoinDao.findById(id);
    }

    public Integer insertCryptocoin(Cryptocoin cryptocoin){
        this.cryptocoinDao.save(cryptocoin);
        return 1;
    }

}
