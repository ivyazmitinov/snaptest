package org.snaptest.processing.generation.model.service

import org.snaptest.processing.generation.model.data.{Test, TestCase}
import org.snaptest.processing.generation.model.service.conditions.BooleanExpressionTree
import spoon.processing.AbstractProcessor
import spoon.reflect.CtModel
import spoon.reflect.code.{CtBlock, CtIf, CtStatement}
import spoon.reflect.declaration.CtMethod

import scala.collection.mutable.ListBuffer

class DefaultModelGenerationService {

  def produceModel(ast: CtModel): TestCase = {

    val tests = ListBuffer[Test]()
    ast.processWith((elem: CtMethod[_]) => {
      //      val i = 1
      //      val test = Test(elem.getSimpleName)
      elem.getBody.getStatements.forEach(processStatement(_))
      //      tests += test
      //      return
    })
    TestCase(tests.toList)
  }

  private def processStatement[T <: CtStatement](ctStatement: T): Unit = ctStatement match {
    case ctIf: CtIf =>
      val expressionTree = BooleanExpressionTree(ctIf.getCondition)
      processStatement(ctIf.getThenStatement)
      processStatement(ctIf.getElseStatement)
      val i = 1
    case ctBlock: CtBlock[_] => ctBlock.getStatements.forEach(processStatement(_))
    case _ =>
  }

  implicit class TestMethodGenerationProcessor(self: (CtMethod[_]) => Unit) extends AbstractProcessor[CtMethod[_]] {

    override def process(element: CtMethod[_]): Unit = {

      self(element)
    }
  }

}
