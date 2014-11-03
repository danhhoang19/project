package com.example.storage;

import com.example.viet_anh.R;

import android.app.Service;
import android.content.Intent;
import android.net.Uri;
import android.os.IBinder;

public class Activity_Storage {
	public static final int[] ABC_MEDIA = { R.raw._a, R.raw._b, R.raw._c,
			R.raw._d, R.raw._e, R.raw._f, R.raw._g, R.raw._h, R.raw._i,
			R.raw._j, R.raw._k, R.raw._l, R.raw._m, R.raw._n, R.raw._o,
			R.raw._p, R.raw._q, R.raw._r, R.raw._s, R.raw._t, R.raw._u,
			R.raw._v, R.raw._w, R.raw._x, R.raw._y, R.raw._z };
	public static final String[] ABC_TEXT2 = { "/eɪ/", "/bi:/", "/si:/",
			"/di:/", "/i:/", "/ef/", "/dʒi:/", "/eɪtʃ/", "/aɪ/", "/dʒeɪ/",
			"/keɪ/", "/el/", "/em/", "/en/", "/oʊ/", "/pi:/", "/kju:/",
			"/ɑ:r/", "/es/", "/ti:/", "/ju:/", "/vi:/", "/ˈdʌblju:/", "/eks/",
			"/waɪ/", "/zi:/" };

	public static final String[] ABC_TEXT = { "a", "b", "c", "d", "e", "f",
			"g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s",
			"t", "u", "v", "w", "x", "y", "z" };

	public static final int[] ABC_IMAGE = { R.drawable._a, R.drawable._b,
			R.drawable._c, R.drawable._d, R.drawable._e, R.drawable._f,
			R.drawable._g, R.drawable._h, R.drawable._i, R.drawable._j,
			R.drawable._k, R.drawable._l, R.drawable._m, R.drawable._n,
			R.drawable._o, R.drawable._p, R.drawable._q, R.drawable._r,
			R.drawable._s, R.drawable._t, R.drawable._u, R.drawable._v,
			R.drawable._w, R.drawable._x, R.drawable._y, R.drawable._z,
			R.drawable._z };
}
