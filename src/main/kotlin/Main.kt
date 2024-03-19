package com.emobg

import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.koin.core.context.startKoin
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import org.koin.ktor.ext.inject


fun main() {
    embeddedServer(Netty, port = 8080) {
        mainModule()
    }.start(wait = true)
}

interface HelloService {
    fun getHello(): String
}

class HelloServiceImpl : HelloService {
    override fun getHello(): String {
        return "Hello"
    }
}

val module1 = module {
    singleOf(::HelloServiceImpl) {
        bind<HelloService>()
    }
}

fun Application.mainModule() {
    startKoin {
        modules(module1)
    }

    val service by inject<HelloService>()

    routing {
        get("/hello") {
            call.respondText(service.getHello())
        }
    }
}

