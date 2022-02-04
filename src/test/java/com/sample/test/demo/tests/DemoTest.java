package com.sample.test.demo.tests;

import java.text.DecimalFormat;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.sample.test.demo.TestBase;
import com.sample.test.demo.constants.PizzaToppings;
import com.sample.test.demo.constants.PizzaTypes;
import com.sample.test.demo.pages.PizzaOrderForm;
import com.sample.test.demo.util.Utilities;

public class DemoTest extends TestBase {

	PizzaOrderForm objPizzaOrderForm;
	
	@BeforeMethod
	public void refreshPage()
	{
		driver.navigate().refresh();
	}
	
	@DataProvider
	public Object[][] getPizzaOrderTestDataForPositiveTestCases(){
		Object data[][] = Utilities.getTestData("positive");
		return data;
	}
	
	//Positive Test Cases with Multiple Dataset from Excel File
    @Test(priority=1, dataProvider="getPizzaOrderTestDataForPositiveTestCases")
    public void orderPizza(String pizzaType, String topping1, String topping2, String quantity, String name, String email, String phone, String paymentType) 
    {
    	objPizzaOrderForm = new PizzaOrderForm();
    	Assert.assertTrue(objPizzaOrderForm.verifyPageHeader());
    	String top1 = "";
    	String top2 = "";
    	if(!topping1.equals(""))
    	{
    		top1 = PizzaToppings.valueOf(topping1).getDisplayName();
    	}
    	if(!topping2.equals(""))
    	{
    		top2 = PizzaToppings.valueOf(topping2).getDisplayName();
    	}
    	String message = objPizzaOrderForm.orderPizza(PizzaTypes.valueOf(pizzaType).getDisplayName(), top1, top2, quantity, name, email, phone, paymentType);
    	DecimalFormat format = new DecimalFormat("0.##");
    	String totalCost = String.valueOf(format.format(PizzaTypes.valueOf(pizzaType).getCost()*Integer.parseInt(quantity)));
    	String expectedMessage = "Thank you for your order! TOTAL: "+totalCost+" "+PizzaTypes.valueOf(pizzaType).getDisplayName();
    	Assert.assertEquals(expectedMessage, message);
    }
    
    @DataProvider
	public Object[][] getPizzaOrderTestDataForNegativeTestCases(){
		Object data[][] = Utilities.getTestData("negative");
		return data;
	}
    
    //Negative Test Cases with Multiple Dataset from Excel File
    @Test(priority=2, dataProvider="getPizzaOrderTestDataForNegativeTestCases")
    public void verifyErrorMessageWithIncorrectDetails(String pizzaType, String topping1, String topping2, String quantity, String name, String email, String phone, String paymentType, String errorMessage) 
    {
    	objPizzaOrderForm = new PizzaOrderForm();
    	Assert.assertTrue(objPizzaOrderForm.verifyPageHeader());
    	String top1 = "";
    	String top2 = "";
    	if(!topping1.equals(""))
    	{
    		top1 = PizzaToppings.valueOf(topping1).getDisplayName();
    	}
    	if(!topping2.equals(""))
    	{
    		top2 = PizzaToppings.valueOf(topping2).getDisplayName();
    	}
    	String message = objPizzaOrderForm.orderPizza(PizzaTypes.valueOf(pizzaType).getDisplayName(), top1, top2, quantity, name, email, phone, paymentType);
    	Assert.assertEquals(errorMessage, message);
    }
}
