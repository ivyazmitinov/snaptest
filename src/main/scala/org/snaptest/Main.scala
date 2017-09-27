package org.snaptest

import org.snaptest.gateway.commandline.CommandLineArgsProcessor
import org.snaptest.processing.service.ProcessingFacade

object Main {

  def main(args: Array[String]): Unit = {
    ProcessingFacade.process(CommandLineArgsProcessor.process(args))
  }

}