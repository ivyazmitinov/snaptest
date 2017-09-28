package org.snaptest.gateway.commandline.service

import org.apache.commons.cli.{DefaultParser, Option, Options}
import org.snaptest.processing.start.data.StartArguments

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
    StartArguments(testFile = cmd.getOptionValue("t"))
  }

}
