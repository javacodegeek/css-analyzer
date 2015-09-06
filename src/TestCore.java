import static org.junit.Assert.*;
import org.junit.Test;

public class TestCore {
    @Test
    public void testValidatekUrl() {
        Core core = Core.getInstance();
        assertFalse(core.validatekUrl("httfdfsfsdfsdf"));
    }
}
