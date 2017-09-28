package org.snaptest.config.components

import org.snaptest.processing.ast.service.SpoonAstService

trait SpoonAstComponent {

  val astService: SpoonAstService
}
