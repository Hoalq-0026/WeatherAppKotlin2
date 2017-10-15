package com.example.kotlin.weatherappkotlin.domain.commands

import com.example.kotlin.weatherappkotlin.data.ForecastRequest
import com.example.kotlin.weatherappkotlin.domain.ForecastDataMapper
import com.example.kotlin.weatherappkotlin.domain.model.ForecastList

/**
 * Created by le.quang.hoa on 8/7/17.
 */
class RequestForecastCommand(val zipCode: String): Command<ForecastList>{

    override fun execute(): ForecastList {
        val forecastRequest = ForecastRequest(zipCode)
        return ForecastDataMapper().convertFromDataModel(forecastRequest.execute())
    }

}