package mattframpton.endclothing_mattframpton.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import mattframpton.endclothing_mattframpton.R

class ProductCatalogueHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    internal val productName: TextView = itemView.findViewById<View>(R.id.productName) as TextView
    internal val productPrice: TextView = itemView.findViewById<View>(R.id.productPrice) as TextView
    internal val productImage: ImageView = itemView.findViewById<View>(R.id.productImage) as ImageView
}