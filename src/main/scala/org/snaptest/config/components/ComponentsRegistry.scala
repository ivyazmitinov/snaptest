package org.snaptest.config.components

import org.snaptest.gateway.commandline.service.DefaultCommandLineArgsService
import org.snaptest.processing.ast.service.SpoonAstService
import org.snaptest.processing.generation.model.service.DefaultModelGenerationService
import org.snaptest.processing.orchestration.service.DefaultProcessingOrchestrationService
import org.snaptest.processing.runtime.service.DefaultRuntimeService

object ComponentsRegistry extends CommandLineComponent
  with ProcessingOrchestrationComponent
  with SpoonAstComponent
  with RuntimeComponent
  with ModelGenerationComponent {

  override lazy val commandLineArgsService = new DefaultCommandLineArgsService
  override lazy val processingOrchestrationService = new DefaultProcessingOrchestrationService(astService, runtimeService, modelGenerationService)
  override lazy val astService = new SpoonAstService
  override lazy val runtimeService: DefaultRuntimeService = new DefaultRuntimeService
  override lazy val modelGenerationService: DefaultModelGenerationService = new DefaultModelGenerationService
}
