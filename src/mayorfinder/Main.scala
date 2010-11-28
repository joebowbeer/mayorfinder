package mayorfinder

object Main {

  def main(args: Array[String]): Unit = {

    val peeps = List("A","B","C")

    def knows(a:String, b:String): Boolean = a match {
      case "A" | "C" => (b == "B")
      case _ => false
    }

    println(Peeps.findMayor(knows, peeps).getOrElse("No one") + " is mayor.")
  }
}
