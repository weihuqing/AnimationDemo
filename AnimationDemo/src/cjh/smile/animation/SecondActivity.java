package cjh.smile.animation;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import cjh.smile.animation.util.ActivityAnimator;
import cjh.smile.animation.util.ActivitySplitAnimationUtil;

public class SecondActivity extends Activity
{
    int pos;
    
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        pos = this.getIntent().getIntExtra("pos", 0);
        if (pos == 9)
        {
            //此必须先准备好splitd
            ActivitySplitAnimationUtil.prepareAnimation(this);
            //然后再涉足contentview
            this.setContentView(R.layout.second);
            ActivitySplitAnimationUtil.animate(this, 1000);
        }
        else
        {
            this.setContentView(R.layout.second);
        }
    }
    
    public void back(View v)
    {
        this.finish();
        if (pos != 9)
        {
            try
            {
                ActivityAnimator anim = new ActivityAnimator();
                anim.getClass()
                    .getMethod(this.getIntent()
                        .getExtras()
                        .getString("backAnimation")
                        + "BackAnimation",
                        Activity.class)
                    .invoke(anim, this);
            }
            catch (Exception e)
            {
                Toast.makeText(this,
                    "An error occured " + e.toString(),
                    Toast.LENGTH_LONG).show();
            }
        }
    }
    
    @Override
    public void onBackPressed()
    {
        back(null);
    }
}
