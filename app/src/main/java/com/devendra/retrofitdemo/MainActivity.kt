package com.devendra.retrofitdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.liveData
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val retService = RetrofitInstance
                .getRetrofitInstance()
                .create(EmployeeService::class.java)

        val responseLiveData: LiveData<Response<Employee>> = liveData {
            val response = retService.getEmp()
            emit(response)
        }
        responseLiveData.observe(this, Observer {
            val dataList = it.body()?.listIterator()

            if(dataList!=null){
                while (dataList.hasNext()){
                    val albumsItem = dataList.next()
                    val result =" "+"Album Title : ${albumsItem.employee_name}"+"\n"+
                            " "+"Album id : ${albumsItem.id}"+"\n"+
                            " "+"User id : ${albumsItem.employee_salary}"+"\n\n\n"
                    text_view.append(result)
                }
            }
        })

    }
}