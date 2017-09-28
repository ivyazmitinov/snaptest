package org.snaptest.processing.service

import org.snaptest.processing.data.StartArguments
import org.snaptest.processing.service.ast.SpoonAstService

/**
  * Facade over all processing
  */
class DefaultStartService(val spoonAstService: SpoonAstService) {

  def start(params: StartArguments): Unit = {
    val ctModel = spoonAstService.build(params.testFile)
    val i = 1
  }

}
