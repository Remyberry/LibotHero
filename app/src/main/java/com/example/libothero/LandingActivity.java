package com.example.libothero;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.libothero.databinding.ActivityLandingBinding;
import com.google.android.material.navigation.NavigationBarView;

public class LandingActivity extends AppCompatActivity {
    ActivityLandingBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityLandingBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigation);
        Menu menu = bottomNavigationView.getMenu();
        int selectedIndex = 2; // Set the index of the item you want to be initially selected
        MenuItem selectedItem = menu.getItem(selectedIndex);
        selectedItem.setChecked(true);




        binding.bottomNavigation.setOnItemSelectedListener(item -> {
            int menuItemId = item.getItemId();

            if (menuItemId == R.id.expand) {
                showDialog();
                /*botdialog dialogFragment = new botdialog();
                dialogFragment.show(getSupportFragmentManager(), "bottom_sheet_dialog");*/
            } else if (menuItemId == R.id.jeeps) {
                showptv();
                // Handle item 2 selection
            } else if (menuItemId == R.id.dashbord) {
                replaceFragment(new HomeFragment());
            } else if (menuItemId == R.id.nearby) {
                replaceFragment(new NearbyFragment());
            } else if (menuItemId == R.id.favorites) {
                showFav();
            } else {
                // Handle default case
            }
            return true;
        });

    }
    private void showDialog(){
        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.test);
        dialog.getWindow().setBackgroundDrawableResource(R.drawable.expandabolbg);
        Window window = dialog.getWindow();

        WindowManager.LayoutParams layoutParams = window.getAttributes();
        int marginInPixels = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 60, getResources().getDisplayMetrics());
        layoutParams.y = marginInPixels;

        window.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        window.setGravity(Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL);
        // Customize the dialog's appearance and behavior here
        window.setAttributes(layoutParams);

        Button btnlogout = dialog.findViewById(R.id.logout);
        Button btnsetting = dialog.findViewById(R.id.settings);


        btnlogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                Intent i = new Intent(getApplicationContext(),
                        LoginActivity.class);
                startActivity(i);
                finish();
            }
        });
        btnsetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                Intent i = new Intent(getApplicationContext(),
                        SettingsActivity.class);
                startActivity(i);
                finish();
            }
        });


        dialog.show();
    }
    private void showptv(){
        Dialog dialog = new Dialog(LandingActivity.this);
        dialog.setContentView(R.layout.fragment_jeepney);
        Window window = dialog.getWindow();
        window.setBackgroundDrawable(null);
        WindowManager.LayoutParams layoutParams = window.getAttributes();
        int marginInPixels = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 60, getResources().getDisplayMetrics());
        layoutParams.y = marginInPixels;
        window.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        window.setGravity(Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL);
        window.setAttributes(layoutParams);


        dialog.show();
    }
    private void showFav(){
        Dialog dialog = new Dialog(LandingActivity.this);
        dialog.setContentView(R.layout.fragment_fav_dialog);
        Window window = dialog.getWindow();
        window.setBackgroundDrawable(null);
        WindowManager.LayoutParams layoutParams = window.getAttributes();
        int marginInPixels = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 60, getResources().getDisplayMetrics());
        layoutParams.y = marginInPixels;
        window.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        window.setGravity(Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL);
        window.setAttributes(layoutParams);


        dialog.show();
    }
    public void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_cont, fragment);
        fragmentTransaction.commit();
    }


}