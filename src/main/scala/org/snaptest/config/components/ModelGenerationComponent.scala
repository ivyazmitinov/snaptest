package org.snaptest.config.components

import org.snaptest.processing.generation.model.service.DefaultModelGenerationService

trait ModelGenerationComponent {

  val modelGenerationService: DefaultModelGenerationService
}
