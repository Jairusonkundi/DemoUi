package com.ericg.demoui

import android.os.Bundle
import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.ericg.demoui.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var binding: ActivityMainBinding? = null
    private var studentRegNo = FakeDatabase.regNo
    private var studentPassword = FakeDatabase.password

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        handleClicks()
    }

    private fun toast(text: String = "Ready to launch") =
        Toast.makeText(this, text, LENGTH_SHORT).show()

    private fun handleClicks() {
        binding?.btnLogIn?.setOnClickListener {
            if (!empty()) {
                validate()
            }
        }
    }

    private fun empty(): Boolean {

        val inputs = arrayOf(binding?.regNo, binding?.password)

        inputs.forEach { input ->
            if (input!!.text.toString().trim().isEmpty()) {
                input.error = "${input.hint} is required"
            }
        }

        return inputs[0]!!.text.toString().trim().isEmpty() &&
                inputs[1]!!.text.toString().trim().isEmpty()
    }

    private fun validate() {
        if (binding?.regNo?.text.toString().trim().equals(studentRegNo, ignoreCase = true) &&
            binding?.password?.text.toString().trim().equals(studentPassword, ignoreCase = false)
        ) {
            navigate()
        }else toast("check details!")
    }

    private fun navigate() {
        toast()
    }

    override fun onDestroy() {
        binding = null
        super.onDestroy()
    }
}