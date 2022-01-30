# Project-Factsparrow
for upload image we need to add static folder in classpath
for gettting class path need to maven clean install
inside target>>class create a stataic folder and inside static folder create photo folder
target>>class>>static>>photo here images will appear as we mentioned this path in Sign up service

json body for save user data 
{
    "email": "mohitchaiser@gmail.com",
    "password": "0298",
    "firstName": "mohit",
    "lastName": "Singh",
    "address": {
        "houseNo": "chasier bhawan",
        "colonyName": "Bhagwati enclave",
        "area": "Gobindpur garwal",
        "city": "Haldawani",
        "district": "Nainital",
        "state": "Uttarakhand",
        "country": "India"
    },
    "mobileNo": "9458595189"
}

![FactSparrow](https://user-images.githubusercontent.com/85048174/148967077-0aa5627a-dc04-4a1b-9f38-34f7598fd97a.jpg)

**aws links**

**1. backend links:** 
save new -->(post) http://fact1-env.eba-fdyeurck.ap-south-1.elasticbeanstalk.com/api/signUp/saveNewUser
![image](https://user-images.githubusercontent.com/85048174/151709208-60d40351-2a86-4b0a-8a6e-1ba76cea354e.png)


upload image---> (post) http://fact1-env.eba-fdyeurck.ap-south-1.elasticbeanstalk.com/api/signUp/uploadDp
![image](https://user-images.githubusercontent.com/85048174/151708977-0982015e-10a4-417c-93df-c8232e096510.png)

getDp-->http://fact1-env.eba-fdyeurck.ap-south-1.elasticbeanstalk.com/api/signUp/getDp/ishwar@gmail.com
![image](https://user-images.githubusercontent.com/85048174/151709033-4b1b3482-81f5-46fa-8336-60bd17b3ca19.png)

**2. UI Links:**
auth code: http://fact-ui.s3-website.ap-south-1.amazonaws.com/

login profile: http://profilefs1.s3-website.ap-south-1.amazonaws.com/

