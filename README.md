# Selenium Graphwalker 


## Prerequisites

- Java Development Kit (JDK) 8 or later
- Maven 3.5 or later
- ChromeDriver (compatible with your version of Chrome)
- Internet connection to download dependencies

## Setup Instructions

1. **Clone the Repository**:
    ```sh
    git clone https://github.com/komalgc/Selenium-Graphwalker.git
    cd Selenium-Graphwalker
    ```

2. **Install Dependencies**:
   Ensure Maven is installed and then run below command so that it generates interface under from models that are placed in the folder src/main/resources. :
    ```sh
    mvn clean install
    ```

   The interface will be generated into: `target/generated-sources/graphwalker/com/Wiki/Wikilogin.java`


3. **Configure ChromeDriver**:
   Download the ChromeDriver that matches your Chrome browser version from [here](https://sites.google.com/a/chromium.org/chromedriver/downloads) and place it in the `src/main/resources/drivers/` directory.


4. **Set Environment Variable**:
   Ensure the path to ChromeDriver is set correctly in the `WikiTest.java` file:
    ```sh
    System.setProperty("webdriver.chrome.driver", "C:\\path\\to\\chromedriver.exe");
    ```

5. **Running the Tests**:

   ```sh
   Run your WikiTest.java Test file
   ```

Built by komal :sparkles:
