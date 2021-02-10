package com.ericg.demoui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.ericg.demoui.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var binding: ActivityMainBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        handleActions()
    }

    private fun handleActions(){
        binding?.btnLogIn?.setOnClickListener{
            val inputs = arrayOf(binding?.regNo, binding?.password)
            inputs.forEach { input ->
                if (input!!.text.toString().isEmpty()){
                    input.error = "required"
                }
            }
        }
    }

}