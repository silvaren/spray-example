package com.example

import akka.pattern.ask
import akka.actor.ActorRef
import com.amazonaws.services.lambda.runtime.Context

import scala.concurrent.Await
import scala.concurrent.duration._

case object AskResponseMessage

class Server (actor: ActorRef) {

  implicit val timeout = Boot.timeout

  def proxy(input: String, context: Context): String = {
    val response = (actor ? AskResponseMessage)
    Await.result(response, 30 seconds).asInstanceOf[String]
  }

}
