package mattframpton.endclothing_mattframpton.network;

import io.reactivex.Single;
import mattframpton.endclothing_mattframpton.model.ProductList;
import retrofit2.http.GET;

public interface EndClothingService {
	@GET("/media/catalog/example.json")
	Single<ProductList> getJSON();
}
