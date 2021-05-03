package com.miczon.task4_fragments.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.miczon.task4_fragments.MainActivity;
import com.miczon.task4_fragments.R;
import com.miczon.task4_fragments.fragments.adapter.ViewPagerAdapter;


public class SecondFragment extends Fragment {
   private ViewPagerAdapter viewPagerAdapter;
 private Button btn;

    public SecondFragment() {
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        btn = view.findViewById(R.id.btn);
        TextView textView = view.findViewById(R.id.tv_january);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//Put the value
                ThirdFragment fragment = new ThirdFragment();
                Bundle arguments = new Bundle();
                arguments.putString( "abc" , textView.getText().toString()           );
                fragment.setArguments(arguments);

                ViewPager viewPager = ((MainActivity) getContext()).findViewById(R.id.viewpager);
                Toast.makeText(getContext(), "hello", Toast.LENGTH_SHORT).show();
                final  FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.second, fragment);

                //we are telling that we are trnsecting within Fragment
                fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);

                //On back button it will go to the from where it comes
                fragmentTransaction.addToBackStack(null);

                fragmentTransaction.commit();
            }
        });
    }
}