package com.ssafy.gumi107.mobile_app.features.tab_trip.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.compose.ui.window.Dialog
import androidx.fragment.app.Fragment
import com.google.android.gms.maps.*
import com.google.android.gms.maps.model.LatLng
import com.ssafy.gumi107.mobile_app.databinding.FragmentMapDetailBinding

class MapDetailFragment :
    GoogleMap.OnMapLongClickListener,OnMapReadyCallback, Fragment() {

    private var googleMap : MapView? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        val binding = FragmentMapDetailBinding.inflate(inflater, container, false)
        googleMap = binding.map
        googleMap!!.getMapAsync(this)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        googleMap?.onCreate(savedInstanceState)
    }

    override fun onStart() {
        super.onStart()
        googleMap?.onStart()
    }

    override fun onResume() {
        super.onResume()
        googleMap?.onResume()
    }

    override fun onStop() {
        googleMap?.onStop()
        super.onStop()
    }

    override fun onMapReady(gm: GoogleMap) {
        val moonHyungRi = LatLng(37.345095458869, 127.21141094644)
        gm.moveCamera(CameraUpdateFactory.newLatLng(moonHyungRi))
        gm.animateCamera(CameraUpdateFactory.zoomTo(13f))

        gm.setOnMapLongClickListener(this)

    }

    override fun onMapLongClick(p0: LatLng) {
        Toast.makeText(requireContext(), "$p0", Toast.LENGTH_SHORT).show()
    }

}