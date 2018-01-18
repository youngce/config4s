package com.github.config4s


import java.{lang, util}
import java.util.Map
import java.util.concurrent.TimeUnit

import com.typesafe.config._
import Implicits._

import scala.concurrent.duration.Duration
import scala.collection.JavaConverters._
import scala.collection.mutable
import scala.reflect.ClassTag
class Config4s(cfg:Config) {
	def getIntList(path: String): mutable.Seq[Int] =
		cfg.getIntList(path).asScala.map(_.asInstanceOf[Int])

	def getLongList(path: String): mutable.Seq[Long] =
		cfg.getLongList(path).asScala.map(_.asInstanceOf[Long])

	def resolve(): Config4s = cfg.resolve().asScala

	def resolve(options: ConfigResolveOptions): Config4s =
		cfg.resolve(options).asScala

//	def getEnum[T <: Enum[T]](enumClass: Class[T], path: String): T = cfg.

	def getMemorySize(path: String): ConfigMemorySize = cfg.getMemorySize(path)

	def getBytes(path: String): Long = cfg.getBytes(path)



	def withValue(path: String, value: ConfigValue): Config4s =
		cfg.withValue(path,value).asScala

	def getDuration(path: String, unit: TimeUnit): Long = cfg.getDuration(path,unit)

	def getDuration(path: String): Duration = cfg.getDuration(path).asScala

	def getList(path: String): ConfigList = ???

	def isResolved: Boolean = cfg.isResolved

	def getAnyRef(path: String): AnyRef = cfg.getAnyRef(path)

	def getObjectList(path: String): util.List[_ <: ConfigObject] = ???

	def atKey(key: String): Config4s = cfg.atKey(key).asScala

	def getNumberList(path: String): mutable.Seq[Number] = cfg.getNumberList(path).asScala

	def getObject(path: String): ConfigObject = ???

	def entrySet(): util.Set[Map.Entry[String, ConfigValue]] = ???

	def getDoubleList(path: String): mutable.Seq[Double] =
		cfg.getDoubleList(path).asScala.map(_.asInstanceOf[Double])

	def withOnlyPath(path: String): Config4s = cfg.withOnlyPath(path).asScala

	def getInt(path: String): Int = cfg.getInt(path)

	def getMemorySizeList(path: String): mutable.Seq[ConfigMemorySize] =
		cfg.getMemorySizeList(path).asScala



	def resolveWith(source: Config): Config4s = cfg.resolveWith(source).asScala

	def resolveWith(source: Config, options: ConfigResolveOptions): Config4s =
		cfg.resolveWith(source,options).asScala

	def getConfigList(path: String): mutable.Seq[Config4s] =
		cfg.getConfigList(path).asScala.map(_.asScala)

	def hasPathOrNull(path: String): Boolean = cfg.hasPathOrNull(path)

	def getStringList(path: String): mutable.Seq[String] = cfg.getStringList(path).asScala

	def getBytesList(path: String): mutable.Seq[Long] =
		cfg.getBytesList(path).asScala.map(_.asInstanceOf[Long])

	def getBooleanList(path: String): mutable.Seq[Boolean] =
		cfg.getBooleanList(path).asScala.map(_.asInstanceOf[Boolean])

	def checkValid(reference: Config, restrictToPaths: String*): Unit =
		cfg.checkValid(reference,restrictToPaths:_*)

	def as[T](implicit ct:ClassTag[T]):T={
		ct.runtimeClass.newInstance().asInstanceOf[T]
	}

	override def getMillisecondsList(path: String): mutable.Seq[Long] = ???

	override def origin(): ConfigOrigin = ???

	override def getDouble(path: String): Double = ???

	override def getNumber(path: String): Number = ???

	override def root(): ConfigObject = ???

	override def hasPath(path: String): Boolean = ???

	override def getDurationList(path: String, unit: TimeUnit): util.List[lang.Long] = ???

	override def getDurationList(path: String): util.List[Duration] = ???

	override def getBoolean(path: String): Boolean = ???

	override def getEnumList[T <: Enum[T]](enumClass: Class[T], path: String): util.List[T] = ???

	override def withoutPath(path: String): Config = ???

	override def withFallback(other: ConfigMergeable): Config = ???

	override def isEmpty: Boolean = ???

	override def getString(path: String): String = ???

	override def getConfig(path: String): Config = ???

	override def getLong(path: String): Long = ???

	override def getValue(path: String): ConfigValue = ???

	override def getNanoseconds(path: String): lang.Long = ???

	override def atPath(path: String): Config = ???

	override def getIsNull(path: String): Boolean = ???

	override def getAnyRefList(path: String): util.List[_] = ???
}
