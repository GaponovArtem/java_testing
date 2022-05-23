
import org.testng.Assert;
import org.testng.annotations.Test;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Locale;

public class CalculatorTest extends TestBase {

    @Test
    public void calculator() {


        double formula = ((5.5 + 6) * 5)/7;
        app.input("((5.5+6)*5)/7=");
        Assert.assertEquals(app.actualResult(), app.expectedResult(formula));

    }

}
