package mattframpton.endclothing_mattframpton.view

import android.support.v7.widget.RecyclerView
import mattframpton.endclothing_mattframpton.network.EndClothingService
import mattframpton.endclothing_mattframpton.presenter.ShopFrontPresenter

interface ShopFrontContract {
    interface View {
        fun setPresenter(shopFrontPresenter: ShopFrontPresenter)
        val getHomePageRecyclerView: RecyclerView
    }

    interface Presenter {
        fun requestData(client: EndClothingService)
    }
}

