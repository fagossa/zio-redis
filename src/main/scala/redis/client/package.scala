package redis

import scalaz.zio.TaskR

package object client {
  type TaskS[A] = TaskR[RedisClientZIO, A]
}
