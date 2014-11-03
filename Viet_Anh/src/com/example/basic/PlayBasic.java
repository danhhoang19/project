package com.example.basic;

import android.app.ActionBar.LayoutParams;
import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
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
import android.widget.ViewSwitcher.ViewFactory;

import com.example.viet_anh.R;

public class PlayBasic extends Activity implements OnClickListener {

	int[] imageIDs = { R.drawable._a, R.drawable._b, R.drawable._c,
			R.drawable._d, R.drawable._e, R.drawable._f, R.drawable._g,
			R.drawable._h, R.drawable._i, R.drawable._j, R.drawable._k,
			R.drawable._l, R.drawable._m, R.drawable._n, R.drawable._o,
			R.drawable._p, R.drawable._q, R.drawable._r, R.drawable._s,
			R.drawable._t, R.drawable._u, R.drawable._v, R.drawable._w,
			R.drawable._x, R.drawable._y, R.drawable._z, R.drawable._z };
	String[] text = { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k",
			"l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x",
			"y", "z" };
	String[] text2 = { "/eɪ/", "/bi:/", "/si:/", "/di:/", "/i:/", "/ef/",
			"/dʒi:/", "/eɪtʃ/", "/aɪ/", "/dʒeɪ/", "/keɪ/", "/el/", "/em/",
			"/en/", "/oʊ/", "/pi:/", "/kju:/", "/ɑ:r/", "/es/", "/ti:/",
			"/ju:/", "/vi:/", "/ˈdʌblju:/", "/eks/", "/waɪ/", "/zi:/" };

	int[] media = { R.raw._a, R.raw._b, R.raw._c, R.raw._d, R.raw._e, R.raw._f,
			R.raw._g, R.raw._h, R.raw._i, R.raw._j, R.raw._k, R.raw._l,
			R.raw._m, R.raw._n, R.raw._o, R.raw._p, R.raw._q, R.raw._r,
			R.raw._s, R.raw._t, R.raw._u, R.raw._v, R.raw._w, R.raw._x,
			R.raw._y, R.raw._z };

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
		ivnghe.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				donghe();
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

	protected void donghe() {

	}

	protected void doPlay() {
		switcherl.setImageResource(imageIDs[mPosition]);
		transLearn.setText(text2[mPosition]);
		textLearn.setText(text[mPosition]);
		mediaPlayer = MediaPlayer.create(this, media[mPosition]);
		mediaPlayer.start();
		mPosition = (mPosition + 1) % imageIDs.length;

		if (mPosition == 2) {
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
