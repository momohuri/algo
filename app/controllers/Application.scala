package controllers

import play.api._
import play.api.mvc._
import play.api.data._
import play.api.data.Forms._
import models._
import play.api.data.format.Formats._

object Application extends Controller {

  val algoForm = Form[Algo](
    mapping (
      "number" -> number,
      "times" -> number,
      "names" -> nonEmptyText)
      (Algo.apply)(Algo.unapply)
  )

  def index = Action {
    Ok(views.html.index("Your new application is ready."))
  }

  def algo = Action {
    Ok(views.html.algo(algoForm))
  }


  def algoCalculate = Action {  implicit req =>
      algoForm.bindFromRequest.fold(
        formWithErrors => BadRequest(views.html.algo(formWithErrors)),
        algo  => {
         val result= algo.caculAlgo();
            Redirect(routes.Application.algo())
        }
      )
    }
    Ok(views.html.index("hello"))
//    algoForm.bindFromRequest.fold(
//      formWithErrors => Redirect("index")
//    )

}