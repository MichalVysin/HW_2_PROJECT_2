import com.fasterxml.jackson.core.JsonProcessingException;

import java.io.IOException;

public class Main {

    public static void main(String[] args){

        DataDownloader dataDownloader = new DataDownloader();

        String downloadedData = "";

        try {
            downloadedData = dataDownloader.downloadData();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        DataMapper dataMapper = new DataMapper();
        VatData vatData = null;

        try {
            vatData = dataMapper.jsonStringToVatData(downloadedData);

        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        UserInterface userInterface = new UserInterface();

        try {
            userInterface.commandLine(vatData);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
