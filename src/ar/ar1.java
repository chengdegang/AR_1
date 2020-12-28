
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ar1 {
	static WebDriver driver;

	@BeforeClass(enabled = true)
	public static void beforeclass() throws IOException {
		//System.setProperty("webdriver.chrome.driver", "E:/extend/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.get("http://ms-test.dongjian.netease.com/login.html");
//		设置窗口全屏
		driver.manage().window().maximize();
	}

	@Test
	public void auto1() throws InterruptedException {
		denglu();
		chuangjian();
		yanzheng();
		shanchu();
	}

	public void denglu(){
		WebElement denglu1 = driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div/div/div/a[1]"));
		denglu1.click();
//		切换成易现账号
		WebElement emailtype = driver.findElement(By.xpath("//*[@id=\"corp\"]/form/div[1]/a"));
		emailtype.click();
		WebElement emailtype2 = driver.findElement(By.xpath("//*[@id=\"corp\"]/form/div[1]/ul/li[4]/a"));
		emailtype2.click();
		WebElement userid = driver.findElement(By.name("ezxrid"));
		userid.sendKeys("chengdegang@ezxr.com");
		WebElement userwd = driver.findElement(By.name("ezxrpw"));
		userwd.sendKeys("Cdg18868890069");
//		登录后台
		WebElement denglu = driver.findElement(By.xpath("//*[@id=\"ezxr\"]/form/input[9]"));
		denglu.click();
//		切换到sdk
		WebElement qie = driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/div"));
		qie.click();
		WebElement qie2 = driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/div/div[3]/div/div[2]/div/ul/li[1]"));
		qie2.click();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		WebElement y = driver.findElement(By.xpath("//*[@id=\"root\"]/div/section/section/aside/div/ul/li[1]/a"));
		y.click();
	}

	public void chuangjian() throws InterruptedException {
//		创建新的应用
		WebElement y2= driver.findElement(By.xpath("//*[@id=\"root\"]/div/section/section/section/div/main/div/button"));
		y2.click();
		WebElement y3= driver.findElement(By.id("create-apply_name"));
		y3.sendKeys("自动化应用");
//		上传应用图标,定位到inut的type="file"
		WebElement s = driver.findElement(By.xpath("//*[@id=\"root\"]/div/section/section/section/div/main/div/div/div[2]/form/div[3]/div[2]/div/span/div[1]/span/div[2]/span/input"));
		s.sendKeys("/Users/jackrechard/Desktop/auto.png");
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
//		输入sdk的bundle等
		WebElement i= driver.findElement(By.id("create-apply_iosFBundleId"));
		i.sendKeys("com.autoz.ezxr");
		WebElement i2= driver.findElement(By.id("create-apply_iosTBundleId"));
		i2.sendKeys("com.autoc.ezxr");
		WebElement i3= driver.findElement(By.id("create-apply_androidFBundleId"));
		i3.sendKeys("com.autoaz.ezxr");
		WebElement i4= driver.findElement(By.id("create-apply_androidTBundleId"));
		i4.sendKeys("com.autoac.ezxr");
//		移动下拉条
//		((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 100)");
//		((JavascriptExecutor) driver).executeScript("window.scrollTo(0,document.body.scrollHeight)");
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		Thread.sleep(2000);
//		创建
		WebElement c= driver.findElement(By.xpath("//*[@id=\"root\"]/div/section/section/section/div/main/div/div/button/span"));
		Actions actions = new Actions(driver);
		actions.moveToElement(c).click().build().perform();
		Thread.sleep(2000);
	}

	public void shanchu() throws InterruptedException {
		WebElement s= driver.findElement(By.xpath("//*[@id=\"root\"]/div/section/section/section/div/main/div/div[1]/div/div/div[1]/span[2]/button[2]"));
		s.click();
		Thread.sleep(2000);
//		通过移动鼠标坐标到删除应用按钮，这里的 (xOffset, yOffset) 是以元素 toElement 的左上角为 (0,0) 开始的 (x, y) 坐标轴。
		Actions action = new Actions(driver);
		action.moveToElement(s,0,20);
//		以鼠标当前位置（即s）中心开始移动到 (xOffset, yOffset) 坐标轴
		Thread.sleep(500);
		action.moveByOffset(0,20);
		Thread.sleep(500);
		action.moveByOffset(0,20);
		Thread.sleep(500);
		action.click();
		action.release().perform();
//		点击最终删除
		Thread.sleep(500);
		WebElement s2= driver.findElement(By.xpath("/html/body/div[3]/div/div[2]/div/div[2]/div/div/div[2]/button[2]"));
		s2.click();

	}

	public void yanzheng() throws InterruptedException {
		WebElement y= driver.findElement(By.xpath("//*[@id=\"root\"]/div/section/section/section/div/main/div/div[1]/div/div/div[1]/span[1]/div/div/div[1]"));
		Assert.assertEquals(y.getText(),"自动化应用");
//		刷新页面
		driver.navigate().refresh();
		Thread.sleep(3000);
//		try {
//			Thread.sleep(1000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//		driver.quit();
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.quit();
	}
}
