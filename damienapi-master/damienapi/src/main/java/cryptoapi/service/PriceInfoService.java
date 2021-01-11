package cryptoapi.service;

import cryptoapi.client.CoinGeckoClient;
import cryptoapi.model.firstapi.cryptoinfo.CryptoPricesInfo;
import cryptoapi.model.firstapi.lastweekinfo.LastWeekCryptoPricesInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service  //what does it do?
//Spring @Service annotation is a specialization of @Component annotation.
// It is used to mark the class as a service provider.

public class PriceInfoService {
    @Autowired
    private CoinGeckoClient coingeckoClient;

    public ResponseEntity<CryptoPricesInfo> getPriceInfo(String id){
        return coingeckoClient.getInfoCoingecko(id);
    }
    public ResponseEntity<LastWeekCryptoPricesInfo> getLastWeekPriceInfo(String id){
        return coingeckoClient.getLastWeekInfoCoingecko(id);
    }

    public ResponseEntity<?> getMarketInfo(String currency,String id,String per_page){
        return coingeckoClient.getMarketInfo(currency,id,per_page);
    }
}

