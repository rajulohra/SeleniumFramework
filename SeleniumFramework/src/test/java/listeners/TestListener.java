package listeners;

import org.testng.*;
import io.qameta.allure.*;
import java.io.*;
import org.openqa.selenium.*;

public class TestListener extends TestListenerAdapter {

    @Attachment(value = "Screenshot", type = "image/png")
    public byte[] saveScreenshot(WebDriver driver) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    @Override
    public void onTestFailure(ITestResult result) {
        WebDriver driver = base.BaseTest.driver;
        saveScreenshot(driver);
    }
}