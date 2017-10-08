package org.snaptest.processing.orchestration.service

import org.snaptest.processing.ast.service.SpoonAstService
import org.snaptest.processing.generation.model.service.DefaultModelGenerationService
import org.snaptest.processing.orchestration.data.StartArguments
import org.snaptest.processing.runtime.service.DefaultRuntimeService

/**
  * Facade over all processing
  */
class DefaultProcessingOrchestrationService(val spoonAstService: SpoonAstService,
                                            val runtimeService: DefaultRuntimeService,
                                            val modelGenerationService: DefaultModelGenerationService) {

  def start(params: StartArguments): Unit = {

    val ctModel = spoonAstService.build(params.sourceFilePath)
    val testCase = modelGenerationService.produceModel(ctModel)
    val clazz = runtimeService.loadClass(params.className, params.classPath)
    //    val i = 1
  }

}
