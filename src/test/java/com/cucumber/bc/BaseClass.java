package com.cucumber.bc;

import java.awt.Desktop.Action;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;


public class BaseClass {
	public static WebDriver driver;
	public static Select s;
	public static JavascriptExecutor js;
	public static Actions ac;
	public static Action act;
	public static TakesScreenshot screenShot;
	public static void browserOpen() {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
	}
	public static void launchUrl(String value) 
	{
		driver.get(value);
	}
	public static void maximizeScreen()
	{
		driver.manage().window().maximize();
	}
	public static void sendData(WebElement element, String data) 
	{
		element.sendKeys(data);
	}
	public static void submit(WebElement element)
	{
		element.submit();
	}
	public static void clickElement(WebElement element) 
	{
		element.click();
	}
	public static void clearElement(WebElement element)
	{
		element.clear();
	}
	public static void getTextinteger(WebElement element)
	{
		
		String text = element.getText();
		int parseInt = Integer.parseInt(text);
		System.out.println(parseInt);
	}
	public static String getText(WebElement element)
	{
		
		String text = element.getText();
		return text;
	}
	public static void browserClose() 
	{
		driver.close();
	}
	
	public static void navigateTo(String url) 
	{
		driver.navigate().to(url);
	}
		public static void quit()
	{
		driver.quit();
	}
	public static void back()
	{
		driver.navigate().back();
	}
	public static void forward()
	{
		driver.navigate().forward();
	}
	public static void refresh()
	{
		driver.navigate().refresh();
	}
	
	
	public static void findElementsByTagName(String tagName)
	{
		List<WebElement> elements=driver.findElements(By.tagName(tagName));
		int size = elements.size();
		System.out.println(size);
	}
	public static void selectByIndex(WebElement element,int index)
	{
		s=new Select(element);
		s.selectByIndex(index);
	}
	public static void selectByValue(WebElement element,String value)
	{
		s=new Select(element);
		s.selectByValue(value);
	}
	public static void selectByVisibleText(WebElement element,String text)
	{
		s=new Select(element);
		s.selectByVisibleText(text);
	}
	public static void deselectByIndex(WebElement element,int index)
	{
		s=new Select(element);
		s.deselectByIndex(index);
	}
	public static void deselectByValue(WebElement element,String value)
	{
		s=new Select(element);
		s.deselectByValue(value);
	}
	public static void deselectByVisibleText(WebElement element,String text)
	{
		s=new Select(element);
		s.deselectByVisibleText(text);
	}
	public static void deselectAll(WebElement element)
	{
		s=new Select(element);
		s.deselectAll();
	}
	public static void getAllSelectedOptions(WebElement element)
	{
		s=new Select(element);
		List<WebElement> elements=s.getAllSelectedOptions();
		for (WebElement webElement : elements) {
			System.out.println(webElement.getText());
		}
		int size = elements.size();
		System.out.println(size);
	}
	public static void getFirstSelectedOption(WebElement element)
	{
		s=new Select(element);
		WebElement firstSelectedOption = s.getFirstSelectedOption();
		System.out.println(firstSelectedOption.getText());
	}
	public static void isMultiple(WebElement element)
	{
		s=new Select(element);
		boolean multiple = s.isMultiple();
		System.out.println(multiple);
	}
	
	public static void sleep(long milliseconds) throws InterruptedException
	{
		Thread.sleep(milliseconds);
	}
	
	public static void contextClick(WebElement element)
	{
		ac=new Actions(driver);
		ac.contextClick(element).perform();		
	}
	public static void doubleClick(WebElement element)
	{
		ac=new Actions(driver);
		ac.doubleClick(element).perform();;		
	}
	public static void mouseHover(WebElement element)
	{
		ac=new Actions(driver);
		ac.moveToElement(element).perform();		
	}
	public static void dragAndDrop(WebElement source,WebElement destination)
	{
		ac=new Actions(driver);
		ac.dragAndDrop(source, destination).perform();
	}
	public static void sleep(int milliseconds) throws InterruptedException
	{
		Thread.sleep(milliseconds);
	}
	public static void simpleAlert()
	{
		driver.switchTo().alert().accept();
	}
	public static void confirmAlertAccept()
	{
		driver.switchTo().alert().accept();
	}
	public static void confirmAlertDismiss()
	{
		driver.switchTo().alert().dismiss();
	}
	public static void promptAlert(String input)
	{
		driver.switchTo().alert().sendKeys(input);
		driver.switchTo().alert().accept();
	}
	public static void frameByIndex(int index)
	{
		driver.switchTo().frame(index);
	}
	public static void frameByName(String name)
	{
		driver.switchTo().frame(name);
	}
	public static void frameByWebElement(WebElement element)
	{
		driver.switchTo().frame(element);
	}
	public static void getWindowHandle()
	{
		String homeWindow=driver.getWindowHandle();
	}
	public static void getWindowHandlesClickButton(int millis,WebElement clickbutton) throws InterruptedException
	{
		String homewindow=driver.getWindowHandle();
		Set<String> windows=driver.getWindowHandles();
		for (String window : windows) {
			if(!homewindow.equals(window))
			{
				driver.switchTo().window(window);
				Thread.sleep(millis);
				clickbutton.click();
			}
		}
	}
	public static void getWindowHandlesSendkeys(String homewindow,int millis,WebElement pinCode,String path,String data) throws InterruptedException
	{
		homewindow=driver.getWindowHandle();
		Set<String> windows=driver.getWindowHandles();
		for (String window : windows) {
			if(!homewindow.equals(window))
			{
				driver.switchTo().window(window);
				Thread.sleep(millis);
				pinCode=driver.findElement(By.xpath(path));
				pinCode.sendKeys(data);
				
			}
		}
	}
	
