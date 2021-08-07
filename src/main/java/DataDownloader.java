import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class DataDownloader {

    public String downloadData() throws IOException, InterruptedException {

        String url = "https://euvatrates.com/rates.json";

        HttpClient httpClient = HttpClient
                .newBuilder()
                .build();

        HttpRequest httpRequest = HttpRequest
                .newBuilder(URI.create(url))
                .build();

        HttpResponse<String> httpResponse = httpClient
                .send(httpRequest, HttpResponse.BodyHandlers.ofString());

        return httpResponse.body();
    }
}
