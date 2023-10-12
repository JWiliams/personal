
# Radio Python Script 🎶 🎶 



This console application was designed to record a long time 
favorite blues show, that only airs on Saturday 
mornings from 6am to 10am (CST). The app first uses selenium to navigate to the blues 
site by way of Firefox. Once there, it finds the play button by its xpath. It clicks it, and 
starts playing audio from the site's livestream. 
Next, the app uses the Pywinauto library to open Audacity recording software and set the recording 
duration. Once set, this activates Audactiy's recording feature and records the audio from the show.


## Libraries used:


    Pyautogui - mouse and clicking of windows of apps
    Selenium- controls automation for browser
    Pywinauto - control keyboard


Pyautogui is a library that allows the app to simulate mouse and keyboard inputs. 
Selenium automates web browsers, allowing the app to interact 
with the website. Pywinauto allows the app to automate Windows 
GUI interactions, such as opening and closing programs. All of these Libraies played an important part
in success of this app



