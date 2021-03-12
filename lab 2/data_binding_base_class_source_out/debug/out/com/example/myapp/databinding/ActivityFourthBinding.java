// Generated by view binder compiler. Do not edit!
package com.example.myapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.example.myapp.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityFourthBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final ImageView image;

  @NonNull
  public final ImageButton imageButton;

  @NonNull
  public final RecyclerView ingredients;

  @NonNull
  public final TextView name;

  @NonNull
  public final TextView nameDesc;

  @NonNull
  public final TextView nameIng;

  @NonNull
  public final RecyclerView recipe;

  @NonNull
  public final TextView type;

  private ActivityFourthBinding(@NonNull ConstraintLayout rootView, @NonNull ImageView image,
      @NonNull ImageButton imageButton, @NonNull RecyclerView ingredients, @NonNull TextView name,
      @NonNull TextView nameDesc, @NonNull TextView nameIng, @NonNull RecyclerView recipe,
      @NonNull TextView type) {
    this.rootView = rootView;
    this.image = image;
    this.imageButton = imageButton;
    this.ingredients = ingredients;
    this.name = name;
    this.nameDesc = nameDesc;
    this.nameIng = nameIng;
    this.recipe = recipe;
    this.type = type;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityFourthBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityFourthBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_fourth, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityFourthBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.image;
      ImageView image = rootView.findViewById(id);
      if (image == null) {
        break missingId;
      }

      id = R.id.imageButton;
      ImageButton imageButton = rootView.findViewById(id);
      if (imageButton == null) {
        break missingId;
      }

      id = R.id.ingredients;
      RecyclerView ingredients = rootView.findViewById(id);
      if (ingredients == null) {
        break missingId;
      }

      id = R.id.name;
      TextView name = rootView.findViewById(id);
      if (name == null) {
        break missingId;
      }

      id = R.id.name_desc;
      TextView nameDesc = rootView.findViewById(id);
      if (nameDesc == null) {
        break missingId;
      }

      id = R.id.name_ing;
      TextView nameIng = rootView.findViewById(id);
      if (nameIng == null) {
        break missingId;
      }

      id = R.id.recipe;
      RecyclerView recipe = rootView.findViewById(id);
      if (recipe == null) {
        break missingId;
      }

      id = R.id.type;
      TextView type = rootView.findViewById(id);
      if (type == null) {
        break missingId;
      }

      return new ActivityFourthBinding((ConstraintLayout) rootView, image, imageButton, ingredients,
          name, nameDesc, nameIng, recipe, type);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
