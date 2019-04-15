package br.com.rk.dot;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author Rhuan Karlus
 * @since 12/04/2019
 */
public class DotHitter {

    private static final int WAIT_TIME = 5;
    private static final String DROP_DOWN_LANCAMENTOS = "menu2";
    private static final String BUTTON_MARCACAO_DO_PONTO = "//*[@id=\"menu2_Item1\"]/a";
    private static final String BUTTON_OK = "Button1";

    public static void hitarODot(final WebDriver webDriver) {
        final WebDriverWait wait = new WebDriverWait(webDriver, WAIT_TIME);

        wait.until(ExpectedConditions.presenceOfElementLocated(By.id(DROP_DOWN_LANCAMENTOS)));
        final String mainWindowHandle = webDriver.getWindowHandle();
        new Actions(webDriver).moveToElement(webDriver.findElement(By.id(DROP_DOWN_LANCAMENTOS))).perform();

        webDriver.findElement(By.xpath(BUTTON_MARCACAO_DO_PONTO)).click();

        popupFocus(wait, webDriver, mainWindowHandle);
        hit(wait, webDriver);
    }

    private static void popupFocus(WebDriverWait wait, WebDriver webDriver, String mainWindowHandle) {
        wait.until(d -> d.getWindowHandles().size() != 1);
        for (String activeHandle : webDriver.getWindowHandles()) {
            if (activeHandle.equals(mainWindowHandle)) {
                continue;
            }

            webDriver.close();
            webDriver.switchTo().window(activeHandle);
            break;
        }
    }

    private static void hit(WebDriverWait wait, WebDriver webDriver) {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id(BUTTON_OK)));
        webDriver.findElement(By.id(BUTTON_OK)).click();
        webDriver.close();
    }

}
