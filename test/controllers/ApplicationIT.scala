package controllers

import org.scalatest._
import org.scalatest.matchers.ShouldMatchers

import play.api.test._
import play.api.test.Helpers._

/**
 * You can mock out a whole application including requests, plugins etc.
 * For more information, consult the wiki.
 */
class ApplicationIT extends FunSpec with ShouldMatchers {

  describe ("Application") {

    it ("should send 404 on a bad request") {
      running(FakeApplication()) {
        route(FakeRequest(GET, "/boum")) should be (None)
      }
    }

    it ("should render the index page") {
      running(FakeApplication()) {
        val home = route(FakeRequest(GET, "/")).get

        status(home) should be (OK)
        contentType(home) should be (Some("text/html"))
        contentAsString(home) should include ("Your new application is ready.")
      }
    }
  }
}