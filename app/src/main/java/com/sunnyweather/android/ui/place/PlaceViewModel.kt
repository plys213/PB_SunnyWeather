package com.sunnyweather.android.ui.place

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.sunnyweather.android.logic.Repository
import com.sunnyweather.android.logic.model.Place

class PlaceViewModel:ViewModel() {
    private val searchLiveData=MutableLiveData<String>()
    val placeList=ArrayList<Place>()
    //当searchLiveData包含的值发生变化时，就会调用lamada表达式中的方法
    val placeLiveData=Transformations.switchMap(searchLiveData){query->
        Repository.searchPlaces(query)
    }
    fun searchPlaces(query:String){
        searchLiveData.value=query
    }

    fun savePlace(place:Place)=Repository.savePlace(place)

    fun getSavedPlace()=Repository.getSavedPlace()

    fun isPlaceSaved()=Repository.isPlaceSaved()
}