package cjh.smile.animation;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;
import cjh.smile.animation.util.ActivityAnimator;
import cjh.smile.animation.util.ActivitySplitAnimationUtil;

public class SmileActivity extends Activity implements OnItemClickListener {
	private String[] _animationList = { "fade", "flipHorizontal",
			"flipVertical", "disappearTopLeft", "appearBottomRight", "unzoom",
			"stack", "slideLeftRight", "slideTopBottom", "spilt",
			"filp3D"};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_smile);

		ListView list = (ListView) this.findViewById(R.id.listView);
		ListAdapter adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, _animationList);
		list.setAdapter(adapter);
		list.setOnItemClickListener(this);
	}

	/**
	 * android版本2.3出现此动画效果报错，因此在这做个限制
	 */
	public static final boolean IS_9 = Build.VERSION.SDK_INT <= Build.VERSION_CODES.GINGERBREAD;

	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		if (arg2 == 10) {
			Intent i = new Intent(this, FlipActivity.class);
			startActivity(i);
		} else {
			Intent i = new Intent(this, SecondActivity.class);
			i.putExtra("backAnimation", _animationList[arg2]);
			i.putExtra("pos", arg2);
			if (arg2 == 9) {
				if (!IS_9) {
					ActivitySplitAnimationUtil.startActivity(this, i);
				} else {
					Toast.makeText(SmileActivity.this,
							"手机系统版本过低(不得低于2.3)，请更换其他手机查看动画此效果！",
							Toast.LENGTH_SHORT).show();
				}
			} else {
				startActivity(i);
				try {
					ActivityAnimator anim = new ActivityAnimator();
					anim.getClass()
							.getMethod(_animationList[arg2] + "Animation",
									Activity.class).invoke(anim, this);
				} catch (Exception e) {
					Toast.makeText(this, "An error occured " + e.toString(),
							Toast.LENGTH_LONG).show();
				}
			}

		}
	}
}
