package org.snaptest.processing.entrypoint.service

import org.snaptest.processing.ast.service.SpoonAstService
import org.snaptest.processing.entrypoint.data.StartArguments
import org.snaptest.processing.runtime.service.DefaultRuntimeService

/**
  * Facade over all processing
  */
class DefaultProcessingEntryPointService(val spoonAstService: SpoonAstService,
                                         val runtimeService: DefaultRuntimeService) {

  def start(params: StartArguments): Unit = {

    val ctModel = spoonAstService.build(params.sourceFilePath)
    val clazz = runtimeService.loadClass(params.className, params.classPath)
    //    val i = 1
  }

}
