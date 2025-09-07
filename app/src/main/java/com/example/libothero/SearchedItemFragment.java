package com.example.libothero;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

public class SearchedItemFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_searched_item, container, false);

        ScrollView outerScrollView = view.findViewById(R.id.outerscrl);
        outerScrollView.setNestedScrollingEnabled(true);

        ScrollView innerScrollView = view.findViewById(R.id.inerscrl);
        innerScrollView.setNestedScrollingEnabled(false);
        return view;

    }
}