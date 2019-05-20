package view.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import com.example.durak_od.R;

public class FilterSearchFragment extends Fragment implements View.OnClickListener {

    FilterSettingsDialog dialog;
    DialogFragment dialogFragment;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        View v = inflater.inflate(R.layout.fragment_top_filters, container, false);
        Toast.makeText(getContext(), "FILTER STARTED", Toast.LENGTH_SHORT).show();
        init(v);

        return v;
    }

    private void init(View view) {
        dialogFragment = new FilterSettingsDialog();

        LinearLayout filter = view.findViewById(R.id.filters_layout);
        ImageView openFilterButton = filter.findViewById(R.id.open_filter_button);// view.findViewById(R.layout.fragment_top_filters).findViewById(R.id.open_filter_button);
        openFilterButton.setOnClickListener(this);

        filter.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.filters_layout:
                    dialogFragment.show(getFragmentManager(),"Dialog");
                break;
            case R.id.open_filter_button:
                Toast.makeText(getContext(), "asdasdasd", Toast.LENGTH_SHORT).show();

                break;
        }
    }
}
