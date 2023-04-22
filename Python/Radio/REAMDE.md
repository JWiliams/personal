#Radio Python Script

This app was designed to record a long time 
favorite blues show, that only airs on Saturday 
mornings from 6am to 10am. The app first uses selenium to navigate to the blues 
site. Once there, it finds the play button by its xpath. Clicks it, and 
starts playing audio from the site's livestream. 
Next, the app uses pywinauto to open Audacity recording software and set the recording 
duration. Once set, the app starts recording the audio from the show.

##Libraries used:
    Pyautogui - mouse and clicking of windows of apps
    selenium- controls automation for browser
    pywinauto - control keyboard


Pyautogui is a library that allows the app to simulate mouse and keyboard inputs. 
Selenium is a library that automates web browsers, allowing the app to interact 
with the website. Pywinauto is a library that allows the app to automate Windows 
GUI interactions, such as opening and closing programs.


