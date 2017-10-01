package org.snaptest.config.components

import org.snaptest.gateway.commandline.service.DefaultCommandLineArgsService
import org.snaptest.processing.ast.service.SpoonAstService
import org.snaptest.processing.entrypoint.service.DefaultProcessingEntryPointService
import org.snaptest.processing.runtime.service.DefaultRuntimeService

object ComponentsRegistry extends CommandLineComponent
  with ProcessingEntryPointComponent
  with SpoonAstComponent
  with RuntimeComponent {

  override lazy val commandLineArgsService = new DefaultCommandLineArgsService
  override lazy val processingEntryPointService = new DefaultProcessingEntryPointService(astService, runtimeService)
  override lazy val astService = new SpoonAstService
  override lazy val runtimeService: DefaultRuntimeService = new DefaultRuntimeService
}
