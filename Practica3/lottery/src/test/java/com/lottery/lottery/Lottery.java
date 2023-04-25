package com.lottery.lottery;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.util.Random;


public class Lottery {
    private static final int MAX_NUMBER = 1_234_000_100;
    public static void main(String[] args){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        int next_number = -1;
        boolean correct_token = false;

        driver.get("https://r1-ctf-vulnerable.numa.host/");
        driver.findElement(By.xpath("//button[text()='Start from scratch']")).click();
        long end = System.currentTimeMillis();
        driver.findElement(By.className("form-control")).sendKeys("1");
        driver.findElement(By.xpath("//button[text()='Check']")).click();

        String number_s = driver.findElement(By.xpath("//ul/il")).getText();
        int number = Integer.parseInt(number_s);

        while (0 < end && !correct_token){
            Random random = new Random(end);
            int current_number = random.nextInt(MAX_NUMBER);
            if (current_number == number){
                correct_token = true;
                next_number = random.nextInt(MAX_NUMBER);
            }
            end--;
        }

        driver.get("https://r1-ctf-vulnerable.numa.host/");
        if (correct_token){
            driver.findElement(By.className("form-control")).
                    sendKeys(Integer.toString(next_number));
            driver.findElement(By.xpath("//button[text()='Check']")).click();
            String flag = driver.findElement(By.tagName("p")).getText();
            System.out.println(flag);
        }
        else{
            System.out.println("FLAG not found");
        }
        driver.quit();
    }
}
