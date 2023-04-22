import datetime
import time
import subprocess
import pyautogui
import os

import math
from datetime import timedelta
from selenium import webdriver
from pywinauto import Application, keyboard
from pathlib import path
from selenium.webdriver.common.action_chains import ActionChains
from selenium.webdriver.common.by import By
from selenium.webdriver.chrome.service import Service

def thisSaturday(aDay):
    theDaysOfWeek = []
    start = 0
    end = 7
    endingTime = aDay + timedelta(hours=4.0)
    if aDay.strftime("%A") == "Saturday" and datetime.datetime.now().strftime("%H") > endingTime.strftime("%H"):
        # adding one allows to skip the saturday(or day) morning show already ran
        start = 1
        end += 1

    for weekday in range(start, end):
        #thisVariable = thisVariable
        theDaysOfWeek.append(aDay + timedelta(1*weekday))

    saturday = []
    # print(theDaysOfWeek)
    n = len(theDaysOfWeek)
    while (n != 0):
        for bluesSaturday in theDaysOfWeek:
            # p = bluesSaturday.strftime("%A") !!!MIGHT DELETE

            if bluesSaturday.strftime("%A") == "Saturday":

                # saturday.append(bluesSaturday.strftime("%m:%d:%Y"))
                return bluesSaturday
            else:
                n -= 1
    print("There is no Saturday")


def kixie():
 
    #s = Service(PATH)

    driver = webdriver.Firefox()
    fw = pyautogui.getActiveWindow()
    driver.get("https://www.alphamediaplayer.com/kixie107")

    em = driver.find_element(By.XPATH, '//*[@id="track-play-pause"]')

    time.sleep(10)
    pyautogui.move(5, 3)

    actions = ActionChains(driver)
    actions.click(em).perform()
    time.sleep(15)
    fw = pyautogui.getActiveWindow()
    fw.minimize()


def record():
    homeDir = Path.home() # Returns Path object of home directory 
    app = Application(backend="uia").start("C:\Program Files\Audacity\Audacity.exe")
    time.sleep(10)
    

    if (type(app.windows()) == list):

        app.windows()[0].type_keys("r", vk_packet=False) # starts recordeing
    else:
        print("What happend?!")

    # time.sleep(5)
    # pyautogui.click(audacity[0].center)
    # pyautogui.hotkey('r')  # records
    time.sleep(14700)  # Will record for 4 hours, value should be 14700 seconds
    app.windows()[0].maximize()
    time.sleep(2)
    keyboard.send_keys("{VK_SPACE}") # stops recording



today = datetime.datetime.now()
improvedToday = today.replace(hour=5, minute=55)

PATH = "C:\\Program Files (x86)\\geckodriver.exe"

# Returns a Datetime object of the nearest saturday
sat = thisSaturday(improvedToday)


# while datetime.datetime.now() < sat:

#     print("Are you ready for sum Blues!? Me too!\nSaturday Morning Blues Workshop will begin in:")
#     # needs to be print( sat - datetime.datetime.now() )
#     print(sat - datetime.datetime.now())
#     time.sleep(1)
#     os.system('cls')



kixie()
record()
