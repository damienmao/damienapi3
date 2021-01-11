package cryptoapi.model.secondapi;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
public class SecondCryptoCurrencyInfo {
    private String id;
    private Float current_price;
    private Long market_cap;


//
//
//    public String getId() {
//        return id;
//    }
//
//    public Float getCurrent_price() {
//        return current_price;
//    }
//
//    public Long getMarket_cap() {
//        return market_cap;
//    }
//
//    public void setId(String id) {
//        this.id = id;
//    }
//
//    public void setCurrent_price(Float current_price) {
//        this.current_price = current_price;
//    }
//
//    public void setMarket_cap(Long market_cap) {
//        this.market_cap = market_cap;
//    }

    public SecondCryptoCurrencyInfo(SecondCryptoCurrencyInfoBuilder secondCryptoCurrencyInfoBuilder){
        id= secondCryptoCurrencyInfoBuilder.id;
        current_price= secondCryptoCurrencyInfoBuilder.currentPrice;
        market_cap= secondCryptoCurrencyInfoBuilder.marketCap;
    }

}
