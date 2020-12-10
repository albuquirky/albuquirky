package edu.cnm.deepdive.albuquirky.controller.ui.commission;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;

import androidx.lifecycle.ViewModelProvider;
import edu.cnm.deepdive.albuquirky.R;
import edu.cnm.deepdive.albuquirky.databinding.FragmentCommissionsBinding;

/**
 * Reusable UI layout to display commissions
 */
public class CommissionFragment extends Fragment {

  private FragmentCommissionsBinding binding;

  /**
   * Initial display of commissions
   *
   * @param inflater - service to convert layout to View objects
   * @param container - a view to hold other views to display
   * @param savedInstanceState - storage to pass data between activities
   * @return View object
   */
  public View onCreateView(@NonNull LayoutInflater inflater,
      ViewGroup container, Bundle savedInstanceState) {
    binding = FragmentCommissionsBinding.inflate(inflater, container, false);
    return binding.getRoot();
  }

}