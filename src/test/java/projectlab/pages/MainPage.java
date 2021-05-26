package projectlab.pages;

import framework.elements.Button;
import org.openqa.selenium.By;

public class MainPage extends BaseSteamPage {

    private static final String targetLanguage = getLocale("loc.langname");

    public MainPage() {
        super(By.xpath("//body[@class='v6 infinite_scrolling responsive_page']"), "MainPage");
        changeLanguage();
    }
    private Button btnGenres(String genre) {
        return new Button(By.xpath(String.format("//div[@class='popup_menu_subheader popup_genre_expand_header responsive_hidden']/a[contains(text(), '%s')]", genre)), "Genre Selection Button");
    }

    private Button menuItems(String menuItem) {
        return new Button(By.xpath(String.format("//a[@class='pulldown_desktop' and text()='%s']", menuItem)), "Menu Item Button");

    }

    private final Button changeLang = new Button(By.id("language_pulldown"), "Change Language Button");


    private final Button btnTargetLanguage = new Button(By.xpath(String.format("//a[contains(@class,'popup_menu_item tight') and contains(text(),'%s')]", targetLanguage)), "Target Language Button");

    public void changeLanguage() {
        if (!changeLang.getText().equals(getLocale("loc.language"))) {
            changeLang.clickAndWait();
            btnTargetLanguage.clickAndWait();
            info(String.format(getLocale("loc.lang.choose"), getLocale("loc.langname")));
        }

    }

    public void navigateMenu(String dropDownMenuLoc, String genreTitleLoc) {
        info(String.format(getLocale("loc.menuItem.choose"), getLocale(dropDownMenuLoc)));
        menuItems(getLocale(dropDownMenuLoc)).clickAndWait();
        info(String.format(getLocale("loc.genre.choose"), getLocale(genreTitleLoc)));
        btnGenres(getLocale(genreTitleLoc)).clickAndWait();

    }

}
