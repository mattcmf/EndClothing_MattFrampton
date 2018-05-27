package mattframpton.endclothing_mattframpton.View;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import mattframpton.endclothing_mattframpton.Adapter.ProductCatalogueAdapter;
import mattframpton.endclothing_mattframpton.DI.ServerResponse;
import mattframpton.endclothing_mattframpton.Model.Product;
import mattframpton.endclothing_mattframpton.Model.ProductList;
import mattframpton.endclothing_mattframpton.R;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

	RecyclerView mRecyclerView;
	ArrayList<Product> data;
	RecyclerView.Adapter adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initViews();
	}

	private void initViews() {
		mRecyclerView = (RecyclerView) findViewById(R.id.productCataRecyclerView);
		mRecyclerView.setHasFixedSize(true);
		RecyclerView.LayoutManager manager = new GridLayoutManager(getApplicationContext(),2);
		mRecyclerView.setLayoutManager(manager);
		loadJSON();
	}

	private void loadJSON() {

		Retrofit retrofit = new Retrofit.Builder()
				.baseUrl("https://www.endclothing.com")
				.addConverterFactory(GsonConverterFactory.create())
				.build();

		ServerResponse request = retrofit.create(ServerResponse.class);
		Call<ProductList> call = request.getJSON();
		call.enqueue(new Callback<ProductList>() {
			@Override
			public void onResponse(Call<ProductList> call, Response<ProductList> response) {
				ProductList productResponse = response.body();
				data = new ArrayList<Product>(productResponse.getProducts());
				adapter = new ProductCatalogueAdapter(data);
				mRecyclerView.setAdapter(adapter);
			}

			@Override
			public void onFailure(Call<ProductList> call, Throwable t) {

			}
		});
		}
}
