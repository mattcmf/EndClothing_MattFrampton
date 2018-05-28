package mattframpton.endclothing_mattframpton.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import mattframpton.endclothing_mattframpton.model.Product;
import mattframpton.endclothing_mattframpton.R;

public class ProductCatalogueAdapter extends RecyclerView.Adapter<ProductCatalogueHolder>{

	ArrayList<Product> productList;

	public ProductCatalogueAdapter(ArrayList data){
		this.productList = data;
	}

	@NonNull
	@Override
	public ProductCatalogueHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
		View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.lineitem, parent, false);
		return new ProductCatalogueHolder(v);
	}

	@Override
	public void onBindViewHolder(@NonNull ProductCatalogueHolder holder, int position) {
		holder.productPrice.setText(productList.get(position).getPrice());
		holder.productName.setText(productList.get(position).getName());
		Glide.with(holder.productImage.getContext())
				.load(productList.get(position).getImage())
				.into(holder.productImage);
	}

	@Override
	public int getItemCount() {
		return productList.size();
	}
}
