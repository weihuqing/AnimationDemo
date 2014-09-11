package cjh.smile.animation.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.LinearLayout;

/**重写的线性布局 支持向右滑动时候 finish掉activity
 * @author admin
 *
 */
public class CustomLinearLayout extends LinearLayout {

	 private GestureDetector gestureDetector;
	 
	public CustomLinearLayout(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}
	
    public CustomLinearLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
    
    public void setGestureDetector(GestureDetector gestureDetector) {
        this.gestureDetector = gestureDetector;
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        if (this.gestureDetector != null)
            this.gestureDetector.onTouchEvent(ev);
        return super.dispatchTouchEvent(ev);

    }

}
