package controllers

import org.scalatest._
import org.scalatest.matchers.ShouldMatchers

import play.api.test._
import play.api.test.Helpers._

/**
 * A functional test will fire up a whole play application in a real (or headless) browser
 */
class ApplicationFT extends FunSpec with ShouldMatchers {
  
  describe ("Application") {
    
    it ("should work from within a browser") {
      running(TestServer(3333), HTMLUNIT) { browser =>

        browser.goTo("http://localhost:3333/")

        browser.pageSource should include ("Your new application is ready.")
      }
    }
    
  }
  
}