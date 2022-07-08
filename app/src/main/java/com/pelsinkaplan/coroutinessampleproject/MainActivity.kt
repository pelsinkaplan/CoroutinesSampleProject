package com.pelsinkaplan.coroutinessampleproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import com.pelsinkaplan.coroutinessampleproject.api.APIInstance
import com.pelsinkaplan.coroutinessampleproject.api.APIService
import com.pelsinkaplan.coroutinessampleproject.data.Coffee
import com.pelsinkaplan.coroutinessampleproject.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    lateinit var postList: List<Coffee>
    private lateinit var adapter: CoffeeAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        CoroutineScope(Dispatchers.IO).launch {
            val dataResponse =
                APIInstance.getInstance().create(APIService::class.java).getHotCoffee()
            withContext(Dispatchers.Main) {
                dataResponse.enqueue(object : Callback<List<Coffee>> {
                    override fun onFailure(call: Call<List<Coffee>>, t: Throwable) {
                        Toast.makeText(applicationContext, t.message.toString(), Toast.LENGTH_LONG)
                            .show()
                    }

                    override fun onResponse(
                        call: Call<List<Coffee>>,
                        response: Response<List<Coffee>>
                    ) {
                        if (response.isSuccessful) {
                            Log.e("Coroutines", "hot coffees")
                            postList = (response.body() as MutableList<Coffee>?)!!
                            adapter = CoffeeAdapter(postList)
                            binding.hotCoffeeRecyclerView.adapter = adapter
                            binding.hotCoffeeRecyclerView.layoutManager =
                                GridLayoutManager(applicationContext, 2)
                        }
                    }
                })
            }
        }

        CoroutineScope(Dispatchers.IO).launch {
            val dataResponse =
                APIInstance.getInstance().create(APIService::class.java).getColdCoffee()
            withContext(Dispatchers.Main) {
                dataResponse.enqueue(object : Callback<List<Coffee>> {
                    override fun onFailure(call: Call<List<Coffee>>, t: Throwable) {
                        Toast.makeText(applicationContext, t.message.toString(), Toast.LENGTH_LONG)
                            .show()
                    }

                    override fun onResponse(
                        call: Call<List<Coffee>>,
                        response: Response<List<Coffee>>
                    ) {
                        if (response.isSuccessful) {
                            Log.e("Coroutines", "hot coffees")
                            postList = (response.body() as MutableList<Coffee>?)!!
                            adapter = CoffeeAdapter(postList)
                            binding.hotCoffeeRecyclerView.adapter = adapter
                            binding.hotCoffeeRecyclerView.layoutManager =
                                GridLayoutManager(applicationContext, 2)
                        }
                    }
                })
            }
        }

    }
}