package org.snaptest.processing.generation.model.service.conditions

import spoon.reflect.code._
import spoon.reflect.code.BinaryOperatorKind.{AND, OR}
import spoon.reflect.code.UnaryOperatorKind.NOT

sealed abstract class BooleanExpressionTree

case class Variable(name: String) extends BooleanExpressionTree

case class Literal(value: Any) extends BooleanExpressionTree

case class Condition(leftHand: BooleanExpressionTree, rightHand: BooleanExpressionTree, comparison: ComparisonOperator) extends BooleanExpressionTree

case class Or(leftHand: BooleanExpressionTree, rightHand: BooleanExpressionTree) extends BooleanExpressionTree

case class And(leftHand: BooleanExpressionTree, rightHand: BooleanExpressionTree) extends BooleanExpressionTree

case class NotOr(leftHand: BooleanExpressionTree, rightHand: BooleanExpressionTree) extends BooleanExpressionTree

case class NotAnd(leftHand: BooleanExpressionTree, rightHand: BooleanExpressionTree) extends BooleanExpressionTree

object BooleanExpressionTree {

  def apply(ctExpression: CtExpression[_], notFlag: Boolean = false): BooleanExpressionTree = ctExpression match {
    case binaryOp: CtBinaryOperator[_] => applyBinary(binaryOp, notFlag)
    case unaryOp: CtUnaryOperator[_] => applyUnary(unaryOp, notFlag)
    case literal: CtLiteral[_] => Literal(literal.getValue)
    case variable: CtVariableRead[_] => Variable(variable.getVariable.getSimpleName)
  }

  private def applyBinary(binaryOp: CtBinaryOperator[_], notFlag: Boolean = false) = binaryOp.getKind match {
    case AND =>
      if (notFlag)
        NotAnd(apply(binaryOp.getLeftHandOperand), apply(binaryOp.getRightHandOperand))
      else
        And(apply(binaryOp.getLeftHandOperand), apply(binaryOp.getRightHandOperand))
    case OR =>
      if (notFlag)
        NotOr(apply(binaryOp.getLeftHandOperand), apply(binaryOp.getRightHandOperand))
      else
        Or(apply(binaryOp.getLeftHandOperand), apply(binaryOp.getRightHandOperand))
    case other => Condition(apply(binaryOp.getLeftHandOperand), apply(binaryOp.getRightHandOperand), ComparisonOperator(other))
  }

  private def applyUnary(unaryOp: CtUnaryOperator[_], notFlag: Boolean = false): BooleanExpressionTree = (unaryOp.getKind: @unchecked) match {
    case NOT => apply(unaryOp.getOperand, !notFlag)
  }
}
