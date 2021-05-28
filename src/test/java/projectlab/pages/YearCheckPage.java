package projectlab.pages;

import framework.elements.Button;
import framework.elements.Label;
import org.openqa.selenium.By;

public class YearCheckPage extends BaseSteamPage {

    private static final String yearVal = "1";

    private static Label lblGameName = new Label(By.xpath("//div[@class='apphub_AppName']"), "Name");
    private static Button btnSetYear = new Button(By.id("ageYear"), "Set Year Button");
    private static Button btnClickViewPage = new Button(By.xpath(String.format("//span[text()='%s']", getLocale("loc.openpage"))), "View Page");

    public YearCheckPage() {
        super(By.xpath("//body[@class='v6 app game_bg responsive_page']"), "Year Check");
        passAge();
        info(getLocale("loc.gamename") + lblGameName.getText());
    }

    public void passAge() {
        if (btnClickViewPage.isPresent()) {
            btnSetYear.clickAndWait();
            btnSetYear.sendKeys(yearVal);
            btnClickViewPage.clickAndWait();
        }
    }
}
