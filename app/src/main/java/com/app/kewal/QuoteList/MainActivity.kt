package com.app.kewal.QuoteList

import android.os.Bundle
import android.util.Log
import android.widget.Adapter
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.app.kewal.QuoteList.AdapterModule.AdapterQuote
import com.app.kewal.QuoteList.AdapterModule.TestAdapter
import com.app.kewal.QuoteList.ModelModule.ResultsItem
import com.app.kewal.QuoteList.Utils.QuotesApi
import com.app.kewal.QuoteList.Utils.RetrofitHelper
import com.app.kewal.R
import com.app.kewal.SerializableModule.ModelClass

const val TAG = "MainActivity"

class MainActivity : AppCompatActivity() {

    val quoteArray = arrayListOf<ResultsItem>()
    lateinit var adapterQuote: TestAdapter
    private lateinit var progressBar: ProgressBar
    private lateinit var centerProgressBar: ProgressBar
    private var pageNum = 1
    var isLoading = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//
//        var obj = ModelClass(name1,age)
//        obj.name =name1
//        obj.age =age

        val rvView = findViewById<RecyclerView>(R.id.rvView)
        progressBar = findViewById<ProgressBar>(R.id.progressBar) as ProgressBar
        centerProgressBar = findViewById<ProgressBar>(R.id.centerProgressBar) as ProgressBar
        /* rvView.layoutManager = LinearLayoutManager(this)
         adapterQuote = AdapterQuote(quoteArray)
         rvView.adapter = adapterQuote
 */
        adapterQuote = TestAdapter(quoteArray)
        rvView.adapter = adapterQuote
        val layoutManager = LinearLayoutManager(this)
        rvView.layoutManager = layoutManager
        adapterQuote.onItemClick ={
            Toast.makeText(this, "On click set...", Toast.LENGTH_SHORT).show()
        }

        getUserList()

        rvView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                val visibleItemCount = layoutManager.childCount
                val pastVisibleItem = layoutManager.findFirstCompletelyVisibleItemPosition()
                val total = adapterQuote.itemCount
                if (isLoading) {
                    if ((visibleItemCount + pastVisibleItem) >= total) {
                        pageNum++
                        getUserList()
                    }
                }
                super.onScrolled(recyclerView, dx, dy)
            }
        })
    }

    private fun getUserList() {
        if (pageNum == 1) centerProgressBar.isVisible = true else progressBar.isVisible = true
        val quotesApi: QuotesApi = RetrofitHelper.getInstance().create(QuotesApi::class.java)
        lifecycleScope.launchWhenCreated {
            try {
                val response = quotesApi.getQuotes(pageNum)
                if (response.isSuccessful)
                    centerProgressBar.isVisible = false
                    progressBar.isVisible = false
                response.body()?.let {
//                    quoteArray = it.results!!
                    quoteArray.addAll(it.results ?: emptyList())
                    Log.d(TAG, "QuoteArray:" + quoteArray)
                    adapterQuote.notifyDataSetChanged()
                }
            } catch (Ex: Exception) {
                Log.e(TAG, "Error" + Ex.localizedMessage)
            }


        }
    }
}



