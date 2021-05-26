package projectlab.pages;

import framework.elements.Button;
import org.openqa.selenium.By;

public class MainPage extends BaseSteamPage {

    private static final String targetLanguage = getLocale("loc.langname");
    private static final String genreLocator = "//div[@class='popup_menu_subheader popup_genre_expand_header responsive_hidden']/a[contains(text(), '%s')]";
    private static final String menuLocator = "//a[@class='pulldown_desktop' and text()='%s']";

    public MainPage() {
        super(By.xpath("//body[@class='v6 infinite_scrolling responsive_page']"), "MainPage");
        changeLanguage();
    }

    private final Button btnChangeLang = new Button(By.id("language_pulldown"), "Change Language Button");

    private final Button btnTargetLanguage = new Button(By.xpath(String.format("//a[contains(@class,'popup_menu_item tight') and contains(text(),'%s')]", targetLanguage)), "Target Language Button");

    public void changeLanguage() {
        if (!btnChangeLang.getText().equals(getLocale("loc.language"))) {
            btnChangeLang.clickAndWait();
            btnTargetLanguage.clickAndWait();
            info(String.format(getLocale("loc.lang.choose"), getLocale("loc.langname")));
        }

    }

    public void navigateMenu(String dropDownMenuLoc, String genreTitleLoc){
        Button btnGenreTitle = new Button(By.xpath(String.format(genreLocator, (getLocale(genreTitleLoc)))), "Genre Title Button");
        Button btnMenuItem = new Button(By.xpath(String.format(menuLocator, (getLocale(dropDownMenuLoc)))), "Menu Item Button");
        btnMenuItem.clickAndWait();
        btnGenreTitle.clickAndWait();
    }


}
