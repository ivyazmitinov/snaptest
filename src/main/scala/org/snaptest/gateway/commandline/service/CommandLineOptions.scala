package org.snaptest.gateway.commandline.service

import org.apache.commons.cli.Option

private object CommandLineOptions {

  private val TestClassOptionDescription = "path to the file to cover tests"
  private val ClassPathWithClassOptionDescription = "classpath with compile file to process"

  val SourcePathOption = new Option("s", "source-path", true, TestClassOptionDescription)
  val ClassPathOption = new Option("xcp", "xclasspath", true, ClassPathWithClassOptionDescription)
  val ClassNameOption = new Option("n", "class-name", true, "//TODO ADD LATER")

  def allOptions = List(SourcePathOption,
    ClassPathOption,
    ClassNameOption)
}
