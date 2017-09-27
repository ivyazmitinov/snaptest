package org.snaptest.gateway.commandline

import org.apache.commons.cli.CommandLine

private object CommandLineArgsValidator {

  val requiredOptions = Set(CommandLineOptions.TestClassOption.getOpt)
  val errorMessages = Map(
    CommandLineOptions.TestClassOption.getOpt -> "t option should be specified"
  )

  def validate(cmd: CommandLine): Unit = {
    for (option <- requiredOptions) {
      if (!cmd.hasOption(option)) {
        throw new IllegalArgumentException(errorMessages(option))
      }
    }
  }
}
