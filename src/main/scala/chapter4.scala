import doodle.core.Image._
import doodle.syntax._
import doodle.jvm.Java2DCanvas._
import doodle.backend.StandardInterpreter._
import doodle.core.{Color, Image}


object Chapter4 {

  //Top-Level

  // Objects cannot be declared without Names

  //Top-level Extended

  // A val can be declared inside object and it can be referenced via object.
  // Referenced as object.nameOfVal


  object ex1 {
    val a = 1
    val b = 2
    val answer = a + b

  }

  object ex2 {
    val a = 1

    object Two {
      val a = 3
      val b = 2
    }

    object Answer {
      val answer = a + Two.b
    }

  }

  // answer 3 val a in scope of ex2 is used of evaluation whereas a=3 is not used since its scope is limited to two

  object ex3 {

    object One {
      val a = 5
      val b = 2 // this is used
      object Answer {
        val a = 1 // this is used
        val answer = a + b // variable available within scope is taken precedence
      }

    }

  }

  object ex4 {

    object One {
      val a = 1
      val b = a + 1
      val answer = a + b //1+2 = 3
    }

  }

  object ex5 {

    object One {
      val a = 1

      object Two {
        val b = 2
      }

     // val answer = a + b // Scope of b is not resolved(scope of b is within the scope of Two) to use the b
      // it needs to be referenced as Two.b
    }

  }

  object ex6 {

    object One {
      //val a = b - 1
      //val b = a + 1
      //val answer = a + b // value of a and b is not given, would get struck in loop

    }

  }

}

  object ArcheryAgain {

    val circleStand =
      (
        circle(10).fillColor(Color.hsl(0.degrees, 0.8.normalized, 0.6.normalized)) on
          circle(20).fillColor(Color.hsl(360.degrees, 1.0.normalized, 1.0.normalized)) on
          circle(30).fillColor(Color.hsl(0.degrees, 0.8.normalized, 0.6.normalized))
        )
    val ArcheryStand =
      (
        rectangle(10, 50).lineWidth(5.0) above (rectangle(50, 10).fillColor(Color.brown)) above (rectangle(100, 50).fillColor(Color.green))
        )
    val finalImage = circleStand above ArcheryStand

    finalImage.draw
  }

object StreetAhead {

  val frontDoor =
    (
      (Image.rectangle(15, 25) fillColor Color.black at(0,-12.5)) on
        (Image.rectangle(50, 50) fillColor Color.red)
      )
  val rooftop = (
    Image.triangle(50,50)fillColor(Color.indianRed)
  )

  val house = rooftop above frontDoor

  val tree =(
    ((circle(30) fillColor(Color.green))above (rectangle(10,20) fillColor(Color.brown)))

  )

  val housebesidetree = (house beside tree)

  val road =(
    (rectangle(90,5) fillColor(Color.yellow) beside (rectangle(45,3) lineColor (Color.black)fillColor(Color.black)))above
      (rectangle(135,10)lineColor (Color.black)fillColor(Color.black))
  )
  val singleBlock = housebesidetree above road

  val finalimage = singleBlock beside singleBlock beside singleBlock
}
