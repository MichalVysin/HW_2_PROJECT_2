import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class UserInterface {

    String separator = "-".repeat(40) + "\n";
    DataAnalyzer dA = new DataAnalyzer();
    String entry = "";
    Scanner input = new Scanner(System.in);
    String result;

    public void commandLine(VatData vatData) throws IOException {

        System.out.print(separator + "      Welcome in this application!\n");
        printMainMenu();

        while (!"4".equals(entry)) {

            entry = input.nextLine();

            switch (entry) {

                case "1" -> {
                    printFilterByLowestRate(vatData);
                    printContinue();

                }
                case "2" -> {
                    printFilterByHighestRate(vatData);
                    printContinue();

                }
                case "3" -> {
                    findCountry(vatData);
                    printContinue();

                }
                case "4" -> System.out.println("Good bye!");

                default -> System.out.println("Invalid choice!");
            }


        }

    }

    private void printMainMenu() {

        System.out.print(separator +
                "    | What would you like to do?\n" +
                "| 1 | Find country with lowest rate.\n" +
                "| 2 | Find country with highest rate.\n" +
                "| 3 | Find your country.\n" +
                "| 4 | Quit\n" +
                separator);

    }

    private void printContinue() throws IOException {

        System.out.print(separator +
                "|   | How do you want to continue?\n" +
                "| 1 | Find something else\n" +
                "| 2 | Save result\n" +
                "| 3 | Quit\n" +
                separator);

        entry = input.nextLine();

        switch (entry) {
            case "1" -> printMainMenu();

            case "2" ->{
                saveToFile();
                System.out.println("Saved!");
                printMainMenu();
            }

            case "3" -> {
                System.out.println("Good bye!");
                System.exit(0);
            }
            default -> {
                System.out.println("Invalid choice, please repeat!");
                printContinue();

            }


        }

    }

    private void printFilterByLowestRate(VatData vatData) {

        System.out.println(separator +
                "    | Filter countries with lowest rate by:\n" +
                "| 1 | Standard rate.\n" +
                "| 2 | Reduced rate.\n" +
                separator);

        entry = input.nextLine();

        result = dA.getLowestVat(vatData, entry);

        System.out.println(result);

        entry = "";

    }

    private void printFilterByHighestRate(VatData vatData) {

        System.out.println(separator +
                "    | Filter countries with highest rate by:\n" +
                "| 1 | Standard rate.\n" +
                "| 2 | Reduced rate.\n" +
                "| 3 | Reduced rate alt.\n" +
                "| 4 | Super reduced rate.\n" +
                "| 5 | Parking rate.\n" +
                separator);

        entry = input.nextLine();

        result = dA.getHighestVat(vatData, entry);

        System.out.println(result);

        entry = "";

    }

    private void findCountry(VatData vatData) {

        System.out.print("Enter abbreviation or the full name of\n" +
                "the country what are you looking for: ");

        entry = input.nextLine();

        String key = "";

        try {

            key = vatData
                    .getRates()
                    .keySet()
                    .stream()
                    .filter(v -> v.equalsIgnoreCase(entry))
                    .findFirst()
                    .get();
        } catch (NoSuchElementException e) {
            //ignored
        }


        for (Map.Entry<String, VatValue> ent : vatData.getRates().entrySet()) {

            if (entry.equalsIgnoreCase(ent.getValue().getCountry())) {
                key = ent.getKey();
                entry = ent.getKey();
            }
        }

        if (vatData.getRates().containsKey(key)) {

            String standardRate;
            String reducedRate;
            String reducedRateAlt;
            String superReducedRate;
            String parkingRate;

            if (vatData.getRates().get(key).getStandardRate() == null) {
                standardRate = "is not\n";
            } else {
                standardRate = vatData.getRates().get(key).getStandardRate() + " %\n";
            }

            if (vatData.getRates().get(key).getReducedRate() == null) {
                reducedRate = "is not\n";
            } else {
                reducedRate = vatData.getRates().get(key).getReducedRate() + " %\n";
            }

            if (vatData.getRates().get(key).getReducedRateAlt() == null) {
                reducedRateAlt = "is not\n";
            } else {
                reducedRateAlt = vatData.getRates().get(key).getReducedRateAlt() + " %\n";
            }

            if (vatData.getRates().get(key).getSuperReducedRate() == null) {
                superReducedRate = "is not\n";
            } else {
                superReducedRate = vatData.getRates().get(key).getSuperReducedRate() + " %\n";
            }

            if (vatData.getRates().get(key).getParkingRate() == null) {
                parkingRate = "is not";
            } else {
                parkingRate = vatData.getRates().get(key).getParkingRate() + " %";
            }

            result =
                    vatData.getRates().get(entry.toUpperCase()).getCountry() + " [" + key + "]\n" +
                            "Standard rate: " + standardRate +
                            "Reduced rate: " + reducedRate +
                            "Reduced rate alt: " + reducedRateAlt +
                            "Super reduced rate: " + superReducedRate +
                            "Parking rate: " + parkingRate;

            System.out.println(result);

        } else {
            System.out.println("Nothing was found");
        }

    }

    private void saveToFile() throws IOException {

        BufferedWriter bw =
                new BufferedWriter(
                        new FileWriter("vatResults.txt")
                );

        bw.write(result);
        bw.close();
    }
}


