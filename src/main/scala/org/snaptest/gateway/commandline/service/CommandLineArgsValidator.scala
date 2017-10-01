package org.snaptest.gateway.commandline.service

import org.apache.commons.cli.CommandLine
import org.snaptest.gateway.commandline.service.CommandLineOptions._

private object CommandLineArgsValidator {

  val requiredOptions = Set(SourcePathOption.getOpt,
    ClassPathOption.getOpt,
    ClassNameOption.getOpt)

  val errorMessages = Map(
    SourcePathOption.getOpt -> "t option should be specified",
    ClassPathOption.getOpt -> "xcp option should be specified"
  )

  def validate(cmd: CommandLine): Unit = {

    for (option <- requiredOptions) {
      if (!cmd.hasOption(option)) {
        throw new IllegalArgumentException(errorMessages(option))
      }
    }
  }

}
