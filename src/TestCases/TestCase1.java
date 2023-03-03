package TestCases;

import java.io.IOException;
import java.util.ArrayList;
import java.util.stream.Stream;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;

import Processes.Process;
import Processes.PurchaseProcess;
import Screens.PaymentInformation.PaymentMethod;
import io.github.bonigarcia.wdm.WebDriverManager;


class TestCase1 {
	
	private static WebDriver driver;
	private static ChromeOptions chromeOptions;
	private Process process; 
	
	public static void createAndStartService() throws IOException {
		WebDriverManager.chromedriver().setup();
  		ArrayList<String> optionsList = new ArrayList<String>();
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
	static void setUpBeforeClass() throws Exception {
		createAndStartService();	
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {}

	@BeforeEach
	void setUp() throws Exception {
		createDriver();
		driver.manage().window().maximize();
		
	}

	@AfterEach
	void tearDown() throws Exception {
		quitDriver();
	}

	
    public static Stream<Object> dataSetForPuchaseTest() {      
        return Stream.of(
        		// Test samsung galaxy tab
        		Arguments.of("http://sqademosatp.net/catalog/", "Samsung Galaxy Tab",2, PaymentMethod.cod ),
        		// Test Beloved
        		Arguments.of("http://sqademosatp.net/catalog/", "Beloved",3, PaymentMethod.cod )		
        );
    }
	
	@ParameterizedTest
	@MethodSource(value = "dataSetForPuchaseTest")
	void purchaseTests(String url, String product, int quantity, PaymentMethod paymentMethod) {
		PurchaseProcess purchaseProcess = new PurchaseProcess(driver, url, product, quantity, paymentMethod);
		purchaseProcess.executeProcess();
	}
}



