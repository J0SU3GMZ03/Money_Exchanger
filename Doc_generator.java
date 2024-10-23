import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Doc_generator {

    public void save_json(List<Exchange> exchanges) throws IOException {
        Gson gson = new GsonBuilder()
                .setPrettyPrinting().create();

        FileWriter write = new FileWriter("Exchanges.json");
        write.write(gson.toJson(exchanges));
        write.close();

    }
}
