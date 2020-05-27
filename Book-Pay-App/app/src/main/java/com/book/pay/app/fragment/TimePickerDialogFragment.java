package com.book.pay.app.fragment;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.text.format.DateFormat;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.TimePicker;

import com.book.pay.app.R;

import java.util.Calendar;

/**
 * A simple {@link Fragment} subclass.
 */
public class TimePickerDialogFragment extends DialogFragment implements TimePickerDialog.OnTimeSetListener {

    public TimePickerDialogFragment() {
        // Required empty public constructor
    }

    private int ora;
    private int minuti;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        final Calendar c = Calendar.getInstance();
        int hour = c.get(Calendar.HOUR_OF_DAY);
        int minute = c.get(Calendar.MINUTE);

        TimePickerDialog tpd = new TimePickerDialog(getActivity(), AlertDialog.THEME_DEVICE_DEFAULT_DARK
                ,this, hour, minute, DateFormat.is24HourFormat(getActivity()));

        TextView tvTitle = new TextView(getActivity());

        tvTitle.setBackgroundColor(Color.parseColor("#EEE8AA"));
        tvTitle.setPadding(5, 3, 5, 3);
        tvTitle.setGravity(Gravity.CENTER_HORIZONTAL);
        tpd.setCustomTitle(tvTitle);

        return tpd;


    }

    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {

        //TODO implementare set ora e minuti
        this.ora = hourOfDay;
        this.minuti = minute;

    }

    public int getOra() {
        return ora;
    }

    public void setOra(int ora) {
        this.ora = ora;
    }

    public int getMinuti() {
        return minuti;
    }

    public void setMinuti(int minuti) {
        this.minuti = minuti;
    }
}
