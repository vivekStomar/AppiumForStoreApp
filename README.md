# Hi 👋🏻, UI Automation using Appium for Store Application for Android and iOS 

## Tools, Technology and Programming Language

- Build System : Gradle
- Autmation Framwork : Appium
- Programming Language : Java
- Platform Supported : Android

## Pre setup

- Follow setup steps for:
  - Setup Java - https://www.java.com/en/download/help/mac_install.html
  - Install NodeJS - https://nodesource.com/blog/installing-nodejs-tutorial-mac-os-x/
  - Install Appium - https://appium.io/docs/en/2.0/quickstart/install/
  - Install Gradle - https://gradle.org/install/
  - Install AndroidStudio - https://developer.android.com/studio/install
  
  - Additiona refrences: 
    https://appium.io/docs/en/2.11/quickstart/
    https://automationhacks.io/slides/2021/appium-conf/hello-appium-writing-your-first-tests/04-common-libraries/ (refrence that I followed)
  

## Pre setup

- Store.apk can be located at root of the project
- android-caps.json for android capabilities
- env.properties.properties for default properties
- *Test.java conains test scenarios
- steps/* contains different definations for operations performed in individual scenaio and assertions that can be performed on individual screens.
- screens/* contains operation that can be performed on UI elements in individual screen.
- core/* contains core implementation which used through the project


## Run Android tests

```zsh
  gradle wrapper
 ./gradlew clean build runTests -Dtag="<any-available-tag>" -Dtarget="ANDROID"
```
example ./gradlew clean build runTests -Dtag="PLACE_ORDER" -Dtarget="ANDROID"

if target property is missing than target mentioned at env.properties would be used.
