package mattframpton.endclothing_mattframpton.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class ProductList {

    @SerializedName("product_count")
    var productCount: Long? = null
    @Expose
    var products: List<Product>? = null
    @Expose
    var title: String? = null

}
