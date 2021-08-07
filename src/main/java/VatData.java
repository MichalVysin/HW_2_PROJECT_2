import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class VatData {

    @JsonProperty("last_updated")
    private String lastUpdate;
    private String disclaimer;
    private Map<String, VatValue> rates = new HashMap<>();

    public String getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(String lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public String getDisclaimer() {
        return disclaimer;
    }

    public void setDisclaimer(String disclaimer) {
        this.disclaimer = disclaimer;
    }

    public Map<String, VatValue> getRates() {
        return rates;
    }

    public void setRates(Map<String, VatValue> rates) {
        this.rates = rates;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VatData vatData = (VatData) o;
        return Objects.equals(lastUpdate, vatData.lastUpdate) && Objects.equals(disclaimer, vatData.disclaimer) && Objects.equals(rates, vatData.rates);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lastUpdate, disclaimer, rates);
    }
}
