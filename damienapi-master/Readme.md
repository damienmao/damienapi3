# damienapi

This api uses rest template (getforentity method) to get CryptoCurrency Info. We used
Wiremock to stub the third party api: https://api.coingecko.com/api/v3

# How to run:
Build image and run via Docker
1.  we did not write the docker file. instead, we ran the command "mvn spring-boot:build—image" 
to build the docker image "damienapi:0.0.1-SNAPSHOT"
2. Run: 
   docker run -d -p 8080:8080 --name damienapi:0.0.1-SNAPSHOT
WireMock Stubbing
1.  Feel free to visit the sites below that are stubbed by Wiremock(wiremock standalone process is running one port 8081)
* http://localhost:8081/coins/bitcoin
* http://localhost:8081/coins/neo
* http://localhost:8081/markets?currency=usd&id=bitcoin
* http://localhost:8081/markets?currency=jpy&id=bitcoin
* http://localhost:8081/markets?currency=jpy&id=bitcoin
* http://localhost:8081/markets?currency=usd&id=neo
2.  note that need to include the jar file  "slf4j-nop-1.7.9.jar" in the command to avoid error:
java -cp "slf4j-nop-1.7.9.jar;wiremock-standalone-2.27.2.jar" com.github.tomakehurst.wiremock.standalone.WireMockServerRunner --port 8080 --global-response-templating


# API Endpoints
1. /coins/{currencyID}, where currencyID is id of a valid cryptocurrency
2. /coins/markets?vs_currency={currencyID}&per_page={paginationLimit}&page={pageNumber}, where currencyID should be either usd, aud, jpy(default value is aud); paginationLimit should be from 1 to 10 (default value is 10), and pageNumber should be an interger which is bigger than 0  (default value is 1).

# API Testing
1.  Under this folder, run: docker-compose up --build to run the API on http://localhost:8081 and access the Wiremock server on http://localhost:8080
2.  Run: cd api-testing. This goes to the folder of api-testing
3.  Run: mvn clean test. This could run the automated REST Assured API tests
