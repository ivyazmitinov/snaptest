package org.snaptest.config.components

import org.snaptest.processing.start.service.DefaultStartService

trait StartComponent {
  val startService: DefaultStartService
}
