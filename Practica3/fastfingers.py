from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support.wait import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC
import time



def fastfingers(driver):
    driver.get("http://localhost")
    time.sleep(5)
    #Hay un contenedo que contiene to el texto a teclear
    palabras = driver.find_element(By.ID, "textDisplay").text
    clickear = driver.find_element(By.CLASS_NAME, "text-input")

    clickear.send_keys(palabras)
    clickear.send_keys(" ")
    time.sleep(10) #10 segundos pa ver la flag xd




if __name__ == '__main__':

    driver = webdriver.Chrome()
    fastfingers(driver)
    driver.quit()