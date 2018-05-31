package mattframpton.endclothing_mattframpton.presenter

import android.support.v7.widget.RecyclerView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import mattframpton.endclothing_mattframpton.adapter.ProductCatalogueAdapter
import mattframpton.endclothing_mattframpton.model.Product
import mattframpton.endclothing_mattframpton.network.EndClothingService
import mattframpton.endclothing_mattframpton.view.ShopFrontContract
import timber.log.Timber
import java.util.*

class ShopFrontPresenter(val view: ShopFrontContract.View) : ShopFrontContract.Presenter {
    private lateinit var data: ArrayList<Product>
    private lateinit var adapter: RecyclerView.Adapter<*>

    init {
        view.setPresenter(this)
    }

    override fun requestData(client: EndClothingService) {
        client.json
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ myData ->
                    data = ArrayList(myData.products)
                    adapter = ProductCatalogueAdapter(data)
                    view.getHomePageRecyclerView.adapter = adapter
                }) { throwable ->
                    Timber.e("Error retrieving data")
                }
    }
}
