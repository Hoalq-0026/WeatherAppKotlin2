package com.example.kotlin.weatherappkotlin.ui.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.kotlin.weatherappkotlin.R
import com.example.kotlin.weatherappkotlin.domain.model.Forecast
import com.example.kotlin.weatherappkotlin.domain.model.ForecastList
import com.example.kotlin.weatherappkotlin.ui.utils.ctx
import com.squareup.picasso.Picasso
import org.jetbrains.anko.find

/**
 * Created by le.quang.hoa on 8/4/17.
 */
class ForecastListAdapter(val weekForecast: ForecastList, val itemClick: OnItemClickListener) : RecyclerView.Adapter<ForecastListAdapter.ViewHolder>() {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindForecast(weekForecast[position])
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.ctx).inflate(R.layout.item_forecast,parent,false)

        return ViewHolder(view,itemClick)
    }

    override fun getItemCount(): Int = weekForecast.size()


    class ViewHolder(view: View, val itemClick: OnItemClickListener) : RecyclerView.ViewHolder(view){
        private val iconView = view.find<ImageView>(R.id.icon)
        private val dateView = view.find<TextView>(R.id.date)
        private val descriptionView = view.find<TextView>(R.id.description)
        private val maxTemperatureView = view.find<TextView>(R.id.maxTemperature)
        private val minTemperatureView = view.find<TextView>(R.id.minTemperature)

        fun bindForecast(forecast: Forecast){
            with(forecast){
                Picasso.with(itemView.ctx).load(iconUrl).into(iconView)
                dateView.text = date
                descriptionView.text = description
                maxTemperatureView.text = "${high}º"
                minTemperatureView.text = "${low}º"
                itemClick(forecast)

            }
        }
    }

    interface OnItemClickListener{
        operator fun invoke(forecast: Forecast)
    }
}