package org.snaptest.config.components

import org.snaptest.gateway.commandline.service.DefaultCommandLineArgsService

trait CommandLineComponent {

  val commandLineArgsService: DefaultCommandLineArgsService
}
