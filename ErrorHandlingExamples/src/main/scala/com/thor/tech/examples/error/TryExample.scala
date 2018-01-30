package com.thor.tech.examples.error

import java.io.InputStream
import java.net.URL

import scala.io.Source
import scala.util.Try


object TryExample {


  def parseURL(url: String): Try[URL] = Try(new URL(url))

  def parseHttpURL(url: String) = parseURL(url).filter(_.getProtocol == "http")


  def inputStreamForURL(url: String): Try[InputStream] = {

    parseURL(url).flatMap { u =>
      Try(u.openConnection()).flatMap(conn => Try(conn.getInputStream))
    }
  }

  def getURLContent(url: String): Try[Iterator[String]] = {

    for {
      url <- parseURL(url)
      connection <- Try(url.openConnection())
      inputStream <- Try(connection.getInputStream)
      source = Source.fromInputStream(inputStream)
    } yield {
      source.getLines()
    }
  }

}
