package org.snaptest.processing.service

import org.snaptest.gateway.commandline.{CommandLineArgsProcessor, CommandLineArgsValidator}
import org.snaptest.processing.data.ParametersParsingResult
import org.snaptest.processing.service.ast.AstBuilder

object ProcessingFacade {

  def process(params: ParametersParsingResult): Unit = {
    val ctModel = AstBuilder.build(params.testFile)
  }

}
