package pageObjects.herokuapp;

import org.openqa.selenium.By;
import org.testng.Assert;
import pageObjects.baseObjects.BasePage;

public class FileUploadPage extends BasePage{
    private final By chooseFileBtn = By.xpath("//input[@name='file']");
    private final By fileUploaded = By.xpath("//h3[contains(text(),'Up')]");
    private By uploadBtn = By.id("file-submit");
    public FileUploadPage uploadFile(){
        driver.findElement(chooseFileBtn).sendKeys(System.getProperty("user.dir") + "\\files\\123.jpg");
        return this;
    }
    public FileUploadPage clickUploadBtn(){
        click(uploadBtn);
        return this;
    }
    public FileUploadPage verifyUploadFile() {
        Assert.assertEquals(getText(fileUploaded),"File Uploaded!");
        return this;
    }

}
