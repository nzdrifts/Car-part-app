import requests
from bs4 import BeautifulSoup

import re
def ScrapeWebsite(carModel):
    # URL of the website to scrape
    url = "https://www.pickapart.co.nz/Avondale-Stock"
    # Send an HTTP GET request to the website
    response = requests.get(url)
    # Parse the HTML code using BeautifulSoup
    soup = BeautifulSoup(response.content, 'html.parser')


    return soup.find_all(string=re.compile(carModel))


carsToSearchFor = ["Maxima", "Altima", "GT-R", "370z", "Murano"]
for car in carsToSearchFor:
    print(ScrapeWebsite(car))