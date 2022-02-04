package com.sample.test.demo.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import com.sample.test.demo.TestBase;

public class PizzaOrderForm extends TestBase{

	@FindBy(xpath="//center[text()='Pizza Order Form']")
	private WebElement pageHeader;
	
	@FindBy(id="pizza1Pizza")
	private WebElement pizza1;
	
	@FindBy(xpath="//select[@class='toppings1']")
	private WebElement pizza1Toppings1;
	
	@FindBy(xpath="//select[@class='toppings2']")
	private WebElement pizza1Toppings2;
	
	@FindBy(id="pizza1Qty")
	private WebElement pizza1Quantity;
	
	@FindBy(id="pizza1Cost")
	private WebElement pizza1Cost;
	
	@FindBy(xpath="//h3[text()='PICKUP INFORMATION ']")
	private WebElement pickupInformationHeader;
	
	@FindBy(id="name")
	private WebElement name;
	
	@FindBy(id="email")
	private WebElement email;
	
	@FindBy(id="phone")
	private WebElement phone;
	
	@FindBy(id="ccpayment")
	private WebElement radioCreditCard;
	
	@FindBy(id="cashpayment")
	private WebElement radioCash;
	
	@FindBy(id="placeOrder")
	private WebElement placeOrderButton;
	
	@FindBy(id="reset")
	private WebElement resetButton;
	
	@FindBy(xpath="//div[@id='dialog']")
	private WebElement message;
	
	public PizzaOrderForm()
	{
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyPageHeader()
	{
		return pageHeader.isDisplayed();
	}
	
	public boolean verifyPickupInformationHeader()
	{
		return pickupInformationHeader.isDisplayed();
	}
	
	public void selectPizza1(String pizza)
	{
		Select select = new Select(pizza1);
		select.selectByValue(pizza);
	}
	
	public void selectPizza1Toppings1(String topping1)
	{
		Select select = new Select(pizza1Toppings1);
		select.selectByValue(topping1);
	}
	
	public void selectPizza1Toppings2(String topping2)
	{
		Select select = new Select(pizza1Toppings2);
		select.selectByValue(topping2);
	}
	
	public void enterPizza1Quantity(String quantity)
	{
		pizza1Quantity.sendKeys(quantity);
	}
	
	public void clearPizza1Quantity()
	{
		pizza1Quantity.clear();
	}
	
	public String getTotalPizzaCost()
	{
		return pizza1Cost.getText();
	}
	
	public void enterCustomerName(String customerName)
	{
		name.sendKeys(customerName);
	}
	
	public void enterCusotmerEmail(String customerEmail)
	{
		email.sendKeys(customerEmail);
	}
	
	public void enterCustomerPhone(String customerPhone)
	{
		phone.sendKeys(customerPhone);
	}
	
	public void clickCreditCard()
	{
		radioCreditCard.click();
	}
	
	public void clickCashOnPickup()
	{
		radioCash.click();
	}
	
	public void clickPlaceOrder()
	{
		placeOrderButton.click();
	}
	
	public void clickReset()
	{
		resetButton.click();
	}
	
	public String getMessage()
	{
		return message.getText();
	}
	
	public String orderPizza(String pizzaType, String topping1, String topping2, String quantity, String name, String email, String phone, String paymentOption)
	{
		selectPizza1(pizzaType);
		if(!topping1.equals(""))
		{
			selectPizza1Toppings1(topping1);
		}
		if(!topping2.equals(""))
		{
			selectPizza1Toppings2(topping2);
		}
		clearPizza1Quantity();
    	enterPizza1Quantity(quantity);
    	enterCustomerName(name);
    	enterCusotmerEmail(email);
    	enterCustomerPhone(phone);
    	if(paymentOption.equalsIgnoreCase("Credit Card"))
    	{
    		clickCreditCard();
    	}
    	else
    	{
    		clickCashOnPickup();
    	}
    	clickPlaceOrder();
    	return getMessage();
	}
}
