package de.rudi.fragments;

import android.app.FragmentTransaction;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import de.rudi.R;
public class StartFragment extends Fragment {

    private Button mAbout;
    private Button mFindRuDi;
    private Button mCreateRuDi;
    private Button mYourRuDi;
    private Button mProfil;

    public StartFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View inputFragmentView = inflater.inflate(R.layout.fragment_start, container, false);

        mAbout = (Button) inputFragmentView.findViewById(R.id.bAbout);
        mFindRuDi = (Button) inputFragmentView.findViewById(R.id.bFindRuDi);
        mCreateRuDi = (Button) inputFragmentView.findViewById(R.id.bCreateRuDi);
        mYourRuDi = (Button) inputFragmentView.findViewById(R.id.bYourRuDi);
        mProfil = (Button) inputFragmentView.findViewById(R.id.bProfil);

        mAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fAbout = new AboutFragment();
                FragmentTransaction change = getFragmentManager().beginTransaction();
                change.replace(R.id.container, fAbout);
                change.addToBackStack(null);
                change.commit();
            }
        });

        mFindRuDi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fAbout = new RuDiSearchFragment();
                FragmentTransaction change = getFragmentManager().beginTransaction();
                change.replace(R.id.container, fAbout);
                change.addToBackStack(null);
                change.commit();
            }
        });

        mCreateRuDi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fAbout = new RudiCreateFragment();
                FragmentTransaction change = getFragmentManager().beginTransaction();
                change.replace(R.id.container, fAbout);
                change.addToBackStack(null);
                change.commit();
            }
        });

        mYourRuDi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fAbout = new YourRuDiFragment();
                FragmentTransaction change = getFragmentManager().beginTransaction();
                change.replace(R.id.container, fAbout);
                change.addToBackStack(null);
                change.commit();
            }
        });

        mProfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fAbout = new ProfilFragment();
                FragmentTransaction change = getFragmentManager().beginTransaction();
                change.replace(R.id.container, fAbout);
                change.addToBackStack(null);
                change.commit();
            }
        });



        // Inflate the layout for this fragment
        return inputFragmentView;


    }

}
