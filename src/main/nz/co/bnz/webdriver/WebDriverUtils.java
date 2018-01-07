package nz.co.bnz.webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.Proxy.ProxyType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtils {

    public static WebElement waitForElementToAppear(WebDriver driver, By by) {
        return (new WebDriverWait(driver, 60)).until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public static boolean waitForElementToHaveText(WebDriver driver, By by, String text) {
        return (new WebDriverWait(driver, 60)).until(ExpectedConditions.textToBe(by, text));
    }

    public static DesiredCapabilities getDesiredCapabilities() {

        DesiredCapabilities dc = DesiredCapabilities.firefox();

        FirefoxProfile firefoxProfile = new FirefoxProfile();
        firefoxProfile.setPreference("browser.startup.homepage", "about:blank");
        firefoxProfile.setPreference("startup.homepage_welcome_url", "about:blank");
        firefoxProfile.setPreference("startup.homepage_welcome_url.additional", "about:blank");
        firefoxProfile.setPreference("app.update.auto", false);
        firefoxProfile.setPreference("app.update.enabled", false);
        firefoxProfile.setPreference("app.update.silent", true);

        firefoxProfile.setPreference("network.automatic-ntlm-auth.trusted-uris", ".thenational.com, .bnz.co.nz");
        firefoxProfile.setPreference("network.automatic-ntlm-auth.allow-non-fqdn", true);
        firefoxProfile.setPreference("network.negotiate-auth.delegation-uris", ".thenational.com, .bnz.co.nz");
        firefoxProfile.setPreference("network.negotiate-auth.trusted-uris", ".thenational.com, .bnz.co.nz");
        firefoxProfile.setPreference("network.negotiate-auth.using-native-gsslib", false);

        dc.setCapability(FirefoxDriver.PROFILE, firefoxProfile);

        Proxy proxy = new Proxy();
        proxy.setProxyType(ProxyType.SYSTEM);

        dc.setCapability(CapabilityType.PROXY, proxy);
        dc.setCapability(CapabilityType.HAS_NATIVE_EVENTS, false);

        return dc;
    }
}
