package pageObjects.herokuapp;

import org.openqa.selenium.By;
import org.testng.Assert;
import pageObjects.baseObjects.BasePage;

public class DragAndDropPage extends BasePage {
    private By shapeA = By.id("column-a");
    private By shapeB = By.id("column-b");

    public DragAndDropPage dragAndDropAtoB(){
        actions
                .dragAndDrop(driver.findElement(shapeA), driver.findElement(shapeB))
                .release()
                .build()
                .perform();
        return this;
    }

    public DragAndDropPage dragAndDropBtoA() {
        actions
                .dragAndDrop(driver.findElement(shapeB), driver.findElement(shapeA))
                .build()
                .perform();
        return this;
    }

    public DragAndDropPage verifyAtoB() {
        Assert.assertEquals(getText(shapeA), "B");
        return this;
    }

    public DragAndDropPage verifyBtoA() {
        Assert.assertEquals(getText(shapeA), "A");
        return this;
    }
}
