package org.snaptest.processing.generation.model.service.conditions

import spoon.reflect.code.BinaryOperatorKind
import spoon.reflect.code.BinaryOperatorKind._

abstract class ComparisonOperator

case class Eq() extends ComparisonOperator

case class Gt() extends ComparisonOperator

case class Lt() extends ComparisonOperator

case class Ge() extends ComparisonOperator

case class Le() extends ComparisonOperator

case class Ne() extends ComparisonOperator

object ComparisonOperator {

  def apply(binaryOperatorKind: BinaryOperatorKind): ComparisonOperator = (binaryOperatorKind: @unchecked) match {
    case EQ => Eq()
    case GT => Gt()
    case LT => Lt()
    case GE => Ge()
    case LE => Le()
    case NE => Ne()
  }
}
