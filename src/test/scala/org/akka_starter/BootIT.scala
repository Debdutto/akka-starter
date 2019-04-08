package org.akka_starter

import akka.stream.scaladsl.Source
import akka.util.ByteString
import com.softwaremill.sttp._
import com.softwaremill.sttp.akkahttp.AkkaHttpBackend

import scala.concurrent.Future

/**
  * Basic Tests for API
  *
  * @@soundtrack Cycling Trivialities - José González
  */
class BootIT extends BaseServiceTest {

  implicit val sttpBackend: SttpBackend[Future, Source[ByteString, Any]] = AkkaHttpBackend()

  "Service" should {

    "bind on port successfully and answer on health checks" in {
      awaitForResult(for {
        serverBinding <- Main.start()
        healthCheckResponse <- sttp.get(uri"http://localhost:8080/ping").send()
        _ <- serverBinding.unbind()
      } yield {
        healthCheckResponse.code shouldBe 200
        healthCheckResponse.body shouldBe Right("pong")
      })
    }
  }
}