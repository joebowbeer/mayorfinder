package mayorfinder

import org.junit._
import org.junit.Assert._

class MayorFinderTest {

  @Before
  def setUp: Unit = {
  }

  @After
  def tearDown: Unit = {
  }

  @Test
  def abc = {
    val peeps = List("A","B","C")
    def knows(a:String, b:String): Boolean = a match {
      case "A" | "C" => (b == "B")
      case _ => false
    }
    assertEquals(Some("B"), Peeps.findMayor(knows, peeps))
  }

  @Test
  def abcd = {
    val peeps = List("A","B","C","D")
    def knows(a:String, b:String): Boolean = a match {
      case "A" | "C" => (b == "B")
      case _ => false
    }
    assertEquals(None, Peeps.findMayor(knows, peeps))
  }

  @Test
  def empty = {
    val peeps = List()
    def knows(a:String, b:String) = false
    assertEquals(None, Peeps.findMayor(knows, peeps))
  }

  @Test
  def one = {
    val peeps = List("A")
    def knows(a:String, b:String) = false
    assertEquals(Some("A"), Peeps.findMayor(knows, peeps))
  }
}
