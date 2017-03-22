/**
  * Created by Ilgiz on 06.12.2016.
  */
class MyClass[T](var x: Int, var t: T) {
  val x_100 = x * 100;

  def print_100(s: String): Unit = {
    for (i <- 0 to x_100)
      println(s)
  }

  def isGrater(x: Int): String = {
    if (this.x > x)
      "Number " + x + "is less."
    else
      "Number " + x + "is greater."
  }

  def x_=(newX: Int) {
    x = newX;
    println("New value: " + newX);
  }

  def +(slog: MyClass[T]): MyClass[T] = {
    new MyClass(this.x + slog.x, t)
  }

  def +(slog: Int): MyClass[T] = {
    new MyClass(this.x + slog, t)
  }
}
