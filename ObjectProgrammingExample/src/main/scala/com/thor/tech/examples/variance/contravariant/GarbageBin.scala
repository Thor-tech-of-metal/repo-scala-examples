package com.thor.tech.examples.variance.contravariant

import com.thor.tech.examples.variance.contravariant.model.{PaperItem, PlasticBottle, PlasticItem, SpecailPlasticBottle}

/**
  * This is class is going to handle all A super types
  *
  * @tparam A this is the type parameter..
  */
class GarbageBin [-A] (items: List[A]) {

  def putAll(items: List[A]): GarbageBin[A] = new GarbageBin(items:::items)

  def itemsCount: Int = this.items.size

  def compressTrash: List[String] ={

    items map { element => s"Compressed item: ${element.toString}"}
  }

}


/**
  * This PlasticRecyclableMachine is able to recycle SpecailPlasticBottle and all super classes only.
  * @param garbageBin This the bin container to be used for the recycling.
  */
case class PlasticRecyclableMachine(garbageBin: GarbageBin[SpecailPlasticBottle]){

  def recyclePlasticContent(): List [String] = garbageBin.compressTrash

}


