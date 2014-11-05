package com.example.basic;

import java.util.ArrayList;
import java.util.List;

import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.viet_anh.R;

public class ListenBasic extends PlayBasic {
	int socau = 10;
	int index = 0;

	List<Question> list_question;
	Question cauhientai;
	int caudung = 0;
	CountDownTimer demThoiGian;
	TextView tvCauHoi, tvThongBao, tvThoiGian;
	RadioButton rd0, rd1, rd2, rd3;
	RadioGroup rdg;
	Button btNext, btCheck;

	ImageView ivListen;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.listen);

		// Nút nghe
		ivListen = (ImageView) findViewById(R.id.imageView1);

		tvCauHoi = (TextView) findViewById(R.id.textView1);
		tvThongBao = (TextView) findViewById(R.id.textView2);
		rdg = (RadioGroup) findViewById(R.id.radioGroup1);
		rd0 = (RadioButton) findViewById(R.id.radio0);
		rd1 = (RadioButton) findViewById(R.id.radio1);
		rd2 = (RadioButton) findViewById(R.id.radio2);
		rd3 = (RadioButton) findViewById(R.id.radio3);
		btNext = (Button) findViewById(R.id.button1);
		btCheck = (Button) findViewById(R.id.button2);
		tvCauHoi.setTextColor(Color.RED);
		btCheck.setVisibility(View.GONE);

		QuestionDatabase db = new QuestionDatabase(this);

		list_question = new ArrayList<Question>();
		list_question = db.layNcaungaunghien(socau);
		hienthi(index);
		btNext.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				if (rdg.getCheckedRadioButtonId() == -1) {
					Toast.makeText(getBaseContext(),
							"Vui lòng chọn một câu trả lời", Toast.LENGTH_SHORT)
							.show();
				} else {

					index++;
					if (index < socau) {
						hienthi(index);
					} else {
						index = 0;
						btNext.setVisibility(View.GONE);
						btCheck.setVisibility(View.VISIBLE);

					}
				}
			}
		});
		btCheck.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub

				if (index >= socau) {
					tvThongBao.setText("Kết quả: ");
					tvCauHoi.setText("Bạn làm đúng " + caudung + " câu");
					rd0.setVisibility(View.GONE);
					rd2.setVisibility(View.GONE);
					rd3.setVisibility(View.GONE);
					rd1.setVisibility(View.GONE);
					index++;
					btCheck.setText("Exit");
				} else {
					hienthi(index);
					KiemTraLai();
					index++;
				}
				if (index == socau + 2) {
					System.exit(0);
				}
			}
		});
	}

	protected void KiemTraLai() {
		// Đưa tất cả Radion Button về màu Đen mỗi khi ấn nút Check
		rd0.setTextColor(Color.BLACK);
		rd2.setTextColor(Color.BLACK);
		rd3.setTextColor(Color.BLACK);
		rd1.setTextColor(Color.BLACK);
		// Tô màu đỏ cho câu Đáp án
		if (cauhientai.dapan.equalsIgnoreCase("a"))
			rd0.setTextColor(Color.RED);
		else if (cauhientai.dapan.equalsIgnoreCase("b"))
			rd1.setTextColor(Color.RED);
		else if (cauhientai.dapan.equalsIgnoreCase("c"))
			rd2.setTextColor(Color.RED);
		else if (cauhientai.dapan.equalsIgnoreCase("d"))
			rd3.setTextColor(Color.RED);
		// Checked vào câu trả lời của người dùng để người dùng so sanh với Đáp
		// án
		if (cauhientai.cautraloi.equalsIgnoreCase("a"))
			rd0.setChecked(true);
		else if (cauhientai.cautraloi.equalsIgnoreCase("b"))
			rd1.setChecked(true);
		else if (cauhientai.cautraloi.equalsIgnoreCase("c"))
			rd2.setChecked(true);
		else if (cauhientai.cautraloi.equalsIgnoreCase("d"))
			rd3.setChecked(true);
		// Disable các Radion Button không cho người dùng chọn lại
		rd0.setEnabled(false);
		rd1.setEnabled(false);
		rd2.setEnabled(false);
		rd3.setEnabled(false);
	}

	private void hienthi(int vitri) {
		tvThongBao.setText("Câu số: " + (vitri + 1) + "/" + socau);
		cauhientai = list_question.get(vitri);
		tvCauHoi.setText(cauhientai.cauhoi);
		rd0.setText(cauhientai.cau_a);
		rd1.setText(cauhientai.cau_b);
		rd2.setText(cauhientai.cau_c);
		rd3.setText(cauhientai.cau_d);
		// Sau khi hiển thị, xóa Checked của các Radion Button của Radion Group.
		rdg.clearCheck();
	}

}
