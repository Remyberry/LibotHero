package com.example.libothero;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.example.libothero.databinding.FragmentJeepneyBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link JeepneyFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class JeepneyFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private BottomNavigationView bottomNavigationView;
    private NavController navController;
    private FrameLayout listContainer;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public JeepneyFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment JeepneyFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static JeepneyFragment newInstance(String param1, String param2) {
        JeepneyFragment fragment = new JeepneyFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_jeepney, container, false);

        /*// Initialize the BottomNavigationView
        bottomNavigationView = view.findViewById(R.id.ptvNav);
        listContainer = view.findViewById(R.id.list_cont);
        navController = NavHostFragment.findNavController(this);
        NavigationUI.setupWithNavController(bottomNavigationView, navController);
        // Set the initial selected item
        Menu menu = bottomNavigationView.getMenu();
        int selectedIndex = 0; // Set the index of the item you want to be initially selected
        MenuItem selectedItem = menu.getItem(selectedIndex);
        selectedItem.setChecked(true);


        bottomNavigationView.setOnItemSelectedListener(item -> {
            int menuItemId = item.getItemId();

            if (menuItemId == R.id.jeeps) {
                replaceFragment(new JeepListFragment());
            } else if (menuItemId == R.id.trikes) {
                replaceFragment(new TrikeListFragment());
            } else if (menuItemId == R.id.trains) {
                replaceFragment(new ListViewFragment());
            }
            else {
            }
            return true;
        });*/


        BottomNavigationView bottomNavigationView = view.findViewById(R.id.ptvNav);

        navController = Navigation.findNavController(requireActivity(), R.id.list_cont);

        bottomNavigationView.setOnItemSelectedListener(item -> {
            int menuItemId = item.getItemId();

            if (menuItemId == R.id.jeeps) {
                navController.navigate(R.id.jeepsfrag);
            } else if (menuItemId == R.id.trikes) {
                navController.navigate(R.id.trikesfrag);
            } else if (menuItemId == R.id.trains) {
                navController.navigate(R.id.trainsfrag);
            }
            else {
            }
            return true;
        });
        return view;
    }
    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getChildFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.list_cont, fragment)
                .commit();
    }
}