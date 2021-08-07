import java.math.BigDecimal;
import java.util.Comparator;
import java.util.stream.Collectors;

public class DataAnalyzer {

    public String getLowestVat(VatData vatData, String entry) {

        try {
            return vatData
                    .getRates()
                    .values()
                    .stream()
                    .peek(v -> {
                        if (v.getStandardRate() == null) {
                            v.setStandardRate(BigDecimal.ZERO);
                        }
                        if (v.getReducedRate() == null) {
                            v.setReducedRate(BigDecimal.ZERO);
                        }
                        if (v.getReducedRateAlt() == null) {
                            v.setReducedRateAlt(BigDecimal.ZERO);
                        }
                        if (v.getSuperReducedRate() == null) {
                            v.setSuperReducedRate(BigDecimal.ZERO);
                        }
                        if (v.getParkingRate() == null) {
                            v.setParkingRate(BigDecimal.ZERO);
                        }

                    })
                    .sorted(Comparator.comparing(switch (entry) {
                        case "1" -> VatValue::getStandardRate;
                        case "2" -> VatValue::getReducedRate;
                        default -> throw new IllegalStateException("Unexpected value: " + entry);
                    })
                            .thenComparing(VatValue::getCountry))
                    .limit(3)
                    .map(v -> {
                        BigDecimal result;
                        switch (entry) {
                            case "1" -> result = v.getStandardRate();
                            case "2" -> result = v.getReducedRate();
                            default -> throw new IllegalStateException("Unexpected value: " + entry);
                        }
                        return v.getCountry() + " - " + result + " %";
                    })
                    .collect(Collectors.joining("\n"));

        } catch (NumberFormatException e) {
            System.out.println("Please enter number");
        }

        return "sd";


    }

    public String getHighestVat(VatData vatData, String entry) {

        try {
            return vatData
                    .getRates()
                    .values()
                    .stream()
                    .peek(v -> {
                        if (v.getStandardRate() == null) {
                            v.setStandardRate(BigDecimal.ZERO);
                        }
                        if (v.getReducedRate() == null) {
                            v.setReducedRate(BigDecimal.ZERO);
                        }
                        if (v.getReducedRateAlt() == null) {
                            v.setReducedRateAlt(BigDecimal.ZERO);
                        }
                        if (v.getSuperReducedRate() == null) {
                            v.setSuperReducedRate(BigDecimal.ZERO);
                        }
                        if (v.getParkingRate() == null) {
                            v.setParkingRate(BigDecimal.ZERO);
                        }

                    })
                    .sorted(Comparator.comparing(
                            switch (entry) {
                                case "1" -> VatValue::getStandardRate;
                                case "2" -> VatValue::getReducedRate;
                                case "3" -> VatValue::getReducedRateAlt;
                                case "4" -> VatValue::getSuperReducedRate;
                                case "5" -> VatValue::getParkingRate;
                                default -> throw new IllegalStateException("Unexpected value: " + entry);
                            })
                            .thenComparing(VatValue::getCountry)
                            .reversed())
                    .limit(3)
                    .map(v -> {
                        BigDecimal result;
                        switch (entry) {
                            case "1" -> result = v.getStandardRate();
                            case "2" -> result = v.getReducedRate();
                            case "3" -> result = v.getReducedRateAlt();
                            case "4" -> result = v.getSuperReducedRate();
                            case "5" -> result = v.getParkingRate();
                            default -> throw new IllegalStateException("Unexpected value: " + entry);
                        }
                        return v.getCountry() + " - " + result + " %";
                    })
                    .collect(Collectors.joining("\n"));

        } catch (NumberFormatException e) {
            System.out.println("Please enter number");
        }

        return "sd";


    }


}
