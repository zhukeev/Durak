package view.fragment;

import android.content.ContextWrapper;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.appyvet.materialrangebar.RangeBar;
import com.example.durak_od.R;
import com.pixplicity.easyprefs.library.Prefs;

import java.util.Objects;

import utils.SharedPreferenceHelper;

public class FilterSettingsDialog extends DialogFragment {

    private RangeBar rangeSeekBar;
    private CheckBox checkBoxPassOn;
    private Button applyButton;
    private RadioButton radioButton1,radioButton2,radioButton3,radioButton4,radioButton5,
                        radioButtonSpeedFast,radioButtonSpeedNormal,radioButtonThrowAll,radioButtonThrowNeighbours;


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

    SharedPreferences sharedPref;
    SharedPreferences.Editor editor;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.filter_dialog, container, false);
        init(v);

        setupRangeSeekbar();
//        setupCheckbox();

        return v;
    }

    private void init(View v) {
        rangeSeekBar = v.findViewById(R.id.rangebarSearchDialog);

        applyButton = v.findViewById(R.id.applyFilterButton);

        new Prefs.Builder()
                .setContext(getContext())
                .setMode(ContextWrapper.MODE_PRIVATE)
                .setPrefsName(getContext().getPackageName())
                .setUseDefaultSharedPreference(true)
                .build();


        radioButton1 = v.findViewById( R.id.filter_settings_checkbox11);
        radioButton2 = v.findViewById(R.id.filter_settings_checkbox22);
        radioButton3 = v.findViewById(R.id.filter_settings_checkbox33);
        radioButton4 = v.findViewById(R.id.filter_settings_checkbox44);
        radioButton5 = v.findViewById(R.id.filter_settings_checkbox55);


        radioButtonSpeedFast = v.findViewById(R.id.speed_of_game_speed_modeRadio);
        radioButtonSpeedNormal = v.findViewById(R.id.speed_of_game_normal_modeRadio);
        radioButtonThrowNeighbours = v.findViewById(R.id.throw_neighboursRadio);
        radioButtonThrowAll = v.findViewById(R.id.throw_allRadio);
        checkBoxPassOn = v.findViewById(R.id.passinOn);
        checkBoxPassOn.setButtonDrawable(R.drawable.passing_mode_inactive);
        checkBoxPassOn.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                buttonView.setButtonDrawable(buttonView.isChecked()?
                        R.drawable.passing_mode_inactive:
                        R.drawable.passing_mode_active);
            }
        });


        applyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveChanges();
                dismiss();
            }
        });
    }

    private void saveChanges() {


        /*SharedPreferenceHelper.setBoolean(Objects.requireNonNull(getContext()),_2PLAYERS,checkBox.isChecked());
        SharedPreferenceHelper.setBoolean(Objects.requireNonNull(getContext()),_3PLAYERS,checkBox2.isChecked());
        SharedPreferenceHelper.setBoolean(Objects.requireNonNull(getContext()),_4PLAYERS,checkBox3.isChecked());
        SharedPreferenceHelper.setBoolean(Objects.requireNonNull(getContext()),_5PLAYERS,checkBox4.isChecked());
        SharedPreferenceHelper.setBoolean(Objects.requireNonNull(getContext()),_6PLAYERS,checkBox5.isChecked());*/

       /* SharedPreferenceHelper.setBoolean(Objects.requireNonNull(getContext()),_SPEED_FAST,checkBoxFastMode.isChecked());
        SharedPreferenceHelper.setBoolean(Objects.requireNonNull(getContext()),_SPEED_NORMAL,checkBoxNormalSpeed.isChecked());
        SharedPreferenceHelper.setBoolean(Objects.requireNonNull(getContext()),_PASS_ON,checkBoxPassOn.isChecked());
        SharedPreferenceHelper.setBoolean(Objects.requireNonNull(getContext()),_THROW_ALL,checkBoxThrowAll.isChecked());
        SharedPreferenceHelper.setBoolean(Objects.requireNonNull(getContext()),_THROW_NEIGHBOURS,checkBoxThrowNeighbours.isChecked());
*/

    }

  /*  private void setupCheckbox() {

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

//        checkBox.setOnCheckedChangeListener(changeListener);
//        checkBox2.setOnCheckedChangeListener(changeListener);
//        checkBox3.setOnCheckedChangeListener(changeListener);
//        checkBox4.setOnCheckedChangeListener(changeListener);
//        checkBox5.setOnCheckedChangeListener(changeListener);
//        checkBoxNormalSpeed.setOnCheckedChangeListener(changeListener);
//        checkBoxFastMode.setOnCheckedChangeListener(changeListener);
//        checkBoxThrowAll.setOnCheckedChangeListener(changeListener);
//        checkBoxThrowNeighbours.setOnCheckedChangeListener(changeListener);
//        checkBoxPassOn.setOnCheckedChangeListener(changeListener);

    }*/

    /*private void setCheck(CompoundButton buttonView, boolean isChecked, String players) {

        switch (buttonView.getId()){

            case R.id.filter_settings_checkbox1:
                buttonView.setButtonDrawable(buttonView.isChecked()?R.drawable.checkbox_unchecked:R.drawable.checkbox_checked);
                break;

            case R.id.filter_settings_checkbox2:
                buttonView.setButtonDrawable(buttonView.isChecked()?R.drawable.checkbox_unchecked:R.drawable.checkbox_checked);
                break;

            case R.id.filter_settings_checkbox3:
                buttonView.setButtonDrawable(buttonView.isChecked()?R.drawable.checkbox_unchecked:R.drawable.checkbox_checked);
                break;

            case R.id.filter_settings_checkbox4:
                buttonView.setButtonDrawable(buttonView.isChecked()?R.drawable.checkbox_unchecked:R.drawable.checkbox_checked);
                break;

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

    }*/

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
