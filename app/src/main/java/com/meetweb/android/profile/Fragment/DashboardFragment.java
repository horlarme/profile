package com.meetweb.android.profile.Fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.button.MaterialButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.meetweb.android.profile.R;

public class DashboardFragment extends Fragment implements View.OnClickListener {

    MaterialButton openComment;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dashboard_fragment, container, false);

        //Setting onclick listener to open comment
        openComment = view.findViewById(R.id.openCommentButton);
        openComment.setOnClickListener(this);

        //returning the view
        return view;
    }

    public void openComments(View view) {
        Toast.makeText(getActivity(), "This will be opening comments activity in future", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.openCommentButton:
                openComments(v);
                break;
        }
    }
}
