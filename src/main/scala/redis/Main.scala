package redis

import redis.client.RedisClientZIO
import redis.service.MyProgram
import scalaz.zio.{DefaultRuntime, Task}

import scala.concurrent.Await

object Main extends App with DefaultRuntime {
  RedisClientZIO("localhost", 6379)
    .fold(handleImpossibleConnection, handleSuccessConnection)

  private def handleImpossibleConnection(exception: scala.Throwable): Unit = {
    println(exception)
    System.exit(1)
  }

  private def handleSuccessConnection(client: RedisClientZIO): Unit = {
    val program = new MyProgram(client)

    // transform the
    val result = unsafeRun(
      program
        .run()
        .provide(client)
        .toFuture
    )

    import scala.concurrent.duration._
    Await.result(result, 5.seconds)
  }
}
