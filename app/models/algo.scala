package models

import scala.util.Random
import helpers.sort
import play.api.libs.concurrent.Execution.Implicits._
import scala.concurrent.Future

/**
 * Created with IntelliJ IDEA.
 * User: momo
 * Date: 5/23/13
 * Time: 8:25 PM
 * class Algo
 */
class Algo  {
  var arraySize :Int = _
  var times :Int = _
  var name : String = _

  def caculAlgo () : Array[Long] = {
    // 0 = max , 1=min, 2 = total , 3 = median
    var arrayOfTime= Array[Long](0,999999999,0,0);
    val start =  System.currentTimeMillis()
    var array = List[Int]()
    for(a <- 0 to times){
      array =    sort.randomArray(arraySize)
      val before = System.currentTimeMillis
      name match {
        case "Quicksort" => {
              sort.QuickSort(array)
        }
        case "Mergesort" => {
              sort.mergeSort(array)
        }
      }
      val timeTaken = System.currentTimeMillis - before
      if(arrayOfTime(0)<timeTaken) {
        arrayOfTime(0) = timeTaken
      }else if (arrayOfTime(1)>timeTaken) {
        arrayOfTime(1) = timeTaken
      }
    }
    arrayOfTime(2) =  System.currentTimeMillis - start
    arrayOfTime(3) = (arrayOfTime(2) / times)
    return arrayOfTime

  }
}

object Algo {
  def unapply(a : Algo) = Some(a.arraySize,a.times,a.name)

  def apply(arraySize : Int, times : Int , name : String)={
    val a = new Algo
    a.arraySize=arraySize
    a.times = times
    a.name = name
    a
  }

}

