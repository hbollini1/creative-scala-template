package chapter8

import java.awt.Image

/**
  * Created by Harishkumar on 4/27/17.
  */
object  praticework extends App {

  val dot = Image.circle(5).lineWidth(3).lineColor(Color.crimson)
  val squareDots =
    dot.at(0, 0).
      on(dot.at(0, 100)).
      on(dot.at(100, 100)).
      on(dot.at(100, 0))

  squareDots.draw

}

object work2 extends App {
  def parametricCircleWithcartesian (angle: Angle) :Point = Point.cartesian(angle.cos * 200,angle.sin * 200)

  def parametricCircleWithPolar (angle: Angle): Point = Point.polar(200,angle)

  def sample(start: Angle, samples: Int): Image = {
    // Angle.one is one complete turn. I.e. 360 degrees
    val step = Angle.one / samples
    val dot = Image.circle(1).lineColor(Color.crimson)
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
    def rose(angle: Angle) = Point.polar((angle * 7).cos * 200, angle)

  sample(0.degrees, 216).draw
}
object test2 extends App{
  def concentricShapes(count: Int, singleShape: Int => Image): Image =
    count match {
      case 0 => Image.empty
      case n => singleShape(n) on concentricShapes(n-1, singleShape)
    }
  // concentricShapes: (count: Int, singleShape: Int => doodle.core.Image)doodle.core.Image
  def colored(shape: Int => Image, color: Int => Color): Int => Image =
    (n: Int) =>
      shape(n) lineWidth 10 lineColor color(n)
  // colored: (shape: Int => doodle.core.Image, color: Int => doodle.core.Color)Int => doodle.core.
  Image
  def fading(n: Int): Color =
    Color.blue fadeOut (1 - n / 20.0).normalized
  // fading: (n: Int)doodle.core.Color
  def spinning(n: Int): Color =
    Color.blue desaturate 0.5.normalized spin (n * 30).degrees
  // spinning: (n: Int)doodle.core.Color
  def size(n: Int): Double =
    50 + 12 * n
  // size: (n: Int)Double
  def circle(n: Int): Image =
    Circle(size(n))
  // circle: (n: Int)doodle.core.Image
  def square(n: Int): Image =
    Image.rectangle(2*size(n), 2*size(n))
  // square: (n: Int)doodle.core.Image
  def triangle(n: Int): Image =
    Image.triangle(2*size(n), 2*size(n))
  // triangle: (n: Int)doodle.core.Image

    (concentricShapes(10, colored(circle, spinning)) beside
      concentricShapes(10, colored(triangle, fading)) beside
      concentricShapes(10, colored(square, spinning))).draw
}

object test3 extends App{

    def concentricShapes(count: => Int, singleShape: Int => Image): Image =
      count match {
        case 0 => Image.empty
        case n => rainbowCircle(n) on concentricShapes(n - 1, singleShape)
      }
    def fadeout(n: Int): Unit = {
      Color.blue fadeOut (1 - n / 20.0).normalized
    }

    def rainbowCircle(n: Int): Image = {
      val color = Color.blue desaturate 0.5.normalized spin (n * 30).degrees
      val shape = Image.circle(50 + n * 12)
      shape lineWidth 10 lineColor color
    }

    def fadingTriangle(n: Int): Image = {
      val color = Color.blue fadeOut (1 - n / 20.0).normalized
      val shape = Image.triangle(100 + n * 24, 100 + n * 24)
      shape lineWidth 10 lineColor color
    }

    def rainbowSquare(n: Int): Image = {
      val color = Color.blue desaturate 0.5.normalized spin (n * 30).degrees
      val shape = Image.rectangle(100 + n * 24, 100 + n * 24)
      shape lineWidth 10 lineColor color
    }

    concentricShapes(10, rainbowCircle).draw

}

object qaz extends App{

  import cats.Monoid
  import cats.implicts._

  implicit object pointInstance extends Monoid [point]{
    def empty = Point.zero
    def combine (x:Point,y:Point):Point =
      Point (x.x+y.x+y.y)
  }
  val circle: Double = > (Angle => Point) =
    (frequency:Double) => (a;Angle)=> Point.polar(1.0,a*frequency)
  val scale = (r:Double)=> (pt:Point) => Point(pt.x*r,pt.y*r)

  val curve = (r:Double) => (circle(1) andThen scale(r)) |+| (circle(6) andThen scale(r/2)) |+| (circle(-14) andThen scale(r/3))


  val sample: Int => (Angle => Image)=> Image =
    (n:Int) => {
      val step = Angle.one / n
      (parameteric: (Angle => Image)) => {
        def loop(count: Int): Image =
          count match {
            case 0 => Image.empty
            case n => parametric(step * n) on loop(n - 1)
          }
        loop(n)
      }
    }
  val style:Point => Image = {

  }

  sample(500)(curve(200))
}




