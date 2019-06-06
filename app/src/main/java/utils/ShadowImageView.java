package utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;

import androidx.annotation.Nullable;

public class ShadowImageView extends ImageView {
    public ShadowImageView(Context context) {
        super(context);
    }

    public ShadowImageView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public ShadowImageView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    @Override
    protected void onDraw(Canvas canvas) {
        Paint mShadow = createShadow();
        Drawable d = getDrawable();
        if (d != null){
            setLayerType(LAYER_TYPE_SOFTWARE, mShadow);
            Bitmap bitmap = ((BitmapDrawable) getDrawable()).getBitmap();
            canvas.drawBitmap(bitmap, 0.0f, 0.0f, mShadow);
        } else {
            super.onDraw(canvas);
        }
    }

    private Paint createShadow() {
        Paint mShadow = new Paint();

        float radius = 10.0f;
        float xOffset = 0.0f;
        float yOffset = 2.0f;

        // color=black
        int color = 0xFF000000;
        mShadow.setShadowLayer(radius, xOffset, yOffset, color);


        return mShadow;
    }
}
