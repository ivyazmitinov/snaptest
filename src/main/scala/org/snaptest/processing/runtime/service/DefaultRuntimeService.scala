package org.snaptest.processing.runtime.service

import java.io.File
import java.net.URLClassLoader

class DefaultRuntimeService {

  def loadClass(className: String, classPath: String): Class[_] = {


    val url = new File(classPath).toURI().toURL()
    val urlClassLoader = new URLClassLoader(Array(url))
    urlClassLoader.loadClass(className)
  }

}
