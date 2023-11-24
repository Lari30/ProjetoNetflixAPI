package com.larisantos.projetonetflixapi

//Tipos Genéricos = Types Generics
fun <T> minhaFuncao( vararg itens: T){
    itens.forEach { item ->
        println(item)
    }
}

class Carro<T>(anoCarro: T){}

fun main(){
    //val carro = Carro(10.20)
    minhaFuncao("Larissa", "Sidney", 10, true, 20.30)
}