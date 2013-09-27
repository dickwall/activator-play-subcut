package controllers

import play.api.test._
import play.api.test.Helpers._
import services.TextGenerator
import org.scalatest._
import org.scalatest.mock.MockitoSugar
import config.StandardBindings
import org.mockito.Mockito._

/**
 * We focus here on testing the controller only - not the infrastructure in front or behind it. Using dependency
 * injection allows the application controller to become testable. It is conceivable that you might have a unit
 * test for the controller if there is enough logic contained in the method that makes it worth testing - the
 * integration test might offer a more useful test if there is not given that you are then testing that the
 * route is configured properly.
 */
class ApplicationTest extends FunSpec with MockitoSugar {
  
  describe ("Application") {
    it ("should invoke the text generator") {

      val textGenerator = mock[TextGenerator]
      
      StandardBindings.modifyBindings { implicit module =>
        module.bind [TextGenerator] toSingle textGenerator // use the mock
        
        val application = new controllers.Application
        application.index(FakeRequest())

        verify(textGenerator).welcomeText
      }
    }
  }
}