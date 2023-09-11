package framework.elements;

import org.openqa.selenium.By;

public class WebTableInventory extends WebTable{
    private final String ITEM_NAME_LOCATOR = "//tbody//td//span[not(@class)]";
    private final String OBJECT_TYPE_LOCATOR = "//tbody//td//span[contains(@class,'multi')]";
    private final String STATUS_LOCATOR = "//tbody//td//span[contains(@class,'status')]";
    private final String CURRENT_STOCK_LEVEL_LOCATOR = "//tbody//td[contains(@class,'stock')]";
    private final String LOW_STOCK_LEVEL_LOCATOR = "//tbody//td[contains(@class,'low')]";
    private final String VIEW_LOCATOR = "//tbody//td[contains(@class,'camera')]";
    private final String CAMERA_LOCATOR = "//tbody//td[contains(@class,'camera')]";
    private final String SETTINGS_LOCATOR = "//tbody//td[contains(@class,'settings')]";

    public WebTableInventory(By locator, String name) {
        super(locator, name);
    }
}
