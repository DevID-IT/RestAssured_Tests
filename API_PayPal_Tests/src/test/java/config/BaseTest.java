package config;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class BaseTest {
    public static Properties config = new Properties();

    @BeforeSuite(alwaysRun = true)
    public void setUp() {
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
    }

    @AfterSuite
    public void tearDown() {

    }
}
