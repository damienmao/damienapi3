package cryptoapi.model.firstapi.lastweekinfo;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public @Data class LastWeekCryptoPricesInfo {

    private LastWeekMarketData market_data;

     public LastWeekCryptoPricesInfo(LastweekCryptopriceInfobuilder lastWeek_crytoPricesOutputBuilder){

        market_data=lastWeek_crytoPricesOutputBuilder.market_data;

    }


}
