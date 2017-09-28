package org.snaptest.processing.data

case class StartArguments(testFile: String) {

}
object StartArguments {
  def apply(testFile: String): StartArguments = new StartArguments(testFile)
}
