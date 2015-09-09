import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;

public class TestCore {

   /*  @Before
    public void setupTestData() {
      Core testCore = Core.getInstance();
    }*/

    @Test
    public void testValidateUrl() {
        Core testCore = Core.getInstance();
        assertTrue("Is 'http://www.bbc.com valid' url. ",testCore.validateUrl("http://www.bbc.com"));
        assertFalse("Is 'http://www.bbc.com invalid' url. ",testCore.validateUrl("unknow com"));

    }
}
