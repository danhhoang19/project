package com.example.basic;

import com.example.viet_anh.R;
import com.example.viet_anh.R.layout;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;

public class BasicMenu extends Activity implements OnClickListener {
	private RelativeLayout Alphabet;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.basicmenu);

		Alphabet = (RelativeLayout) findViewById(R.id.Alphabet);
		Alphabet.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		if (v == Alphabet) {
			Intent alphatbet = new Intent(BasicMenu.this, PlayBasic.class);
			startActivity(alphatbet);

		}
	}

}
