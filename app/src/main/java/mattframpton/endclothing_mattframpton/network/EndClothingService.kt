package mattframpton.endclothing_mattframpton.network

import io.reactivex.Single
import mattframpton.endclothing_mattframpton.model.ProductList
import retrofit2.http.GET

interface EndClothingService {
    @get:GET("/media/catalog/example.json")
    val json: Single<ProductList>
}
