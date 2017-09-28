package org.snaptest.processing.start.data

case class StartArguments(testFile: String) {

}
object StartArguments {
  def apply(testFile: String): StartArguments = new StartArguments(testFile)
}
