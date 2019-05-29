package view.activity;

import android.annotation.SuppressLint;
import android.content.ClipData;
import android.content.ClipDescription;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.example.durak_od.R;

public class GameTableActivity extends AppCompatActivity implements View.OnDragListener, View.OnTouchListener {

    ImageView imageViewCard1, imageViewCard2, imageViewCardBoard;
    GridLayout gridLayout;
    RelativeLayout relativeLayout_h_6, relativeLayout_h_7, relativeLayout_h_8, relativeLayout_h_9, relativeLayoutTheUsersCards;
    private ImageView imageViewCard3, imageViewCard4;
    private String TAG = "GameTableActivity";

    public static int dpToPx(int dp) {
        return (int) (dp * Resources.getSystem().getDisplayMetrics().density);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_table);
        init();

        getCards();


    }

    private void getCards() {

    }

    @SuppressLint("ClickableViewAccessibility")
    private void init() {
        imageViewCard1 = findViewById(R.id.card_board_card1);
        imageViewCard2 = findViewById(R.id.card_board_card2);
        imageViewCard3 = findViewById(R.id.card_board_card3);
        imageViewCard4 = findViewById(R.id.card_board_card4);
        imageViewCardBoard = findViewById(R.id.card_board_card_IV);
        gridLayout = findViewById(R.id.card_board_grid_layout);


        relativeLayout_h_6 = findViewById(R.id.ll_6_h);
        relativeLayout_h_7 = findViewById(R.id.ll_7_h);
        relativeLayout_h_8 = findViewById(R.id.ll_8_h);
        relativeLayout_h_9 = findViewById(R.id.ll_9_h);
        relativeLayoutTheUsersCards = findViewById(R.id.card_board_users_cards);


        relativeLayout_h_6.setTag("" + R.id.ll_6_h);
        relativeLayout_h_7.setTag("" + R.id.ll_7_h);
        relativeLayout_h_8.setTag("" + R.id.ll_8_h);
        relativeLayout_h_9.setTag("" + R.id.ll_9_h);
        relativeLayoutTheUsersCards.setTag("" + relativeLayoutTheUsersCards.getId());

        gridLayout.setTag("" + gridLayout.getId());

        imageViewCard1.setTag("" + imageViewCard1.getId());
        imageViewCard2.setTag("" + imageViewCard2.getId());
        imageViewCard3.setTag("" + imageViewCard3.getId());
        imageViewCard4.setTag("" + imageViewCard4.getId());
        imageViewCardBoard.setTag("" + imageViewCardBoard.getId());

        relativeLayout_h_6.setOnDragListener(this);
        relativeLayout_h_6.setOnTouchListener(this);
        relativeLayout_h_7.setOnDragListener(this);
        relativeLayout_h_7.setOnTouchListener(this);
        relativeLayout_h_8.setOnDragListener(this);
        relativeLayout_h_8.setOnTouchListener(this);
        relativeLayout_h_9.setOnDragListener(this);
        relativeLayout_h_9.setOnTouchListener(this);

//        imageViewCardBoard.setOnDragListener(this);
        gridLayout.setOnDragListener(this);
    }

    @Override
    public boolean onDrag(View v, DragEvent event) {

        int action = event.getAction();

        switch (action) {
            case DragEvent.ACTION_DRAG_STARTED:

                return true;


            case DragEvent.ACTION_DRAG_ENTERED:
                if (!v.equals(null) && v.getId() != R.id.card_board_grid_layout) {
                    ViewGroup viewGroup = (ViewGroup) v;
                    ImageView imageView = (ImageView) viewGroup.getChildAt(0);
                    Log.e(TAG, "onDrag: ENTERED ON " + viewGroup.getClass().getSimpleName() + " ID " + viewGroup.getId());
//                    imageView.setElevation(10);
                    imageView.setColorFilter(Color.BLUE, PorterDuff.Mode.MULTIPLY);
                    v.invalidate();
                }
                return true;
            case DragEvent.ACTION_DRAG_LOCATION:
                return true;
            case DragEvent.ACTION_DRAG_EXITED:
                if (!v.equals(null) && v.getId() != R.id.card_board_grid_layout) {
                    ViewGroup viewGroup = (ViewGroup) v;
                    ImageView imageView = (ImageView) viewGroup.getChildAt(0);
                    imageView.clearColorFilter();
                    v.invalidate();

                }
                return true;
            case DragEvent.ACTION_DRAG_ENDED:
                if (!v.equals(null) && v.getId() != R.id.card_board_grid_layout) {
                    ViewGroup viewGroup = (ViewGroup) v;
                    ImageView imageView = (ImageView) viewGroup.getChildAt(0);
                    imageView.clearColorFilter();
                    v.invalidate();

                }
                return true;
            case DragEvent.ACTION_DROP:
                View viewState = (View) event.getLocalState();

                ViewGroup parentView = (ViewGroup) viewState.getParent();

                Log.e(TAG, "onDrag: dropped class' parent " + v.getParent().getClass().getSimpleName());
                Log.e(TAG, "onDrag: dropped to " + v.getClass().getSimpleName());
                Log.e(TAG, "onDrag: View " + viewState.getClass().getSimpleName());
                Log.e(TAG, "onDrag: View's parent" + parentView.getClass().getSimpleName());


                //If an object dropped to GridLayout
                if (v.getClass().getSimpleName().equals(GridLayout.class.getSimpleName())) {

                    //if a user dropped to the same GridLayout return false
                    if (parentView.getClass().getSimpleName().equals(GridLayout.class.getSimpleName())) {
                        Log.e(TAG, "onDrag: dropped back");
                        return false;
                    }

                    GridLayout gridView = (GridLayout) v;

                    RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) viewState.getLayoutParams();

                    params.width = dpToPx(120);
                    params.height = dpToPx(170);
                    params.setMargins(0, 0, 0, 0);

                    viewState.setLayoutParams(params);
                    parentView.removeView(viewState);
                    gridView.addView(viewState);

                    try {
                        RelativeLayout layout = null;
                        layout = (RelativeLayout) gridView.getChildAt(gridView.getChildCount() - 1);

                        ImageView imageView = (ImageView) layout.getChildAt(0);
                       layout.setPadding(0,0,0,0);
                        imageView.setRotation(-5);
                    } catch (ClassCastException e) {

                        CardView layout = null;


                        layout = (CardView) gridView.getChildAt(gridView.getChildCount() - 1);

                        ImageView imageView = (ImageView) layout.getChildAt(0);

//                        imageView.setRotation(-5);
                        e.printStackTrace();
                    }

                    v.setVisibility(View.VISIBLE);

                    //If an object dropped to RelativeLayout (onto another card)
                } else if (v.getClass().getSimpleName().equals(RelativeLayout.class.getSimpleName()) &&
                        v.getId() != viewState.getId() && v.getParent().getClass().getSimpleName().equals(GridLayout.class.getSimpleName())) {
                    Log.e(TAG, "onDrag: RelativeLayout dragging ");
                    if (parentView.getClass().getSimpleName().equals(v.getClass().getSimpleName())) {
                        Log.e(TAG, "onDrag: PARENT " + parentView.getClass().getSimpleName() + " \n V" + v.getClass().getSimpleName());
                        if (parentView.getParent().getClass().getSimpleName().equals(v.getClass().getSimpleName())) {
                            Log.e(TAG, "onDrag: HAS CHILD WRONG");
                            return false;
                        }
                        RelativeLayout layout = (RelativeLayout) v;
                        Log.e(TAG, "onDrag: " + layout.getChildCount());

                        try {
                            RelativeLayout relativeLayout = (RelativeLayout) viewState;
                            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(relativeLayout.getLayoutParams());

                            layoutParams.leftMargin = dpToPx(8);
//                            layoutParams.topMargin = dpToPx(8);
                            relativeLayout.setLayoutParams(layoutParams);
//                       relativeLayout.setPadding(dpToPx(8),dpToPx(8),0,0);
                            ImageView imageView = (ImageView) relativeLayout.getChildAt(0);
                            imageView.setRotation(10);
                        } catch (ClassCastException e) {
                            CardView cardView = (CardView) viewState;
                            CardView.LayoutParams layoutParams = new CardView.LayoutParams(cardView.getLayoutParams());

                            cardView.setRotation(10);

//                            layoutParams.leftMargin = dpToPx(8);
                            layoutParams.topMargin = dpToPx(8);
//                            cardView.setLayoutParams(layoutParams);
//                       relativeLayout.setPadding(dpToPx(8),dpToPx(8),0,0);
                            ImageView imageView = (ImageView) cardView.getChildAt(0);
//                            imageView.setRotation(10);
                            e.printStackTrace();
                        }

                        parentView.removeView(viewState);
                        layout.addView(viewState);
                        v.setVisibility(View.VISIBLE);
                        return true;
                    }


                }


        }


        return true;
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {

        if (event.getAction() == MotionEvent.ACTION_MOVE) {
            ClipData.Item item = new ClipData.Item((CharSequence) v.getTag());

            String[] mimeTypes = {ClipDescription.MIMETYPE_TEXT_PLAIN};
            ClipData data = new ClipData(v.getTag().toString(), mimeTypes, item);

            View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(v);


            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
//                if (
                v.startDragAndDrop(data, shadowBuilder, v, View.DRAG_FLAG_OPAQUE);
//                ) {
//                v.setVisibility(View.INVISIBLE);
//                return true;
//                } else
//                    v.setVisibility(View.VISIBLE);
//
            }

            return false;

        }

        return true;
    }


}
