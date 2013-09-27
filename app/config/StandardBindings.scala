package config
import play.api.GlobalSettings
import services.{WelcomeTextGenerator, TextGenerator, Greeting}
import com.escalatesoft.subcut.inject._

/**
 * Set up the Guice injector and provide the mechanism for return objects from the dependency graph.
 */
object StandardBindings extends NewBindingModule(module => {
  import module._
  
  bind [Greeting] toSingle new Greeting("Your new application is ready.")
  bind [TextGenerator] toModuleSingle { implicit module => new WelcomeTextGenerator }
})
