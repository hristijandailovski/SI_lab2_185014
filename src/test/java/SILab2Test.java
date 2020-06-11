import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class SILab2Test {
    SILab2 func= new SILab2();
    @Test
    void testEveryPath() {
        RuntimeException ex;
        //for every path:
        // 1|2|3.1|3.2|24,25|26
        assertEquals(0,func.function(new ArrayList<Angle>()).size());


        //1|2|3.1|3.2|4,5,6|7|16|21|22|26
        ex = assertThrows(RuntimeException.class, () -> func.function(new ArrayList<Angle>(Arrays.asList(new Angle(-2,25,4)))));
        assertTrue(ex.getMessage().contains("The angle is smaller or greater then the minimum"));

        //1|2|3.1|3.2|4,5,6|7|16|17|19|20|26
        ex = assertThrows(RuntimeException.class, () -> func.function(new ArrayList<Angle>(Arrays.asList(new Angle(360,25,3)))));
        assertTrue(ex.getMessage().contains("The angle is greater then the maximum"));

        //1|2|3.1|3.2|4,5,6|7|16|17|18|23|3.3|3.2|24,25|26
        assertNotNull(func.function(new ArrayList<Angle>(Arrays.asList(new Angle(360, 0, 0)))));

        //1|2|3.1|3.2|4,5,6|7|8|10,11|13|14|23|3.3|3.2|24,25|26
        assertNotNull(func.function(new ArrayList<Angle>(Arrays.asList(new Angle(7,35,21)))));


        //1|2|3.1|3.2|4,5,6|7|8|10,11|12|26
        ex = assertThrows(RuntimeException.class, () -> func.function(new ArrayList<Angle>(Arrays.asList(new Angle(11,42,-10)))));
        assertTrue(ex.getMessage().contains("The seconds of the angle are not valid"));

        //1|2|3.1|3.2|4,5,6|7|8|9|26
        ex = assertThrows(RuntimeException.class, () -> func.function(new ArrayList<Angle>(Arrays.asList(new Angle(98,-30,12)))));
        assertTrue(ex.getMessage().contains("The minutes of the angle are not valid!"));





    }

    @Test
    void multipleConditions(){
        RuntimeException ex;

        // if(deg>=0 && deg<360)
        assertNotNull(func.function(new ArrayList<Angle>(Arrays.asList(new Angle(55,20,15)))));

        ex = assertThrows(RuntimeException.class, () -> func.function(new ArrayList<Angle>(Arrays.asList(new Angle(370, 25, 45)))));
        assertTrue(ex.getMessage().contains("The angle is smaller or greater then the minimum"));

        ex = assertThrows(RuntimeException.class, () -> func.function(new ArrayList<Angle>(Arrays.asList(new Angle(-56, 89, 98)))));
        assertTrue(ex.getMessage().contains("The angle is smaller or greater then the minimum"));

        //if(min<0 || min >59)
        ex = assertThrows(RuntimeException.class, () -> func.function(new ArrayList<Angle>(Arrays.asList(new Angle(52, -3, 5)))));
        assertTrue(ex.getMessage().contains("The minutes of the angle are not valid!"));

        assertNotNull(func.function(new ArrayList<Angle>(Arrays.asList(new Angle(89,12,16)))));

        assertNotNull(func.function(new ArrayList<Angle>(Arrays.asList(new Angle(46,36,12)))));

        //if(sec<0 || sec >59)
        ex = assertThrows(RuntimeException.class, () -> func.function(new ArrayList<Angle>(Arrays.asList(new Angle(56, 32, -6)))));
        assertTrue(ex.getMessage().contains("The seconds of the angle are not valid"));

        ex = assertThrows(RuntimeException.class, () -> func.function(new ArrayList<Angle>(Arrays.asList(new Angle(212, 41, 65)))));
        assertTrue(ex.getMessage().contains("The seconds of the angle are not valid"));

        assertNotNull(func.function(new ArrayList<Angle>(Arrays.asList(new Angle(310,20,35)))));

        //if(min ==0 &&  sec ==0)
        assertNotNull(func.function(new ArrayList<Angle>(Arrays.asList(new Angle(360,0,0)))));

        ex = assertThrows(RuntimeException.class, () -> func.function(new ArrayList<Angle>(Arrays.asList(new Angle(360, 0, -18)))));

        assertTrue(ex.getMessage().contains("The angle is greater then the maximum")); //mozhe da bidat i nevalidni vrednosti za min i sec

    }

}