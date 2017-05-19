import doodle.core._
import doodle.core.Image._
import doodle.syntax._
import doodle.jvm.Java2DCanvas._
import doodle.backend.StandardInterpreter._
import doodle.core.PathElement._
import doodle.turtle._
import doodle.turtle.Instruction._

object Chapter10 extends App{


  val path =
    Image.openPath(
      List(moveTo(10,10), lineTo(-10,10), lineTo(-10,-10), lineTo(10, -10), lineTo(10, 10))
    )
  path.draw

  val instructions = List(forward(10), turn(90.degrees), forward(20), turn(90.degrees), forward(30), turn(90.degrees), forward(40))
  val path1 = Turtle.draw(instructions)
  path1.draw

  def polygon(sides: Int, sideLength: Double): Image = {
    val turnAngle = Angle.one / sides
    def apply(n: Int): List[Instruction] =
      n match {
        case 0 => Nil
        case n => turn(turnAngle) :: forward(sideLength) :: apply(n-1)
      }
    Turtle.draw(apply(sides))
  }
  polygon(5,30).draw


  def squareSpiral(steps: Int, distance: Double, angle: Angle, increment: Double): Image = {
    def iter(steps: Int, distance: Double): List[Instruction] = {
      steps match {
        case 0 => Nil
        case n => forward(distance) :: turn(angle) :: iter(steps - 1, distance + increment)
      }
    }
    Turtle.draw(iter(steps, distance))
  }
    squareSpiral(100,10.0,89.degrees,2.0).draw

  def double[A](in: List[A]): List[A] =
    in.flatMap { x => List(x, x) }

  println(double(List(1,2,3,4)))

  def onNothing[A](in: List[A]): List[A] =
    List()
  println(onNothing(List(1,2,3,4)))

/*  // Have to ask to expalin in detail

  def rewrite(instructions: List[Instruction], rule: Instruction => List[Instruction]): List[
    Instruction] =
    instructions.flatMap { i =>
      i match {
        case Branch(i) =>
          List(branch(rewrite(i, rule):_*))
        case other =>
          rule(other)
      }
    }

  def iterate(steps: Int,
              seed: List[Instruction],
              rule: Instruction => List[Instruction]): List[Instruction] = {
    steps match {
      case 0 => seed
      case n => iterate(n - 1, rewrite(seed, rule), rule)
    }
  }

  val x: Instruction= turn(90.degrees)
  val x1: Instruction => List[Instruction] = x.(x) = x
  Turtle.draw(iterate(3,List(forward(10),forward(10)),x1)).draw*/

  def flatpolygon(sides: Int, sideLength: Double): Image = {
    val rotation = Angle.one / sides
    Turtle.draw((1 to sides).toList.flatMap { n =>
      List(turn(rotation), forward(sideLength))
    })
  }
  flatpolygon(5,100).draw

  def flatsquareSpiral(steps: Int, distance: Double, angle: Angle, increment: Double): Image = {
    Turtle.draw((1 to steps).toList.flatMap { n =>
      List(forward(distance + (n * increment)), turn(angle))
    })
  }
  flatsquareSpiral(300,10,89.degrees,3).draw
}
