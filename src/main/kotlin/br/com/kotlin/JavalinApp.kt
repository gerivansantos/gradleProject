package br.com.kotlin

import br.com.kotlin.controller.UserController
import io.javalin.Javalin
import io.javalin.apibuilder.ApiBuilder.get
import io.javalin.apibuilder.ApiBuilder.path
import java.lang.Exception

class JavalinApp(private val port: Int) {

    val controller = UserController(users)

    fun init() : Javalin {
        val app = Javalin.create().apply {
            port(port)
            exception(Exception::class.java) { e, _ -> e.printStackTrace() }
        }.start()

        app.get("/") { ctx -> ctx.json(mapOf("message" to "ola, mundo")) }

        app.routes{
            path("api"){
                path("users"){
                    path(":id"){
                        get{ ctx -> controller.getUser(ctx)}

                    }
                }
            }

        }

        return app
    }

}

fun main(args: Array<String>){
    JavalinApp(7000).init()
}
