package redis.client

import com.redis.RedisClient
import scalaz.zio.ZIO

import scala.util.Try

case class RedisClientZIO private(private val client: RedisClient) {
  def set(key: String, value: String): TaskS[Boolean] =
    ZIO.access(_.client.set(key, value))

  def get(key: String): TaskS[Option[String]] =
    ZIO.access(_.client.get(key))
}

object RedisClientZIO {

  def apply(host: String, port: Int): Try[RedisClientZIO] = Try {
    RedisClientZIO(new RedisClient(host, port))
  }

}