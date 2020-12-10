package edu.cnm.deepdive.albuquirky.controller.ui.orders;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProvider;
import edu.cnm.deepdive.albuquirky.adapter.OrdersRecyclerAdapter;
import edu.cnm.deepdive.albuquirky.controller.MainViewModel;
import edu.cnm.deepdive.albuquirky.databinding.FragmentOrdersBinding;
import edu.cnm.deepdive.albuquirky.model.Order;
import edu.cnm.deepdive.albuquirky.model.ProductOnOrder;
import java.util.List;

/**
 * Fragment to display orders
 */
public class OrdersFragment extends Fragment {

  private FragmentOrdersBinding binding;
  private OrdersRecyclerAdapter adapter;
  private OrdersViewModel ordersViewModel;

  /**
   *
   *
   * @param inflater - service to convert layout to View objects
   * @param container - a view to hold other views to display
   * @param savedInstanceState - storage to pass data between activities
   * @return View object
   */
  public View onCreateView(@NonNull LayoutInflater inflater,
      ViewGroup container, Bundle savedInstanceState) {
    binding = FragmentOrdersBinding.inflate(inflater);
//    ordersViewModel = new ViewModelProvider(this).get(OrdersViewModel.class);
    return binding.getRoot();
  }

//  @Override
//  public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
//    super.onViewCreated(view, savedInstanceState);
//    setupViewModel();
//  }

//   private void setupViewModel() {
//     FragmentActivity activity = getActivity();
//     adapter = new OrdersRecyclerAdapter(activity);
////     binding.ordersList.setAdapter(adapter);
//     ordersViewModel = new ViewModelProvider(activity).get(OrdersViewModel.class);
//     getLifecycle().addObserver(viewModel);
//     LifecycleOwner lifecycleOwner = getViewLifecycleOwner();
  //   viewModel.getText().observe(lifecycleOwner, this::updateOrdersList);
//
//   }

//  private void updateOrdersList(Li) {
//
//  }

//  private void updateOrdersList(List<ProductOnOrder> orders) {
//    adapter.getOrders().clear();
//    adapter.getOrders().addAll(orders);
//    adapter.notifyItemInserted(orders.size());
     //noinspection ConstantConditions
//     binding.ordersList.getLayoutManager().scrollToPosition(orders.size() - 1);
//
//   }

}