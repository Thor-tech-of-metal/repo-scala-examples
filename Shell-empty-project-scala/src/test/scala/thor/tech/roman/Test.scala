package thor.tech.roman

import org.scalamock.scalatest.MockFactory
import org.scalatest.{BeforeAndAfter, FlatSpec, Matchers}


class Test extends FlatSpec with Matchers with BeforeAndAfter with MockFactory {


  for( number <- 1 to 10){

    it should s"calculate ${number}" in {

      true should be (true)
    }
  }

}
