package kumar

import scala.math._

object getGeolocation {
  def addDistance(): (Double, Double) = {
    val cordinates: (Double, Double) = (12.916576, 77.610116)
    val randomOffsets = (5000, 5000)
    val lat = cordinates._1 + (180 / Pi) * (randomOffsets._2 / 6378137.00)
    val lon = cordinates._2 + (180 / Pi) * (randomOffsets._1 / 6378137.00) / cos(cordinates._1)
    println(s"New cordinates are ($lat,$lon")
    (lat, lon)

  }
  def getDistGeolocation(c1: (Double, Double), c2: (Double, Double)): Double = {
    val R = 6371; // Radius of the earth
    val latDistance = Math.toRadians(c2._1 - c1._1)
    val lonDistance = Math.toRadians(c2._2 - c1._2)
    val a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2) + Math.cos(Math.toRadians(c1._1)) * Math.cos(Math.toRadians(c1._2)) * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2)
    val c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a))
    val distance = R * c * 1000; // convert to meters
    distance
  }
  def main(args: Array[String]): Unit = {
    val distance = addDistance()
    val cordinates: (Double, Double) = (12.916576, 77.610116)
    val distanceBetween2cordinates=(getDistGeolocation((distance._1, distance._2), cordinates))
    val disInLKm=distanceBetween2cordinates/1000.00
    println(s"the distance in km is $disInLKm")

  }
}