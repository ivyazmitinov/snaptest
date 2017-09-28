package org.snaptest

import org.snaptest.config.components.ComponentsRegistry

object Main {

  private val startService = ComponentsRegistry.startService
  private val argsService = ComponentsRegistry.commandLineArgsService

  def main(args: Array[String]): Unit = {
    startService.start(argsService.buildAndValidateParams(args))
  }

}