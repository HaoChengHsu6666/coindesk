package com.example.coindesk.service.impl;

import com.example.coindesk.dao.CryptocoinDao;
import com.example.coindesk.entity.Cryptocoin;
import com.example.coindesk.service.CryptocoinService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class CryptocoinServiceImplMockTest {

    @Autowired
    private CryptocoinService cryptocoinService;

    //一部分參照真實寫出的邏輯功能，一部分是可自行定義假的功能
//  @SpyBean
//  private CryptocoinDao cryptocoinDao;

    //完全自行定義假的相關物件、參數及功能
    @MockBean
    private CryptocoinDao cryptocoinDao;

    @Test
    public void getCoinById(){
        Cryptocoin mockCoin = new Cryptocoin();
        mockCoin.setId(10);
        mockCoin.setName("Mockcoin");
        mockCoin.setCode("MOCK");

//        Mockito.when(cryptocoinDao.findById(2)).thenReturn(Optional.of(mockCoin));

        //在findById裡給任何id值都會回傳定義的假物件
        Mockito.when(cryptocoinDao.findById(Mockito.any())).thenReturn(Optional.of(mockCoin));
        //另一種寫法...
        Mockito.doReturn(Optional.of(mockCoin)).when(cryptocoinDao.findById(Mockito.any()));


        Cryptocoin coin = cryptocoinService.getCoinById(3);

        Optional<Cryptocoin> cryptocoin = Optional.ofNullable(coin);

        assertNotNull(cryptocoin);
        assertTrue(cryptocoin.isPresent());

        Optional<Integer> id = Optional.ofNullable(coin.getId());
        assertEquals(10, id.get());

        Optional<String> name = Optional.ofNullable(coin.getName());
        assertEquals("Mockcoin", name.get());
    }
}