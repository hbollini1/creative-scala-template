package chapter8

import doodle.syntax._
import doodle.jvm.Java2DCanvas._
import doodle.backend.StandardInterpreter._
import doodle.core.Image.Circle
import doodle.core.{Angle, Color, Image, Point}



/**
  * Created by Harishkumar on 4/28/17.
  */
object Exercise extends App {

  def rose(angle: Angle) = Point.polar((angle * 7).cos * 200, angle)

  rose _ // Type Point takes angle as parameter


  val roseFn = (angle: Angle) => Point.cartesian(angle.cos * 200, angle.sin * 200)

}


// Not able to work through this
object Exercise2 extends App {

  def concentricShapes(count: Int, singleShape: Int => Image): Image =
    count match {
      case 0 => Image.empty
      case n => singleShape(n) on concentricShapes(n - 1, singleShape)
    }

  def circle(n: Int): Image = {
    Image.circle(50) lineWidth(10)  lineColor(Color.blue)
  }

  def triangle(n: Int): Image = {
    Image.triangle(100,150) lineWidth(10) lineColor(Color.blue)
  }

  def square(n: Int): Image = {
    Image.rectangle(100, 100) lineWidth(10) lineColor(Color.blue)
  }
  //oncentricShapes(10, circle).draw

  //hitting Compile error

/*  Error:(41, 32) could not find implicit value for parameter draw: doodle.backend.Draw
  concentricShapes(10, circle).draw
  Error:(41, 32) not enough arguments for method draw: (implicit draw: doodle.backend.Draw, implicit interpreter: doodle.backend.Configuration => doodle.backend.Interpreter)Unit.
    Unspecified value parameters draw, interpreter.
    concentricShapes(10, circle).draw*/
}

object Ex3 extends App{
  def rose(angle: Angle) = Point.polar((angle * 7).cos * 200, angle)
  def parametricCircleWithPolar (angle: Angle): Point = Point.polar(200,angle)
  def sample(start: Angle, samples: Int): Image = {
    // Angle.one is one complete turn. I.e. 360 degrees
    val step = Angle.one / samples
    val dot = Image.circle(5).lineColor(Color.crimson)
    def loop(count: Int): Image = {
      val angle = step * count
      count match {
        case 0 => Image.empty
        case n =>
          dot.at(rose(angle).toVec) on loop(n - 1)
      }
    }
    loop(samples)
  }
  sample(0.degrees,144).draw
}

