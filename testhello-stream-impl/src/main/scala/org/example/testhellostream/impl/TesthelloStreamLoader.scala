package org.example.testhellostream.impl

import com.lightbend.lagom.scaladsl.api.ServiceLocator.NoServiceLocator
import com.lightbend.lagom.scaladsl.server._
import com.lightbend.lagom.scaladsl.devmode.LagomDevModeComponents
import play.api.libs.ws.ahc.AhcWSComponents
import org.example.testhellostream.api.TesthelloStreamService
import org.example.testhello.api.TesthelloService
import com.softwaremill.macwire._

class TesthelloStreamLoader extends LagomApplicationLoader {

  override def load(context: LagomApplicationContext): LagomApplication =
    new TesthelloStreamApplication(context) {
      override def serviceLocator = NoServiceLocator
    }

  override def loadDevMode(context: LagomApplicationContext): LagomApplication =
    new TesthelloStreamApplication(context) with LagomDevModeComponents

  override def describeService = Some(readDescriptor[TesthelloStreamService])
}

abstract class TesthelloStreamApplication(context: LagomApplicationContext)
  extends LagomApplication(context)
    with AhcWSComponents {

  // Bind the service that this server provides
  override lazy val lagomServer = serverFor[TesthelloStreamService](wire[TesthelloStreamServiceImpl])

  // Bind the TesthelloService client
  lazy val testhelloService = serviceClient.implement[TesthelloService]
}
