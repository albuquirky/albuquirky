package edu.cnm.deepdive.albuquirky.controller.ui.profile;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;

import androidx.lifecycle.ViewModelProvider;
import edu.cnm.deepdive.albuquirky.R;
import edu.cnm.deepdive.albuquirky.databinding.FragmentProfileBinding;
import edu.cnm.deepdive.albuquirky.model.Profile;
import edu.cnm.deepdive.albuquirky.service.AlbuquirkyWebService;
import edu.cnm.deepdive.albuquirky.service.GoogleSignInService;
import org.jetbrains.annotations.NotNull;

public class ProfileFragment extends Fragment implements OnClickListener {

  public static final int PROFILE_IMAGE_REQUEST_CODE = 1024;
  private FragmentProfileBinding binding;
  private ProfileViewModel profileViewModel;
  private AlbuquirkyWebService webService;
  private Profile user;

  public View onCreateView(@NonNull LayoutInflater inflater,
      ViewGroup container, Bundle savedInstanceState) {

    binding = FragmentProfileBinding.inflate(inflater, container, false);
    binding.profilePicture.setOnClickListener((v) -> selectProfileImage());
    binding.updateProfile.setOnClickListener((v) -> updateProfile());


//    binding.inputEmail.setText(profileViewModel.getUser().getValue().getEmail());
    return binding.getRoot();
  }

  private void selectProfileImage() {
    Intent intent = new Intent();
    intent.setType("image/*");
    intent.setAction(Intent.ACTION_GET_CONTENT);
    startActivityForResult(Intent.createChooser(intent, getString(R.string.profile_image_prompt)),
        PROFILE_IMAGE_REQUEST_CODE);
  }

  private void updateProfile() {
    user.setUsername(binding.inputUsername.getText().toString().trim());
    user.setEmail(binding.inputEmail.getText().toString().trim());
    user.setAddress(binding.inputAddress.getText().toString().trim());
    profileViewModel.save(user);
  }

  @Override
  public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    profileViewModel = new ViewModelProvider(this).get(ProfileViewModel.class);
    profileViewModel.getUser().observe(getViewLifecycleOwner(), (user) -> {
      this.user = user;
      binding.inputUsername.setText(user.getUsername());
      binding.inputEmail.setText(user.getEmail());
      binding.inputAddress.setText(user.getAddress());
    });
  }

  @Override
  public void onActivityResult(int requestCode, int resultCode,
      @Nullable Intent data) {
    super.onActivityResult(requestCode, resultCode, data);
    if (requestCode == PROFILE_IMAGE_REQUEST_CODE && resultCode == Activity.RESULT_OK && data != null) {
      binding.profilePicture.setImageURI(data.getData());
    }
  }

  @Override
  public void onClick(View v) {

  }
}