import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;

public class TestCore {

   /*  @Before
    public void setupTestData() {
      Core testCore = Core.getInstance();
    }*/


    @Test
    public void testCreatingTestCore() {
        Core testCore = Core.getInstance();
        assertNotNull("failture - object Core not created", testCore);
    }

    @Test
    public void testValidateUrl() {
        Core testCore = Core.getInstance();
        assertTrue("failture - 'http://www.bbc.com' is invalid url.",testCore.validateUrl("http://www.bbc.com"));
        assertFalse("failture - 'unknow com' is valid url. ",testCore.validateUrl("unknow com"));
    }

    @Test
    public void testTypeOfGetPageContent() {
        Core testCore = Core.getInstance();
        if (!(Core.getPageContent("http://www.bbc.com") instanceof String)) {
            fail("failture - getPageContent not return String from correct url");
        }
    }


}
