# Creative Scala Template

This is a template project designed for people taking [Creative Scala][creative-scala].

Fork or clone this template. (What's the difference? If you fork this repository you get your own copy on Github. You can then clone that repository to get a copy on your computer and save work back to your fork on Github and share it with other programmers. If you clone this repository without forking you get a copy on your computer but no copy on Github that you can save work back to and share.)

Then run `sbt.sh` (OS X and Linux) or `sbt.bat` (Windows) to start SBT.

Finally type `console` in SBT and then type `Example.image.draw`. If you see a picture of three nested circles everything is working well.

You can edit the file `Example.scala` to create your own code. See [Creative Scala][creative-scala] for more!

[creative-scala]: http://underscore.io/training/courses/creative-scala/



what is first class values
  something is first class when can pass it to a method return it froma method, or give it a name with a `val`
  methods are not first class

why are first class values useful
  it allows us to more clearly define heiarchial set of functions--abstarction
  composition

what iis

  .curried


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


