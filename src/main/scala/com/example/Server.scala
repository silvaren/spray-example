package com.example

import akka.pattern.ask
import akka.actor.ActorRef
import com.amazonaws.services.lambda.runtime.Context
import spray.http.{HttpMethods, HttpRequest, HttpResponse, Uri}

import scala.concurrent.Await
import scala.concurrent.duration._
import scala.concurrent.ExecutionContext.Implicits.global

class Server (actor: ActorRef) {

  implicit val timeout = Boot.timeout

  def proxy(input: String, context: Context): String = {
    val response = (actor ? HttpRequest(HttpMethods.GET,Uri("/a")))
    val responseString = response.map(_.asInstanceOf[HttpResponse]).map(_.entity.asString)
    Await.result(responseString, 30 seconds)
  }

}
