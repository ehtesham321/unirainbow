package org.example.testhello.impl

class fibo {
  var sum =1
  var x = 0
  var temp = 0
  def fib(i :Int): Unit ={
    val series = List[Int](i)
    for ( xx <- 0 to i){
      println(xx)
    }
    for ( xx <- 0 to i){
      temp = sum
      sum = sum + x
      series.+(sum.asInstanceOf[String])
      x = temp
    }
    println(series)
  }
}
