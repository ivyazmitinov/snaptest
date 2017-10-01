package org.snaptest.config.components

import org.snaptest.processing.runtime.service.DefaultRuntimeService

trait RuntimeComponent {

  val runtimeService: DefaultRuntimeService
}
