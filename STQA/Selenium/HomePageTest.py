import unittest
from selenium import webdriver
from selenium.common.exceptions import NoSuchElementException
from selenium.webdriver.common.by import By

class HomePageTest(unittest.TestCase):
    @classmethod
    def setUp(inst):
        # create a new Firefox session """
        inst.driver = webdriver.Firefox()
        inst.driver.implicitly_wait(30)
        inst.driver.maximize_window()

        # navigate to the application home page """
        inst.driver.get("http://www.google.com/")

    def test_search_box(self):
        # check search box exists on Home page
        self.assertTrue(self.is_element_present(By.NAME,"q"))

    def test_language_settings(self):
        # check language options on Home page
        self.assertTrue(self.is_element_present(By.ID,"SIvCob"))

    def test_images_link(self):
        # check images link on Home page
        images_link = self.driver.find_element_by_link_text("Images")
        images_link.click()
        # check search field exists on Images page
        self.assertTrue(self.is_element_present(By.NAME,"q"))
        self.search_field = self.driver.find_element_by_name("q")
        # enter search keyword and submit
        self.search_field.send_keys("Selenium Webdriver framework architecture diagram")
        self.search_field.submit()

    @classmethod
    def tearDown(inst):
        # close the browser window
        inst.driver.quit()

    def is_element_present(self, how, what):
        """
        Helper method to confirm the presence of an element on page
        :params how: By locator type
        :params what: locator value
        """
        try: self.driver.find_element(by=how, value=what)
        except NoSuchElementException: return False
        return True
