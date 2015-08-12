package com.datarita.ultimatecamera.turu.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.TextView;

import com.datarita.ultimatecamera.turu.R;
import com.datarita.ultimatecamera.turu.views.TwoWayView;

public class HorizontalPhotoGalleryFragment extends SimplePhotoGalleryListFragment {

    // Left and right scrolling two way view
    private TwoWayView mHorizontalListView;

    public HorizontalPhotoGalleryFragment(){
        super();
    }

    /**
     * Static factory method
     * @param sectionNumber
     * @return
     */
    public static HorizontalPhotoGalleryFragment newInstance(int sectionNumber) {
        HorizontalPhotoGalleryFragment fragment = new HorizontalPhotoGalleryFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    /**
     * Create View!
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return
     */
    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        View view = null;
        view = inflater.inflate(R.layout.fragment_horizontal_gallery, container, false);

        // Set the mAdapter
        mEmptyTextView = (TextView)view.findViewById(R.id.empty);
        mHorizontalListView = (TwoWayView)  view.findViewById(R.id.horizontalList);
        mHorizontalListView.setAdapter(mAdapter);
        mHorizontalListView.setItemMargin(10);

        resolveEmptyText();

        return view;
    }
}
