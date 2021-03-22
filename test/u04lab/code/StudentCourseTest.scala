package u04lab.code

import org.junit.jupiter.api.{BeforeEach, Test}
import org.junit.jupiter.api.Assertions._
import u04lab.code.Lists.List._

class StudentCourseTest {
  val cPPS: Course = Course("PPS","Viroli")
  val cPCD: Course = Course("PCD","Ricci")
  val s1: Student = Student("mattia",2015)

  @BeforeEach
  def initCourses(): Unit = {
    s1.enrolling(cPPS)
    s1.enrolling(cPCD)
  }

  @Test def testCourses(): Unit = {
    assertEquals(Cons("PCD",Cons("PPS", Nil())), s1.courses)
  }

  @Test def testHasTeacher(): Unit = {
    assertTrue(s1.hasTeacher("Viroli"))
    assertTrue(s1.hasTeacher("Ricci"))
  }
}
