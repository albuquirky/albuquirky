package edu.cnm.deepdive.albuquirky.adapter;

import android.view.LayoutInflater;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import edu.cnm.deepdive.albuquirky.databinding.OrdersBinding;
import java.util.List;

public class OrdersRecyclerAdapter {

//  private final List<Orders> orders;
  private final LayoutInflater inflater;

  public class Holder extends RecyclerView.ViewHolder {

    private final OrdersBinding binding;

    public Holder(@NonNull OrdersBinding binding){
      super(binding.getRoot());
      this.binding = binding;
    }

    private void bind(int position){
      ;
    }
  }
}
