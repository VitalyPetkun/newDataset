package framework.elements;

import framework.browser.Browser;
import framework.utils.WaiterUtils;
import org.openqa.selenium.*;
import framework.utils.SmartLogger;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public abstract class BaseElement {

    private By locator;

    private String elementName;

    protected BaseElement(By locator, String elementName) {
        this.locator = locator;
        this.elementName = elementName;
    }

    public Dimension getSize() {
        return this.findElement().getSize();
    }

    public Point getLocation() {
        return this.findElement().getLocation();
    }

    public void click() {
        SmartLogger.logInfo("Click " + elementName + ".");
        try {
            WebElement element = WaiterUtils.elementToBeClickable(locator);
            ((JavascriptExecutor) Browser.getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
            element.click();
        } catch (Exception | Error ex) {
            SmartLogger.logError("Don't click " + elementName + " with locator: " + locator);
        }
    }

    public void clickAndClear() {
        this.click();
        this.findElement().clear();
    }

    public boolean isPresent() {
        return this.findElements().size() > 0;
    }

    public boolean invisible() {
        return this.findElementsWithoutWait().size() == 0;
    }

    public void focus() {
        SmartLogger.logInfo("Focus " + elementName + ".");
        try {
            WebElement element = WaiterUtils.visibilityOfElementLocated(locator);
            ((JavascriptExecutor) Browser.getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
            ((JavascriptExecutor) Browser.getDriver()).executeScript("arguments[0].focus();", element);
        } catch (Exception | Error ex) {
            SmartLogger.logError("Don't focus " + elementName + " with locator: " + locator);
        }
    }

    public int sizeList() {
        return this.findElements().size();
    }

    public void loadFile(String filePath) {
        this.findElement().sendKeys(filePath);
    }

    public String getAttribute(String attribute) {
        return this.findElement().getAttribute(attribute);
    }

    public String getText() {
        return this.findElement().getText();
    }

    public String getTextElementForListElements(int index) {
        return this.findElements().get(index).getText();
    }

    public String getElementName() {
        return elementName;
    }

    public By getLocator() {
        return locator;
    }

    protected WebElement findElement() {
        WebElement element = null;
        try {
            element = WaiterUtils.visibilityOfElementLocated(locator);
        } catch (Exception | Error ex) {
            SmartLogger.logError("Don't find " + elementName + " with locator: " + locator);
        }

        return element;
    }

    protected List<WebElement> findElements() {
        List<WebElement> elements = new ArrayList<>();
        try {
            WebElement element = WaiterUtils.visibilityOfElementLocated(locator);
            elements = Browser.getDriver().findElements(locator);
        } catch (Exception | Error ex) {
            SmartLogger.logError("Don't find " + elementName + " with locator: " + locator);
        }

        return elements;
    }

    protected List<WebElement> findElementsWithoutWait() {
        List<WebElement> elements = new ArrayList<>();
        try {
            elements = Browser.getDriver().findElements(locator);
        } catch (Exception | Error ex) {
            SmartLogger.logError("Don't find " + elementName + " with locator: " + locator);
        }

        return elements;
    }

    protected List<WebElement> findChildElements(By childLocator) {
        List<WebElement> childElements = new ArrayList<>();
        try {
            childElements = this.findElement().findElements(childLocator);
        } catch (Exception | Error ex) {
            SmartLogger.logError("Don't find " + elementName + " child with locator: " + childLocator);
        }

        return childElements;
    }

    public File captureElementBitmap(String format) {
        try {
            File screen = Browser.takeScreenshot();
            BufferedImage img = ImageIO.read(screen);
            Rectangle rect = new Rectangle(this.getLocation(), this.getSize());
            BufferedImage dest = img.getSubimage(this.getLocation().getX(), this.getLocation().getY(), rect.width, rect.height);
            ImageIO.write(dest, format, screen);
            return screen;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
