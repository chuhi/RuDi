package de.rudi.fragments;


import android.app.FragmentTransaction;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import de.rudi.R;
import de.rudi.activities.MainActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProfilFragment extends Fragment {

    private Button mSave;
    private Button mPassword;

    public ProfilFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View inputFragmentView = inflater.inflate(R.layout.fragment_profil, container, false);

        mSave = (Button) inputFragmentView.findViewById(R.id.saveButton2);
        mPassword = (Button) inputFragmentView.findViewById(R.id.chancePasswordButton);

        mSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),"Deine Daten wurden gespeichert",Toast.LENGTH_LONG).show();

                Fragment fStart = new StartFragment();
                FragmentTransaction change = getFragmentManager().beginTransaction();
                change.replace(R.id.container, fStart);
                change.addToBackStack(null);
                change.commit();
            }
        });

        mPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),"Noch nicht implementiert :-(",Toast.LENGTH_LONG).show();
            }
        });

        // Inflate the layout for this fragment
        return inputFragmentView;
    }


}
