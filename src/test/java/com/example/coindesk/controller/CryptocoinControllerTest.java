package com.example.coindesk.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcResultMatchersDsl;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class CryptocoinControllerTest {

    @Autowired(required = false)
    private MockMvc mockMvc;

    @Test
    public void getCoinById() throws Exception {

        //似模擬API tester中創建Http request，以"設定URL路徑方式或參數"的請求
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/cryptocoin/select/2");

        //似斷言Assert，以mockMVC做模擬，"執行請求發送"，並驗證測試結果是否為設定的回應結果
//        mockMvc.perform(requestBuilder)
//                .andExpect(MockMvcResultMatchers.status().is(200));


//        import MockMvcResultMatchers的static方法後即可簡寫成下列方式
          mockMvc.perform(requestBuilder)
                  .andDo(print())
                  .andExpect(status().is(200))
                  //"$"為此"JSON物件"，"."為"的"之意，取出此JSON物件的Id與後者是否相等
                  .andExpect(jsonPath("$.id",equalTo(2)))
                  .andExpect(jsonPath("$.name",notNullValue()));
          //更多的JSON PATH練習可搜尋jsonpath online evaluator

    }

}