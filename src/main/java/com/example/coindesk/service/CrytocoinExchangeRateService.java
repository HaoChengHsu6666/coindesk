package com.example.coindesk.service;

import com.example.coindesk.entity.CrytocoinExchangeRate;

public interface CrytocoinExchangeRateService {

    CrytocoinExchangeRate getRateDataById(Integer id);

    CrytocoinExchangeRate insertRateData(CrytocoinExchangeRate crytocoinExchangeRate);

}
