package controllers

import play.api.mvc._
import services._
import com.escalatesoft.subcut.inject._

/**
 * Instead of declaring an object of Application as per the template project, we must declare a class given that
 * the application context is going to be responsible for creating it and wiring it up with the text generator service.
 * @param bindingModule the bindings to use - will default to StandardBindings unless an implicit is defined
 */
class Application(implicit val bindingModule: BindingModule) 
    extends Controller with Injectable {

  private val textGenerator = inject[TextGenerator]

  def index = Action {
    Ok(views.html.index(textGenerator.welcomeText))
  }
  
}
