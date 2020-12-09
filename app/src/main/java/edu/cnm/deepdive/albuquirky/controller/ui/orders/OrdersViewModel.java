package edu.cnm.deepdive.albuquirky.controller.ui.orders;

import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class OrdersViewModel extends ViewModel implements LifecycleObserver {

  private MutableLiveData<String> mText;

  public OrdersViewModel(FragmentActivity activity) {
    mText = new MutableLiveData<>();
    mText.setValue("This is gallery fragment");
  }

  public LiveData<String> getText() {
    return mText;
  }
}