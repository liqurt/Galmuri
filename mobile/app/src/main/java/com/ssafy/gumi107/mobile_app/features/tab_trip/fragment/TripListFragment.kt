package com.ssafy.gumi107.mobile_app.features.tab_trip.fragment

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.navigation.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.ssafy.gumi107.mobile_app.R
import com.ssafy.gumi107.mobile_app.config.BaseFragment
import com.ssafy.gumi107.mobile_app.config.Global
import com.ssafy.gumi107.mobile_app.config.RetrofitCallback
import com.ssafy.gumi107.mobile_app.databinding.FragmentTripListBinding
import com.ssafy.gumi107.mobile_app.features.tab_trip.adapter.TripAdapter
import com.ssafy.gumi107.mobile_app.dto.Trip
import com.ssafy.gumi107.mobile_app.service.TripService

class TripListFragment : BaseFragment<FragmentTripListBinding>(
    FragmentTripListBinding::bind, R.layout.fragment_trip_list
) {
    private lateinit var tripAdapter: TripAdapter
    private var tripList = mutableListOf<Trip>()
    private lateinit var mView : View
    private lateinit var mContinent : String
    private fun initTripList() {
        Log.d(Global.GLOBAL_LOG_TAG, "initTripList: ")
        val ts = TripService()
        ts.selectAllTrip(SelectAllTripCallback())
    }

    inner class SelectAllTripCallback : RetrofitCallback<List<Trip>> {
        override fun onError(t: Throwable) {
            Log.d(Global.GLOBAL_LOG_TAG, "onError: ")
        }

        override fun onSuccess(code: Int, responseData: List<Trip>) {
            Log.d(Global.GLOBAL_LOG_TAG, "onSuccess: $responseData")
            tripList = responseData as MutableList<Trip>
            initRecyclerView(mView)
        }

        override fun onFailure(code: Int) {
            Log.d(Global.GLOBAL_LOG_TAG, "onFailure: ")
        }
    }

    private fun initRecyclerView(view: View) {

        Log.d(Global.GLOBAL_LOG_TAG, "initRecyclerView: ")
        val listener = object : TripAdapter.TripClickListener {
            override fun onClick(trip: Trip, position: Int) {
                val action = TripListFragmentDirections.actionTabTravelersToTripDetailFragment(trip)
                view.findNavController().navigate(action)
            }
        }
        tripAdapter = TripAdapter(tripList).apply {
            setItemClickListener(listener)
        }
        binding.rcvTrip.apply {
            adapter = tripAdapter
            //layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)

            // Linear?????? grid??? ??????. spanCount??? ?????? 2?????? ??????????????? ?????????.
            layoutManager = GridLayoutManager(context, 2)
        }
    }

    private fun initNewTrip() {
        binding.fabNewTrip.setOnClickListener {
            val action = TripListFragmentDirections.actionTabTravelersToTripMakeFragment()
            view?.findNavController()?.navigate(action)
        }
    }

    private fun initContinentButton(){
        binding.triplistBtnAsia.setOnClickListener {
            mContinent = "Asia"
            getTripsByContinent()
        }
        binding.triplistBtnEurope.setOnClickListener {
            mContinent = "Europe"
            getTripsByContinent()
        }
        binding.triplistBtnAfrica.setOnClickListener {
            mContinent = "Africa"
            getTripsByContinent()
        }
        binding.triplistBtnNorthAmerica.setOnClickListener {
            mContinent = "North America"
            getTripsByContinent()
        }
        binding.triplistBtnSouthAmerica.setOnClickListener {
            mContinent = "South America"
            getTripsByContinent()
        }
        binding.triplistBtnOceania.setOnClickListener {
            mContinent = "Oceania"
            getTripsByContinent()
        }
        binding.triplistBtnAll.setOnClickListener {
            initTripList()
        }

    }

    private fun getTripsByContinent(){
        val ts = TripService()
        ts.selectTripsByContinent(mContinent, SelectTripsByContinentCallback())
    }

    inner class SelectTripsByContinentCallback: RetrofitCallback<List<Trip>>{
        override fun onError(t: Throwable) {
            Log.d(Global.GLOBAL_LOG_TAG, "onError: ")
        }

        override fun onSuccess(code: Int, responseData: List<Trip>) {
            Log.d(Global.GLOBAL_LOG_TAG, "onSuccess: $responseData")
            tripList = responseData as MutableList<Trip>
            initRecyclerView(mView)
        }

        override fun onFailure(code: Int) {
            Log.d(Global.GLOBAL_LOG_TAG, "onFailure: ")
        }
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mView = view
        initTripList()
        initRecyclerView(view)
        initNewTrip()
        initContinentButton()
    }
}