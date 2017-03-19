package com.example

import akka.actor.Actor
import spray.routing._
import spray.http._
import MediaTypes._

// we don't implement our route structure directly in the service actor because
// we want to be able to test it independently, without having to spin up an actor
class MyServiceActor extends Actor with MyService {

  // the HttpService trait defines only one abstract member, which
  // connects the services environment to the enclosing actor or test
  def actorRefFactory = context

  // this actor only runs our route, but you could add
  // other things here, like request stream processing
  // or timeout handling
  def receive = {
    runRoute(myRoute)
  }

}


// this trait defines our service behavior independently from the service actor
trait MyService extends HttpService {

  val myRoute =
    path("a") {
      get {
        respondWithMediaType(`text/html`) { // XML is marshalled to `text/xml` by default, so we simply override here
          complete {
            <html>
              <body>
                <h1>A!</h1>
              </body>
            </html>
          }
        }
      }
    } ~
      path("b") {
        get {
          respondWithMediaType(`text/html`) {
            // XML is marshalled to `text/xml` by default, so we simply override here
            complete {
              <html>
                <body>
                  <h1>B!</h1>
                </body>
              </html>
            }
          }
        }
      } ~
      path("headers") {
        get {
          headerValueByName("X-User-Id") { userId =>
            complete(s"The user is $userId")
          }
        }
      } ~
      path("query") {
        get {
          parameters("thisparam1", "thisparam2") { (thisparam1, thisparam2) =>
            complete(s"The first query param is '$thisparam1' and the second one is '$thisparam2'")
          }
        }
      } ~
      path("pathparams" / Segment / "andanother" / IntNumber) {(param1, param2) =>
        get {
          complete(s"The first path param is '$param1' and the second one is '$param2'")
        }
      }
}