package in.abmulani.carinventory.widgets;


import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;

import com.rengwuxian.materialedittext.MaterialEditText;

import in.abmulani.carinventory.R;
import in.abmulani.carinventory.utils.Utils;


public class CarInventoryEditText extends MaterialEditText {

    public CarInventoryEditText(Context context) {
        super(context);
    }

    public CarInventoryEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public CarInventoryEditText(Context context, AttributeSet attrs, int defStyle) {
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

    private void setTextFontStyle(Context context, int textStyleIndex) {
        setTypeface(Utils.getThisFont(context, textStyleIndex));
    }

}
