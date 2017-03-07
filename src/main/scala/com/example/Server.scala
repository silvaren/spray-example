package com.example

import akka.pattern.ask
import akka.actor.ActorRef
import com.amazonaws.services.lambda.runtime.Context
import spray.http.{HttpMethods, HttpRequest, HttpResponse, Uri}

import scala.concurrent.Await
import scala.concurrent.duration._
import scala.concurrent.ExecutionContext.Implicits.global

case class LambdaProxyEvent(resource: String, path: String, httpMethod: String, headers: Map[String,String],
                            queryStringParameters: Map[String,String], pathParameters: Map[String,String],
                            stageVariables: Map[String,String], requestContext: RequestContext,
                            body: String, isBase64Encoded: Boolean)

case class RequestContext(accountId: String, resourceId: String, stage: String, requestId: String, identity: String,
                           resourcePath: String, httpMethod: String, apiId: String)

case class Identity(cognitoIdentityPoolId: String, accountId: String, cognitoIdentityId: String, caller: String,
                   apiKey: String, sourceIp: String, cognitoAuthenticationType: String,
                    cognitoAuthenticationProvider: String, userArn: String, userAgent: String, user: String)


class Server (actor: ActorRef) {

  implicit val timeout = Boot.timeout

  def proxy(input: String, context: Context): String = {


    val response = (actor ? HttpRequest(HttpMethods.GET,Uri("/a")))
    val responseString = response.map(_.asInstanceOf[HttpResponse]).map(_.entity.asString)
    Await.result(responseString, 30 seconds)
  }

}
