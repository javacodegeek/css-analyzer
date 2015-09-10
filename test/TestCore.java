import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;

public class TestCore {

    private Core testCore;

    @Before
    public void setupTestData() {
        testCore = Core.getInstance();
    }


    @Test
    public void testCreatingTestCore() {
        assertNotNull("failture - object Core not created", testCore);
    }

    @Test
    public void testValidateUrl() {
        assertTrue("failture - 'http://www.bbc.com' is invalid url.",testCore.validateUrl("http://www.bbc.com"));
        assertFalse("failture - 'unknow com' is valid url. ",testCore.validateUrl("unknow com"));
    }

    @Test
    public void testTypeOfGetPageContent() {
        if (!(Core.getPageContent("http://www.bbc.com") instanceof String)) {
            fail("failture - getPageContent not return String from correct url");
        }
    }

}
