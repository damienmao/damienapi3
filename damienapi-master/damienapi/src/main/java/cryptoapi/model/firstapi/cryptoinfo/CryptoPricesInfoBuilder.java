package cryptoapi.model.firstapi.cryptoinfo;
import lombok.Data;
public  @Data class CryptoPricesInfoBuilder {
        public String id;
        public String name;
        public String symbol;
        public String last_updated;
        public String genesis_date;
        public MarketData market_data;


//        public CryptoPricesOutputBuilder market_data(Market_data market_data) {
//            this.market_data=market_data;
//            return this;
//        }
//        public CryptoPricesOutputBuilder genesis_date(String genesis_date) {
//            this.genesis_date=genesis_date;
//            return this;
//        }
//
//        public CryptoPricesOutputBuilder getId(String id) {
//            this.id=id;
//            return this;
//        }
//        public CryptoPricesOutputBuilder getName(String name) {
//            this.name=name;
//            return this;
//        }
//        public CryptoPricesOutputBuilder getSymbol(String symbol) {
//            this.symbol=symbol;
//            return this;
//        }
//
//        public CryptoPricesOutputBuilder getLast_updated(String last_updated) {
//            this.last_updated = last_updated;
//            return this;
//        }
//
//        public CryptoPricesOutput build(){
//            return new CryptoPricesOutput(this);
//        }
  }

