package mattframpton.endclothing_mattframpton.adapter;


import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import mattframpton.endclothing_mattframpton.R;

public class ProductCatalogueHolder extends RecyclerView.ViewHolder {

	TextView productName, productPrice;
	ImageView productImage;

	public ProductCatalogueHolder(View itemView) {
		super(itemView);
		productImage = (ImageView) itemView.findViewById(R.id.productImage);
		productName = (TextView) itemView.findViewById(R.id.productName);
		productPrice = (TextView) itemView.findViewById(R.id.productPrice);
	}
}