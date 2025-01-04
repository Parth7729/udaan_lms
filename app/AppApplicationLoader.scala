import play.api.{Application, ApplicationLoader}


class AppApplicationLoader extends ApplicationLoader {

  override def load(context: ApplicationLoader.Context): Application = new AppComponents(context = context).application

}