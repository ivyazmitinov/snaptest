package org.snaptest.processing.generation.model.data

case class Test(methodName: String,
                when: List[WhenParam],
                asserts: List[Assert]) {

}
