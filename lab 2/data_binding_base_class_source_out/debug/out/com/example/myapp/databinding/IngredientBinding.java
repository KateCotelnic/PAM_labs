// Generated by view binder compiler. Do not edit!
package com.example.myapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import com.example.myapp.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class IngredientBinding implements ViewBinding {
  @NonNull
  private final CardView rootView;

  @NonNull
  public final ImageView imageView;

  @NonNull
  public final TextView nameIngredient;

  private IngredientBinding(@NonNull CardView rootView, @NonNull ImageView imageView,
      @NonNull TextView nameIngredient) {
    this.rootView = rootView;
    this.imageView = imageView;
    this.nameIngredient = nameIngredient;
  }

  @Override
  @NonNull
  public CardView getRoot() {
    return rootView;
  }

  @NonNull
  public static IngredientBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static IngredientBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.ingredient, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static IngredientBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.imageView;
      ImageView imageView = rootView.findViewById(id);
      if (imageView == null) {
        break missingId;
      }

      id = R.id.name_ingredient;
      TextView nameIngredient = rootView.findViewById(id);
      if (nameIngredient == null) {
        break missingId;
      }

      return new IngredientBinding((CardView) rootView, imageView, nameIngredient);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}