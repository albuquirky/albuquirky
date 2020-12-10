package edu.cnm.deepdive.albuquirky.controller.ui.products;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProvider;
import edu.cnm.deepdive.albuquirky.adapter.CarouselAdapter;
import edu.cnm.deepdive.albuquirky.databinding.FragmentProductBinding;
import java.util.ArrayList;
import org.jetbrains.annotations.NotNull;

/**
 * Displays the product_fragment layout for a list of products in a carousel.
 */
public class ProductFragment extends Fragment {

  private FragmentProductBinding binding;
  private ProductViewModel viewModel;

  /**
   * Initial display of list of images of products
   *
   * @param inflater - service to display layout
   * @param container - view to hold other views to display
   * @param savedInstanceState - stores data to pass to activity
   * @return binding.getRoot - View to display
   */
  public View onCreateView(
      @NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    binding = FragmentProductBinding.inflate(inflater);
    // TODO Get array of image objects.
    ArrayList<Fragment> fragments = new ArrayList<>();
//    for (/* Image image : images */) {
//      CarouselItemFragment fragment = CarouselItemFragment.getInstance(/* image */);
//      fragments.add(fragment);
//    }
    CarouselAdapter adapter = new CarouselAdapter(getParentFragmentManager(), 1, fragments);
//    binding.productImageCarousel.setAdapter(adapter);
//    binding.productIndicator.setupWithViewPager(binding.productImageCarousel, true);
    return binding.getRoot();
  }

  @Override
  public void onViewCreated(@NonNull @NotNull View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    setupViewModel();
  }

  private void setupViewModel() {
    FragmentActivity activity = getActivity();
    //noinspection ConstantConditions
    viewModel = new ViewModelProvider(activity).get(ProductViewModel.class);
    getLifecycle().addObserver(viewModel);
    LifecycleOwner lifecycleOwner = getViewLifecycleOwner();
//    viewModel.getProduct().observe(lifecycleOwner, /* TODO What happens here? */);
  }

}