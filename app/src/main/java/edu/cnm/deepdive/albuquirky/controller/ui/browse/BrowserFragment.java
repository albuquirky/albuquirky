package edu.cnm.deepdive.albuquirky.controller.ui.browse;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.ViewModelProvider;
import edu.cnm.deepdive.albuquirky.databinding.FragmentBrowserBinding;
import edu.cnm.deepdive.albuquirky.model.SearchResponse.SearchData.ProdDto;
import edu.cnm.deepdive.albuquirky.controller.MainViewModel;
import org.jetbrains.annotations.NotNull;

public class BrowserFragment extends Fragment {

  private MainViewModel viewModel;
  private FragmentBrowserBinding binding;


  /**
   * This method enables and develops the search function through the click of the search button.
   *
   * @param inflater
   * @param container
   * @param savedInstanceState
   * @return
   */
  public View onCreateView(@NonNull @NotNull LayoutInflater inflater,
      ViewGroup container,
      Bundle savedInstanceState) {
    binding = FragmentBrowserBinding.inflate(inflater, container, false);
    binding.searchButton.setOnClickListener((v) ->
        viewModel.search(binding.searchText.getText().toString().trim()));
    return binding.getRoot();
  }

  @Override
  public void onViewCreated(@NonNull @NotNull View view,
      @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    viewModel = new ViewModelProvider(this).get(MainViewModel.class);
    viewModel.getResults().observe(getViewLifecycleOwner(), (verses) -> {
      ArrayAdapter<ProdDto> adapter = new ArrayAdapter<>(getContext(),
          android.R.layout.simple_list_item_1, verses);
      binding.searchResults.setAdapter(adapter);
    });
    viewModel.getThrowable().observe(getViewLifecycleOwner(), (throwable) ->
        Toast.makeText(getContext(), throwable.getMessage(), Toast.LENGTH_LONG).show());
  }
}