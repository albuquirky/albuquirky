package edu.cnm.deepdive.albuquirky.ui;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import edu.cnm.deepdive.albuquirky.R;
import edu.cnm.deepdive.albuquirky.databinding.FragmentBrowserBinding;
import org.jetbrains.annotations.NotNull;

/**
 * A simple {@link Fragment} subclass. Use the {@link BrowserFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BrowserFragment extends Fragment {

  private FragmentBrowserBinding binding;
  // TODO: Rename parameter arguments, choose names that match
  // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
  private static final String ARG_PARAM1 = "param1";
  private static final String ARG_PARAM2 = "param2";

  // TODO: Rename and change types of parameters
  private String mParam1;
  private String mParam2;

  public BrowserFragment() {
    // Required empty public constructor
  }

  /**
   * Use this factory method to create a new instance of this fragment using the provided
   * parameters.
   *
   * @param param1 Parameter 1.
   * @param param2 Parameter 2.
   * @return A new instance of fragment BrowserFragment.
   */
  // TODO: Rename and change types and number of parameters
  public static BrowserFragment newInstance(String param1, String param2) {
    BrowserFragment fragment = new BrowserFragment();
    Bundle args = new Bundle();
    args.putString(ARG_PARAM1, param1);
    args.putString(ARG_PARAM2, param2);
    fragment.setArguments(args);
    return fragment;
  }

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    if (getArguments() != null) {
      mParam1 = getArguments().getString(ARG_PARAM1);
      mParam2 = getArguments().getString(ARG_PARAM2);
    }
  }


  public View onCreateView(@NonNull @NotNull LayoutInflater inflater,
      ViewGroup container,
      Bundle savedInstanceState) {
    binding = FragmentBrowserBinding.inflate(inflater, container, false);
    binding.searchButton.setOnClickListener((v) ->
        viewModel.search(binding.searchText.getText().toString().trim()));
    return binding.getRoot();

  }
}