package arraytodouble;

import static DoubleToBytes;
import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

/**
 * Parameterized test class for DoubleToBytes class.
 * 
 * @author Erika Bourque
 * @author Jonathan Bizier
 */
@RunWith(Parameterized.class)
public class DoubleToBytesParamTest {
    Double test;
    
    public DoubleToBytesParamTest(Double d) {
        this.test = d;
    }
    
    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
            {1.2},
            {345.3},
            {876.13897},
            {8324.000004},
            {87936249.67},
        });
    }
    @Test
    public void testMethod()
    {
        Byte[] temp;
        Double result;
        
        // Action
        temp = DoubleToBytes.doubleToByteArray(test);
        result = DoubleToBytes.byteArrayToDouble(temp);
        
        assertEquals(test, result);
    }
}
