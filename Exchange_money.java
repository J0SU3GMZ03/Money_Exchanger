import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Exchange_money {

    public Exchange exchange_money( String base_code,
                                    String target_code,
                                    double amount){

        URI address = URI.create("https://v6.exchangerate-api.com/v6/" +
                "7a36effe1f0062819dbeca31/pair/" + base_code + "/"
                + target_code+ "/" + amount);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(address).build();

        try {
            HttpResponse<String> response = client.send(request,
                    HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(),
                    Exchange.class);
        } catch (Exception e) {
            throw new RuntimeException("Error");
        }
    }

}
