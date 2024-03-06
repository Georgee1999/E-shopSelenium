package com.example.eshopselenium.testComponents;

import com.example.eshopselenium.pageObjects.LandingPage;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

public class BaseTest {

    WebDriver driver;
    public LandingPage landingPage;

    public WebDriver initializeDriver() throws IOException {
        //Properties class
        Properties properties = new Properties();
        FileInputStream fis = new FileInputStream("C:\\Users\\jkvarda\\Desktop\\Selenium\\E-shopSelenium\\src\\main\\resources\\application.properties");
        properties.load(fis);

        String browserName = System.getProperty("browser") != null ? System.getProperty("browser") : properties.getProperty("browser");

        if (browserName.contains("chrome")) {
            ChromeOptions options = new ChromeOptions();
           // if (browserName.contains("headless")) {
           //     options.addArguments("headless");
           // }
            driver = new ChromeDriver(options);
            driver.manage().window().maximize();//.setSize(new Dimension(1440,900));// Fullscreen
        } else if (browserName.equals("firefox")) {
            //Firefox
        } else if (browserName.equals("edge")) {
            //Edge
            driver = new EdgeDriver();
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        return driver;
    }

    public List<HashMap<String, String>> getJsonDataToMap(String filePath) throws IOException {

        // reading json to string
        String jsonContent = FileUtils.readFileToString(new File(filePath),
                StandardCharsets.UTF_8);

        // String to Hashmap  (Jackson Databind)
        ObjectMapper mapper = new ObjectMapper();
        List<HashMap<String, String>> data = mapper.readValue(jsonContent, new TypeReference<List<HashMap<String, String>>>() {
        });

        return data;
    }

    @BeforeMethod(alwaysRun = true)
    public LandingPage launchApplication() throws IOException {

        driver = initializeDriver();
        landingPage = new LandingPage(driver);
        landingPage.goTo();
        return landingPage;
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driver.close();
    }
}
