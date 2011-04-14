import com.thoughtworks.selenium.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.server.SeleniumServer;

import java.util.regex.Pattern;

public class heidtbkdWebTest extends SeleneseTestCase {
	static SeleniumServer server = null;
	
	@Before
	public void setUp() throws Exception {
	try {
		if(server == null) {
			server = new SeleniumServer();
			server.start();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		setUp("http://webtesting.idyll.org/", "*chrome");
	}

	@Test
	public void testHeidtbkdWeb() throws Exception {
		selenium.open("/");
		selenium.click("link=Log in");
		selenium.waitForPageToLoad("30000");
		selenium.click("create");
		selenium.waitForPageToLoad("30000");
		selenium.type("name", "Karl");
		selenium.type("username", "heidtbkd");
		selenium.type("password", "uu4567uu");
		selenium.click("create");
		selenium.waitForPageToLoad("30000");
		selenium.type("username", "heidtbkd");
		selenium.type("password", "uu4567uu");
		selenium.click("login");
		selenium.waitForPageToLoad("30000");
		verifyTrue(selenium.isTextPresent("Welcome, heidtbkd"));
	}

	@After
	public void tearDown() throws Exception {
		selenium.stop();
	}
}
