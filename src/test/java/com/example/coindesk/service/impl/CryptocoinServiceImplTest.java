package com.example.coindesk.service.impl;

import com.example.coindesk.entity.Cryptocoin;
import com.example.coindesk.service.CryptocoinService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class CryptocoinServiceImplTest {

    @Autowired
    private CryptocoinService cryptocoinService;

    @Test
    @DisplayName("測試以Id取得加密貨幣資訊")
    public void getCoinById(){
        Cryptocoin cryptocoin = cryptocoinService.getCoinById(2);
        assertNotNull(cryptocoin);
        assertEquals("Ether",cryptocoin.getName());
        assertEquals("ETH"  ,cryptocoin.getCode());
        assertTrue("ETH".equals(cryptocoin.getCode()));
    }

    @Transactional //測試完成後會強制將資料rollback，不會影響到資料表
    @Test
    @DisplayName("測試新增加密貨幣資訊")
    public void insertCryptocoin(){
        Cryptocoin cryptocoin = new Cryptocoin();
        cryptocoin.setName("Tethercoin");
        cryptocoin.setCode("USDT");

        Cryptocoin newCoin = cryptocoinService.insertCryptocoin(cryptocoin);
//      Cryptocoin newCoin = cryptocoinService.getCoinById(cryptocoin.getId());

        assertNotNull(newCoin);
        assertTrue("USDT".equals(cryptocoin.getCode()));
        assertEquals("Tethercoin",newCoin.getName());
    }

    @Transactional //測試完成後會強制將資料rollback，不會影響到資料表
    @Test
    @DisplayName("測試更新加密貨幣資訊")
    public void updateCryptocoin(){
        Cryptocoin theOldCoin = cryptocoinService.getCoinById(3);
        theOldCoin.setCode("BIG_DOGDOG_DER_GEGE");

        Cryptocoin theNewCoin = cryptocoinService.updateCryptocoin(theOldCoin);
        assertEquals("Dogecoin",theNewCoin.getName());
        assertFalse("DOGE" == theNewCoin.getCode());
    }

    @Transactional //測試完成後會強制將資料rollback，不會影響到資料表
    @Test
    @DisplayName("測試以Id刪除加密貨幣資訊")
    public void deleteById(){
        cryptocoinService.deleteCryptocoinById(2);
        Cryptocoin cryptocoin = cryptocoinService.getCoinById(2);
        assertNull(cryptocoin);
    }

}