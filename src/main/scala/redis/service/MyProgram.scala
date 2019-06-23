package redis.service

import redis.client.{RedisClientZIO, TaskS}
import scalaz.zio.Task

class MyProgram(client: RedisClientZIO) {
  def putString(s: String): Task[Unit] = Task.effect(println(s))

  def run(): TaskS[Unit] = {
    for {
      _ <- client.set("name", "Diana")
      mName <- client.get("name")
      _ <- mName match {
        case Some(name) => putString(name)
        case _ => Task.succeed(())
      }
    } yield ()
  }
}
