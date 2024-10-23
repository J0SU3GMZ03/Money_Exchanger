import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner read = new Scanner(System.in);
        Exchange_money exchange_money = new Exchange_money();

        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy
                        .UPPER_CAMEL_CASE).setPrettyPrinting()
                .create();

        List<Exchange> exchanges = new ArrayList<>();

        int option = 0;

        while (option != 1) {
            System.out.println("**************** Currency Codes ************************");
            System.out.println("ARS - Argentine Peso");
            System.out.println("BOB - Bolivian Boliviano");
            System.out.println("BRL - Brazilian Real");
            System.out.println("CLP - Chilean Peso");
            System.out.println("COP - Colombian Peso");
            System.out.println("USD - United States Dollar");
            System.out.println("*******************************************************+");

            try {
                System.out.println("Introduce your base currency code");
                var base_code = read.nextLine();
                System.out.println("Introduce your target currency code");
                var target_code = read.nextLine();
                System.out.println("Introduce the amount");
                var amount = read.nextDouble();
                read.nextLine();
                Exchange exchange = exchange_money.exchange_money(base_code, target_code, amount);
                exchanges.add(exchange);
                System.out.println(exchange);

                Doc_generator generator = new Doc_generator();
                generator.save_json(exchanges);
            } catch (RuntimeException | IOException e){
                System.out.println(e.getMessage());
                System.out.println("Closing the program");
            }

            System.out.println("Process completed, If you want to continue, " +
                    "please press 0, otherwise press 1");
            option = read.nextInt();
            read.nextLine();

        }

    }
}