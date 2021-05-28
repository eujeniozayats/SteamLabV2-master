package projectlab.test;

import framework.BaseTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import projectlab.pages.*;

import java.util.Locale;
import java.util.ResourceBundle;

public class TC_001_DownloadSteamTest extends BaseTest {


    @BeforeClass
    public void before() {
        resourceBundle = ResourceBundle.getBundle(resourceBundlePath, Locale.forLanguageTag(System.getProperty("language")));
    }

    public void runTest() throws Exception {
        logger.step(1);
        MainPage mainPage = new MainPage();
        mainPage.navigateMenu("loc.categories", "loc.genre");

        logger.step(2);
        CategoryPage categoryPage = new CategoryPage();
        categoryPage.findBestDeal();

        logger.step(3);
        GamePage gamePage = new GamePage();
        gamePage.validateIsGamePresent();
        gamePage.clickInstallSteam();

        logger.step(4);
        InstallerPage installerPage = new InstallerPage();
        installerPage.downloadSteamAndVerify();

    }
}
