package com.thor.tech.examples.constructors

case class Path(coordinates:Map[Int,Int]) {

  //overload the constructor.
  def this(coordinates: (Int,Int) *) = this (coordinates.toMap)

  def getAllCoordinates = coordinates.map{
    element=> s"x: = ${element._1} and y: = ${element._2}"
  }
}
