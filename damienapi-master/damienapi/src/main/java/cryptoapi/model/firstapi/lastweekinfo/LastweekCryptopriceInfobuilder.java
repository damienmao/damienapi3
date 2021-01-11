package cryptoapi.model.firstapi.lastweekinfo;

public class LastweekCryptopriceInfobuilder {

    public LastWeekMarketData market_data;

    public LastweekCryptopriceInfobuilder market_data(LastWeekMarketData market_data) {
        this.market_data=market_data;
        return this;
    }
    public LastWeekCryptoPricesInfo build(){
        return new LastWeekCryptoPricesInfo(this);
    }
}
