import unittest
from SeleniumPythonRefactorTestCase import SearchText
from SeleniumPythonMultipleTests import HomePageTest

# get all tests from SearchText and HomePageTest class
search_text = unittest.TestLoader().loadTestsFromTestCase(SearchText)
home_page_test = unittest.TestLoader().loadTestsFromTestCase(HomePageTest)

# create a test suite combining search_text and home_page_test
test_suite = unittest.TestSuite([home_page_test, search_text])

# run the suite
unittest.TextTestRunner(verbosity=2).run(test_suite)
