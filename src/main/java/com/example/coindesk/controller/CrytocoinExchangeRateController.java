package com.example.coindesk.controller;

import com.example.coindesk.entity.CrytocoinExchangeRate;
import com.example.coindesk.service.CrytocoinExchangeRateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/CERC")
public class CrytocoinExchangeRateController {

    @Autowired
    private CrytocoinExchangeRateService crytocoinExchangeRateService;

    @GetMapping("select/{id}")
    public CrytocoinExchangeRate getRateDataById(@PathVariable Integer id){
        return crytocoinExchangeRateService.getRateDataById(id);
    }

    @PostMapping("/insert")
    public String insertRateData(@RequestBody CrytocoinExchangeRate crytocoinExchangeRate){
        crytocoinExchangeRate = crytocoinExchangeRateService.insertRateData(crytocoinExchangeRate);
        return "已新增新匯率資訊，其編號Id為: " + crytocoinExchangeRate.getId();
    }


}
