package com.example

import java.io.{InputStream, OutputStream}

import com.amazonaws.services.lambda.runtime.{Context, RequestStreamHandler}

object NewHandler extends RequestStreamHandler {

  override def handleRequest(is: InputStream, os: OutputStream, context: Context): Unit = {
    val input = scala.io.Source.fromInputStream(is).mkString
    println("input: ", input)
    val output = """{
      "statusCode": 200,
      "headers": { "headerName": "headerValue"},
      "body": "bla"
    }""".filter(_ != '\n')
    println("output: ", output)
    os.write(output.getBytes("UTF-8"))
  }
}
