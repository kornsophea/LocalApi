package com.example.apilocalhostapp

import android.os.Binder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.apilocalhostapp.databinding.ActivityListDataBinding
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback

class ListDataActivity : AppCompatActivity() {
    private lateinit var binding: ActivityListDataBinding
    private  var adapter: DataAdapter?=null
    private lateinit var apiData: ApiData
    private lateinit var recyclerView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityListDataBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recyclerview.layoutManager=LinearLayoutManager(this)
        adapter= DataAdapter()
        binding.recyclerview.adapter=adapter



        getDataLocalApi()

        adapter?.setOnClickDeleteItem {
            deleteDataLocalApi(it.id)
        }

    }
    private fun getDataLocalApi(){
        val api=ApiClient.create()
        val call=api.getDataApi()
        //sda
        call.enqueue(object: retrofit2.Callback<List<ApiData>>{
            override fun onResponse(call: Call<List<ApiData>>, response: Response<List<ApiData>>) {
                if(response.isSuccessful){
                    val responseData=response.body()
                    adapter?.addItems(responseData as ArrayList<ApiData>)
                }else{
                    Toast.makeText(this@ListDataActivity,"Fail Response",Toast.LENGTH_LONG).show()
                }
            }

            override fun onFailure(call: Call<List<ApiData>>, t: Throwable) {
                Toast.makeText(this@ListDataActivity,"Fail Connection",Toast.LENGTH_LONG).show()
            }

        })
    }
    private fun deleteDataLocalApi(id:Int){
        val builder= AlertDialog.Builder(this)
        builder.setMessage("Do you want to delete?")
        builder.setCancelable(true)
        builder.setPositiveButton("Yes"){
                dialog,_->
            dialog.dismiss()
                val api=ApiClient.create()
                val call=api.deleteDataApi(id)
                call.enqueue(object : retrofit2.Callback<Void>{
                    override fun onResponse(call: Call<Void>, response: Response<Void>) {
                        if(response.isSuccessful){
                            getDataLocalApi()
                            Toast.makeText(this@ListDataActivity,"Delete Successfully",Toast.LENGTH_LONG).show()
                        }else{
                            Toast.makeText(this@ListDataActivity,"No Response",Toast.LENGTH_LONG).show()
                        }
                    }

                    override fun onFailure(call: Call<Void>, t: Throwable) {
                        Toast.makeText(this@ListDataActivity,"Fail Connection",Toast.LENGTH_LONG).show()
                    }

                })
        }
        builder.setNegativeButton("No"){
                dialog,_->dialog.dismiss()
        }
        val alert=builder.create()
        alert.show()
    }
}