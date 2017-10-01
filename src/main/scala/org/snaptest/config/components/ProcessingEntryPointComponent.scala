package org.snaptest.config.components

import org.snaptest.processing.entrypoint.service.DefaultProcessingEntryPointService

trait ProcessingEntryPointComponent {

  val processingEntryPointService: DefaultProcessingEntryPointService
}
