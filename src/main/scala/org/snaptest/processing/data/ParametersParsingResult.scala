package org.snaptest.processing.data

class ParametersParsingResult(val testFile: String) {

}
object ParametersParsingResult {
  def apply(testFile: String): ParametersParsingResult = new ParametersParsingResult(testFile)
}
