package ro.uvt.asavoaei.andreea.cardiovascularapp.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.widget.TextView;

import com.github.mikephil.charting.components.MarkerView;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.utils.MPPointF;
import com.github.mikephil.charting.utils.Utils;

import ro.uvt.asavoaei.andreea.cardiovascularapp.R;

@SuppressLint("ViewConstructor")
public class BloodPressureAndPressureMarkerView extends MarkerView {
    private final TextView tvContent;

    public BloodPressureAndPressureMarkerView(Context context, int layoutResource) {
        super(context, layoutResource);
        tvContent = findViewById(R.id.tvContent);
    }

    @Override
    public void refreshContent(Entry e, Highlight highlight) {
        if (e.getY() < 110 && e.getY() > 90) {
            tvContent.setText(e.getY() + "cb");
        } else {
            tvContent.setText(Utils.formatNumber(e.getY(), 0, true) + "mmHg");
        }
        super.refreshContent(e, highlight);
    }

    @Override
    public MPPointF getOffset() {
        return new MPPointF(-(getWidth() / 2), -getHeight());
    }
}