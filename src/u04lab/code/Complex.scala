package u04lab.code

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

trait Complex {
  def re: Double
  def im: Double
  def +(c: Complex): Complex // should implement the sum of two complex numbers..
  def *(c: Complex): Complex // should implement the product of two complex numbers
}

object Complex {
  def apply(re:Double, im:Double):Complex = new ComplexImpl(re, im) // Fill here

  private case class ComplexImpl(override val re: Double,
                    override val im: Double) extends Complex {
    require (re != null && im != null)

    override def +(c: Complex): Complex = ComplexImpl(re + c.re, im + c.im)

    override def *(c: Complex): Complex = ComplexImpl((re * c.re) - (im * c.im), (re * c.im) + (im * c.re))
  }
}

object ComplexTest {

  @Test def testComplexOperations(): Unit = {
    val array = Array(Complex(10, 20), Complex(1, 1), Complex(7, 0))
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

/*
object TryComplex extends App {
  val a = Array(Complex(10,20), Complex(1,1), Complex(7,0))
  val c = a(0) + a(1) + a(2)
  println(c, c.re, c.im) // (ComplexImpl(18.0,21.0),18.0,21.0)
  val c2 = a(0) * a(1)
  println(c2, c2.re, c2.im) // (ComplexImpl(-10.0,30.0),-10.0,30.0)
}*/

/** Hints:
  * - implement Complex with a ComplexImpl class, similar to PersonImpl in slides
  * - check that equality and toString do not work
  * - use a case class ComplexImpl instead, creating objects without the 'new' keyword
  * - check equality and toString now
  */


