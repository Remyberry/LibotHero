package com.example.libothero;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link JeepListFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class JeepListFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private ListView listView;
    private ArrayAdapter<String> adapter;
    String[] data = {"MAINGATE - FRIENDSHIP","C'POINT - BALIBAGO - HIGHWAY","SM CITY - MAIN GATE - DAU", "CHECKPOINT - HESONVILLE - HOLY", "SAPANG BATO - ANGELES"
    ,"CHECKPOINT - HOLY - HIGHWAY", "MARISOL - PAMPANG"};

    public JeepListFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment JeepListFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static JeepListFragment newInstance(String param1, String param2) {
        JeepListFragment fragment = new JeepListFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_jeep_list, container, false);

        listView = view.findViewById(R.id.jeeplist);

        adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, data);
        listView.setAdapter(adapter);

        return view;

    }
}