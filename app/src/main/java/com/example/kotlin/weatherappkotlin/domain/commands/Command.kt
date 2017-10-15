package com.example.kotlin.weatherappkotlin.domain.commands

/**
 * Created by le.quang.hoa on 8/7/17.
 */
interface Command<out T> {
    fun execute(): T
}