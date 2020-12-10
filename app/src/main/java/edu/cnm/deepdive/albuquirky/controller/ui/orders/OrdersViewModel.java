package edu.cnm.deepdive.albuquirky.controller.ui.orders;

import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

/**
 * Viewmodel to display orders fragment
 */
public class OrdersViewModel extends ViewModel {

  private MutableLiveData<String> mText;

  /**
   * Sets a {@link MutableLiveData} variable to a String to be displayed
   *
   * @param activity -
   */
  public OrdersViewModel(FragmentActivity activity) {
    mText = new MutableLiveData<>();
    mText.setValue("This is gallery fragment");
  }

  /**
   * Gets LiveData
   *
   * @return mText - String LiveData
   */
  public LiveData<String> getText() {
    return mText;
  }
}