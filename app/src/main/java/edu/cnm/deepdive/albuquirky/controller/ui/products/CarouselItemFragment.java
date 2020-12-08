package edu.cnm.deepdive.albuquirky.controller.ui.products;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import edu.cnm.deepdive.albuquirky.databinding.FragmentCarouselItemBinding;

public class CarouselItemFragment extends Fragment {

  private FragmentCarouselItemBinding binding;

  public static CarouselItemFragment getInstance(/* TODO Pass in instance of Image object from server */) {
    CarouselItemFragment fragment = new CarouselItemFragment();
//    if (/* image != null */) {
//      Bundle bundle = new Bundle();
//      /* bundle.putParcelable("image", image); */
//      fragment.setArguments(bundle);
//    }
    return fragment;
  }

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    if(getArguments() != null) {
      /* TODO Store image as field, from getArguments.getParcelable("image") */
    }
  }

  @Override
  public View onCreateView(
      @NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    binding = FragmentCarouselItemBinding.inflate(inflater);
    return binding.getRoot();
  }

  @Override
  public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
//    if (/* image != null */) {
//      binding.carouselImage;
//      binding.carouselDescription.setText();
//    }
  }

}