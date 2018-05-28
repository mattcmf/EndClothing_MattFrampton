package mattframpton.endclothing_mattframpton.model

import com.google.gson.annotations.Expose

class Product {

    @Expose
    var id: String? = null
    @Expose
    var image: String? = null
    @Expose
    var name: String? = null
    @Expose
    var price: String? = null

}
