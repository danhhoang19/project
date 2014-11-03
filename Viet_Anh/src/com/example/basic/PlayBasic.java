package com.example.basic;

import android.app.ActionBar.LayoutParams;
import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.AvoidXfermode;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewSwitcher.ViewFactory;

import com.example.storage.Activity_Storage;
import com.example.viet_anh.R;

public class PlayBasic extends Activity implements OnClickListener {

	private ImageSwitcher switcherl;
	private int mPosition = 0;
	private ImageView lNext, ivnghe;
	private TextView transLearn, textLearn, textView1;
	MediaPlayer mediaPlayer;

	// private Dialog dialog;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.playbasic);

		textView1 = (TextView) findViewById(R.id.textView1);
		ivnghe = (ImageView) findViewById(R.id.ivnghe);
		transLearn = (TextView) findViewById(R.id.transLearn);
		textLearn = (TextView) findViewById(R.id.textLearn);
		switcherl = (ImageSwitcher) findViewById(R.id.switcherl);
		switcherl.setFactory(new ViewFactory() {

			@Override
			public View makeView() {
				ImageView myView = new ImageView(getApplicationContext());
				myView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
				myView.setLayoutParams(new ImageSwitcher.LayoutParams(
						LayoutParams.FILL_PARENT, LayoutParams.FILL_PARENT));
				return myView;
			}

		});

		Animation in = AnimationUtils.loadAnimation(this,
				android.R.anim.slide_in_left);
		Animation out = AnimationUtils.loadAnimation(this,
				android.R.anim.slide_out_right);
		switcherl.setInAnimation(in);
		switcherl.setOutAnimation(out);
		lNext = (ImageView) findViewById(R.id.lNext);
		lNext.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				doPlay();

			}
		});

	}

	protected void doPlay() {
		switcherl.setImageResource(Activity_Storage.ABC_IMAGE[mPosition]);
		transLearn.setText(Activity_Storage.ABC_TEXT2[mPosition]);
		textLearn.setText(Activity_Storage.ABC_TEXT[mPosition]);
		mediaPlayer = MediaPlayer.create(this,
				Activity_Storage.ABC_MEDIA[mPosition]);
		mediaPlayer.start();
		mPosition = (mPosition + 1) % Activity_Storage.ABC_IMAGE.length;
		textView1.setText((mPosition) + " of 26");
		// Sự kiện nút nghe
		ivnghe.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				mediaPlayer.start();

			}
		});
		if (mPosition == 5) {
			doDialog();

		}
	}

	private void doDialog() {
		mediaPlayer.stop();
		final Dialog dialog = new Dialog(PlayBasic.this);
		dialog.setContentView(R.layout.dialogbasic);
		dialog.getWindow().setBackgroundDrawable(
				new ColorDrawable(Color.argb(50, 255, 255, 255)));
		dialog.show();

		ImageButton button1 = (ImageButton) dialog.findViewById(R.id.button1);
		button1.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				mPosition = 0;
				dialog.dismiss();
			}
		});
		ImageButton button3 = (ImageButton) dialog.findViewById(R.id.button3);
		button3.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent listen = new Intent(PlayBasic.this, ListenBasic.class);
				startActivity(listen);
			}
		});
	}

	@Override
	public void onClick(View v) {
	}
}
