import doodle.core.Image._
import doodle.core.PathElement._
import doodle.core.Point._
import doodle.core.Color._
import doodle.core._
import doodle.syntax._
import doodle.backend.StandardInterpreter._
import doodle.jvm.Java2DCanvas._

object polygon extends App {

  val triangle =
    closedPath(List(
      moveTo(polar(50, 0.degrees)),
      lineTo(polar(50, 120.degrees)),
      lineTo(polar(50, 240.degrees))
    ))
  val square =
    closedPath(List(
      moveTo(polar(50, 45.degrees)),
      lineTo(polar(50, 135.degrees)),
      lineTo(polar(50, 225.degrees)),
      lineTo(polar(50, 315.degrees))
    ))
  val pentagon =
    closedPath (List(
      moveTo(polar(50, 72.degrees)),
      lineTo(polar(50, 144.degrees)),
      lineTo(polar(50, 216.degrees)),
      lineTo(polar(50, 288.degrees)),
      lineTo(polar(50, 360.degrees))
    ))
  val gap =
    rectangle(10, 100).noLine.noFill

  def format(image: Image): Image =
    image.lineWidth(3.0).lineColor(paleTurquoise).fillColor(turquoise)

  val image =
    format(triangle) beside gap beside  format(square) beside gap beside format(pentagon)

  image.draw

}

object Curve extends App{

  def curve(radius: Int, start: Angle, increment: Angle): PathElement = {
    curveTo(
      polar(radius * .8, start + (increment * .3)),
      polar(radius * 1.2, start + (increment * .6)),
      polar(radius, start + increment)
    )
  }
  val triangle =
    closedPath(List(
      moveTo(polar(50, 0.degrees)),
      curve(50, 0.degrees, 120.degrees),
      curve(50, 120.degrees, 120.degrees),
      curve(50, 240.degrees, 120.degrees)
    ))
  val square =
    closedPath(List(
      moveTo(polar(50, 45.degrees)),
      curve(50, 45.degrees, 90.degrees),
      curve(50, 135.degrees, 90.degrees),
      curve(50, 225.degrees, 90.degrees),
      curve(50, 315.degrees, 90.degrees)
    ))
  val pentagon =
    closedPath((List(
      moveTo(polar(50, 72.degrees)),
      curve(50, 72.degrees, 72.degrees),
      curve(50, 144.degrees, 72.degrees),
      curve(50, 216.degrees, 72.degrees),
      curve(50, 288.degrees, 72.degrees),
      curve(50, 360.degrees, 72.degrees)
    )))
  val spacer =
    rectangle(10, 100).noLine.noFill
  def style(image: Image): Image =
    image.lineWidth(6.0).lineColor(paleTurquoise).fillColor(turquoise)
  val image = style(triangle) beside spacer beside style(square) beside spacer beside style(pentagon)

  image.draw
}

object lists extends App{

  def ones(x:Int): List[Int] ={
    x match {
      case 0 => Nil
      case n => 1::ones(n-1)
    }
  }
  ones(5)
  def onesmap(x:Int): List[Int] ={
    (0 to x).toList.map(n => 1)
  }
println(onesmap(5))

  def descending(x:Int): List[Int] ={
    x match {
      case 0 => Nil
      case n => n ::descending(n-1)
    }
  }
  descending(5)

  def descendingmaps(x:Int): List[Int] ={
    (x to 0 by -1).toList
  }
  println(descendingmaps(10))


  def ascending(x:Int): List[Int] ={
    def iter(x:Int, counter:Int):List[Int] = {
      x match {
        case 0 => Nil
        case n => counter :: iter((n - 1),counter+1)
      }
    }
    iter(x,1)
  }
  ascending(5)

  def ascendingmaps(n: Int): List[Int] =
    (0 until n).toList.map(x => x + 1)

  println(ascendingmaps(5))

  def fill[A](n: Int, a: A): List[A] =
    n match {
      case 0 => Nil
      case n => a :: fill(n-1, a)
    }
  fill(3,"scala")
  fill (3, Color.blueViolet)

  def double(list: List[Int]): List[Int] =
    list match {
      case Nil => Nil
      case head :: tail => (head * 2) :: double(tail)
    }
  double(List(1,3,5,7))

  def doublemaps(list: List[Int]): List[Int] =
    list.map (x => x * 2)

  println(doublemaps(List(1,3,5,7)))

  def product(list: List[Int]): Int =
    list match {
      case Nil => 1
      case hd :: tl => hd * product(tl)
    }

  println(product(Nil))

  println(product(List(1,2,3,4,5,0)))


  def contains[A](list: List[A], search: A): Boolean =
    list match {
      case Nil => false
      case hd :: tl => (hd == search) || contains(tl, search)
    }

  println(contains(List(1,2,3), 3))

  println(contains(List(Color.blue,Color.red),Color.red))

  def first[A](list: List[A], elt: A): A =
    list match {
      case Nil => elt
      case hd :: tl => hd
    }

  println(first(Nil,5))

  println(first(List(1,2,3,4,5),"HI"))

  def reverse[A](list: List[A]): List[A] = {
    def iter(list: List[A], reversed: List[A]): List[A] =
      list match {
        case Nil => reversed
        case hd :: tl => iter(tl, hd :: reversed)
      }
    iter(list, Nil)
  }

println("List(1,2,3,4,5,6)")
  println(reverse(List(1,2,3,4,5,6)))

}