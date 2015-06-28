package com.example.popupcustomtestproj;

import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.drawable.BitmapDrawable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.LinearLayout.LayoutParams;

@SuppressLint("NewApi")
public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		/**
		 * Notice: We make the activity fullscreen for the PopupWindow's x&y range from screen (0, 0) to (screen width, screen height).
		 */
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	private void createPopup(int anchorYUp, int anchorYDown, int anchorX) {
		PopupTextView mPopupTextView = (PopupTextView) LayoutInflater
				.from(this).inflate(R.layout.popup_layout, null);

		mPopupTextView.setAnchorYUp(anchorYUp);
		mPopupTextView.setAnchorYDown(anchorYDown);
		mPopupTextView.setAnchorX(anchorX);
		mPopupTextView.setText("This is a test string!!!!!This is a test string!!!!!This is a test string!!!!!");
		mPopupTextView.show();
	}

	public void showPopupWindow(View v) {
		createPopup((int)( v.getY()), (int)(v.getY() + v.getHeight()), (int)(v.getX() + v.getWidth() / 2));
	}
}
