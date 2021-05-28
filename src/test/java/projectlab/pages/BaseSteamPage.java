package projectlab.pages;

import framework.BasePage;
import framework.elements.Button;
import org.openqa.selenium.By;


public class BaseSteamPage extends BasePage {

    private Button btnInstallSteam = new Button(By.xpath("//div[@class='header_installsteam_btn header_installsteam_btn_green']"), "Header Install Steam Button");

    public BaseSteamPage(By locator, String pageTitle) {
        super(locator, pageTitle);
    }

    public void clickInstallSteam() {
        btnInstallSteam.clickAndWait();
    }
}
