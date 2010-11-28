package mayorfinder

/**
 * Given a list of people and a "knows" relation, find the mayor,
 * that is, the person who everyone knows but who doesn't know anyone.
 */
object Main {

  type P = String

  def findMayor(knows: (P,P) => Boolean, peeps: List[P]): P = {
    def known(a:P, b:P) = if (knows(a,b)) b else if (knows(b,a)) a else null
    val mayor = peeps.reduceLeft(known)
    return if (mayor != null && !peeps.exists(knows(mayor, _))) mayor else null
  }

  def main(args: Array[String]): Unit = {

    val peeps = List("A","B","C")

    def knows(a:P, b:P): Boolean = a match {
      case "A" | "C" => (b == "B")
      case _ => false
    }

    val mayor = findMayor(knows, peeps)

    println((if (mayor != null) mayor else "No one") + " is mayor.")
  }
}
