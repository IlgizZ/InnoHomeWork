/**
  * Created by Ilgiz on 22.11.2016.
  */
object Main {
  def main(args: Array[String]): Unit = {

    var k = 0;

    for (k <- 0 to 4) {
      val r = scala.util.Random

      var i = 0
      var l = List(1);
      var limit = 200;
      var multiplier = 3;

      for (i <- 1 to 25) {
        l = r.nextInt(100) :: l
      }

      def makeMultiplier(multiplier: Int) = (x: Int) => x * multiplier

      def cutter = (x: Int) =>
        if (x < limit) x
        else limit;

      def remover(x: Int): Boolean = {
        if (x < limit) true else false
      }

      val mult = makeMultiplier(multiplier)
      println(l)

      l = l.map(mult)

      l = l.map(cutter)
      l = l.filter(remover)

      println(l)

    }
    doLone()

  }

  def doLone() = {
    val lessThan = 65
    val start = 1

    def action(i: Int) = {
      print(i + " ")
      i * 2
    }

    val loan = new Function()

    def condition(y: Int) = y < lessThan

    loan.loan[Int](start)(condition)(action)
  }
}
