package org.snaptest.config.components

import org.snaptest.gateway.commandline.service.DefaultCommandLineArgsService
import org.snaptest.processing.ast.service.SpoonAstService
import org.snaptest.processing.start.service.DefaultStartService

object ComponentsRegistry extends CommandLineComponent
  with StartComponent
  with SpoonAstComponent {
  override lazy val commandLineArgsService = new DefaultCommandLineArgsService
  override lazy val startService = new DefaultStartService(astService)
  override lazy val astService = new SpoonAstService
}
