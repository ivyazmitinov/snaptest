package org.snaptest.processing.service.components

import org.snaptest.gateway.commandline.DefaultCommandLineArgsService
import org.snaptest.processing.service.DefaultStartService
import org.snaptest.processing.service.ast.SpoonAstService

object ComponentsRegistry extends CommandLineComponent
  with StartComponent
  with SpoonAstComponent {
  override lazy val commandLineArgsService = new DefaultCommandLineArgsService
  override lazy val startService = new DefaultStartService(astService)
  override lazy val astService = new SpoonAstService
}
