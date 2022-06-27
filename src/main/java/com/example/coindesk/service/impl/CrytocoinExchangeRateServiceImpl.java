package com.example.coindesk.service.impl;

import com.example.coindesk.dao.CrytocoinExchangeRateDao;

import com.example.coindesk.entity.CrytocoinExchangeRate;
import com.example.coindesk.service.CrytocoinExchangeRateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CrytocoinExchangeRateServiceImpl implements CrytocoinExchangeRateService {

    @Autowired
    private CrytocoinExchangeRateDao crytocoinExchangeRateDao;

    public CrytocoinExchangeRate getRateDataById(Integer id){
        return crytocoinExchangeRateDao.findById(id).orElse(null);
    }

    public CrytocoinExchangeRate insertRateData(CrytocoinExchangeRate crytocoinExchangeRate){
        return crytocoinExchangeRateDao.save(crytocoinExchangeRate);
    }

}
