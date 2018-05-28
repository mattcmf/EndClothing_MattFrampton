package mattframpton.endclothing_mattframpton.view

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import mattframpton.endclothing_mattframpton.R
import mattframpton.endclothing_mattframpton.adapter.ProductCatalogueAdapter
import mattframpton.endclothing_mattframpton.di.application.EndClothingApplication
import mattframpton.endclothing_mattframpton.model.Product
import mattframpton.endclothing_mattframpton.network.EndClothingService
import timber.log.Timber
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var mRecyclerView: RecyclerView
    internal lateinit var data: ArrayList<Product>
    private lateinit var adapter: RecyclerView.Adapter<*>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val client = (application as EndClothingApplication).endClothingService
        val context = this
        Timber.plant(Timber.DebugTree())
        initViews(context)
        if (client != null) requestData(client) else Timber.e("Error loading client")
    }

    private fun initViews(context: Context) {
        mRecyclerView = findViewById<View>(R.id.productCataRecyclerView) as RecyclerView
        mRecyclerView.setHasFixedSize(true)
        val manager = GridLayoutManager(context, 2)
        mRecyclerView.layoutManager = manager
    }

    private fun requestData(client: EndClothingService) {
        client.json
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ myData ->
                    data = ArrayList(myData.products)
                    adapter = ProductCatalogueAdapter(data)
                    mRecyclerView.adapter = adapter
                }) { throwable ->
                    // handle error event
                }
    }
}