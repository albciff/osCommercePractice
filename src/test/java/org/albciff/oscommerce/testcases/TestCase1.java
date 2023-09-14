package org.albciff.oscommerce.testcases;

import java.util.ArrayList;
import java.util.stream.Stream;

import org.albciff.oscommerce.processes.PurchaseProcess;
import org.albciff.oscommerce.screens.PaymentInformation.PaymentMethod;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;

import io.github.bonigarcia.wdm.WebDriverManager;


class TestCase1 {
	
	private static WebDriver driver;
	private static ChromeOptions chromeOptions;
	
	public static void createAndStartService() {
		WebDriverManager.chromedriver().setup();
  		ArrayList<String> optionsList = new ArrayList<>();
		chromeOptions = new ChromeOptions();
		optionsList.add("--start-maximized");
		optionsList.add("--incognito");
		optionsList.add("disable-notifications");
		chromeOptions.addArguments(optionsList);
		chromeOptions.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
  		chromeOptions.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
	}
	
	public static void createDriver() {
		driver = new ChromeDriver(chromeOptions);
	}
	
	public static void quitDriver() {
		  driver.quit();
	}

	@BeforeAll
	static void setUpBeforeClass() {
		createAndStartService();	
	}

	@AfterAll
	static void tearDownAfterClass() {
		// aquest mètode és buit pq en aquest moment del test no és 
		// necessari. Però el mantenim per l'estructura i pq si s'afegeixen
		// més tests, pot acabar necessari alguna operació de tearDown
	}

	@BeforeEach
	void setUp() {
		createDriver();
		driver.manage().window().maximize();
		
	}

	@AfterEach
	void tearDown() {
		quitDriver();
	}

    public static Stream<Object> dataSetForPuchaseTest() {      
        return Stream.of(
        		// Test samsung galaxy tab
        		Arguments.of("http://sqademosatp.net/catalog/", "Samsung Galaxy Tab", 2, PaymentMethod.CASH, "oscommerce@gmail.com", "oscommerce"),
        		// Test Beloved
        		Arguments.of("http://sqademosatp.net/catalog/", "Beloved",3, PaymentMethod.CASH, "oscommercee@gmail.com", "oscommerce")		
        );
    }
	
	@ParameterizedTest
	@MethodSource(value = "dataSetForPuchaseTest")
	void purchaseTests(String url, String product, int quantity, PaymentMethod paymentMethod, String userEmail, String userPwd) {
		PurchaseProcess purchaseProcess = new PurchaseProcess(driver, url, product, quantity, paymentMethod, userEmail, userPwd);
		purchaseProcess.executeProcess();
	}
}



