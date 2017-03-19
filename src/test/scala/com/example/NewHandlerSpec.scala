package com.example

import java.io.{ByteArrayInputStream, ByteArrayOutputStream}

import org.specs2.mutable.Specification

class NewHandlerSpec extends Specification {

  val inputStringForRouteA = """{
        "resource": "/{proxy+}",
        "path": "/a",
        "httpMethod": "GET",
        "headers": {
          "Accept": "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8",
          "Accept-Encoding": "gzip, deflate, sdch, br",
          "Accept-Language": "en-US,en;q=0.8,fr;q=0.6,pt;q=0.4",
          "cache-control": "max-age=0",
          "CloudFront-Forwarded-Proto": "https",
          "CloudFront-Is-Desktop-Viewer": "true",
          "CloudFront-Is-Mobile-Viewer": "false",
          "CloudFront-Is-SmartTV-Viewer": "false",
          "CloudFront-Is-Tablet-Viewer": "false",
          "CloudFront-Viewer-Country": "BR",
          "Host": "4phet300bj.execute-api.us-west-2.amazonaws.com",
          "upgrade-insecure-requests": "1",
          "User-Agent": "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_6) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36",
          "Via": "2.0 b5978c85527d1d1df42d24c8cd4fa4a9.cloudfront.net (CloudFront)",
          "X-Amz-Cf-Id": "hC4tCpiPLdEUfXKvMF6QzDMFDqu56Je9wMmNp5F7ExSgkQHpIg-x9w==",
          "X-Amzn-Trace-Id": "Root=1-58bcab84-7734e7e82b2fd0a51b84a816",
          "X-Forwarded-For": "179.181.71.227, 54.182.233.77",
          "X-Forwarded-Port": "443",
          "X-Forwarded-Proto": "https"
        },
        "queryStringParameters": null,
        "pathParameters": {
          "proxy": "a"
        },
        "stageVariables": null,
        "requestContext": {
          "accountId": "652271758785",
          "resourceId": "6wpa7g",
          "stage": "prod",
          "requestId": "d54e54f5-0202-11e7-83ea-8d40733c326f",
          "identity": {
          "cognitoIdentityPoolId": null,
          "accountId": null,
          "cognitoIdentityId": null,
          "caller": null,
          "apiKey": null,
          "sourceIp": "179.181.71.227",
          "accessKey": null,
          "cognitoAuthenticationType": null,
          "cognitoAuthenticationProvider": null,
          "userArn": null,
          "userAgent": "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_6) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36",
          "user": null
        },
          "resourcePath": "/{proxy+}",
          "httpMethod": "GET",
          "apiId": "4phet300bj"
        },
        "body": null,
        "isBase64Encoded": false
      }"""

  val inputStringForRouteB = """{
        "resource": "/{proxy+}",
        "path": "/b",
        "httpMethod": "GET",
        "headers": {
          "Accept": "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8",
          "Accept-Encoding": "gzip, deflate, sdch, br",
          "Accept-Language": "en-US,en;q=0.8,fr;q=0.6,pt;q=0.4",
          "cache-control": "max-age=0",
          "CloudFront-Forwarded-Proto": "https",
          "CloudFront-Is-Desktop-Viewer": "true",
          "CloudFront-Is-Mobile-Viewer": "false",
          "CloudFront-Is-SmartTV-Viewer": "false",
          "CloudFront-Is-Tablet-Viewer": "false",
          "CloudFront-Viewer-Country": "BR",
          "Host": "4phet300bj.execute-api.us-west-2.amazonaws.com",
          "upgrade-insecure-requests": "1",
          "User-Agent": "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_6) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36",
          "Via": "2.0 b5978c85527d1d1df42d24c8cd4fa4a9.cloudfront.net (CloudFront)",
          "X-Amz-Cf-Id": "hC4tCpiPLdEUfXKvMF6QzDMFDqu56Je9wMmNp5F7ExSgkQHpIg-x9w==",
          "X-Amzn-Trace-Id": "Root=1-58bcab84-7734e7e82b2fd0a51b84a816",
          "X-Forwarded-For": "179.181.71.227, 54.182.233.77",
          "X-Forwarded-Port": "443",
          "X-Forwarded-Proto": "https"
        },
        "queryStringParameters": null,
        "pathParameters": {
          "proxy": "b"
        },
        "stageVariables": null,
        "requestContext": {
          "accountId": "652271758785",
          "resourceId": "6wpa7g",
          "stage": "prod",
          "requestId": "d54e54f5-0202-11e7-83ea-8d40733c326f",
          "identity": {
          "cognitoIdentityPoolId": null,
          "accountId": null,
          "cognitoIdentityId": null,
          "caller": null,
          "apiKey": null,
          "sourceIp": "179.181.71.227",
          "accessKey": null,
          "cognitoAuthenticationType": null,
          "cognitoAuthenticationProvider": null,
          "userArn": null,
          "userAgent": "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_6) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36",
          "user": null
        },
          "resourcePath": "/{proxy+}",
          "httpMethod": "GET",
          "apiId": "4phet300bj"
        },
        "body": null,
        "isBase64Encoded": false
      }"""

