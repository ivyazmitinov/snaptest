package org.snaptest.processing.ast.service

import spoon.Launcher
import spoon.reflect.CtModel

class SpoonAstService{

  def build(pathToSource: String): CtModel = {
    val spoonLauncher = new Launcher()
    spoonLauncher.addInputResource(pathToSource)
    spoonLauncher.getEnvironment.setAutoImports(true)
    spoonLauncher.buildModel()
    spoonLauncher.getModel
  }

}
