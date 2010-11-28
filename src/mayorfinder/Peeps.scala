package mayorfinder

object Peeps {

  /**
   * Given a list of people and a "knows" relation, find the mayor,
   * that is, the person who everyone knows but who doesn't know anyone.
   */
  def findMayor[P >: Null](knows: (P,P) => Boolean, peeps: List[P]): Option[P] = {
    if (peeps.nonEmpty) {
      def known(a:P, b:P) = if (knows(a,b)) b else if (knows(b,a)) a else null
      val mayor = peeps.reduceLeft(known)
      if (mayor != null && !peeps.exists(knows(mayor, _)))
        return Some(mayor)
    }
    None
  }
}
