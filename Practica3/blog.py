from selenium import webdriver
from collections import deque
import re
from selenium.webdriver.common.by import By


def links_bfs():
    q = deque()
    visited = set()
    total_count = 0
    start = "https://r2-ctf-vulnerable.numa.host/"
    regex = r'\bURJC\b'
    visited.add(start)
    q.append(start)
    while q:
        name = q.popleft()
        driver.get(name)
        count = len(re.findall(regex, driver.page_source))
        total_count += count
        links = driver.find_elements(By.XPATH, "//h2[contains(@class,'card-title')]/a")
        for next_link in links:
            next_name = next_link.get_attribute("href")
            if next_name not in visited:
                visited.add(next_name)
                q.append(next_name)
    print(total_count)


if __name__ == '__main__':

    driver = webdriver.Chrome()
    driver.maximize_window()
    links_bfs()
    driver.quit()