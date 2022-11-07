package com.example.orderapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ReceiptActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_receipt)

        var showReceipt : TextView = findViewById(R.id.showReceipt)
        var oprice = intent.getIntExtra("DPRICE", 0)
        var message = "The total cost of yor order is Ksh." + oprice
        var textView:TextView=findViewById(R.id.price)
        textView.text=message
        var price:TextView=findViewById(R.id.showReceiptpay)
        var payBtn: FloatingActionButton = findViewById(R.id.btnPayment)


        payBtn.setOnClickListener {
            intent = getApplicationContext().getPackageManager().getLaunchIntentForPackage("com.android.stk");
            if (intent != null){
                startActivity(intent);
            }else{
                Toast.makeText(getApplicationContext(), "NO SIM CARD FOUND",Toast.LENGTH_LONG).show();
            }
        }
    }
}