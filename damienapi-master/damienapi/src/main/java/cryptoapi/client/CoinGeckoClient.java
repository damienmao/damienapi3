package cryptoapi.client;

import cryptoapi.model.firstapi.cryptoinfo.CryptoPricesInfo;
import cryptoapi.model.secondapi.SecondCryptoCurrencyInfo;
import cryptoapi.model.firstapi.lastweekinfo.LastWeekCryptoPricesInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.*;


@Component

//Component works when we enable the component scan
//And Spring will scan the entire classpath (we can adjust the filtering) and pick up the bean.
//@Beans is used to explicitly declare the bean.

//If use @Component on those service classes and the component scan in the application, we might end up detecting more beans than necessary. In this case, you either had to adjust the filtering of the component scan or provide the configuration that even the unused beans can run. Otherwise, the application context won’t start.
//So, essentially, use @Bean for adding third-party classes to the context. And @Component if it is just inside your single application.
public class CoinGeckoClient {


    //in the WebApiApp class, we created a rest template bean with @Bean and spring holds of it for us.
    //And now by using @Autowired, we ask the instance of rest template from spring
    @Autowired
    private RestTemplate restTemplate;

    Date Today=new Date();
    long DAY_IN_MS = 1000 * 60 * 60 * 24;
    SimpleDateFormat formatter=new SimpleDateFormat("dd-MM-yyyy");

    Date date_OneWeekAgo =new Date(System.currentTimeMillis()-7*DAY_IN_MS);
    String Str_date_OneWeekAge=formatter.format(date_OneWeekAgo);
    String Str_Today=formatter.format(Today);

    String URL="https://api.coingecko.com/api/v3/coins/";  //api.coingecko.com is the host name

    private static final Logger logger=Logger.getLogger(CoinGeckoClient.class.getName());

    public ResponseEntity<CryptoPricesInfo> getInfoCoingecko(String id){

        logger.info("logger Name: "+logger.getName()+Str_Today+"\r\n"+"Coingecko API " +
                "" +
                "C");

        logger.warning("can cause some exception, e.g coingeckto service error/query parameter is wrong");
       // System.out.println(Str_Today);
//        System.out.println("API Coingecko");

        return
                restTemplate.getForEntity(URL+id, CryptoPricesInfo.class,id);

        //.getForEntity method retrieves resources of a given URI or URL templates
    }
    public ResponseEntity<LastWeekCryptoPricesInfo> getLastWeekInfoCoingecko(String id){
        return
                restTemplate.getForEntity(URL+id+"/history?date="+Str_date_OneWeekAge,
                        LastWeekCryptoPricesInfo.class);

    }

    public ResponseEntity<SecondCryptoCurrencyInfo[]> getMarketInfo(String currency, String id, String per_page){
        return
                restTemplate.getForEntity(URL+"markets?vs_currency="+currency+"&ids="+id
                                +"&order=market_cap_desc&per_page="+per_page+"&page=1&sparkline=false",
                        SecondCryptoCurrencyInfo[].class);
    }



}
