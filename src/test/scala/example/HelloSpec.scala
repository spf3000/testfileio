package example

import org.scalatest._

import scala.io.Source
import java.io._

class HelloSpec extends FlatSpec with Matchers {
  "this test" should "write a file to root and then read it" in {
     val file = new File("testfile.txt")
     val bw = new BufferedWriter(new FileWriter(file))
     bw.write("yello!!")
     bw.close()

     Thread.sleep(1000)
    val relativePath = "./testfile.txt"
    val lines : List[String] = Source.fromFile(relativePath).getLines.toList

   lines should contain("yello!!")

  }
}
