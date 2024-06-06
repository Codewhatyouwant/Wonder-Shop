package com.example.wondermap.ui.home

import android.location.Location
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.app.ActivityCompat
import androidx.core.location.LocationManagerCompat.getCurrentLocation
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.wondermap.R
import com.example.wondermap.databinding.FragmentHomeBinding
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.material.navigation.NavigationView

class HomeFragment : Fragment() ,OnMapReadyCallback, NavigationView.OnNavigationItemSelectedListener{
    private var mGoogleMap:GoogleMap? = null
    private lateinit var drawerLayout: DrawerLayout

    private var _binding: FragmentHomeBinding? = null

    private lateinit var currentLocation: Location
    private lateinit var fusedLocationProviderClient: FusedLocationProviderClient
    private val permissionCode = 101

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

//        drawerLayout = childFragmentManager.findFragmentById(R.id.drawer_layout) as DrawerLayout
//        val toolbar = childFragmentManager.findFragmentById(R.id.toolbar)
//
//        val navigationView = childFragmentManager.findFragmentById(R.id.nav_view)
//
//        val toggle = ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open_nav, R.string.close_nav)
//
//        drawerLayout.addDrawerListener(toggle)
//        toggle.syncState()
//
//        if (savedInstanceState == null) {
//            childFragmentManager.beginTransaction()
//                .replace(R.id.fragment_container, HomeFragment()).commit()
//        }


//        map view
        val mapFragment = childFragmentManager
            .findFragmentById(R.id.mapFragment) as SupportMapFragment
        mapFragment.getMapAsync(this)

//        map Current loction
//        fusedLocationProviderClient= LocationServices.getFusedLocationProviderClient(this)

//        getCurrentLocation()

//        val textView: TextView = binding.textHome
//        homeViewModel.text.observe(viewLifecycleOwner) {    childFragmentManager
//            textView.text = it
//        }
        return root
    }

//    private fun getCurrentLocation() {
//        if (ActivityCompat.checkSelfPermission(this,android.Manifest.permission.ACCESS_FINE_LOCATION)!=
//            packageManager.PERMISSION_GRANT){
//
//        }
//    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
    override fun onMapReady(googleMap: GoogleMap) {

    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        TODO("Not yet implemented")
    }
}