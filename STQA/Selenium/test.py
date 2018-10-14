from selenium import webdriver
browser = webdriver.Firefox()
browser.get('http://google.com/')
searchbox = browser.find_element_by_id('lst-ib')
searchbox.send_keys("Tomorows weather")
search = browser.find_element_by_name('btnK')
search.submit()
print driver.title
browser.quit()
