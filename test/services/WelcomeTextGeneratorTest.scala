package services

import org.scalatest._
import org.scalatest.matchers.ShouldMatchers
import config.StandardBindings
import com.escalatesoft.subcut.inject._

/**
  * Unit tests for the service itself. We would expect that the majority of unit tests would be on components like
  * this.
  */
class WelcomeTextGeneratorTest extends FunSpec with ShouldMatchers {

   describe ("WelcomeTextGenerator") {
     it ("should generate some text") {
       implicit val bindingModule: BindingModule = StandardBindings // test the defaults
       val textGenerator = new WelcomeTextGenerator

       textGenerator.welcomeText should be ("Your new application is ready.")
     }
   }
 }