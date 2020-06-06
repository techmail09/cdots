# cdots

[![CDOTS Demo](https://img.youtube.com/vi/HTRjLrACOg8/maxresdefault.jpg)](https://www.youtube.com/watch?v=HTRjLrACOg8)

# Overview
The purpose of this program is to volunteer and support people during this Pandemic (COVID-19) which has rendered many people to seek support. This app can be used as a digital platform to connect people requiring support with the volunteers. 

The platform acts as centralized monitoring system to bring people together to overcome the pandemic situation by reaching out to support each other during this New Normal.

# Description

During COVID Pandemic some of the issues faced are mentioned here - 

People in need of food/medicines/other essentials –  Volunteers willing to help need a platform to reach out to people looking for support.  To provide the required support to the people, this app can be used as a platform for people seeking support to send a request that can be viewed by the volunteer and help can be provided in time.

Senior Citizens/differently abled in need of support -  As an example, there are many senior citizens and differently abled people who are at high risk of exposure to the infection and cannot venture out to get their supplies can reach out to the volunteers for help.  

# Scope of the App

- Connecting people within a geographical area
- Catering to the necessities like Food, Groceries, Medicines
- Maintaining social distancing by facilitating time slots for collecting the necessities
- Update Government directives/instructions – travel updates, ration updates, etc, through SMS.  Regional language options can be provided

# Solution Roadmap
- Business model – This is a service based app connecting people and not profit based
- Funding needs – Service based and non-profitable app
- Sustainability plan – This app can be used to connect helping hands (volunteers) with the people who want to use the services

# Setup the database
```
Create cloudant database manually with 1 db "quickhelp"
```

# Setup the backend

Edit the cloudant connection string & credentials to access db 
```
cd cdots-backend/
pip install -r requirements.txt
  ```

Run the backend app.
  ```
python app.py
  ```

# Run the android app on your mobile phone

Edit the backend connection string
```
Compile the apk & setup in your android device.
```


