package mattframpton.endclothing_mattframpton.view;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import mattframpton.endclothing_mattframpton.R;
import mattframpton.endclothing_mattframpton.adapter.ProductCatalogueAdapter;
import mattframpton.endclothing_mattframpton.di.application.EndClothingApplication;
import mattframpton.endclothing_mattframpton.model.Product;
import mattframpton.endclothing_mattframpton.network.EndClothingService;
import timber.log.Timber;

public class MainActivity extends AppCompatActivity {

	RecyclerView mRecyclerView;
	ArrayList<Product> data;
	RecyclerView.Adapter adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		EndClothingService client = ((EndClothingApplication) getApplication()).getEndClothingService();
		Context context = this;
		Timber.plant(new Timber.DebugTree());
		initViews(context);
		requestData(client);
	}

	private void initViews(Context context) {
		mRecyclerView = (RecyclerView) findViewById(R.id.productCataRecyclerView);
		mRecyclerView.setHasFixedSize(true);
		RecyclerView.LayoutManager manager = new GridLayoutManager(context,2);
		mRecyclerView.setLayoutManager(manager);
	}

	private void requestData(EndClothingService client) {
		client.getJSON()
				.subscribeOn(Schedulers.io())
				.observeOn(AndroidSchedulers.mainThread())
				.subscribe(myData ->
				{
					data = new ArrayList<Product>(myData.getProducts());
					adapter = new ProductCatalogueAdapter(data);
					mRecyclerView.setAdapter(adapter);
				}, throwable -> {
					// handle error event
				});
		}
}