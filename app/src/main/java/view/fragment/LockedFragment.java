package view.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.appyvet.materialrangebar.RangeBar;
import com.example.durak_od.R;

import java.util.Objects;

import utils.SharedPreferenceHelper;

public class LockedFragment extends Fragment implements View.OnClickListener {




    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_locked, container, false);

        return v;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){

        }
    }
}
