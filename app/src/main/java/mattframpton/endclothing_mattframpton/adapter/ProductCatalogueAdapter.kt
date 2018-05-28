package mattframpton.endclothing_mattframpton.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.bumptech.glide.Glide
import mattframpton.endclothing_mattframpton.R
import mattframpton.endclothing_mattframpton.model.Product
import java.util.*

class ProductCatalogueAdapter(data: ArrayList<*>) : RecyclerView.Adapter<ProductCatalogueHolder>() {

    internal var productList: ArrayList<Product>

    init {
        this.productList = data as ArrayList<Product>
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductCatalogueHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.lineitem, parent, false)
        return ProductCatalogueHolder(v)
    }

    override fun onBindViewHolder(holder: ProductCatalogueHolder, position: Int) {
        holder.productPrice.text = productList[position].price
        holder.productName.text = productList[position].name
        Glide.with(holder.productImage.context)
                .load(productList[position].image)
                .into(holder.productImage)
    }

    override fun getItemCount(): Int {
        return productList.size
    }
}
