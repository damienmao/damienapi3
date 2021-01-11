package test;
import cryptoapi.WebApiApp;
import cryptoapi.client.CoinGeckoClient;
import cryptoapi.model.firstapi.cryptoinfo.CryptoPricesInfo;
import cryptoapi.model.firstapi.lastweekinfo.LastWeekCryptoPricesInfo;
import cryptoapi.model.secondapi.SecondCryptoCurrencyInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest(classes= WebApiApp.class)
public class ClientTest {

    @Autowired
    private CoinGeckoClient client;


    @Test
    //first cryptocurrencInfo
    public void test_getCurrencyDetails(){

        ResponseEntity<CryptoPricesInfo> cpo=client.getInfoCoingecko("bitcoin");

        assertEquals("bitcoin",cpo.getBody().getId());
        assertEquals("Bitcoin",cpo.getBody().getName());
        assertNotNull(cpo.getBody().getLast_updated());
        assertNotNull(cpo.getBody().getGenesis_date());
        assertNotNull(cpo.getBody().getMarket_data().getCurrentPrice());
        assertNotNull(cpo.getBody().getMarket_data().getPriceChange24Hours());
    }

    @Test
    //last week priceInfo
    public void test_getLastweekInfo(){
        ResponseEntity<LastWeekCryptoPricesInfo> lwcpo=client.getLastWeekInfoCoingecko("bitcoin");

        assertNotNull(lwcpo.getBody().getMarket_data().getCurrent_price());
    }

    @Test
    //Second Api PriceInfo
    public void test_getSecondApiPriceInfo(){
    ResponseEntity<SecondCryptoCurrencyInfo[]> spi=client.getMarketInfo("usd","bitcoin","10");

        assertNotNull( spi.getBody());

    }





































}
