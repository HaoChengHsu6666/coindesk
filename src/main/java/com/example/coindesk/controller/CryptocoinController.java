package com.example.coindesk.controller;

import com.example.coindesk.entity.Cryptocoin;
import com.example.coindesk.service.CryptocoinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cryptocoin")
public class CryptocoinController {

    @Autowired
    private CryptocoinService cryptocoinService;

    @GetMapping("/select/{id}")
    public Cryptocoin getCoinById(@PathVariable Integer id){
        return cryptocoinService.getCoinById(id);
    }

    @PostMapping("/insert")
    public String insertCryptocoin(@RequestBody Cryptocoin cryptocoin){
        cryptocoin =  cryptocoinService.insertCryptocoin(cryptocoin);
        return "已新增成功，新增的用戶ID為：" + cryptocoin.getId();
    }

    @PutMapping("/update/{id}")
    public String updateCryptocoinById(@RequestBody Cryptocoin cryptocoin,
                                   @PathVariable Integer id){
        cryptocoin = cryptocoinService.updateCryptocoinById(cryptocoin,id);
        return "已更新成功，更新的用戶ID為：" + cryptocoin.getId();
    }

    @DeleteMapping("/delete/{id}")
    public String deleteCryptocoinById(@PathVariable Integer id){
        cryptocoinService.deleteCryptocoinById(id);
        return "已執行deleteCryptocoinById，id碼: " + id + " 已被刪除了!";
    }


}

