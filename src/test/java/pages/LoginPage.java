
package pages;

import org.openqa.selenium.WebDriver;


    public class LoginPage {
        private WebDriver driver;
        private String url = "https://www.saucedemo.com/";

        public LoginPage(WebDriver driver) {
            this.driver = driver;
        }

        public void openLoginPage() {
            driver.get(url);
        }
    }
