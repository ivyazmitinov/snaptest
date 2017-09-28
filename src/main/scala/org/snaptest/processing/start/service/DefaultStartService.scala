package org.snaptest.processing.start.service

import org.snaptest.processing.ast.service.SpoonAstService
import org.snaptest.processing.start.data.StartArguments

/**
  * Facade over all processing
  */
class DefaultStartService(val spoonAstService: SpoonAstService) {

  def start(params: StartArguments): Unit = {
    val ctModel = spoonAstService.build(params.testFile)
    val i = 1
  }

}
