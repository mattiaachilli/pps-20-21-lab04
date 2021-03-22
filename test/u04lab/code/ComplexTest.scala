package u04lab.code
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions._

class ComplexTest {

  @Test def testComplexOperations(): Unit = {
    val array = Array(Complex(10,20), Complex(1,1), Complex(7,0))
    val c = array(0) + array(1) + array(2)
    val c2 = array(0) * array(1)
    assertEquals(18.0, c.re)
    assertEquals(21.0, c.im)
    assertEquals(-10.0, c2.re)
    assertEquals(30.0, c2.im)
  }

  @Test def testComplexEquality(): Unit = {
    val complex = Complex(-10, 20)
    val complex1 = Complex(-10, 20)
    assertEquals(complex1, complex)
    assertEquals("ComplexImpl(-10.0,20.0)", complex.toString)
  }
}
