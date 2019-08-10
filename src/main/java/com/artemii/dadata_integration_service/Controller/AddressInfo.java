package com.artemii.dadata_integration_service.Controller;

import com.artemii.dadata_integration_service.Model.ResultAddress;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.redcom.lib.integration.api.client.dadata.DaDataClient;
import ru.redcom.lib.integration.api.client.dadata.DaDataClientFactory;
import ru.redcom.lib.integration.api.client.dadata.DaDataException;
import ru.redcom.lib.integration.api.client.dadata.dto.Address;

import java.math.BigDecimal;

@Controller
public class AddressInfo {

    private Logger logger = LoggerFactory.getLogger(AddressInfo.class);

    private static final String API_KEY = "69dde0f9d305fcb9ddf841e09b6ab64b540c6fde";
    private static final String SECRET_KEY = "2dedb2769470afe430f2546dcf3a01a6d906b074";
    private final DaDataClient dadata;

    public AddressInfo(final RestTemplateBuilder restTemplateBuilder) {
        dadata = DaDataClientFactory.getInstance(API_KEY, SECRET_KEY, null, restTemplateBuilder);
    }

    @ResponseBody
    @GetMapping({"/searchAddress"})
    public ResultAddress getAddressCoords(@RequestParam("inputAddress") String requestAddress) throws DaDataException {
        final Address responseAddress = dadata.cleanAddress(requestAddress);
        final BigDecimal balance = dadata.getProfileBalance();

        ResultAddress resultAddress = new ResultAddress(responseAddress.getGeoLat(), responseAddress.getGeoLon());
        logInfo(requestAddress, responseAddress, balance);
        return resultAddress;
    }

    private void logInfo(String requestAddress, Address responseAddress, BigDecimal balance) {
        logger.info("Camunda request: " + requestAddress);
        logger.info("Dadata Response: " + responseAddress.getGeoLat() + " " + responseAddress.getGeoLon());
        logger.info("Current balance: " + balance);
    }
}