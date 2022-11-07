package com.example.orderapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Message
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.Toast
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    var orderMessage = "" //declare a global order message variable
    var price = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var donut: ImageView = findViewById(R.id.donut)
        var iceCream: ImageView = findViewById(R.id.ice_cream)
        var froyo: ImageView = findViewById(R.id.froyo)
        var orderButton: FloatingActionButton = findViewById(R.id.btnOrder)

        var sprinkleCheck: CheckBox = findViewById(R.id.sprinkles)
        var oreoCheck: CheckBox = findViewById(R.id.oreos)
        var fruitCheck: CheckBox = findViewById(R.id.fruit)

        donut.setOnClickListener {
            orderMessage = getString(R.string.donut_order_message)
            displayToast(orderMessage)
            price = 0+50
        }

        froyo.setOnClickListener {
            orderMessage = getString(R.string.froyo_order_message)
            displayToast(orderMessage)
            price = 0+150
        }

        iceCream.setOnClickListener {
            orderMessage = getString(R.string.ice_cream_order_message)
            displayToast(orderMessage)
            price = 0+200
        }

        orderButton.setOnClickListener {
            if (sprinkleCheck.isChecked){
                price = price + 20
                displayToast(orderMessage+" = "+price.toString())
            }
            if (sprinkleCheck.isChecked and oreoCheck.isChecked){
                price = price + 30
                displayToast(orderMessage+" = "+price.toString())
            }
            if (sprinkleCheck.isChecked and oreoCheck.isChecked and fruitCheck.isChecked){
                price = price + 50
                displayToast(orderMessage+" = "+price.toString())
            }


            if (oreoCheck.isChecked){
                price = price + 30
                displayToast(orderMessage+" = "+price.toString())
            }
            if (oreoCheck.isChecked and sprinkleCheck.isChecked) {
                price = price + 20
                displayToast(orderMessage+" = "+price.toString())
            }
            if (oreoCheck.isChecked and sprinkleCheck.isChecked and fruitCheck.isChecked){
                price = price + 50
                displayToast(orderMessage+" = "+price.toString())
            }


            if (fruitCheck.isChecked){
                price = price + 50
                displayToast(orderMessage+" = "+price.toString())
            }
            if (fruitCheck.isChecked and oreoCheck.isChecked) {
                price = price + 30
                displayToast(orderMessage+" = "+price.toString())
            }
            if (fruitCheck.isChecked and oreoCheck.isChecked and sprinkleCheck.isChecked){
                price = price + 20
                displayToast(orderMessage+" = "+price.toString())
            }


            var intentOrder = Intent (this, OrderActivity::class.java)
            intentOrder.putExtra("ORDER", orderMessage)
            intentOrder.putExtra("PRICE", price)
            startActivity(intentOrder)
        }
    }

    private fun displayToast(message: String){
        Toast.makeText(applicationContext, message, Toast.LENGTH_SHORT).show()
    }
}