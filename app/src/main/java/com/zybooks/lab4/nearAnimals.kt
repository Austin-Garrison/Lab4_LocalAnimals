package com.zybooks.lab4

import android.Manifest
import android.animation.ObjectAnimator
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.motion.widget.Debug.getLocation
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

class nearAnimals : AppCompatActivity(), LocationListener {
    private lateinit var locationManager: LocationManager
    private lateinit var tvGpsLocation: TextView
    lateinit var showbtn : Button

    private val locationPermissionCode = 2
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_near_animals)
//        title = "KotlinApp"
        showbtn = findViewById(R.id.showAnimals)
        val button: Button = findViewById(R.id.getLocation)
        button.setOnClickListener {
            getLocation()
        }
    }
    private fun getLocation() {
        locationManager = getSystemService(Context.LOCATION_SERVICE) as LocationManager
        if ((ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED)) {
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.ACCESS_FINE_LOCATION), locationPermissionCode)
        }
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 5000, 5f, this)
    }
    override fun onLocationChanged(location: Location) {
        tvGpsLocation = findViewById(R.id.current_location)
        if(location.longitude <= 85) {
            tvGpsLocation.text = "Location: East Coast"
            showbtn.setOnClickListener {
                val intent = Intent(this, eastCoastAnimals::class.java)
                startActivity(intent)
                finish()
            }
        }
        if(location.longitude > 85 && location.longitude < 115) {
            tvGpsLocation.text = "Location: Midwest"
            showbtn.setOnClickListener {
                val intent = Intent(this, midwestAnimals::class.java)
                startActivity(intent)
                finish()
            }
        }
            if (location.longitude >= 115) {
                tvGpsLocation.text = "Location: West Coast"
                showbtn.setOnClickListener {
                    val intent = Intent(this, westCoastAnimals::class.java)
                    startActivity(intent)
                    finish()
                }
            }
            fun onRequestPermissionsResult(
                requestCode: Int,
                permissions: Array<out String>,
                grantResults: IntArray
            ) {
                super.onRequestPermissionsResult(requestCode, permissions, grantResults)
                if (requestCode == locationPermissionCode) {
                    Toast.makeText(this, "Permission Granted", Toast.LENGTH_SHORT).show()
                }
        }
    }
}