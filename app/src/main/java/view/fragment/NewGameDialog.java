package view.fragment;

import android.content.Intent;
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

import java.util.Objects;

import utils.SharedPreferenceHelper;
import view.activity.GameTableActivity;

public class NewGameDialog extends DialogFragment {

    private RangeBar rangeSeekBar;
    private CheckBox checkBoxPrivateGame,checkBoxPassOn;
    CompoundButton.OnCheckedChangeListener changeListener;
    private Button  newGameButton;
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
    private final String _PRIVATE_GAME = "PRIVATE_GAME";


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.new_game_dialog, container, false);

        init(v);

        setupRangeSeekbar();
        setupCheckbox();

        return v;
    }

    private void init(View v) {
        rangeSeekBar = v.findViewById(R.id.rangebarNewGameDialog);

        newGameButton = v.findViewById(R.id.createNewGameButton);

        radioButton1 = v.findViewById( R.id.new_game_settings_radio1);
        radioButton2 = v.findViewById(R.id.new_game_settings_radio2);
        radioButton3 = v.findViewById(R.id.new_game_settings_radio3);
        radioButton4 = v.findViewById(R.id.new_game_settings_radio4);
        radioButton5 = v.findViewById(R.id.new_game_settings_radio5);


        radioButtonSpeedFast = v.findViewById(R.id.new_game_settings_radio_fast_speed);
        radioButtonSpeedNormal = v.findViewById(R.id.new_game_settings_radio_normal_speed);
        radioButtonThrowNeighbours = v.findViewById(R.id.new_game_settings_radio_throw_neighbours);
        radioButtonThrowAll = v.findViewById(R.id.new_game_settings_radio_throw_all);
        checkBoxPrivateGame = v.findViewById(R.id.private_game_Checkbox);

        checkBoxPassOn = v.findViewById(R.id.news_game_settings_passinOn_checkbox);
        checkBoxPassOn.setButtonDrawable(R.drawable.passing_mode_active);
        checkBoxPassOn.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                buttonView.setButtonDrawable(buttonView.isChecked()?
                        R.drawable.passing_mode_inactive:
                        R.drawable.passing_mode_active);
            }
        });



        boolean passOn   = SharedPreferenceHelper.getBoolean(Objects.requireNonNull(getContext()),_PASS_ON,true);
        boolean privatePrivate   = SharedPreferenceHelper.getBoolean(Objects.requireNonNull(getContext()),_PRIVATE_GAME,true);




        setCheck(checkBoxPassOn,passOn,_PASS_ON);
        setCheck(checkBoxPrivateGame,privatePrivate,_PRIVATE_GAME);




        newGameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), GameTableActivity.class);
                startActivity(intent);
                dismiss();
            }
        });
    }

    private void setupCheckbox() {

         changeListener = new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                switch (buttonView.getId()) {

                    case R.id.passinOn:
                        setCheck(buttonView,isChecked,_PASS_ON);
                        break;
                    case R.id.private_game_Checkbox:
                        setCheck(buttonView,isChecked,_PRIVATE_GAME);
                        break;
                }


            }
        };

//        checkBoxPassOn.setOnCheckedChangeListener(changeListener);
        checkBoxPrivateGame.setOnCheckedChangeListener(changeListener);

    }

    private void setCheck(CompoundButton buttonView, boolean isChecked, String players) {

        switch (buttonView.getId()){

            case R.id.news_game_settings_passinOn_checkbox:
                buttonView.setButtonDrawable(buttonView.isChecked()?
                        R.drawable.passing_mode_inactive:
                        R.drawable.passing_mode_active);
                SharedPreferenceHelper.setBoolean(Objects.requireNonNull(getContext()),_PASS_ON,isChecked);

            case R.id.private_game_Checkbox:
                buttonView.setButtonDrawable(buttonView.isChecked()?
                        R.drawable.private_game_icon_gray:
                        R.drawable.private_game_icon);
                SharedPreferenceHelper.setBoolean(Objects.requireNonNull(getContext()),_PRIVATE_GAME,isChecked);

                break;
                default: break;
        }

    }

    private void setupRangeSeekbar() {

        rangeSeekBar.setOnRangeBarChangeListener(new RangeBar.OnRangeBarChangeListener() {
            @Override
            public void onRangeChangeListener(RangeBar rangeBar, int leftPinIndex, int rightPinIndex, String leftPinValue, String rightPinValue) {
                Toast.makeText(getContext(), "ProgreSS " +  "L "+leftPinValue+ " R "+rightPinValue, Toast.LENGTH_SHORT).show();
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
