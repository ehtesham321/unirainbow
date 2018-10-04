package org.example.testhellostream.impl

import com.lightbend.lagom.scaladsl.api.ServiceCall
import org.example.testhellostream.api.TesthelloStreamService
import org.example.testhello.api.TesthelloService

import scala.concurrent.Future

/**
  * Implementation of the TesthelloStreamService.
  */
class TesthelloStreamServiceImpl(testhelloService: TesthelloService) extends TesthelloStreamService {
  def stream = ServiceCall { hellos =>
    Future.successful(hellos.mapAsync(8)(testhelloService.hello(_).invoke()))
  }
}
