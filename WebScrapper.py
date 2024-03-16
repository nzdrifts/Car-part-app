import requests
from bs4 import BeautifulSoup

import re

def ScrapeWebsite(carModelList):
    # URL of the website to scrape
    url = "https://www.pickapart.co.nz/Avondale-Stock"
    # Send an HTTP GET request to the website
    response = requests.get(url)
    # Parse the HTML code using BeautifulSoup
    soup = BeautifulSoup(response.content, 'html.parser')

    for car in carModelList:
        if soup.find_all(string=re.compile(car)): #checks to see if list is no empty
            print(soup.find_all(string=re.compile(car)))
    return



carsToSearchFor = ["Maxima", "Altima", "GT-R", "370z", "Murano"]
ScrapeWebsite(carsToSearchFor)
