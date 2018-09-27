package org.akka_starter

import akka.http.scaladsl.testkit.ScalatestRouteTest
import org.scalatest._
import org.scalatest.mockito.MockitoSugar

import scala.concurrent.duration._
import scala.concurrent.{Await, Future}

/**
  * BaseTest Class, Extend and use
  *
  * @@soundtrack Violin Concerto No. 1 "EsoConcerto": II. Adagio - Ezio Bosso
  */
trait BaseServiceTest extends WordSpec with Matchers with ScalatestRouteTest with MockitoSugar {

  def awaitForResult[T](futureResult: Future[T]): T =
    Await.result(futureResult, 5.seconds)
}