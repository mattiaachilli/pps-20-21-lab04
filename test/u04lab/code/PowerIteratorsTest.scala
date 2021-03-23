package u04lab.code

import Optionals._
import Lists._
import Lists.List._
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions._

class PowerIteratorsTest {

  val factory = new PowerIteratorsFactoryImpl()

  @Test
  def testIncremental() {
    val pi = factory.incremental(5,_+2); // pi produce 5,7,9,11,13,...
    assertEquals(Option.of(5), pi.next());
    assertEquals(Option.of(7), pi.next());
    assertEquals(Option.of(9), pi.next());
    assertEquals(Option.of(11), pi.next());
    assertEquals(Cons(5, Cons(7, Cons(9, Cons(11, Nil())))), pi.allSoFar()); // elementi già prodotti
    val piReversed = pi.reversed()
    for (_ <- 0 until 10) {
      pi.next(); // procedo in avanti per un po'..
    }
    assertEquals(Option.of(11), piReversed.next());
    assertEquals(Option.of(9), piReversed.next());
    assertEquals(Option.of(7), piReversed.next());
    assertEquals(Option.of(5), piReversed.next());
    assertEquals(Cons(11, Cons(9, Cons(7, Cons(5, Nil())))), piReversed.allSoFar());
  }
}