  val inputStringForRouteHeaders = """{
        "resource": "/{proxy+}",
        "path": "/headers",
        "httpMethod": "GET",
        "headers": {
          "Accept": "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8",
          "Accept-Encoding": "gzip, deflate, sdch, br",
          "Accept-Language": "en-US,en;q=0.8,fr;q=0.6,pt;q=0.4",
          "cache-control": "max-age=0",
          "CloudFront-Forwarded-Proto": "https",
          "CloudFront-Is-Desktop-Viewer": "true",
          "CloudFront-Is-Mobile-Viewer": "false",
          "CloudFront-Is-SmartTV-Viewer": "false",
          "CloudFront-Is-Tablet-Viewer": "false",
          "CloudFront-Viewer-Country": "BR",
          "Host": "4phet300bj.execute-api.us-west-2.amazonaws.com",
          "upgrade-insecure-requests": "1",
          "User-Agent": "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_6) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36",
          "Via": "2.0 b5978c85527d1d1df42d24c8cd4fa4a9.cloudfront.net (CloudFront)",
          "X-Amz-Cf-Id": "hC4tCpiPLdEUfXKvMF6QzDMFDqu56Je9wMmNp5F7ExSgkQHpIg-x9w==",
          "X-Amzn-Trace-Id": "Root=1-58bcab84-7734e7e82b2fd0a51b84a816",
          "X-Forwarded-For": "179.181.71.227, 54.182.233.77",
          "X-Forwarded-Port": "443",
          "X-Forwarded-Proto": "https",
          "X-User-Id": "myuserid"
        },
        "queryStringParameters": null,
        "pathParameters": {
          "proxy": "headers"
        },
        "stageVariables": null,
        "requestContext": {
          "accountId": "652271758785",
          "resourceId": "6wpa7g",
          "stage": "prod",
          "requestId": "d54e54f5-0202-11e7-83ea-8d40733c326f",
          "identity": {
          "cognitoIdentityPoolId": null,
          "accountId": null,
          "cognitoIdentityId": null,
          "caller": null,
          "apiKey": null,
          "sourceIp": "179.181.71.227",
          "accessKey": null,
          "cognitoAuthenticationType": null,
          "cognitoAuthenticationProvider": null,
          "userArn": null,
          "userAgent": "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_6) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36",
          "user": null
        },
          "resourcePath": "/{proxy+}",
          "httpMethod": "GET",
          "apiId": "4phet300bj"
        },
        "body": null,
        "isBase64Encoded": false
      }"""

  val inputStringForQueryParams = """{
    "resource": "/{proxy+}",
    "path": "/query",
    "httpMethod": "GET",
    "headers": {
      "Accept": "*/*",
      "Accept-Encoding": "gzip, deflate, sdch, br",
      "Accept-Language": "en-US,en;q=0.8,fr;q=0.6,pt;q=0.4",
      "cache-control": "no-cache",
      "CloudFront-Forwarded-Proto": "https",
      "CloudFront-Is-Desktop-Viewer": "true",
      "CloudFront-Is-Mobile-Viewer": "false",
      "CloudFront-Is-SmartTV-Viewer": "false",
      "CloudFront-Is-Tablet-Viewer": "false",
      "CloudFront-Viewer-Country": "BR",
      "Host": "4phet300bj.execute-api.us-west-2.amazonaws.com",
      "postman-token": "c5a543d5-f9b5-dbba-913e-23c8f2b58e71",
      "User-Agent": "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_6) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36",
      "Via": "2.0 1d7454c76d6ac81147ca3cbd1284c8ae.cloudfront.net (CloudFront)",
      "X-Amz-Cf-Id": "PZxUdDKOpChbVnCFDrDrtYscuVdHAMfGivBKK0jQBd1jjwW0uqDSWQ==",
      "X-Amzn-Trace-Id": "Root=1-58ca815e-5021e2fe215bc94041d71c4d",
      "X-Forwarded-For": "177.135.97.51, 205.251.221.76",
      "X-Forwarded-Port": "443",
      "X-Forwarded-Proto": "https"
    },
    "queryStringParameters": {
      "thisparam": "thisvalue"
    },
    "pathParameters": {
      "proxy": "query"
    },
    "stageVariables": null,
    "requestContext": {
      "accountId": "652271758785",
      "resourceId": "6wpa7g",
      "stage": "prod",
      "requestId": "f07fd1d2-0a41-11e7-9bf2-b744cea6b478",
      "identity": {
      "cognitoIdentityPoolId": null,
      "accountId": null,
      "cognitoIdentityId": null,
      "caller": null,
      "apiKey": null,
      "sourceIp": "177.135.97.51",
      "accessKey": null,
      "cognitoAuthenticationType": null,
      "cognitoAuthenticationProvider": null,
      "userArn": null,
      "userAgent": "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_6) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36",
      "user": null
    },
      "resourcePath": "/{proxy+}",
      "httpMethod": "GET",
      "apiId": "4phet300bj"
    },
    "body": null,
    "isBase64Encoded": false
  }"""

