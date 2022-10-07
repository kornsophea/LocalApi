package com.example.apilocalhostapp

import android.os.Binder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.apilocalhostapp.databinding.ActivityListDataBinding
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback

class ListDataActivity : AppCompatActivity() {
    private lateinit var binding: ActivityListDataBinding
    private lateinit var adapter: DataAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityListDataBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getDataLocalApi()
    }
    private fun getDataLocalApi(){
        val api=ApiClient.create()
        val call=api.getDataApi()
        call.enqueue(object: retrofit2.Callback<List<ApiData>>{
            override fun onResponse(call: Call<List<ApiData>>, response: Response<List<ApiData>>) {
                if(response.isSuccessful){
                    val responseData=response.body()
                    binding.recyclerview.layoutManager=LinearLayoutManager(baseContext)
                    adapter=DataAdapter(responseData as ArrayList<ApiData>)
                    binding.recyclerview.adapter=adapter
                }else{
                    Toast.makeText(this@ListDataActivity,"Fail Response",Toast.LENGTH_LONG).show()
                }
            }

            override fun onFailure(call: Call<List<ApiData>>, t: Throwable) {
                Toast.makeText(this@ListDataActivity,"Fail Connection",Toast.LENGTH_LONG).show()
            }

        })
    }
}