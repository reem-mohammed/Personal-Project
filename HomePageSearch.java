package makemytrip_pk;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class HomePageSearch {

	public WebDriver driver;

	public HomePageSearch(WebDriver driver) {
		this.driver = driver;
	}

	int CheckedItem = 0;
	Set<String> set = new HashSet<>();

	// ---------------Popular Filter--------------
	By items = By.xpath("//p[text()='Popular Filters']/following-sibling::div[1]/span/label/div/div/p");
	By moreItemsText = By.xpath(
			"//p[text()='Popular Filters']/following-sibling::div[1]/span//following-sibling::div[1]//div[@class='flexOne']/p");
	By searchBtn = By.xpath("//a[text()='Search']");
	By popCheckboxes = By.xpath("//p[text()='Popular Filters']/following-sibling::div[1]/span");
	By popCheckboxesFirstName = By.xpath("//label/div/div/p");
	By more = By.xpath("//a[@class='font14 LatoMedium']");
	By moreItems = By.xpath("//div[@class='collapse in']/span");
	By moreItemBox = By.xpath("//div[@class='appliedFilterOuter append_bottom10']/ul/li");
	By applyFilterList = By.xpath("//ul[@class='appliedFilter']/li");
	By appFilter = By.xpath("//ul[@class='appliedFilter']/li");
	By clearBTN = By.xpath("//span[@class='clearFilter']");

	By unCheckedItems = By.xpath("//p[text()='Popular Filters']/following-sibling::div[1]/span/label/span/span");
	By unCheckedItemsMore = By.xpath("//div[@class='collapse in']/span/label/span/span");

	// --------------------------One Way price WebElements-----------------------

	By priceValue = By.xpath("//div[@class='rc-slider-step']/following-sibling::div[1]");

	// ---------------------------Departure & Arrivals
	// Links----------------------------------
	By departuresLinks = By.xpath("//div[@class='fli-items-wrapper collapse in']/div[2]//div/div/div");
	By arrivalsLink = By.xpath("//div[@class='fli-items-wrapper collapse in']/div[3]//div/div/div");

	// ----------------------------Search Results----------------------------------------------
	By searchResults = By.xpath("//div[@class='fli-intl-lhs pull-left']/div/div/following-sibling::div");
	By searchTitle = By.xpath("//span[@class='airways-name ']");
	By titlesResults = By.xpath(
			"//div[@class='fli-intl-lhs pull-left']/div/div/following-sibling::div//span[@class='airways-name ']");
	By DepResults = By.cssSelector("div[class='fli-time-section pull-left departure'] div");
	By viewProducts = By.cssSelector("div[class='pull-left make_relative']");
	By searchToolBarLinks = By.xpath("//ul[@class='makeFlex font12']/li/a");
	By searchButtons = By.xpath("//div[@class='faresRightSection']/div[2]");
	
	By viewDetailsBox = By.xpath("//div[@class='viewFaresOuter  collapse in']//button[@class='btn fli_primary_btn text-uppercase ']");
	// --------------------------Popular Filter-----------------------------------------------

	// Get search button clicked
	public void getSearchBtnClicked() {
		driver.findElement(searchBtn).click();
	}

//	// Get checkedItems
//	public List<WebElement> getPopularCheckboxes() {
//		return driver.findElements(unCheckedItems);
//	}

	// Check all the popular checkboxes
	public void getCheckboxesChecked() {
		for (int i = 0; i < getUnCheckedList().size(); i++) {
			getUnCheckedList().get(i).click();
			if (getUnCheckedList().get(i).getAttribute("data-ischecked").equals("true")) {
				CheckedItem++;
			}
		}
	}

	// Get More BTN clicked
	public void getMoreLinkClicked() {
		driver.findElement(more).click();
	}

	// Get MoreItems in the List
	public List<WebElement> getmoreItemsList() {
		return driver.findElements(moreItems);
	}

	// get checked items
	public void getmoreItemsChecked() {
		for (int i = 0; i < getmoreItemsList().size(); i++) {
			getmoreItemsList().get(i).click();
		}
	}

	// Validate selected items
	public void ValidatePopularItems() {
		System.out.println("# of checked items : " + CheckedItem);
		System.out.println("# of items : " + getmoreItemsList().size());

	}

	// Validate item's Popular List
	public List<WebElement> ValidatePopularItemsList() {
		return driver.findElements(applyFilterList);
	}

	// Validate the filterBox & Checked items
	public void getValidatePIandCh() {
		int Items = getUnCheckedList().size();
		int moreItems = getmoreItemsList().size();

		if (ValidatePopularItemsList().size() == (Items + moreItems)) {
			System.out.println("Numbers are Matching!");
		}
	}

	// Get CheckBoxFirstName
	public List<WebElement> getChecboxesText() {
		return driver.findElements(moreItemsText);
	}

	// Get the items in the box
	public List<WebElement> getappFilterListBox() {
		return driver.findElements(appFilter);
	}

	// Put the items in set
	public void getItensInTheSet() {
		for (int i = 0; i < getappFilterListBox().size(); i++) {
			String item = getappFilterListBox().get(i).getText();
			set.add(item);
		}
	}

	// compare and validate BTW items in the Box and checked List
	public void CompareItems() {

		// Function insert items in set
		getItensInTheSet();

		// Compare the Set with the checked List
		for (int i = 0; i < getChecboxesText().size(); i++) {
			String fullName = getChecboxesText().get(i).getText();
			String[] strs = fullName.split(" ([^A-Z])");
			if (set.contains(strs[0])) {
				System.out.println("Passed : " + strs[0]);
			} else {
				System.out.println("Failed : " + strs[0]);
			}
		}
	}

	// Click clear BTN
	public void getClearBTNClicked() {
		driver.findElement(clearBTN).click();
	}

	// Get uncheckedItems
	public List<WebElement> getUnCheckedList() {
		return driver.findElements(unCheckedItems);
	}

	// Get unCheckedMoreItems
	public List<WebElement> getunCheckedItemsMore() {
		return driver.findElements(unCheckedItemsMore);
	}

	// check items after clicking on the clear button
	public void validateItemsAfterClear() {
		// validate unchecked items
		for (int i = 0; i < getUnCheckedList().size(); i++) {
			if (getUnCheckedList().get(i).getAttribute("data-ischecked").equals("false")) {
				System.out.println(getChecboxesText().get(i).getText() + "  unChecked item!");
			}
		}

		// validate unchecked more items
		for (int i = 0; i < getunCheckedItemsMore().size(); i++) {
			// Validate More items
			if (getunCheckedItemsMore().get(i).getAttribute("data-ischecked").equals("false")) {
				System.out.println(
						getChecboxesText().get(i + (getUnCheckedList().size())).getText() + "  unChecked item!");
			}
		}

		// Validate checkboxes list & List items after clear action
		System.out.println("No Checked items in the filter box!");
	}

//----------------------------------- One Way Price ------------------------------------------

	// Move the slider and get the values
	public void getOneWayPriceValue() throws InterruptedException {
		Actions action = new Actions(driver);
		WebElement oneWayPrice = driver.findElement(priceValue);

		String actualVal = "";
		int val = -30;
		for (int i = 0; i < 14; i++) {
			actualVal = oneWayPrice.getAttribute("aria-valuenow");
			action.moveToElement(oneWayPrice).click().dragAndDropBy(oneWayPrice, val, 0).build().perform();
			System.out.println(actualVal);
		}

		String str = getappFilterListBox().get(0).getText();
		String[] strs = str.split("-");
		String res = strs[1].replaceAll("[^a-zA-Z0-9]", "");
		if (actualVal.equals(res)) {
			System.out.println("Matching values");
		}
	}

//------------------------Departure & Arrival Links---------------------------------		

	public List<WebElement> getDepLinksIntoList() {
		return driver.findElements(departuresLinks);
	}

	public List<WebElement> getArrLinksIntoList() {
		return driver.findElements(arrivalsLink);
	}

	public void getDepLinks() {
		for (int i = 0; i < getDepLinksIntoList().size(); i++) {
			getDepLinksIntoList().get(i).click();
		}
	}

	public void getArrLinks() {
		for (int i = 0; i < getArrLinksIntoList().size(); i++) {
			getArrLinksIntoList().get(i).click();
		}
	}
//-------------------------------Search Results---------------------------------------

	public List<WebElement> getTitles() {
		return driver.findElements(searchTitle);
	}
	
	public List<WebElement> getDeps() {
		return driver.findElements(DepResults);
	}


	//get search results titles
	public void getResults() {
		for (int i = 0; i < getTitles().size(); i++) {
			String title = getTitles().get(i).getText();
			String dep = getDeps().get(i).getText();
			System.out.println(title + "--" + dep);
		}
	}

	//get all the buttons into list
	public List<WebElement> getClicked(){
		return driver.findElements(viewProducts);
	}
	
	//get the view products link clicked
	public void getViewProductsClicked() throws InterruptedException {
		for (int i = 0; i < getClicked().size(); i++) {
			getClicked().get(i).click();
			//getBookBtnClicked();
		}
	}
	
	//-----------------------Search Tool Bar Links---------------------
	public List<WebElement> getLinksIntoList() {
		return driver.findElements(searchToolBarLinks);
	}
	
	public void getToolBarLinksClicked() {
		for(int i = 0 ; i < getLinksIntoList().size()-1 ; i++) {
			String clickLink = Keys.chord(Keys.COMMAND,Keys.ENTER);
			getLinksIntoList().get(i).sendKeys(clickLink);
			driver.getTitle();	
		}
	}
	
	//----------------------- Book Buttons------------------------------
	
	public List<WebElement> getBTNIntoList() {
		return driver.findElements(searchButtons);
	}
	
	public void getBookBtnClicked() {
		for(int i = 0 ; i < getBTNIntoList().size();i++) {
			getBTNIntoList().get(i).click();
		}
	}
	
}
