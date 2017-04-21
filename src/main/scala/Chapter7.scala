import doodle.core.Image
import doodle.core.Image._
import doodle.syntax._
import doodle.jvm.Java2DCanvas._
import doodle.backend.StandardInterpreter._
import doodle.core.{Color, Image}

/**
  * Created by Harishkumar on 4/20/17.
  */
object Chapter7 extends App {

  def ex1(str: String): Int = {
    str match {
      case "bcde" => 0
      case "cdef" => 1
      case "abcd" => 2
    }
  }

  println(ex1("abcd")) //returns 2

  def ex2(intX: Int): String = {
    intX match {
      case 0 => "zero"
      case 1 => "one"
      case 1 => "two"
    }
  }

  println(ex2(1)) // return one and Two becomes unrecheable.

  def ex3(): Unit = {
    1 match {
      case n => n + 1; println(n + 1)
      case 1 => 1000; println("1000")
    }
  }

  ex3 //First case n is applicable so that is evaluated even if exact match is avaialble next

  def ex4: Unit = {
    1 match {
      case a => a; println("A")
      case b => b + 1; println("B")
      case c => c * 2; println("C")
    }
  }

  ex4


  def cross(count: Int): Image = {
    val unit = Image.circle(10)
    count match {
      case 0 => unit
      case n => unit beside (unit above (cross(n - 1) above unit) beside unit)
    }
  }

  cross(2).draw


  def chess(count: Int): Image = {
    val blacksquare = rectangle(30, 30).fillColor(Color.black)
    val whitesquare = rectangle(30, 30).fillColor(Color.white)

    val singleComponent = ((blacksquare beside whitesquare) above (whitesquare beside blacksquare))

    count match {
      case 0 => singleComponent
      case n => ((chess(n - 1) beside chess(n - 1)) above ((chess(n - 1) beside chess(n - 1))))
    }
  }

  chess(1).draw


  def sierpinski(count: Int): Image = {
    val triangle = Image.triangle(10, 10)
    val unit = (triangle above (triangle beside triangle))

    count match {
      case 0 => unit
      case n => (sierpinski(n - 1) above (sierpinski(n - 1) beside sierpinski(n - 1)))
    }
  }

  sierpinski(3).draw


  // Given a natural number, returns that number
  // Examples:
  // identity(0) == 0
  // identity(3) == 3
  def identity(n: Int): Int =
  n match {
    case 0 => 0
    case n => 1 + identity(n - 1)
  } // Yes above would return expected


  // Given a natural number, double that number
  // Examples:
  // double(0) == 0
  // double(3) == 6
  def double(n: Int): Int =
  n match {
    case 0 => 0
    case n => 2 * double(n - 1)
  } // nope method would return 2*2*2


  def gradientBoxes(n: Int): Image = {
    n match {

      case 0 => Image.empty
      case n =>
        (Image.rectangle(20, 20) lineWidth (5) lineColor (Color.blueViolet.spin((n * 10).degrees))
          fillColor (Color.red.spin((n * 10).degrees))
          beside gradientBoxes(n - 1))
    }
  }

  gradientBoxes(5).draw


  def concentriccircles(n: Int): Image = {
    n match {
      case 0 => Image.empty
      case n => Circle(n * 10) under concentriccircles(n - 1)
    }

  }

  concentriccircles(10).draw


  def unitCircle (size:Int,color:Color)={
    circle(size) lineWidth(3) lineColor(color)
  }
  def fadeCircles(n:Int,size:Int,color:Color): Image ={
    n match {
      case 0 => Image.empty
      case n => unitCircle(size,color) under fadeCircles(n-1,size-7,color.fadeOutBy(0.15.normalized))
    }
  }
  fadeCircles(10,10,Color.red).draw

  def colorChangingColor(n:Int,size:Int,color:Color): Image ={
    n match {
      case 0 => Image.empty
      case n => unitCircle(size,color) under colorChangingColor(n-1,size-7,color.spin(10.degrees))
    }
  }
  colorChangingColor(10,10,Color.red).draw
}