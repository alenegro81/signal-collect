/*
 *  @author Philip Stutz
 *  
 *  Copyright 2010 University of Zurich
 *      
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *  
 *         http://www.apache.org/licenses/LICENSE-2.0
 *  
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *  
 */

package com.signalcollect.messaging

import com.signalcollect.interfaces._
import java.util.HashMap
import com.signalcollect.logging.DefaultLogger
import com.signalcollect.interfaces.LogMessage
import java.util.concurrent.atomic.AtomicInteger
import akka.actor.ActorRef
import com.signalcollect.coordinator.DefaultWorkerApi
import com.signalcollect.GraphEditor
import com.signalcollect.Vertex
import com.signalcollect.Edge
import java.util.Random

class DefaultMessageBus[@specialized(Int, Long) Id, @specialized(Int, Long, Float, Double) Signal](
    val numberOfWorkers: Int,
    workerApiFactory: WorkerApiFactory) extends AbstractMessageBus[Id, Signal] {
  lazy val workerApi = workerApiFactory.createInstance[Id, Signal](workerProxies, mapper)
}