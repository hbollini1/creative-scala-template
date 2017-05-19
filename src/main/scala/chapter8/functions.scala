/*
// Functions
import cats.Monoid
import cats.implicits._

object qazqaz extends App {

  implicit object pointInstance extends Monoid[Point] {
    def empty = Point.zero

    def combine(x: Point, y: Point): Point =
      Point(x.x + y.x, x.y + y.y)
  }

  val circle: Double => (Angle => Point) =
    (frequency: Double) => (a: Angle) => Point.polar(1.0, a * frequency)
  val scale: Double => (Point => Point) =
    (r: Double) => (pt: Point) => Point(pt.x * r, pt.y * r)

  val curve: Double => Angle => Point =
    (r: Double) =>
      (circle(1) andThen scale(r)) |+| (circle(6) andThen scale(r / 2)) |+| (circle(-14) andThen scale(r / 3))
circle
  // (circle(1) andThen scale(200))
  // circle: Double => (Angle => Point)
  // scale: Double => (Point => Point)
  // (Angle => Point) andThen (Point => Point)
  // Angle => Point

  // (circle(1) andThen scale(r)) |+| (circle(6) andThen scale(r / 2)) |+| (circle(-14) andThen scale(r / 3))
  // (Angle => Point) |+| (Angle => Point) |+| (Angle => Point)
  // Angle => Point

  // import cats.syntax.semigroup._semigroup

  // Don't copy after here ---------------

  val sample: Int => (Angle => Image) => Image =
    (n: Int) => {
      val step = Angle.one / n
      (parametric: (Angle => Image)) => {
        def loop(count: Int): Image =
          count match {
            case 0 => Image.empty
            case n => parametric(step * n) on loop(n - 1)
          }

        loop(n)
      }
    }

  val style: Point => Image = {
    val c = curve(0.53)
    (pt: Point) => {
      val color = c(pt.angle)
      Image.circle(3).
        at(pt.toVec).
        lineColor(Color.royalBlue).
        fillColor(Color.hsla(color.angle, color.r.normalized, 0.7.normalized, 0.5.normalized))
    }
  }

  val image = sample.apply(500).apply(curve(200) andThen style)

  image.draw
}
*/
