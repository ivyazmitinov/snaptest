package org.snaptest.processing.service.ast

import spoon.Launcher
import spoon.reflect.CtModel

object AstBuilder{

  def build(pathToSource: String): CtModel = {
    val spoonLauncher = new Launcher()
    spoonLauncher.addInputResource(pathToSource)
    spoonLauncher.getEnvironment.setAutoImports(true)
    spoonLauncher.buildModel()
    spoonLauncher.getModel
  }

}