  val inputStringForPathParams = """{
    "resource": "/{proxy+}",
    "path": "/pathparams/pathvalue1/andanother/42",
    "httpMethod": "GET",
    "headers": {
      "Accept": "*/*",
      "Accept-Encoding": "gzip, deflate, sdch, br",
      "Accept-Language": "en-US,en;q=0.8,fr;q=0.6,pt;q=0.4",
      "cache-control": "no-cache",
      "CloudFront-Forwarded-Proto": "https",
      "CloudFront-Is-Desktop-Viewer": "true",
      "CloudFront-Is-Mobile-Viewer": "false",
      "CloudFront-Is-SmartTV-Viewer": "false",
      "CloudFront-Is-Tablet-Viewer": "false",
      "CloudFront-Viewer-Country": "BR",
      "Host": "4phet300bj.execute-api.us-west-2.amazonaws.com",
      "postman-token": "1ecc6cb1-3ee9-9b73-016c-430964a33d8f",
      "User-Agent": "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_6) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36",
      "Via": "2.0 a0d2f65264713c255448d1a4c773a5fe.cloudfront.net (CloudFront)",
      "X-Amz-Cf-Id": "rAIhsXF_aT4OnQo5iKtPYGFn0_noCswZKKHsjP174XzKiTEUq5AYyg==",
      "X-Amzn-Trace-Id": "Root=1-58cdac5d-659d156e647eb012431d44f7",
      "X-Forwarded-For": "201.22.222.58, 205.251.221.84",
      "X-Forwarded-Port": "443",
      "X-Forwarded-Proto": "https"
    },
    "queryStringParameters": null,
    "pathParameters": {
      "proxy": "pathparams/pathvalue1/andanother/42"
    },
    "stageVariables": null,
    "requestContext": {
      "accountId": "652271758785",
      "resourceId": "6wpa7g",
      "stage": "prod",
      "requestId": "55252413-0c25-11e7-bfb9-a3549facd2e3",
      "identity": {
      "cognitoIdentityPoolId": null,
      "accountId": null,
      "cognitoIdentityId": null,
      "caller": null,
      "apiKey": null,
      "sourceIp": "201.22.222.58",
      "accessKey": null,
      "cognitoAuthenticationType": null,
      "cognitoAuthenticationProvider": null,
      "userArn": null,
      "userAgent": "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_6) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36",
      "user": null
    },
      "resourcePath": "/{proxy+}",
      "httpMethod": "GET",
      "apiId": "4phet300bj"
    },
    "body": null,
    "isBase64Encoded": false
  }"""

  "NewHandler" should {

    "return a! in route A" in {
      val inputStream = new ByteArrayInputStream(inputStringForRouteA.getBytes())
      val outputStream = new ByteArrayOutputStream()
      NewHandler.handleRequest(inputStream,outputStream,null)
      outputStream.toString must contain("A!")
    }

    "return b! in route B" in {
      val inputStream = new ByteArrayInputStream(inputStringForRouteB.getBytes())
      val outputStream = new ByteArrayOutputStream()
      NewHandler.handleRequest(inputStream,outputStream,null)
      outputStream.toString must contain("B!")
    }

    "return userId from header" in {
      val inputStream = new ByteArrayInputStream(inputStringForRouteHeaders.getBytes())
      val outputStream = new ByteArrayOutputStream()
      NewHandler.handleRequest(inputStream,outputStream,null)
      outputStream.toString must contain("myuserid")
    }

    "return value from query param" in {
      val inputStream = new ByteArrayInputStream(inputStringForQueryParams.getBytes())
      val outputStream = new ByteArrayOutputStream()
      NewHandler.handleRequest(inputStream,outputStream,null)
      outputStream.toString must contain("thisvalue")
    }

    "return values from path param" in {
      val inputStream = new ByteArrayInputStream(inputStringForPathParams.getBytes())
      val outputStream = new ByteArrayOutputStream()
      NewHandler.handleRequest(inputStream,outputStream,null)
      outputStream.toString must contain("pathvalue1")
      outputStream.toString must contain("42")
    }
  }
}
