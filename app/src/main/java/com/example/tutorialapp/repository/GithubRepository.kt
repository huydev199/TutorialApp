package com.example.tutorialapp.repository

import android.util.Log
import com.example.tutorialapp.api.GitHubService
import com.example.tutorialapp.api.RetrofitClientInstance
import com.example.tutorialapp.model.apis.Repo
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.create
import java.io.UnsupportedEncodingException

class GithubRepository {
    private val service: GitHubService by lazy {
        RetrofitClientInstance().initRetrofit!!.create(GitHubService::class.java)
    }
    fun getList(){
        service.listRepos("mojombo").enqueue(object:Callback<List<Repo>>{
            override fun onResponse(call: Call<List<Repo>>, response: Response<List<Repo>>) {

                    Log.d("res", " status "+response.code()+" onResponse "+response.body())
            }

            override fun onFailure(call: Call<List<Repo>>, t: Throwable) {
            }

        })

    }
}