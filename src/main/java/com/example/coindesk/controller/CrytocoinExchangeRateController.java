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

    @PostMapping("/insert") //RequestBody中 "不須給" Id
    public String insertRateData(@RequestBody CrytocoinExchangeRate crytocoinExchangeRate){
        crytocoinExchangeRate = crytocoinExchangeRateService.insertRateData(crytocoinExchangeRate);
        return "已新增新的匯率資訊，其編號Id為: " + crytocoinExchangeRate.getId();
    }

    @PutMapping("/update")  //RequestBody中 "須給" Id
    public String updateRateDataById(@RequestBody CrytocoinExchangeRate crytocoinExchangeRate){
        crytocoinExchangeRate = crytocoinExchangeRateService.updateRateDataById(crytocoinExchangeRate);
        return "已更新匯率資訊，其編號Id為: " + crytocoinExchangeRate.getId();
    }

    @DeleteMapping("/delete/{id}")
    public void deleteRateDataById(@PathVariable Integer id){
        crytocoinExchangeRateService.deleteRateDataById(id);
    }


}
