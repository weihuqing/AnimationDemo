package cjh.smile.animation;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ViewAnimator;
import cjh.smile.animation.util.AnimationFactory;
import cjh.smile.animation.util.AnimationFactory.FlipDirection;

/**
 * 两页翻转效果--仿百度点击我的应用后出现的效果
 * 
 * @author Administrator
 * 
 */
public class FlipActivity extends Activity implements OnClickListener
{
    
    ViewAnimator viewAnimator;
    
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.flip);
        viewAnimator = (ViewAnimator) this.findViewById(R.id.viewFlipper);
        
        viewAnimator.setOnClickListener(this);
        
        this.findViewById(R.id.view1).setOnClickListener(this);
        
        this.findViewById(R.id.view2).setOnClickListener(this);
    }
    
    @Override
    public void onClick(View v)
    {
        // TODO Auto-generated method stub
        switch (v.getId())
        {
            case R.id.viewFlipper:
                AnimationFactory.flipTransition(viewAnimator,
                    FlipDirection.LEFT_RIGHT);
                break;
            
            case R.id.view1:
                AnimationFactory.flipTransition(viewAnimator,
                    FlipDirection.LEFT_RIGHT);
                
                break;
            case R.id.view2:
                AnimationFactory.flipTransition(viewAnimator,
                    FlipDirection.RIGHT_LEFT);
                break;
        }
    }
}