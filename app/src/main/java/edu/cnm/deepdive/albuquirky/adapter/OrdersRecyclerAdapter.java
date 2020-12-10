package edu.cnm.deepdive.albuquirky.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import edu.cnm.deepdive.albuquirky.adapter.OrdersRecyclerAdapter.Holder;
import edu.cnm.deepdive.albuquirky.databinding.OrdersBinding;
import edu.cnm.deepdive.albuquirky.model.ProductOnOrder;
import java.util.ArrayList;
import java.util.List;

/**
 * Adapter to bind views to orders and prices
 */
public class OrdersRecyclerAdapter extends RecyclerView.Adapter<Holder> {

  private final Context context;
  private final LayoutInflater inflater;
  private final List<ProductOnOrder> orders;
//  private final Image image;

  /**
   * Constructor to initialize {@link OrdersRecyclerAdapter}
   *
   * @param context - link to system
   */
  public OrdersRecyclerAdapter(Context context) {
    this.context = context;
    inflater = LayoutInflater.from(context);
    orders = new ArrayList<>();
  }

  /**
   * Gets list of orders
   *
   * @return orders - list of orders
   */
  public List<ProductOnOrder> getOrders() {
    return orders;
  }

  @NonNull
  @Override
  public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    OrdersBinding binding = OrdersBinding.inflate(inflater, parent, false);
    return new Holder(binding);
  }

  @Override
  public void onBindViewHolder(@NonNull Holder holder, int position) {
    holder.bind(position);
  }

  @Override
  public int getItemCount() {
    return orders.size();
  }

  /**
   * Storage for component views
   */
  class Holder extends RecyclerView.ViewHolder {

    private final OrdersBinding binding;

    /**
     * Constructor to initialize {@link Holder}
     *
     * @param binding - links UI components to data
     */
    public Holder(@NonNull OrdersBinding binding) {
      super(binding.getRoot());
      this.binding = binding;
    }

    private void bind(int position) {
      ProductOnOrder order = orders.get(position);
//    binding.itemNameOrderId.setText(order.getProduct());
      binding.itemCost.setText(order.getUnitPrice());
//      Product
//      binding.itemNameOrderId.setText(Product..);
//      binding.itemNameOrderId.setText(order.getOrderId);
//      binding.orderDatePlaced.setText(order.getPlacedDate());
//      binding.itemCost.setText();
//      binding.productOrderImage.;
    }
  }
}
