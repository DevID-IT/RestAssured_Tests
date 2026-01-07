package CucumberBDD.base;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class BaseTestBDD {
    public static Properties config = new Properties();
    public static Response response;
    public static String client_id;
    public static String secret;
    public static String access_token;

    public static void init() {
        RestAssured.filters(new AllureRestAssured());

        FileInputStream fis;
        try {
            fis = new FileInputStream("./src/test/resources/properties/config.properties");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        try {
            config.load(fis);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        RestAssured.baseURI = config.getProperty("baseURI");
        client_id = config.getProperty("paypalClientID");
        secret = config.getProperty("paypalSecret");
    }
}
