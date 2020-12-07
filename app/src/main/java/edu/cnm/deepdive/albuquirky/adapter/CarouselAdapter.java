package edu.cnm.deepdive.albuquirky.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import java.util.ArrayList;

public class CarouselAdapter extends FragmentStatePagerAdapter {

  private ArrayList<Fragment> images;

  @NonNull
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
