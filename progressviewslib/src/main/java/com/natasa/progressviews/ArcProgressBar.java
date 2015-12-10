/*
 * ProgressViews
 * Copyright (c) 2015  Natasa Misic
 *
 *
 *     This program is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     This program is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 */

package com.natasa.progressviews;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;

import com.natasa.progressviews.utils.ProgressStartPoint;
import com.natasa.progressviews.utils.ShapeType;

public class ArcProgressBar extends ProgressView {

	private static final int START_ANGLE = 180;
	private int PADDING = 0;
	private float left;
	private float right;
	private RectF oval;
	private float top;
	private float bottom;

	public ArcProgressBar(Context context) {
		super(context);
	}

	public ArcProgressBar(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);

	}

	public ArcProgressBar(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	@Override
	void init() {
		oval = new RectF();
		initForegroundColor();
		initBackgroundColor();
	}

	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		canvas.drawArc(oval, START_ANGLE, START_ANGLE, false, backgroundPaint);

		// ColorsHelper.setGradientPaint(foregroundPaint, left,top, right, top);

		float angle = START_ANGLE * progress / maximum_progress;
		canvas.drawArc(oval, START_ANGLE, angle, false, foregroundPaint);
	}

	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		super.onMeasure(widthMeasureSpec, heightMeasureSpec);
		left = 0 + strokeWidth / 2;
		top = 0 + strokeWidth / 2;
		right = min - strokeWidth / 2;
		bottom = min - strokeWidth / 2;
		oval.set(left + PADDING, top + PADDING, right - PADDING, bottom
				- PADDING);

	}

	public void setArcViewPadding(int padding) {
		PADDING = padding;
		invalidate();
	}

	public int getPadding() {
		return PADDING;
	}

	@Override
	public ShapeType setType(ShapeType type) {
		return ShapeType.ARC;

	}
}
