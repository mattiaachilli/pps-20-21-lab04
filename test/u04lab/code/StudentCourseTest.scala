package u04lab.code

import org.junit.jupiter.api.{BeforeEach, Test}
import org.junit.jupiter.api.Assertions._
import u04lab.code.Lists.List._

class StudentCourseTest {
  val cPPS: Course = Course("PPS","Viroli")
  val cPCD: Course = Course("PCD","Ricci")
  val cSDR = Course("SDR","D'Angelo")
  val cASW = Course("AWS", "Mirri")
  val s1: Student = Student("mattia",2015)

  @BeforeEach
  def initCourses(): Unit = {
    s1.enrolling(cPPS)
    s1.enrolling(cPCD)
  }

  @Test def testCourses(): Unit = {
    assertEquals(Cons("PPS",Cons("PCD", Nil())), s1.courses)
  }

  @Test def testHasTeacher(): Unit = {
    assertTrue(s1.hasTeacher("Viroli"))
    assertTrue(s1.hasTeacher("Ricci"))
  }

  @Test def testMultipleEnrolling(): Unit = {
    s1.enrolling(cSDR, cASW)
    assertEquals(Cons("PPS",Cons("PCD", Cons("SDR", Cons("AWS", Nil())))), s1.courses)
    assertTrue(s1.hasTeacher("D'Angelo"))
    assertTrue(s1.hasTeacher("Mirri"))
  }
}
