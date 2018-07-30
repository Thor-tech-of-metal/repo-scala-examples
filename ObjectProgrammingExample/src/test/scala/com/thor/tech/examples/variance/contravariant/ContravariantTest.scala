package com.thor.tech.examples.variance.contravariant

import com.thor.tech.examples.variance.contravariant.model.{PlasticBottle, PlasticItem, SpecailPlasticBottle}
import org.scalamock.scalatest.MockFactory
import org.scalatest.{BeforeAndAfter, FlatSpec, Matchers}

class ContravariantTest extends FlatSpec with Matchers with BeforeAndAfter with MockFactory {

  it should s"Evalute recycling PlasticRecyclableMachine for SpecailPlasticBottle and super classes only." in {

    val items=  List(
      new PlasticItem("plastic item."),
      new PlasticBottle("plastic bottle."),
      new SpecailPlasticBottle("special plastic bottle.")
    )

    val expectedResult = List("Compressed item: Item(plastic item.)", "Compressed item: Item(plastic bottle.)", "Compressed item: Item(special plastic bottle.)")

    val recyclablePlasticBin : GarbageBin[SpecailPlasticBottle] = new GarbageBin(items)


    val plasticRecyclableMachine = PlasticRecyclableMachine(recyclablePlasticBin)

    plasticRecyclableMachine.recyclePlasticContent()

    recyclablePlasticBin.compressTrash should be (expectedResult)
  }
}

