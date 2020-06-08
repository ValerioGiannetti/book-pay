package com.book.pay.app.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.book.pay.app.MainActivity;
import com.book.pay.app.R;
import com.book.pay.app.activity.SettingsActivity;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.google.android.material.navigation.NavigationView;

/**
 * A simple {@link Fragment} subclass.
 */
public class NavigationDrawerFragment extends BottomSheetDialogFragment {

    public NavigationDrawerFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
         View view =  inflater.inflate(R.layout.fragment_navigation_drawer, container, false);

        final NavigationView navigationView =view.findViewById(R.id.navigation_view);
        final FrameLayout layout = view.findViewById(R.id.drawer_navigation);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                int id = item.getItemId();
                Intent intent;

                switch (id){
                    case R.id.navigation_home:
                        intent = new Intent(getContext(), MainActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.navigation_settings:
                        intent = new Intent(getContext(), SettingsActivity.class);
                        startActivity(intent);
                        break;
                    default:
                        throw new IllegalStateException("Unexpected value: " + id);
                }

                return false;
            }

        });
         return view;
    }
}
