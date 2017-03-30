package com.example

import java.io.{InputStream, OutputStream}

import com.amazonaws.services.lambda.runtime.{Context, RequestStreamHandler}

object NewHandler extends RequestStreamHandler {

  val server = new Server(Boot.service)

  override def handleRequest(is: InputStream, os: OutputStream, context: Context): Unit = {
    val input = scala.io.Source.fromInputStream(is).mkString
    println("input: ", input)
    val response: String = server.proxy(input, context)
    println("output: ", response)
    val integrationResponse = """{
      "statusCode": 200,
      "headers": {},
      "body": response
    }"""
    os.write(integrationResponse.getBytes("UTF-8"))
  }
}
