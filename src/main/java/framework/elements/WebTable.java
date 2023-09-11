package framework.elements;

import framework.utils.SmartLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public abstract class WebTable extends BaseElement {
    private final String HEAD_ROW_LOCATOR = "//thead//tr";
    private final String HEAD_CELL_LOCATOR = "./th";
    private final String BODY_CELL_LOCATOR = "./td";
    private String BODY_ROW_LOCATOR = "//tbody//tr";
    private List<List<String>> body;
    private List<List<String>> head;

    public WebTable(By locator, String name) {
        super(locator, name);
    }

    public List<List<String>> getHeadListText() {
        if (head == null)
            head = this.getListMultiRowElementsText(By.xpath(HEAD_ROW_LOCATOR), By.xpath(HEAD_CELL_LOCATOR));
        return head;
    }

    public List<List<String>> getBodyListText() {
        if (body == null)
            body = this.getListMultiRowElementsText(By.xpath(BODY_ROW_LOCATOR), By.xpath(BODY_CELL_LOCATOR));
        return body;
    }

    public List<List<String>> getListMultiRowElementsText(By rowLocator, By rowCellLocator) {
        List<List<String>> listMultiRowElementsText = new ArrayList<>();
        List<WebElement> rows = new ArrayList<>();
        rows = this.findChildElements(rowLocator);
        rows.forEach(row -> listMultiRowElementsText.add(getListRowElementsText(row, rowCellLocator)));

        return listMultiRowElementsText;
    }

    private List<String> getListRowElementsText(WebElement row, By rowCellLocator) {
        List<WebElement> rowCells = new ArrayList<>();
        try {
            rowCells = row.findElements(rowCellLocator);
        } catch (Exception | Error ex) {
            SmartLogger.logError("Don't find child with locator: " + rowCellLocator.toString());
        }

        List<String> listRowElementsText = new ArrayList<>();
        rowCells.forEach(rowCell -> listRowElementsText.add(rowCell.getText()));

        return listRowElementsText;
    }
}
