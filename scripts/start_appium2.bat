@echo off


appium server  -p 4723 -a 127.0.0.1 -pa /wd/hub
 --relaxed-security
--allow-cors
 --allow-insecure=adb_shell  
 
 


pause
