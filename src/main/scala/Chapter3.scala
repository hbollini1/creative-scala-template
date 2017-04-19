
import doodle.core.Image._
import doodle.syntax._
import doodle.jvm.Java2DCanvas._
import doodle.backend.StandardInterpreter._
import doodle.core.Color

object Chapter3 extends App{

  // I Go Round in Circles

 def goRoundINCircles {
   circle(1).draw
   circle(10).draw
   circle(100).draw
 }
//What is the type of a circle? A rectangle? A triangle?

  // All are type of Image

// Not My Type of Art

  // NotSure

def widthOfACircle() {
  (circle(30) under (circle(10) beside circle(10) beside circle(10))).draw
}
  widthOfACircle

  def evilEye: Unit = {
    ((circle(45) fillColor(Color.blue))under
      (circle(30) fillColor(Color.white)) under
        (circle(20)fillColor(Color.aqua)) under
          circle(10)fillColor(Color.black)).draw
  }

  evilEye

  def compilationTarget: Unit = {
    ((circle(10))on (circle(20))on(circle(30))).draw
  }

  compilationTarget

  def compilationTargetBonous: Unit ={
    (
      circle(10).fillColor(Color.hsl(0.degrees, 0.8.normalized, 0.6.normalized))on
        circle(20).fillColor(Color.hsl(360.degrees, 1.0.normalized, 1.0.normalized)) on
        circle(30).fillColor(Color.hsl(0.degrees, 0.8.normalized, 0.6.normalized))
      ).draw
  }
  compilationTargetBonous

  def stayOnTarget: Unit ={

    val image =
      (
        circle(10).fillColor(Color.hsl(0.degrees, 0.8.normalized, 0.6.normalized))on
          circle(20).fillColor(Color.hsl(360.degrees, 1.0.normalized, 1.0.normalized)) on
          circle(30).fillColor(Color.hsl(0.degrees, 0.8.normalized, 0.6.normalized))
        )
    val image2 =
      (
        rectangle(10,50).lineWidth(5.0)above(rectangle(50,10).fillColor(Color.brown))above(rectangle(100,50).fillColor(Color.green))
      )
    val finalImage = image above image2
    finalImage.draw
  }
  stayOnTarget
}
