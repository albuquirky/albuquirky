package edu.cnm.deepdive.albuquirky.controller.ui.browse;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import edu.cnm.deepdive.albuquirky.adapter.SearchAdapter;
import edu.cnm.deepdive.albuquirky.controller.MainViewModel;
import edu.cnm.deepdive.albuquirky.databinding.FragmentBrowserBinding;
import edu.cnm.deepdive.albuquirky.model.Product;

/**
 * The fragment class for displaying a list of {@link Product} objects in the browser screen.
 */
public class BrowserFragment extends Fragment {

  private MainViewModel viewModel;
  private FragmentBrowserBinding binding;

  /**
   * This method enables and develops the search function through the click of the search button.
   *
   * @param inflater The {@link LayoutInflater} to inflate the page elements.
   * @param container The {@link ViewGroup} containing the inflated elements.
   * @param savedInstanceState The {@link Bundle} representing a previous Activity state.
   * @return The root of the Activity view binding.
   */
  public View onCreateView(@NonNull LayoutInflater inflater,
      ViewGroup container, Bundle savedInstanceState) {
    binding = FragmentBrowserBinding.inflate(inflater, container, false);
    binding.searchButton.setOnClickListener((v) ->
        viewModel.search(binding.searchText.getText().toString().trim()));
    binding.searchResults.setOnItemClickListener((parent, view, position, id) -> {
      Product product = (Product) parent.getItemAtPosition(position);
      //TODO navigate to frag to display product
    });
    return binding.getRoot();
  }

  @Override
  public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    viewModel = new ViewModelProvider(this).get(MainViewModel.class);
    getLifecycle().addObserver(viewModel);
    viewModel.getResults().observe(getViewLifecycleOwner(), (products) -> {
      SearchAdapter adapter = new SearchAdapter(getContext(), products);
      binding.searchResults.setAdapter(adapter);
    });
    viewModel.getThrowable().observe(getViewLifecycleOwner(), (throwable) ->
        Toast.makeText(getContext(), throwable.getMessage(), Toast.LENGTH_LONG).show());
  }

}