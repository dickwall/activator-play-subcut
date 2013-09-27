package services

import com.escalatesoft.subcut.inject._

/**
 * A type declaring the interface that will be injectable.
 */
abstract class TextGenerator {
  val welcomeText: String
}

/**
 * A simple implementation of TextGenerator that we will inject.
 */
class WelcomeTextGenerator(implicit val bindingModule: BindingModule) 
    extends TextGenerator with Injectable {
  val welcomeText = injectOptional[Greeting].map(_.value).getOrElse("Yo!")
}

/**
 * A further dependency to make things a little more interesting. In
 * this case we have a Greeting type that has an embedded greeting string
 * in it. Concrete classes can be injected with any instance of that class
 * or a subclass of that type
 */
case class Greeting(value: String)