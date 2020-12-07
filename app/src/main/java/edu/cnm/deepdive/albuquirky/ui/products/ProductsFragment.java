package edu.cnm.deepdive.albuquirky.ui.products;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import edu.cnm.deepdive.albuquirky.adapter.CarouselAdapter;
import edu.cnm.deepdive.albuquirky.databinding.FragmentProductsBinding;
import java.util.ArrayList;

public class ProductsFragment extends Fragment {

  private FragmentProductsBinding binding;

  public View onCreateView(@NonNull LayoutInflater inflater,
      ViewGroup container, Bundle savedInstanceState) {
    binding = FragmentProductsBinding.inflate(inflater);
    // TODO Get array of image objects.
    ArrayList<Fragment> fragments = new ArrayList<>();
    for (/* Image image : images */) {
      CarouselItemFragment fragment = CarouselItemFragment.getInstance(/* image */);
      fragments.add(fragment);
    }
    CarouselAdapter adapter = new CarouselAdapter(getParentFragmentManager(), 1, fragments);
    binding.productImageCarousel.setAdapter(adapter);
    binding.productIndicator.setupWithViewPager(binding.productImageCarousel, true);
    return binding.getRoot();
  }

}