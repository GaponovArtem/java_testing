
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;


public class TestBase {

    AppManager app = new AppManager();

    @Parameters({"browserName"})
    @BeforeSuite
    public void setup(String browser) {

        app.init(browser);
    }

    @AfterSuite
    public void shutdown() {
        app.shutDown();
    }
}