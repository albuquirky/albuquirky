package edu.cnm.deepdive.albuquirky.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import java.util.ArrayList;

/**
 * Adapter that uses Fragments to manage images in a carousel
 */
public class CarouselAdapter extends FragmentStatePagerAdapter {

  private ArrayList<Fragment> images;

  /**
   * Constructor to initialize {@link CarouselAdapter}
   *
   * @param fm - FragmentManager that will interact with this adapter
   * @param behavior - int to control whether the current or all fragments are in RESUMED state
   * @param fragments - resizable array of fragments
   */
  public CarouselAdapter(@NonNull FragmentManager fm, int behavior, ArrayList<Fragment> fragments) {
    super(fm, behavior);
    images = fragments;
  }

  @Override
  public Fragment getItem(int position) {
    return images.get(position);
  }

  @Override
  public int getCount() {
    return images.size();
  }

}