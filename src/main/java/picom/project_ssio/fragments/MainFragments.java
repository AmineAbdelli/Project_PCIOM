package picom.project_ssio.fragments;

/**
 * Created by pro on 30/01/2017.
 */
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import pciom.projet_ssio.R;


public class MainFragments extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootview = inflater.inflate(R.layout.fragment_main,container,false);

        return rootview;

    }
}
