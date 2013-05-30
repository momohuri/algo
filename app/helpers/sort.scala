package helpers

import scala.util.Random


/**
 * Created with IntelliJ IDEA.
 * User: momo
 * Date: 5/25/13
 * Time: 5:08 PM
 * To change this template use File | Settings | File Templates.
 */
object sort {

    def randomArray(arraySize : Int):List[Int] = {
      var array = List[Int]()

        for ( a <- (0 to arraySize/10).par){
        array =  array :+ Random.nextInt(1000)
      }
        //the /10 and concat with the same arrays it because it s to long to generate the table.
        for (a <- (0 to 9).par){
        array = List.concat(array ,array)
      }
      return array
    }


    def QuickSort(myArray : List[Int]):List[Int] =  {
      if(myArray.length <=1 ) return myArray
      else{
        val pivot = myArray(myArray.length/2)
        List.concat(
          QuickSort(myArray filter (pivot >) ),
          myArray filter (pivot==),
          QuickSort(myArray filter (pivot <))
        )
      }
  }



  def mergeSort(list:List[Int]):List[Int] = {
    list match {
      case x::Nil=> List(x)
      case _ =>
        val (a, b) = list.splitAt(list.length /2)
        mergeForMergeSort(mergeSort(a), mergeSort(b))
    }
    def mergeForMergeSort(aList:List[Int], bList:List[Int]):List[Int]= bList match {
      case Nil =>  aList //return if b isempty
      case _ =>
        aList match {
          case Nil => bList    //return if a isempty
          case x::xs =>
            if (x < bList.head)
              x::mergeForMergeSort(xs, bList)
            else
              bList.head::mergeForMergeSort(aList, bList.tail)
        }
    }
  }

}
