package org.snaptest

import org.snaptest.config.components.ComponentsRegistry

object Main {

  private val orchestrationService = ComponentsRegistry.processingOrchestrationService
  private val argsService = ComponentsRegistry.commandLineArgsService

  def main(args: Array[String]): Unit = {

    orchestrationService.start(argsService.buildAndValidateParams(args))
  }

}