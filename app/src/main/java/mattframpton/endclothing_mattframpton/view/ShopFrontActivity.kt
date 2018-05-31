package mattframpton.endclothing_mattframpton.view

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import mattframpton.endclothing_mattframpton.R
import mattframpton.endclothing_mattframpton.di.application.EndClothingApplication
import mattframpton.endclothing_mattframpton.presenter.ShopFrontPresenter
import timber.log.Timber

class ShopFrontActivity : AppCompatActivity(), ShopFrontContract.View  {

    private var presenter: ShopFrontContract.Presenter? = null
    private lateinit var mRecyclerView: RecyclerView

    override val getHomePageRecyclerView: RecyclerView
        get() = mRecyclerView

    override fun setPresenter(shopFrontPresenter: ShopFrontPresenter) {
        this.presenter = kotlin.checkNotNull(shopFrontPresenter)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter = ShopFrontPresenter(this)

        val client = (application as EndClothingApplication).endClothingService
        val context = this
        Timber.plant(Timber.DebugTree())
        initViews(context)
        if (client != null) presenter?.requestData(client) else
            Timber.e("Error loading client")
    }

    private fun initViews(context: Context) {
        mRecyclerView = findViewById<View>(R.id.productCataRecyclerView) as RecyclerView
        mRecyclerView.setHasFixedSize(true)
        val manager = GridLayoutManager(context, 2)
        mRecyclerView.layoutManager = manager
    }
}

