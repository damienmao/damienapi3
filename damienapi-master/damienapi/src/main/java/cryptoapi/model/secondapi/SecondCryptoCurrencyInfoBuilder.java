package cryptoapi.model.secondapi;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SecondCryptoCurrencyInfoBuilder {
    public String id;

    @JsonProperty("current_price")
    public float currentPrice;

    @JsonProperty("market_cap")
    public long marketCap;

    public SecondCryptoCurrencyInfoBuilder Id(String id) {
        this.id = id;
        return this;
    }

    public SecondCryptoCurrencyInfoBuilder Current_price(float currentPrice) {
        this.currentPrice = currentPrice;
        return this;
    }

    public SecondCryptoCurrencyInfoBuilder Market_cap(long marketCap) {
        this.marketCap = marketCap;
        return this;
    }

    public SecondCryptoCurrencyInfo build(){
        return new SecondCryptoCurrencyInfo(this);
    }
}
