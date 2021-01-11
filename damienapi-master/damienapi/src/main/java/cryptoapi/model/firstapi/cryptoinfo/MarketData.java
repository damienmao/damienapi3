package cryptoapi.model.firstapi.cryptoinfo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

public @Data class MarketData {

    @JsonProperty ("price_change_24h_in_currency")
    private PriceChange24hours priceChange24Hours;

    @JsonProperty ("current_price")   //JsonProperty is to map the Json Key name of source API to the your model;
    private CurrentPrice currentPrice;

}
