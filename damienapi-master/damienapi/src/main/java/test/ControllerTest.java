package test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import cryptoapi.controller.WebApiController;
import cryptoapi.model.firstapi.cryptoinfo.CryptoPricesInfo;
import cryptoapi.model.firstapi.lastweekinfo.LastWeekCryptoPricesInfo;
import cryptoapi.model.secondapi.SecondCryptoCurrencyInfo;
import cryptoapi.service.PriceInfoService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

public class ControllerTest {

    private CryptoPricesInfo mockCpi;
    private SecondCryptoCurrencyInfo mockScpi;
    private LastWeekCryptoPricesInfo mockLwi;

    private PriceInfoService coinService;
    private WebApiController controller;

    @Before
    public void setUp() throws Exception{

        coinService=mock(PriceInfoService.class);
        controller=mock(WebApiController.class);

        mockCpi=mock(CryptoPricesInfo.class);
        mockLwi=mock(LastWeekCryptoPricesInfo.class);
        mockScpi=mock(SecondCryptoCurrencyInfo.class);


    }

    @After
    public void tearDown() throws  Exception{

    }

    @Test
    public void that_getCryptoPriceInfo_return_Cpi(){


        ResponseEntity<CryptoPricesInfo> cpiResponse=new ResponseEntity(mockCpi, HttpStatus.OK);
        when(coinService.getPriceInfo("bitcoin")).thenReturn(cpiResponse);

        ResponseEntity<LastWeekCryptoPricesInfo> lwiResponse=new ResponseEntity(mockLwi, HttpStatus.OK);
        when(coinService.getLastWeekPriceInfo("bitcoin")).thenReturn(lwiResponse);


        List<Object> JsonArrayNew=new ArrayList<>();
        JsonArrayNew.add(cpiResponse.getBody());
        JsonArrayNew.add(lwiResponse.getBody());

        ResponseEntity<List> cpi=controller.retrievePricesByID("bitcoin");

        assertEquals(JsonArrayNew,
                cpi.getBody());
    }



}
