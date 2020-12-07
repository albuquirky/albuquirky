package edu.cnm.deepdive.albuquirky.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import edu.cnm.deepdive.albuquirky.adapter.OrdersRecyclerAdapter.Holder;
import edu.cnm.deepdive.albuquirky.databinding.OrdersBinding;
import edu.cnm.deepdive.albuquirky.model.Order;
import java.util.ArrayList;
import java.util.List;
import org.jetbrains.annotations.NotNull;

public class OrdersRecyclerAdapter extends RecyclerView.Adapter<Holder> {

  private final Context context;
  private final List<Order> orders;
  private final LayoutInflater inflater;

  public OrdersRecyclerAdapter(Context context) {
    this.context = context;
    orders = new ArrayList<>();
    inflater = LayoutInflater.from(context);
  }

  public List<Order> getOrders() {
    return orders;
  }

  @NonNull
  @Override
  public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    return null;
  }

  @Override
  public void onBindViewHolder(@NonNull Holder holder, int position) {
    holder.bind(position);
  }

  @Override
  public int getItemCount() {
    return orders.size();
  }

  public class Holder extends RecyclerView.ViewHolder {

    private final OrdersBinding binding;

    public Holder(@NonNull OrdersBinding binding){
      super(binding.getRoot());
      this.binding = binding;
    }

    private void bind(int position){
      Order order = orders.get(position);
      binding.
    }
  }
}
