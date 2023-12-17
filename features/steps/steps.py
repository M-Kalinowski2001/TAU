import logging
from behave import given, when, then
from selenium import webdriver
from selenium.webdriver.common.by import By
from time import sleep

logger = logging.getLogger('selenium')
logger.setLevel(logging.INFO)
ch = logging.StreamHandler()
ch.setLevel(logging.DEBUG)
formatter = logging.Formatter('%(asctime)s - %(name)s - %(levelname)s - %(message)s')
ch.setFormatter(formatter)
logger.addHandler(ch)

@given('the user is on the Saucedemo website using "{browser}"')
def step_open_saucedemo_website(context, browser):
    if 'Chro' in browser:
        logger.info(f'Opening the Chrome browser and starting the test')
        chrome_options = webdriver.ChromeOptions()
        context.driver = webdriver.Chrome(options=chrome_options)
    else:
        logger.info(f'Opening the Firefox browser and starting the test')
        firefox_options = webdriver.FirefoxOptions()
        context.driver = webdriver.Firefox(options=firefox_options)

    context.driver.get("https://www.saucedemo.com/")

@when('the user logs in with username "{username}" and password "{password}"')
def step_login(context, username, password):
    context.driver.find_element(By.ID, "user-name").send_keys(username)
    context.driver.find_element(By.ID, "password").send_keys(password)
    context.driver.find_element(By.ID, "login-button").click()
    sleep(2)

@when('the user adds products to the cart')
def step_add_to_cart(context):
    context.driver.find_element(By.ID, "add-to-cart-sauce-labs-backpack").click()
    context.driver.find_element(By.ID, "add-to-cart-sauce-labs-fleece-jacket").click()
    context.driver.find_element(By.ID, "add-to-cart-sauce-labs-onesie").click()
    sleep(2)

@then('the cart should contain {item_count} items')
def step_check_cart(context, item_count):
    cart_count = int(context.driver.find_element(By.CLASS_NAME, "shopping_cart_container").text)
    assert cart_count == int(item_count), f"Expected {item_count} items in the cart, but found {cart_count} items."


@given('the user is on the Scrapthissite website using "{browser}"')
def step_open_saucedemo_website(context, browser):
    if 'Chro' in browser:
        logger.info(f'Opening the Chrome browser and starting the test')
        chrome_options = webdriver.ChromeOptions()
        context.driver = webdriver.Chrome(options=chrome_options)
    else:
        logger.info(f'Opening the Firefox browser and starting the test')
        firefox_options = webdriver.FirefoxOptions()
        context.driver = webdriver.Firefox(options=firefox_options)

    context.driver.get("http://www.scrapethissite.com/")

@when('the user attempts to log in with invalid credentials')
def step_login_invalid_credentials(context):
    context.driver.get('http://www.scrapethissite.com/')
    login_subpage_button = context.driver.find_element(By.ID, 'nav-login')
    login_subpage_button.click()

    login_input = context.driver.find_element(By.ID, 'email')
    login_input.send_keys('invalid_user')

    password_input = context.driver.find_element(By.ID, 'password')
    password_input.send_keys('invalid_password')

    login_button = context.driver.find_element(By.CLASS_NAME, 'btn-primary')
    login_button.click()

    sleep(2)

@then('the user should not be able to log in')
def step_check_invalid_login(context):
    assert context.driver.current_url != 'URL_AFTER_SUCCESSFUL_LOGIN', "User logged in with invalid credentials."
