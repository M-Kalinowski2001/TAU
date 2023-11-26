import logging
from time import sleep

from selenium import webdriver
from selenium.webdriver import Keys
from selenium.webdriver.chrome.options import Options as chop
from selenium.webdriver.common.by import By
from selenium.webdriver.firefox.options import Options as ffop

logger = logging.getLogger('selenium')
logger.setLevel(logging.INFO)
ch = logging.StreamHandler()
ch.setLevel(logging.DEBUG)
formatter = logging.Formatter('%(asctime)s - %(name)s - %(levelname)s - %(message)s')
ch.setFormatter(formatter)
logger.addHandler(ch)

DRIVER_NAMES = ['Chrome', 'Firefox']
for driver_name in DRIVER_NAMES:
    if 'Chro' in driver_name:
        logger.info(f'Opening the {driver_name} browser and starting the test')
        chrome_options = chop()
        driver = webdriver.Chrome(options=chrome_options)
    else:
        logger.info(f'Opening the {driver_name} browser and starting the test')
        firefox_options = ffop()
        driver = webdriver.Firefox(options=firefox_options)
    driver.get("https://www.saucedemo.com/")
    logger.info("Logging in")
    driver.find_element(By.ID, "user-name").send_keys("problem_user")
    driver.find_element(By.ID, "password").send_keys("secret_sauce")
    driver.find_element(By.ID, "login-button").click()
    sleep(2)
    try:
        driver.find_element(By.ID, "shopping_cart_container")
        logger.info("User was logged successfuly")
    except:
        logger.error("User was unable to log in")
        driver.close()
    driver.find_element(By.ID, "add-to-cart-sauce-labs-backpack").click()
    driver.find_element(By.ID, "add-to-cart-sauce-labs-fleece-jacket").click()
    driver.find_element(By.ID, "add-to-cart-sauce-labs-onesie").click()
    sleep(2)
    if 3 == driver.find_element(By.CLASS_NAME, "shopping_cart_container").text:
        logger.info("Test successful")
    else:
        logger.error("Error adding products to the cart")

logger.info(f'Closing the {driver_name} browser and ending the test scenario')
driver.close()

sleep(2)


DRIVER_NAMES = ['Chrome', 'Firefox']
for driver_name in DRIVER_NAMES:
    if 'Chro' in driver_name:
        logger.info(f'Opening the {driver_name} browser and starting the test')
        chrome_options = chop()
        driver = webdriver.Chrome(options=chrome_options)
    else:
        logger.info(f'Opening the {driver_name} browser and starting the test')
        firefox_options = ffop()
        driver = webdriver.Firefox(options=firefox_options)

    driver.get('http://www.scrapethissite.com/')
    login_subpage_button = driver.find_element(By.ID, 'nav-login')
    login_subpage_button.click()

    login_input = driver.find_element(By.ID, 'email')
    login_input.send_keys('test123@gmail.com')

    password_input = driver.find_element(By.ID, 'password')
    password_input.send_keys('password123')

    login_button = driver.find_element(By.CLASS_NAME, 'btn-primary')
    login_button.click()

    sleep(2)

logger.info("User was unable to log in, there is no such user")
logger.info(f'End of the test scenario for {driver_name} browser')
driver.close()