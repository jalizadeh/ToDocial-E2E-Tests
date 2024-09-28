package test.java.app_tests;

import main.java.utils.DataProvider;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

public class DataProviderTest {

    private static final String HOMEPAGE = "http://localhost:8089";

    @Test
    public void testSingletonInstance(){
        DataProvider dp1 = DataProvider.getInstance();
        DataProvider dp2 = DataProvider.getInstance();
        assertSame(dp1, dp2, "Both instances should be the same");
    }

    @Test
    public void testLoadedProperties(){
        DataProvider dp = DataProvider.getInstance();
        assertEquals(HOMEPAGE, dp.homepage());
    }

}