	public static WebElement findById(String id)
	{
		return driver.findElement(By.id(id));
	}
	public static WebElement findByName(String name)
	{
		return driver.findElement(By.name(name));
	}
	public static WebElement findByClassName(String className)
	{
		return driver.findElement(By.className(className));
	}
	public static WebElement findElementBy(By by)
	{
		return driver.findElement(by);
	}
	public static String getAttribute(WebElement element,String attrName)
	{
		return element.getAttribute(attrName);
	}
	public static void jsSetAttribute(String attrName,String attrValue,WebElement element)
	{
		js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].setAttribute('"+attrName+"','"+attrValue+"')", element);
	}
	public static void jsGetAttribute(String attrName,WebElement element)
	{
		js=(JavascriptExecutor)driver;
		String value=(String)js.executeScript("return arguments[0].getAttribute('"+attrName+"')", element);
		System.out.println(value);
	}
	
	public static void jsClick(WebElement element)
	{
		js=(JavascriptExecutor)driver;	
		js.executeScript("arguments[0].click()", element);
	}
	
	public static WebElement jsScroll(WebElement element) {
		try {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true)", element);
		}catch (Exception e) {
			throw new RuntimeException("Warning: Unable to move focus to an Element");
		}
		return element;
	}
	public static WebElement jsScrollClick(WebElement element) {
		try {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true)", element);
		Thread.sleep(3000);
		element.click();
		}catch (Exception e) {
			throw new RuntimeException("Warning: Unable to move focus to an Element");
		}
		return element;
	}
	
	public static void screenShot() throws IOException
	{
		screenShot=(TakesScreenshot)driver;
		File source = screenShot.getScreenshotAs(OutputType.FILE);
		File destination=new File("C:\\Users\\Asus-2020\\eclipse-workspace\\SelProject\\Screenshot\\screen.jpeg");
		FileUtils.copyFile(source, destination);
	}
	
		public static String excelRead(int i,int j)
	{
		String value=null;
		try {
			File fi=new File("C:\\Users\\Asus-2020\\eclipse-workspace\\Oct_Maven\\src\\test\\resources\\Excel Input\\TestDataLoga.xlsx");
			FileInputStream is = new FileInputStream(fi);
			try {
				Workbook wb = new XSSFWorkbook(is);
				Sheet sh = wb.getSheet("Sheet1");
				Row row = sh.getRow(i);
				Cell cell = row.getCell(j);
				int cellType = cell.getCellType();
				if(cellType==1)
				{
					value = cell.getStringCellValue();
				}
				else if(cellType==0)
				{
					if(DateUtil.isCellDateFormatted(cell))
					{
						Date dateCellValue = cell.getDateCellValue();
						SimpleDateFormat simple=new SimpleDateFormat("dd/MM/yyyy");
						value = simple.format(dateCellValue);
					}
					else
					{
						double numericCellValue = cell.getNumericCellValue();
						long date=(long)numericCellValue;
						value = String.valueOf(date);
					}
				}
			} catch (IOException e) {
				}
			} catch (FileNotFoundException e) {
			}
			return value;
			}
	
	public static String getProperties(String data)
	{
		String value=null;
		try
		{
		File f=new File("C:\\Users\\Asus-2020\\eclipse-workspace\\Maven_Project\\src\\test\\resources\\file.properties");
		FileReader fr=new FileReader(f);
		Properties p=new Properties();
		p.load(fr);
		value = p.getProperty(data);
		}catch (Exception e) {
			
		}
		return value;
	}
}
