package mattframpton.endclothing_mattframpton.DI;

import mattframpton.endclothing_mattframpton.Model.ProductList;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ServerResponse {
	@GET("/media/catalog/example.json")
	Call<ProductList> getJSON();
}
