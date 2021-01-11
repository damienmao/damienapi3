package cryptoapi.model.firstapi.lastweekinfo;


import cryptoapi.model.firstapi.cryptoinfo.CurrentPrice;
import lombok.Data;


public @Data class LastWeekMarketData {
    private CurrentPrice current_price;
}
