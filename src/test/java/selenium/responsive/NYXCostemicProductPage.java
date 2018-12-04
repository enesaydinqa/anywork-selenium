package selenium.responsive;

import java.util.logging.Logger;
import java.util.stream.IntStream;

import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.openqa.selenium.support.PageFactory;

import base.BaseResponsiveTest;
import enums.URLFactory;
import selenium.pages.MainPageResponsive;

@DisplayName("NYX Costemic Product Page - Responsive")
public class NYXCostemicProductPage extends BaseResponsiveTest
{
    Logger LOGGER = Logger.getLogger(NYXCostemicProductPage.class.getName());

    @Test
    @DisplayName("Product Sale Price")
    public void testProductSalePrice()
    {

        MainPageResponsive mainPage = PageFactory.initElements(driver, MainPageResponsive.class);

        navigateToURL(URLFactory.MAIN_URL);

        IntStream.range(0, mainPage.getProductSalePrices().size())
                .forEach(count -> {
                    Assert.assertNotEquals(0, getText(mainPage.getProductSalePrices().get(count)));
                });

    }
}