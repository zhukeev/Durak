package view.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.appyvet.materialrangebar.RangeBar;
import com.example.durak_od.R;

import java.util.Objects;

import utils.SharedPreferenceHelper;

public class FilterSettingsDialog extends DialogFragment {

    private RangeBar rangeSeekBar;
    private CheckBox checkBox,checkBox2,checkBox3,checkBox4,checkBox5
            , checkBoxNormalSpeed, checkBoxFastMode, checkBoxThrowNeighbours, checkBoxThrowAll,checkBoxPassOn;
    private Button applyButton;


    private final String _2PLAYERS = "2PLAYERS";
    private final String _3PLAYERS = "3PLAYERS";
    private final String _4PLAYERS = "4PLAYERS";
    private final String _5PLAYERS = "5PLAYERS";
    private final String _6PLAYERS = "6PLAYERS";
    private final String _SPEED_NORMAL = "SPEED_NORMAL";
    private final String _SPEED_FAST = "SPEED_FAST";
    private final String _THROW_NEIGHBOURS = "THROW_NEIGHBOURS";
    private final String _THROW_ALL = "THROW_ALL";
    private final String _PASS_ON = "PASS_ON";


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.filter_dialog, container, false);
        init(v);

        setupRangeSeekbar();
        setupCheckbox();

        return v;
    }

    private void init(View v) {
        rangeSeekBar = v.findViewById(R.id.rangebarMat);
        applyButton = v.findViewById(R.id.applyFilterButton);


        checkBox = v.findViewById( R.id.filter_settings_checkbox1);
        checkBox2 = v.findViewById(R.id.filter_settings_checkbox2);
        checkBox3 = v.findViewById(R.id.filter_settings_checkbox3);
        checkBox4 = v.findViewById(R.id.filter_settings_checkbox4);
        checkBox5 = v.findViewById(R.id.filter_settings_checkbox5);
        checkBoxFastMode = v.findViewById(R.id.speed_of_game_fast_mode);
        checkBoxNormalSpeed = v.findViewById(R.id.speed_of_game_normal_mode);
        checkBoxThrowNeighbours = v.findViewById(R.id.throw_neighbours);
        checkBoxThrowAll = v.findViewById(R.id.throw_all);
        checkBoxPassOn = v.findViewById(R.id.passinOn);


        //get saved checkbox config
        boolean twoP   = SharedPreferenceHelper.getBoolean(Objects.requireNonNull(getContext()),_2PLAYERS,true);
        boolean threeP = SharedPreferenceHelper.getBoolean(Objects.requireNonNull(getContext()),_2PLAYERS,true);
        boolean fourP  = SharedPreferenceHelper.getBoolean(Objects.requireNonNull(getContext()),_2PLAYERS,true);
        boolean fiveP  = SharedPreferenceHelper.getBoolean(Objects.requireNonNull(getContext()),_2PLAYERS,true);
        boolean sixP   = SharedPreferenceHelper.getBoolean(Objects.requireNonNull(getContext()),_2PLAYERS,true);

        boolean passOn   = SharedPreferenceHelper.getBoolean(Objects.requireNonNull(getContext()),_PASS_ON,true);
        boolean throwAll   = SharedPreferenceHelper.getBoolean(Objects.requireNonNull(getContext()),_THROW_ALL,true);
        boolean throwNeighbours   = SharedPreferenceHelper.getBoolean(Objects.requireNonNull(getContext()),_THROW_NEIGHBOURS,true);
        boolean fastMode   = SharedPreferenceHelper.getBoolean(Objects.requireNonNull(getContext()),_SPEED_FAST,true);
        boolean normalMode   = SharedPreferenceHelper.getBoolean(Objects.requireNonNull(getContext()),_SPEED_NORMAL,true);




        setCheck(checkBoxPassOn,passOn,_PASS_ON);
        setCheck(checkBoxThrowAll,throwAll,_THROW_ALL);
        setCheck(checkBoxThrowNeighbours,throwNeighbours,_THROW_NEIGHBOURS);
        setCheck(checkBoxFastMode,fastMode,_SPEED_FAST);
        setCheck(checkBoxNormalSpeed,normalMode,_SPEED_NORMAL);

        setCheck(checkBox,twoP,_2PLAYERS);
        setCheck(checkBox2,threeP,_3PLAYERS);
        setCheck(checkBox3,fourP,_4PLAYERS);
        setCheck(checkBox4,fiveP,_5PLAYERS);
        setCheck(checkBox5,sixP,_6PLAYERS);

        applyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveChanges();
                dismiss();
            }
        });
    }

    private void saveChanges() {
        SharedPreferenceHelper.setBoolean(Objects.requireNonNull(getContext()),_2PLAYERS,checkBox.isChecked());
        SharedPreferenceHelper.setBoolean(Objects.requireNonNull(getContext()),_3PLAYERS,checkBox2.isChecked());
        SharedPreferenceHelper.setBoolean(Objects.requireNonNull(getContext()),_4PLAYERS,checkBox3.isChecked());
        SharedPreferenceHelper.setBoolean(Objects.requireNonNull(getContext()),_5PLAYERS,checkBox4.isChecked());
        SharedPreferenceHelper.setBoolean(Objects.requireNonNull(getContext()),_6PLAYERS,checkBox5.isChecked());
        SharedPreferenceHelper.setBoolean(Objects.requireNonNull(getContext()),_SPEED_FAST,checkBoxFastMode.isChecked());
        SharedPreferenceHelper.setBoolean(Objects.requireNonNull(getContext()),_SPEED_NORMAL,checkBoxNormalSpeed.isChecked());
        SharedPreferenceHelper.setBoolean(Objects.requireNonNull(getContext()),_PASS_ON,checkBoxPassOn.isChecked());
        SharedPreferenceHelper.setBoolean(Objects.requireNonNull(getContext()),_THROW_ALL,checkBoxThrowAll.isChecked());
        SharedPreferenceHelper.setBoolean(Objects.requireNonNull(getContext()),_THROW_NEIGHBOURS,checkBoxThrowNeighbours.isChecked());

    }

    private void setupCheckbox() {

        CompoundButton.OnCheckedChangeListener changeListener = new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                switch (buttonView.getId()) {
                    case R.id.filter_settings_checkbox1:
                        setCheck(buttonView, isChecked, _2PLAYERS);
                        break;
                    case R.id.filter_settings_checkbox2:
                        setCheck(buttonView, isChecked, _3PLAYERS);
                        break;
                    case R.id.filter_settings_checkbox3:
                        setCheck(buttonView, isChecked, _4PLAYERS);
                        break;
                    case R.id.filter_settings_checkbox4:
                        setCheck(buttonView, isChecked, _5PLAYERS);
                        break;
                    case R.id.filter_settings_checkbox5:
                        setCheck(buttonView, isChecked, _6PLAYERS);
                        break;

                    case R.id.speed_of_game_normal_mode:
                        setCheck(buttonView,isChecked,_SPEED_NORMAL);

                        break;
                    case R.id.speed_of_game_fast_mode:
                        setCheck(buttonView,isChecked,_SPEED_FAST);
                        break;
                    case R.id.passinOn:
                        setCheck(buttonView,isChecked,_PASS_ON);
                        break;
                    case R.id.throw_all:
                        setCheck(buttonView,isChecked,_THROW_ALL);
                        break;
                    case R.id.throw_neighbours:
                        setCheck(buttonView,isChecked,_THROW_NEIGHBOURS);
                        break;
                }


            }
        };

        checkBox.setOnCheckedChangeListener(changeListener);
        checkBox2.setOnCheckedChangeListener(changeListener);
        checkBox3.setOnCheckedChangeListener(changeListener);
        checkBox4.setOnCheckedChangeListener(changeListener);
        checkBox5.setOnCheckedChangeListener(changeListener);
        checkBoxNormalSpeed.setOnCheckedChangeListener(changeListener);
        checkBoxFastMode.setOnCheckedChangeListener(changeListener);
        checkBoxThrowAll.setOnCheckedChangeListener(changeListener);
        checkBoxThrowNeighbours.setOnCheckedChangeListener(changeListener);
        checkBoxPassOn.setOnCheckedChangeListener(changeListener);

    }

    private void setCheck(CompoundButton buttonView, boolean isChecked, String players) {

        switch (buttonView.getId()){

            case R.id.filter_settings_checkbox1:
            case R.id.filter_settings_checkbox2:
            case R.id.filter_settings_checkbox3:
            case R.id.filter_settings_checkbox4:
            case R.id.filter_settings_checkbox5:


                buttonView.setButtonDrawable(buttonView.isChecked()?R.drawable.checkbox_unchecked:R.drawable.checkbox_checked);
                SharedPreferenceHelper.setBoolean(Objects.requireNonNull(getContext()),players,isChecked);
                Toast.makeText(getContext(), "put "+buttonView.isChecked(), Toast.LENGTH_SHORT).show();
                break;

            case R.id.speed_of_game_normal_mode:
                if (!checkBoxFastMode.isChecked() && !isChecked) {
                    Toast.makeText(getContext(), "FAST MODE is "+ checkBoxFastMode.isChecked() +" Normal mode is  "+isChecked, Toast.LENGTH_SHORT).show();
                } else {

                    buttonView.setButtonDrawable(buttonView.isChecked()?
                            R.drawable.grdaient_arrow_speed_game_normal_mode_inactive:
                            R.drawable.grdaient_arrow_speed_game_normal_mode_active);
                    SharedPreferenceHelper.setBoolean(Objects.requireNonNull(getContext()),_SPEED_NORMAL,isChecked);
                }


                break;
            case R.id.speed_of_game_fast_mode:
                if (!checkBoxNormalSpeed.isChecked() && !isChecked) {
                        return;
                }

                    buttonView.setButtonDrawable(!buttonView.isChecked()?
                            R.drawable.grdaient_arrow_speed_game_speed_mode_inactive:
                            R.drawable.grdaient_arrow_speed_game_speed_mode_active);
                    SharedPreferenceHelper.setBoolean(Objects.requireNonNull(getContext()),_SPEED_FAST,isChecked);


                break;
            case R.id.passinOn:
                buttonView.setButtonDrawable(buttonView.isChecked()?
                        R.drawable.passing_mode_inactive:
                        R.drawable.passing_mode_active);
                SharedPreferenceHelper.setBoolean(Objects.requireNonNull(getContext()),_PASS_ON,isChecked);

                break;
            case R.id.throw_all:
                buttonView.setButtonDrawable(buttonView.isChecked()?
                        R.drawable.throw_all_icon_inactive:
                        R.drawable.throw_all_icon_active);
                SharedPreferenceHelper.setBoolean(Objects.requireNonNull(getContext()),_THROW_ALL,isChecked);

                break;
            case R.id.throw_neighbours:
                buttonView.setButtonDrawable(buttonView.isChecked()?
                        R.drawable.neighbours_mode_inactive:
                        R.drawable.neighbours_mode_active);
                SharedPreferenceHelper.setBoolean(Objects.requireNonNull(getContext()),_THROW_NEIGHBOURS,isChecked);

                break;
                default: break;
        }

    }

    private void setupRangeSeekbar() {

        rangeSeekBar.setOnRangeBarChangeListener(new RangeBar.OnRangeBarChangeListener() {
            @Override
            public void onRangeChangeListener(RangeBar rangeBar, int leftPinIndex, int rightPinIndex, String leftPinValue, String rightPinValue) {

            }

            @Override
            public void onTouchStarted(RangeBar rangeBar) {

            }

            @Override
            public void onTouchEnded(RangeBar rangeBar) {

            }
        });
    }


}
