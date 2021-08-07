import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.math.BigDecimal;
import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class VatValue {

    private String country;

    @JsonProperty("standard_rate")
    @JsonDeserialize(using = CustomDeserialize.class)
    private BigDecimal standardRate;

    @JsonProperty("reduced_rate")
    @JsonDeserialize(using = CustomDeserialize.class)
    private BigDecimal reducedRate;

    @JsonProperty("reduced_rate_alt")
    @JsonDeserialize(using = CustomDeserialize.class)
    private BigDecimal reducedRateAlt;

    @JsonProperty("super_reduced_rate")
    @JsonDeserialize(using = CustomDeserialize.class)
    private BigDecimal superReducedRate;

    @JsonProperty("parking_rate")
    @JsonDeserialize(using = CustomDeserialize.class)
    private BigDecimal parkingRate;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public BigDecimal getStandardRate() {
        return standardRate;
    }

    public void setStandardRate(BigDecimal standardRate) {
        this.standardRate = standardRate;
    }

    public BigDecimal getReducedRate() {
        return reducedRate;
    }

    public void setReducedRate(BigDecimal reducedRate) {
        this.reducedRate = reducedRate;
    }

    public BigDecimal getReducedRateAlt() {
        return reducedRateAlt;
    }

    public void setReducedRateAlt(BigDecimal reducedRateAlt) {
        this.reducedRateAlt = reducedRateAlt;
    }

    public BigDecimal getSuperReducedRate() {
        return superReducedRate;
    }

    public void setSuperReducedRate(BigDecimal superReducedRate) {
        this.superReducedRate = superReducedRate;
    }

    public BigDecimal getParkingRate() {
        return parkingRate;
    }

    public void setParkingRate(BigDecimal parkingRate) {
        this.parkingRate = parkingRate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VatValue vatValue = (VatValue) o;
        return Objects.equals(country, vatValue.country) && Objects.equals(standardRate, vatValue.standardRate) && Objects.equals(reducedRate, vatValue.reducedRate) && Objects.equals(reducedRateAlt, vatValue.reducedRateAlt) && Objects.equals(superReducedRate, vatValue.superReducedRate) && Objects.equals(parkingRate, vatValue.parkingRate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(country, standardRate, reducedRate, reducedRateAlt, superReducedRate, parkingRate);
    }
}
