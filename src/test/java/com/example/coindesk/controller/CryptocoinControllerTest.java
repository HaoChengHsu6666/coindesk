package com.example.coindesk.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcResultMatchersDsl;
import org.springframework.test.web.servlet.MvcResult;
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
    @DisplayName("測試select by MockMvc")
    public void getCoinById() throws Exception {

        //似模擬API tester中創建Http request，以"設定URL路徑方式或參數"的請求
//        RequestBuilder requestBuilder = MockMvcRequestBuilders
//                .get("/cryptocoin/select/2");

        //或寫成...
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/cryptocoin/select/{id}", 2)
                .header("headerName", "headerValue")
                .queryParam("CODE", "ETHER");

        //似斷言Assert，以mockMVC做模擬，"執行請求發送"，並驗證測試結果是否為設定的回應結果
//        mockMvc.perform(requestBuilder)
//                .andExpect(MockMvcResultMatchers.status().is(200));


//        import MockMvcResultMatchers的static方法後即可簡寫成下列的方式
        MvcResult mvcResult = mockMvc.perform(requestBuilder)
                //打印在console視窗上(方便做比對或加上jsonpath的內容)
                .andDo(print())
                .andExpect(status().is(200))
                //"$"為此"JSON物件"，"."為"的"之意，取出此JSON物件的Id與後者測試的值是否相符
                .andExpect(jsonPath("$.id", equalTo(2)))
                .andExpect(jsonPath("$.name", notNullValue()))
                //只能寫在最後一行
                .andReturn();
        //更多的JSON PATH練習可搜尋jsonpath online evaluator

        //把response的結果以字串回傳並顯示之
        String body = mvcResult.getResponse().getContentAsString();
        System.out.println("返回的 response body 為: " + body);
    }
        @Test
        @DisplayName("測試insert by MockMvc")
        public void insert() throws Exception {
            RequestBuilder requestBuilder = MockMvcRequestBuilders
                    .post("/cryptocoin/insert")
                    //*******非常重要*******
                    //使用POST方法時，需加入此行才能在requestbody內加入JSON參數
                    .contentType(MediaType.APPLICATION_JSON)
                    .content("{\n" +
                            "\"name\": \"Tether\",\n" +
                            "\"code\": \"USDT\"\n" +
                            "}");
            mockMvc.perform(requestBuilder)
                    .andDo(print())
                    .andExpect(status().is(200));
        }

        @Test
        @DisplayName("測試update by MockMvc")
        public void update() throws Exception {
            RequestBuilder requestBuilder = MockMvcRequestBuilders
                    .put("/cryptocoin/update")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content("{\n" +
                            "  \"id\" : \"6\",\n" +
                            "  \"name\": \"Zilliqa\",\n" +
                            "  \"code\": \"ZIL\"\n" +
                            "}");
            mockMvc.perform(requestBuilder)
                    .andDo(print())
                    .andExpect(status().is(200));
        }

        @Test
        @DisplayName("測試delete by MockMvc")
        public void delete() throws Exception {
            RequestBuilder requestBuilder = MockMvcRequestBuilders
                    .delete("/cryptocoin/delete/{id}",23);

            MvcResult mvcResult = mockMvc.perform(requestBuilder)
                    .andDo(print())
                    .andExpect(status().is(200))
                    .andReturn();

            String body = mvcResult.getResponse().getContentAsString();
            System.out.println("返回的body為: "+ body);
        }
    }
