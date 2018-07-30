package com.thor.tech.examples.variance.covariants

import com.thor.tech.examples.variance.covariants.model._
import org.scalamock.scalatest.MockFactory
import org.scalatest.{BeforeAndAfter, FlatSpec, Matchers}

class CovarianceTest extends FlatSpec with Matchers with BeforeAndAfter with MockFactory {

  it should s"Evalute SoftDrinks in VendingMachine dispenseNext()" in {

    val softDrinksVM: VendingMachine[SoftDrink] = VendingMachine (

      Some(new Cola("Coca cola Goliat del conur!")),
      List(new TonicWater("TonicWater carlitos"),new Cola("Cocucha") )
    )

    val nextSoftDrink = softDrinksVM.dispenseNext();

    nextSoftDrink.items should be ( List(new Cola("Cocucha")) )
  }


  it should s"Evalute SoftDrinks in VendingMachine dispenseNext() and addAll" in {

    val softDrinksVM: VendingMachine[SoftDrink] = VendingMachine (

      Some(new Cola("Coca cola Goliat del conur!")),
      List(new TonicWater("TonicWater carlitos"),new Cola("Cocucha") )
    )

    val result = softDrinksVM.dispenseNext().addAll(List(new Cola("Cocucha pretty")));

    result.items should be ( List(Cola("Cocucha"), Cola("Cocucha pretty")) )
  }


  it should s"Evalute Juice in VendingMachine dispenseNext()" in {

    val softDrinksVM: VendingMachine[Juice] = VendingMachine (

      Some(Orange("Tropicana brazuka")),
      List(Apple("Cepita"),Orange("Cepita naranja") )
    )

    val nextSoftDrink = softDrinksVM.dispenseNext();

    nextSoftDrink.items should be ( List(new Orange("Cepita naranja")) )
  }

  it should s"Evalute Juice in VendingMachine dispenseNext() and addAll" in {

    val softDrinksVM: VendingMachine[Juice] = VendingMachine (

      Some(Orange("Tropicana brazuka")),
      List(Apple("Cepita"),Orange("Cepita naranja") )
    )

    val nextSoftDrink = softDrinksVM.dispenseNext().addAll(List(new Orange("Cepita naranja")));

    nextSoftDrink.items should be ( List(Orange("Cepita naranja"), Orange("Cepita naranja")) )
  }
}
