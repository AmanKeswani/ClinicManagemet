package com.example.doctorrewrite.Classes;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialogFragment;

import com.example.doctorrewrite.R;

public class AddVisitDialog extends AppCompatDialogFragment {

    private EditText name;
    private EditText place;
    private EditText date;
    private EditText to_pay;
    private EditText paid;
    private DialogListener listener;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder dialog = new AlertDialog.Builder(getActivity());
        LayoutInflater li = getActivity().getLayoutInflater();
        View view = li.inflate(R.layout.addvisitdialog, null);

        dialog.setView(view)
                .setTitle("Add Visit")
                .setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                })
                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Visit v = new Visit();
                        v.setTo_pay(Integer.parseInt(to_pay.getText().toString()));
                        v.setPaid(Integer.parseInt(paid.getText().toString()));
                        v.setName(name.getText().toString());
                        v.setDate(date.getText().toString());
                        v.setPlace(place.getText().toString());
                        listener.pass_visit(v);

                    }
                });

        name = view.findViewById(R.id.addVisitName);
        place = view.findViewById(R.id.addVisitPlace);
        date = view.findViewById(R.id.addVisitDate);
        to_pay = view.findViewById(R.id.addVisitToPay);
        paid = view.findViewById(R.id.addVisitPaid);

        return dialog.create();
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        try {
            listener = (DialogListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + "must implement DialogListener");
        }
    }

    public interface DialogListener{
        void pass_visit(Visit v);

    }

}
