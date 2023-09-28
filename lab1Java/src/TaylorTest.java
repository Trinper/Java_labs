import static org.junit.jupiter.api.Assertions.*;

class TaylorTest {

    @org.junit.jupiter.api.Test
    void testMethodCounting1() {
        Taylor taylor = new Taylor(0.4 , 8);
        assertTrue(Math.abs(Math.atan(taylor.getNum()) - taylor.Counting()) < Math.pow(10, -1 * (taylor.getK() + 1)));
    }

    @org.junit.jupiter.api.Test
    void testMethodCounting2() {
        Taylor taylor = new Taylor(0.5, 10);
        assertTrue(Math.abs(Math.atan(taylor.getNum()) - taylor.Counting()) <  Math.pow(10, -1 * (taylor.getK() + 1)));
    }

    @org.junit.jupiter.api.Test
    void testMethodCounting3() {
        Taylor taylor = new Taylor(0.6, 4);
        assertTrue(Math.abs(Math.atan(taylor.getNum()) - taylor.Counting()) < Math.pow(10, -1 * (taylor.getK() + 1)));
    }

    @org.junit.jupiter.api.Test
    void testMethodCounting4() {
        Taylor taylor = new Taylor(0.99, 11);
        assertTrue(Math.abs(Math.atan(taylor.getNum()) - taylor.Counting()) < Math.pow(10, -1 * (taylor.getK() + 1)));
    }

    @org.junit.jupiter.api.Test
    void testMethodCounting5() {
        Taylor taylor = new Taylor(0.00001, 11);
        assertTrue(Math.abs(Math.atan(taylor.getNum()) - taylor.Counting()) < Math.pow(10, -1 * (taylor.getK() + 1)));
    }
}