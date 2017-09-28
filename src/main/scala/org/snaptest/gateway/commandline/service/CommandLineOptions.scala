package org.snaptest.gateway.commandline.service

import org.apache.commons.cli.Option

private object CommandLineOptions {

  private val TestClassOptionDescription = "path to the file to cover tests"

  val TestClassOption = new Option("t", "test-class", true, TestClassOptionDescription)

  def allOptions = List(TestClassOption)
}
