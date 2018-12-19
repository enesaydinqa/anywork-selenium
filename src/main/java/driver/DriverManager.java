package driver;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.remote.RemoteWebDriver;

import net.lightbody.bmp.BrowserMobProxy;

public abstract class DriverManager
{

    protected static RemoteWebDriver driver;
    protected static BrowserMobProxy proxy;

    static String REMOTE_TEST = System.getProperty("RemoteTest").toLowerCase();
    private static String USERNAME = System.getProperty("Username");
    static String AUTOMATE_KEY = System.getProperty("AutomateKey");
    String BROWSER_STACK_URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";

    protected abstract void createDriver() throws Exception;

    public RemoteWebDriver getDriver() throws Exception
    {
        if (null == driver)
        {
            createDriver();
            PropertyConfigurator.configure(System.getProperty("user.dir") + "/src/main/resources/log4j.properties");
        }
        return driver;
    }
}
