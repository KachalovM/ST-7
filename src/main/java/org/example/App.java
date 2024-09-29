package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class App {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:/GoogleD/chromedriver.exe");
        WebDriver webDriver = new ChromeDriver();
        try {
            webDriver.get("http://www.papercdcase.com/index.php");

            WebElement artistInput = webDriver.findElement(By.xpath("/html/body/table[2]/tbody/tr/td[1]/div/form/table/tbody/tr[1]/td[2]/input"));
            artistInput.sendKeys("Test Artist");

            WebElement titleInput = webDriver.findElement(By.xpath("/html/body/table[2]/tbody/tr/td[1]/div/form/table/tbody/tr[2]/td[2]/input"));
            titleInput.sendKeys("Test Album");

            for (int i = 1; i <= 8; i++) {
                String xpath = String.format("/html/body/table[2]/tbody/tr/td[1]/div/form/table/tbody/tr[3]/td[2]/table/tbody/tr/td[1]/table/tbody/tr[%d]/td[2]/input", i);

                WebElement trackInput = webDriver.findElement(By.xpath(xpath));

                trackInput.sendKeys("Track " + i);
            }

            for (int i = 1; i <= 8; i++) {
                String xpath = String.format("/html/body/table[2]/tbody/tr/td[1]/div/form/table/tbody/tr[3]/td[2]/table/tbody/tr/td[2]/table/tbody/tr[%d]/td[2]/input", i);

                WebElement trackInput = webDriver.findElement(By.xpath(xpath));

                trackInput.sendKeys("Track " + (i + 8));
            }

            WebElement formatA4 = webDriver.findElement(By.xpath("/html/body/table[2]/tbody/tr/td[1]/div/form/table/tbody/tr[4]/td[2]/input[2]"));
            formatA4.click();

            WebElement jewelCase = webDriver.findElement(By.xpath("/html/body/table[2]/tbody/tr/td[1]/div/form/table/tbody/tr[5]/td[2]/input[2]"));
            jewelCase.click();

            WebElement generateButton = webDriver.findElement(By.xpath("/html/body/table[2]/tbody/tr/td[1]/div/form/p/input"));
            generateButton.submit();

            Thread.sleep(5000);

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

    }
}