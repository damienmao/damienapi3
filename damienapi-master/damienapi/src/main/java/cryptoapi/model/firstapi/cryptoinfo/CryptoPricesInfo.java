package cryptoapi.model.firstapi.cryptoinfo;
import lombok.Data;

public @Data class CryptoPricesInfo {
    private String id;
    private String name;
    private String symbol;
    private String last_updated;
    private String genesis_date;
    private MarketData market_data;

    public CryptoPricesInfo(CryptoPricesInfoBuilder cryptoPricesInfoBuilder){
        id= cryptoPricesInfoBuilder.id;
        name= cryptoPricesInfoBuilder.name;
        symbol= cryptoPricesInfoBuilder.symbol;
        last_updated= cryptoPricesInfoBuilder.last_updated;
        market_data= cryptoPricesInfoBuilder.market_data;
        genesis_date= cryptoPricesInfoBuilder.genesis_date;
    }

    public CryptoPricesInfo() {
    }
}

