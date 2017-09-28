package org.snaptest.processing.service.components

import org.snaptest.gateway.commandline.DefaultCommandLineArgsService

trait CommandLineComponent {

  val commandLineArgsService: DefaultCommandLineArgsService
}
