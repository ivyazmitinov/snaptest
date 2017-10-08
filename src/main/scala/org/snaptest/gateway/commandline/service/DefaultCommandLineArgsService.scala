package org.snaptest.gateway.commandline.service

import org.apache.commons.cli.{DefaultParser, Option, Options}
import org.snaptest.gateway.commandline.service.CommandLineOptions._
import org.snaptest.processing.orchestration.data.StartArguments

class DefaultCommandLineArgsService {

  /**
    * Performs parsing, validation and conversion to the [[StartArguments]]
    *
    */
  def buildAndValidateParams(args: Array[String]): StartArguments = {

    val cmd = new DefaultParser().parse({
      val options = new Options()
      CommandLineOptions.allOptions.foreach((option: Option) => options.addOption(option))
      options
    }, args)

    CommandLineArgsValidator.validate(cmd)

    StartArguments(sourceFilePath = cmd.getOptionValue(SourcePathOption.getOpt),
      classPath = cmd.getOptionValue(ClassPathOption.getOpt),
      className = cmd.getOptionValue(ClassNameOption.getOpt))
  }

}
