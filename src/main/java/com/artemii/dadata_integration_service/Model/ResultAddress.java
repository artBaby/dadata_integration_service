package com.artemii.dadata_integration_service.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by Artemiy on 08.08.2019.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class ResultAddress {

    private Double latitude;
    private Double longitude;

    public ResultAddress(Double latitude, Double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    @Override
    public String toString() {
        return "Fetched coords: " +
                "latitude: " + latitude +
                " longitude: " + longitude;
    }
}
