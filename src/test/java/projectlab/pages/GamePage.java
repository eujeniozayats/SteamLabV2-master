package projectlab.pages;

import framework.elements.Label;
import org.openqa.selenium.By;


public class GamePage extends BaseSteamPage {

    private static final Label lblGameName = new Label(By.xpath("//div[@class='apphub_AppName']"), "Name");

    public GamePage() {
        super(By.xpath("//body[@class='v6 app game_bg responsive_page']"), "GamePage");
        YearCheckPage yearCheckPage = new YearCheckPage();
        yearCheckPage.passAge();
        info(getLocale("loc.gamename") + lblGameName.getText());
    }

    public void validateIsGamePresent() {
        lblGameName.isPresent();
    }
}


