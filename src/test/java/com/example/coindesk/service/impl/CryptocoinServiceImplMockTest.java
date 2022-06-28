package com.example.coindesk.service.impl;

import com.example.coindesk.dao.CryptocoinDao;
import com.example.coindesk.entity.Cryptocoin;
import com.example.coindesk.service.CryptocoinService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class CryptocoinServiceImplMockTest {

    @Autowired
    private CryptocoinService cryptocoinService;

    @MockBean
    private CryptocoinDao cryptocoinDao;

    @Test
    public void getCoinById(){
        Cryptocoin mockCoin = new Cryptocoin();
        mockCoin.setId(10);
        mockCoin.setName("Mockcoin");
        mockCoin.setCode("MOCK");

        Mockito.when(cryptocoinDao.findById(2)).thenReturn(Optional.of(mockCoin));

        Cryptocoin coin = cryptocoinService.getCoinById(2);

        Optional<Cryptocoin> cryptocoin = Optional.ofNullable(coin);
        assertNotNull(cryptocoin);

        Optional<Integer> id = Optional.ofNullable(coin.getId());
        assertEquals(10, id.get());

        Optional<String> name = Optional.ofNullable(coin.getName());
        assertEquals("Mockcoin", name.get());
    }
}