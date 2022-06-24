package com.example.coindesk.controller;

import com.example.coindesk.entity.Cryptocoin;
import com.example.coindesk.service.CryptocoinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/cryptocoin")
public class CryptocoinController {

    @Autowired
    private CryptocoinService cryptocoinService;

    @GetMapping("/select")
    public Optional<Cryptocoin> getCoinById(@PathVariable Integer id){
        return cryptocoinService.getCoinById(id);
    }

    @PostMapping("/insert")
    public Integer insertCryptocoin(@RequestBody Cryptocoin cryptocoin){
//        cryptocoinService.insertCryptocoin(cryptocoin);
        cryptocoinService.insertCryptocoin(cryptocoin);
        return 1;
    }


}

