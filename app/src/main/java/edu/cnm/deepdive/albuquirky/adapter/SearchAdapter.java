package edu.cnm.deepdive.albuquirky.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import edu.cnm.deepdive.albuquirky.R;
import edu.cnm.deepdive.albuquirky.databinding.ItemSearchBinding;
import edu.cnm.deepdive.albuquirky.model.Product;
import java.text.NumberFormat;
import java.util.List;

/**
 * Adapter class for the {@link edu.cnm.deepdive.albuquirky.controller.ui.browse.BrowserFragment}.
 */
public class SearchAdapter extends ArrayAdapter<Product> {

  private final LayoutInflater inflater;
  private final NumberFormat formatter;
  private ItemSearchBinding binding;

  /**
   * The constructor sets a value for the required {@link LayoutInflater} and a {@link NumberFormat}
   *  to properly format product prices as currency.
   * @param context The application context.
   * @param products A list of {@link Product} objects to display.
   */
  public SearchAdapter(@NonNull Context context, @NonNull List<Product> products) {
    super(context, R.layout.item_search, products);
    inflater = LayoutInflater.from(context);
    formatter = NumberFormat.getCurrencyInstance();
  }

  @NonNull
  @Override
  public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
    binding = (convertView != null)
        ? ItemSearchBinding.bind(convertView)
        : ItemSearchBinding.inflate(inflater, parent, false);
    Product product = getItem(position);
    binding.name.setText(product.getName());
    binding.description.setText(product.getDescription());
    binding.price.setText(formatter.format(product.getPrice() / 100));
    return binding.getRoot();
  }

}