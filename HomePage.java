package makemytrip_pk;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

	public WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	// WebElements
	By oneRoundTrip = By.xpath("//ul[@class='fswTabs latoBlack greyText']/li[1]");
	By from = By.id("fromCity");
	By fromInput = By.xpath("//div[@class='react-autosuggest__container react-autosuggest__container--open']/input");

	By toInput = By.cssSelector("div[class='react-autosuggest__container react-autosuggest__container--open'] input");
	By ToList = By.cssSelector("ul[class='react-autosuggest__suggestions-list'] li p:nth-child(1)");
	By toBox = By.xpath("//div[@class='fsw_inputBox searchToCity inactiveWidget ']");
	By labelBox = By.xpath("//label[@for='toCity']");
	By inputToBox = By.xpath("//input[@id='toCity']");

	By DepartureBox = By.xpath("//label[@for='departure']");
	By departureDate = By.cssSelector("div[class='DayPicker-Day DayPicker-Day--selected']");
	By returnOneWay = By.xpath("//div[@class='fsw_inputBox flightTravllers inactiveWidget ']");

	By TravelersBox = By.cssSelector("label[for='travellers']");
	By adults = By.xpath("//div[@class='appendBottom20']/ul[1]/li");
	By childs = By.xpath("//div[@class='makeFlex column childCounter']/ul[1]/li");
	By infants = By.xpath("//div[@class='makeFlex column pushRight infantCounter']/ul[1]/li");

	By travlClass = By.cssSelector("ul[class='guestCounter classSelect font12 darkText'] li");
	By apply = By.xpath("//button[@data-cy='travellerApplyBtn']");
	By passLimitMsg = By.id("smallErrorMessage");
	By travelResson = By.xpath("//div[@class='fsw_inputBox travelFor inactiveWidget ']");
	By travelRessonList = By.xpath("//ul[@class='travelForPopup']/li");

	By roundTrip = By.xpath("//li[@data-cy='roundTrip']");
	By returnRound = By.xpath("//div[@class='fsw_inputBox dates reDates inactiveWidget  ']");
	By returnDate = By.xpath("//div[@class='DayPicker-Day DayPicker-Day--end DayPicker-Day--selected']");
	By multiCityRadio = By.xpath("//li[@data-cy='mulitiCityTrip']");
	By multiCityBox = By.xpath("//div[@class='anotherChild']/div");
	By multiCitiInput = By.xpath("//input[@aria-controls='react-autowhatever-1']");

	By multiFrom = By.xpath("//div[@class='fsw_inner multiCity ']/div[1]");
	By multiTo = By.xpath("//div[@class='fsw_inner multiCity ']/div[2]");

	By multiDeparture = By.xpath("//div[@class='fsw_inner multiCity ']/div[3]");
	By multiDepDate = By.cssSelector("div[class='DayPicker-Day DayPicker-Day--selected']");

	By multiTravelClass = By.xpath("//div[@class='fsw_inputBox flightTravllers inactiveWidget ']");
	By multiTravelClassBox = By.className("travellers");

	By anotherCityBtn = By.xpath("//div[@class='fsw_inner multiCity '][2]/button");
	
	
	// Methods
	public WebElement getCounFrom() {
		return driver.findElement(from);
	}

	public WebElement selectFrom() {
		return driver.findElement(fromInput);
	}

	public WebElement selectTo() {
		return driver.findElement(toInput);
	}

	public WebElement getCl() {
		return driver.findElement(labelBox);
	}

	public WebElement selectToClick() {
		return driver.findElement(toBox);
	}

	public List<WebElement> getListTo() {
		return driver.findElements(ToList);
	}

	public WebElement getToValue() {
		return driver.findElement(inputToBox);
	}

//--------------------------------------------------------------	

	// Validate 'To' city
	public void validateCityTo(int CityIndex) {

		for (int i = 0; i < getListTo().size(); i++) {
			if (i == CityIndex) {
				selectTo().sendKeys(Keys.ENTER);
				break;
			}
			selectTo().sendKeys(Keys.ARROW_DOWN);

		}
	}

