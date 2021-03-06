package makemytrip_pk;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class HomePageTopToolBar {
	public WebDriver driver;

	public HomePageTopToolBar(WebDriver driver) {
		this.driver = driver;
	}

	By topBar = By.cssSelector("ul[class='makeFlex font12'] li");
	By lastItemLinks = By.xpath("//div[@class='moreOption font16 latoBold']/a");
	By lastItem = By.xpath("//span[@class='chNavIcon appendBottom2 chSprite chMore']");

	public List<WebElement> getTopToolBar() {
		return driver.findElements(topBar);
	}

	public void getToolBarSize() {
		System.out.println(getTopToolBar().size());
	}

	// Handle all the ToolBar links except the last one
	public void getToolBarItems() {
		for (int i = 0; i < getTopToolBar().size() - 1; i++) {
			getTopToolBar().get(i).click();
			System.out.println(getTopToolBar().get(i).getText());
		}
	}

	// Click the last item
	public WebElement getLastItemClicked() {
		return driver.findElement(lastItem);
	}

	// get the last item Links
	public List<WebElement> getToolBarLastItemLinks() {
		return driver.findElements(lastItemLinks);
	}

	// open new tabs in the last item.
	public void getLastItemPages() throws InterruptedException {

		JavascriptExecutor js = (JavascriptExecutor) driver;

		getLastItemClicked().click();

		for (int i = 1; i < getToolBarLastItemLinks().size(); i++) {

			String link = getToolBarLastItemLinks().get(i).getAttribute("href");
			js.executeScript("window.open('" + link + "');");
		}

		Set<String> pages = driver.getWindowHandles();
		Iterator<String> it = pages.iterator();
		while (it.hasNext()) {
			driver.switchTo().window(it.next());
			System.out.println(driver.getTitle());

		}

	}

}
