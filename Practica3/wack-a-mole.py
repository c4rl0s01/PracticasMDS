from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support.wait import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC
import time


def wack_a_mole(driver):
    driver.get("http://localhost")

    puntos = WebDriverWait(driver, 15).until(EC.presence_of_element_located((By.ID, "score")))
    while int(puntos.text) < 10001:
        try:
            topo = driver.find_element(By.CLASS_NAME, "mole")
            topo.click()
        except:
            pass

    flag = driver.find_element(By.ID, "flag")
    flag = flag.text

    print(str(flag))



if __name__ == '__main__':
    driver = webdriver.Chrome()
    wack_a_mole(driver)
    driver.quit()