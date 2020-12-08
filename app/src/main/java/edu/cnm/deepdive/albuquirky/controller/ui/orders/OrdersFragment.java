package edu.cnm.deepdive.albuquirky.controller.ui.orders;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import edu.cnm.deepdive.albuquirky.databinding.FragmentOrdersBinding;

public class OrdersFragment extends Fragment {

  private FragmentOrdersBinding binding;

  public View onCreateView(@NonNull LayoutInflater inflater,
      ViewGroup container, Bundle savedInstanceState) {
    binding = FragmentOrdersBinding.inflate(inflater, container, false);
    return binding.getRoot();
  }

}