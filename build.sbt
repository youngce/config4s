import com.typesafe.sbt.pgp.PgpKeys.{gpgCommand,pgpSecretRing,useGpg}
name := "config4s"

version := "0.1"

scalaVersion := "2.12.4"

libraryDependencies += "com.typesafe" % "config" % "1.3.1"

useGpg := true
gpgCommand := "/usr/local/bin/gpg"
//pgpSecretRing := file("./secring.gpg")

// POM settings for Sonatype
val user="youngce"
//val projectName=name.value
val githubSuffix=s"$user/config4s"

homepage := Some(url(s"https://github.com/$githubSuffix"))
scmInfo := Some(ScmInfo(url(s"https://github.com/$githubSuffix"),s"git@github.com:$githubSuffix.git"))
developers := List(Developer("youngce",
	"Mark Yang",
	"youngce0918@gmail.com",
	url(s"https://github.com/$user")))
licenses += ("Apache-2.0", url("http://www.apache.org/licenses/LICENSE-2.0"))



publishMavenStyle := true


// Add sonatype repository settings
publishTo := Some(
	if (isSnapshot.value)
		Opts.resolver.sonatypeSnapshots
	else
		Opts.resolver.sonatypeStaging
)
