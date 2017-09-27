package org.snaptest.gateway.commandline

import org.apache.commons.cli.{DefaultParser, Option, Options}
import org.snaptest.processing.data.ParametersParsingResult

object CommandLineArgsProcessor {

  /**
    * Performs parsing, validation and conversion to the ParametersParsingResult
    *
    */
  def process(args: Array[String]): ParametersParsingResult = {
    val cmd = new DefaultParser().parse({
      val options = new Options()
      CommandLineOptions.allOptions.foreach((option: Option) => options.addOption(option))
      options
    }, args)
    CommandLineArgsValidator.validate(cmd)
    ParametersParsingResult(testFile = cmd.getOptionValue("t"))
  }

}
