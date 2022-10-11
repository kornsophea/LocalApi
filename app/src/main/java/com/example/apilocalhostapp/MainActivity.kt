package com.example.apilocalhostapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.apilocalhostapp.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnPost.setOnClickListener {
            val name=binding.edtName.text.toString()
//            postDataToLocalApi(name)
        }


    }
//    private fun postDataToLocalApi(name:String){
//        val data=ApiData(id,name)
//        val apiInterface=ApiClient.create()
//        val call=apiInterface.postDataApi(data)
//        call.enqueue(object :retrofit2.Callback<ApiData>{
//            override fun onResponse(call: Call<ApiData>, response: Response<ApiData>) {
//                if(response.isSuccessful){
//                    Toast.makeText(this@MainActivity,"Post Data Successfully",Toast.LENGTH_LONG).show()
//                }else{
//                    Toast.makeText(this@MainActivity,response.message(),Toast.LENGTH_LONG).show()
//                }
//            }
//
//            override fun onFailure(call: Call<ApiData>, t: Throwable) {
//                Toast.makeText(this@MainActivity,t.message,Toast.LENGTH_LONG).show()
//            }
//
//        })
//    }
}