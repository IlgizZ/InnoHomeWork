/**
  * Created by Ilgiz on 22.11.2016.
  * do atcion while condition true
  */
class Function {

  def loan[A](arg: A)(condition: A => Boolean)(action: A => A): A = {
    val result = action(arg)

    if (condition(arg))
      loan[A](result)(condition)(action)
    else
      result
  }

}
