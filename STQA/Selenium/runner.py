import unittest
import HTMLTestRunner
import os
#import SearchText
#import HomePageTest
from SearchText import SearchText
from HomePageTest import HomePageTest

# get the directory path to output report file
dir = os.getcwd()

# get all tests from SearchText and HomePageTest class
search_text = unittest.TestLoader().loadTestsFromTestCase(SearchText)
home_page_test = unittest.TestLoader().loadTestsFromTestCase(HomePageTest)

# create a test suite combining search_text and home_page_test
test_suite = unittest.TestSuite([home_page_test, search_text])

# open the report file
outfile = open("SeleniumPythonTestSummary.html", "w")

# configure HTMLTestRunner options
runner = HTMLTestRunner.HTMLTestRunner(stream=outfile,title='Test Report', description='Acceptance Tests')

# run the suite using HTMLTestRunner
runner.run(test_suite)


#Terminal Verbose
unittest.TextTestRunner(verbosity=2).run(test_suite)