//--------------------------------------------------------------	


	public WebElement geteDpartureBox() {
		return driver.findElement(DepartureBox);

	}

	public WebElement geteDpartureDate() {
		return driver.findElement(departureDate);

	}

	public WebElement getReturn() {
		return driver.findElement(returnOneWay);
	}

	public WebElement getTravelClickBox() {
		return driver.findElement(TravelersBox);
	}

	public List<WebElement> getAdultsNum() {
		return driver.findElements(adults);
	}

	public List<WebElement> getChildsNum() {
		return driver.findElements(childs);
	}

	public List<WebElement> getInfantsNum() {
		return driver.findElements(infants);
	}

	public List<WebElement> getTravlClass() {
		return driver.findElements(travlClass);
	}

	public WebElement clickApply() {
		return driver.findElement(apply);
	}

	public WebElement getPassInvalid() {
		return driver.findElement(passLimitMsg);
	}

	public WebElement getRessonForTravl() {
		return driver.findElement(travelResson);
	}

	public List<WebElement> getRessonForTravlList() {
		return driver.findElements(travelRessonList);
	}

	public WebElement getTripRound() {
		return driver.findElement(roundTrip);
	}

	public WebElement getReturnRound() {
		return driver.findElement(returnRound);
	}

	public WebElement getRoundDate() {
		return driver.findElement(returnDate);
	}

	public WebElement getMultiCityRadio() {
		return driver.findElement(multiCityRadio);
	}

	public List<WebElement> getMultiCityBox() {
		return driver.findElements(multiCityBox);
	}

	public List<WebElement> getMultiCityFrom() {
		return driver.findElements(multiFrom);
	}

	public List<WebElement> getMultiCityTo() {
		return driver.findElements(multiTo);
	}

	public List<WebElement> getMultiCityDep() {
		return driver.findElements(multiDeparture);
	}

	public WebElement getMultiCityInput() {
		return driver.findElement(multiCitiInput);
	}

	public List<WebElement> getMultiDepDate() {
		return driver.findElements(multiDepDate);
	}

	public WebElement getMultiTravelClass() {
		return driver.findElement(multiTravelClass);
	}

	public WebElement getMultiTravelClassBox() {
		return driver.findElement(multiTravelClassBox);
	}

	// --------Get Travelers numbers-----------
	public int getTravelClassDetails(int adNum, int chNum, int infNum, int tc) {

		getAdultsNum().get(adNum).click();
		getChildsNum().get(chNum).click();
		getInfantsNum().get(infNum).click();
		getTravlClass().get(tc).click();
		return tc + infNum + chNum + adNum;
	}

	// --------Handling the travelers numbers--------------------

	public void getAcceptedPassNum(int TotalPassengers, int acceptedPass) {

		if (TotalPassengers >= acceptedPass) {
			System.out.println(getPassInvalid().getText());
		} else {
			// vaild passengers num
			clickApply().click();
		}
	}

	// ----------------------------------------------------------------------------

	public void getTravelsRessonsDetails() {
		getRessonForTravl().click();

		for (int i = 0; i < getRessonForTravlList().size(); i++) {
			if (i == 1) {
				getRessonForTravlList().get(i).click();
			}
		}
	}

	// ----------------------------------------------------------------------
	public WebElement getAddCityBlock() {
		return driver.findElement(anotherCityBtn);
	}

	public WebElement getOneRound() {
		return driver.findElement(oneRoundTrip);
	}

	// ------------------------------Rounds Validation----------------------------

	// One Way Validation
	public void ValidateOnWay() {
		if (getOneRound().isEnabled()) {
			System.out.println("True");
		} else {
			System.out.println("False");
		}
	}

	// Round Trip
	public void ValidateRoundWay() {
		if (getTripRound().isEnabled()) {
			System.out.println("True");
		} else {
			System.out.println("False");
		}
	}

	// MultiRound Trip
	public void ValidateMultiRoundWay() {
		if (getMultiCityRadio().isEnabled()) {
			System.out.println("True");
		} else {
			System.out.println("False");
		}
	}

	// --------------------Validate From & To Destination--------------

	// Validate From One Way
	public void ValidateFromOneWay(String cityFromValue) {
		if (getCounFrom().getAttribute("value").equalsIgnoreCase(cityFromValue)) {
			System.out.println("True");
		} else {
			System.out.println("False");
		}
	}

	// Validate To One Way
	public void ValidateToOneWay(String cityToValue) {
		if (getToValue().getAttribute("value").equalsIgnoreCase(cityToValue)) { 
			System.out.println("True");
		} else {
			System.out.println("False");
		}
	}
	
	
	
}
