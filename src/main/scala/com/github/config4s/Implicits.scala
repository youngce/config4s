package com.github.config4s

import com.typesafe.config.{Config, ConfigFactory}

object Implicits {




	implicit class JDuration(jd:java.time.Duration){
		def asScala= scala.concurrent.duration.Duration.fromNanos(jd.toNanos)
	}
	val cfg=ConfigFactory.defaultApplication()
	implicit class JList[T](jl: java.util.List[T]){
		import scala.collection.JavaConverters._
		def asScala1= jl.asScala
	}
	implicit class RichConfig(cfg:Config){

		def getAnyRefOpt(path:String): Option[AnyRef] ={
			if (cfg.hasPath(path)) Some(cfg.getAnyRef(path)) else None
		}
		def getStringOpt(path:String): Option[String] ={
			getOpt[String](path)
		}
		def getBooleanOpt(path:String) ={

			getOpt[Boolean](path)
		}
		def getIntOpt(path:String)={
			getOpt[Int](path)
		}




		def getOpt[T <:Any](path:String):Option[T] ={
			getAnyRefOpt(path).map(_.asInstanceOf[T])
		}
	}







}
