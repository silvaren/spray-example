organization  := "com.example"

version       := "0.1"

scalaVersion  := "2.11.6"

scalacOptions := Seq("-unchecked", "-deprecation", "-encoding", "utf8")

libraryDependencies ++= {
  val akkaV = "2.3.9"
  val sprayV = "1.3.3"
  Seq(
    "io.spray"            %%  "spray-can"     % sprayV,
    "io.spray"            %%  "spray-routing" % sprayV,
    "io.spray"            %%  "spray-testkit" % sprayV  % "test",
    "com.typesafe.akka"   %%  "akka-actor"    % akkaV,
    "com.typesafe.akka"   %%  "akka-testkit"  % akkaV   % "test",
    "org.specs2"          %%  "specs2-core"   % "2.3.11" % "test"
  )
}

libraryDependencies += "com.amazonaws" % "aws-lambda-java-core" % "1.1.0"

assemblyMergeStrategy in assembly := {
  case PathList("META-INF", xs @ _*) => MergeStrategy.discard
  case x => MergeStrategy.first
}

Revolver.settings

retrieveManaged := true

enablePlugins(AwsLambdaPlugin)

deployMethod := Some("DIRECT")

lambdaName := Some("SprayExample")

handlerName := Some("com.example.NewHandler::handleRequest")

awsLambdaMemory := Some(128)

awsLambdaTimeout := Some(30)

roleArn := Some("arn:aws:iam::652271758785:role/service-role/lambda_basic_execution")

region := Some("us-west-2")
