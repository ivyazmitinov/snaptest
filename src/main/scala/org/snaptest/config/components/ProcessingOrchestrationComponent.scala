package org.snaptest.config.components

import org.snaptest.processing.orchestration.service.DefaultProcessingOrchestrationService

trait ProcessingOrchestrationComponent {

  val processingOrchestrationService: DefaultProcessingOrchestrationService
}
