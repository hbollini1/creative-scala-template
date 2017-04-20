import doodle.core.Image._
import doodle.syntax._
import doodle.jvm.Java2DCanvas._
import doodle.backend.StandardInterpreter._
import doodle.core.{Color, Image}
object Chapter6 extends App{

  def square(x:Int):Int = {
    x * x
  }

  def halve(x:Double): Double = x/2

  def sumThreeNumbers (a: Int, b:Int, c:Int) : Int = {
    println("inside method - calculation is done here")
    println (a+b+c)
    (a+b+c)
  }
  sumThreeNumbers({println("a");2},{println("b");2},{println("c");2})

  val box = rectangle(20,20).lineWidth(5).lineColor(Color.red)fillColor(Color.red)

  def stackingBoxes (noOfBoxes:Int): Image= noOfBoxes match {

    case 0 => Image.empty
    case noOfBoxes => box beside stackingBoxes(noOfBoxes-1)

  }
  stackingBoxes(5).draw




}
