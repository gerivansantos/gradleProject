package br.com.kotlin

data class User(val nome: String)

val users = hashMapOf(
    0 to User("Kleber"),
    1 to User("Caio")
)