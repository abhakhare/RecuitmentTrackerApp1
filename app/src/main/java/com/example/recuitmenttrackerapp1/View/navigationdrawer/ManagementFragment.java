package com.example.recuitmenttrackerapp1.View.navigationdrawer;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.recuitmenttrackerapp1.R;


/**
 * Created by anupamchugh on 10/12/15.
 */
public class ManagementFragment extends Fragment {

    public ManagementFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_manegment, container, false);

        return rootView;
    }

}
