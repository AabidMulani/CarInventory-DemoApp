package in.abmulani.carinventory.widgets;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;

import in.abmulani.carinventory.R;
import in.abmulani.carinventory.utils.Utils;


/**
 * Aabid Mulani
 * AB
 */
public class CarInventoryTextView extends AppCompatTextView {

    public CarInventoryTextView(Context context) {
        super(context);
    }

    public CarInventoryTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public CarInventoryTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        if (!isInEditMode()) {
            TypedArray typedArray = context.obtainStyledAttributes(attrs,
                    R.styleable.customTextView, 0, 0);
            try {
                int textStyleIndex = typedArray.getInt(R.styleable.customTextView_textStyle, 0);
                setTextFontStyle(context, textStyleIndex);
            } finally {
                typedArray.recycle();
            }
        }
    }

    public void setTextFontStyle(Context context, int textStyleIndex) {
        setTypeface(Utils.getThisFont(context, textStyleIndex));
    }

}
