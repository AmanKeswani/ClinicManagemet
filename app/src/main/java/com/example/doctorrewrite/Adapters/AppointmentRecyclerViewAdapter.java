package com.example.doctorrewrite.Adapters;

import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.example.doctorrewrite.Classes.Appointment;
import com.example.doctorrewrite.R;

import java.util.List;

public class AppointmentRecyclerViewAdapter extends RecyclerView.Adapter<AppointmentRecyclerViewAdapter.ViewHolder> {
    private Context context;
    private List<Appointment> appointmentList;

    public AppointmentRecyclerViewAdapter(Context context, List<Appointment> appointmentList) {
        this.context = context;
        this.appointmentList = appointmentList;
    }

    @NonNull
    @Override
    public AppointmentRecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.appointmentcard, parent, false);
        return new ViewHolder(view);


    }

    @Override
    public void onBindViewHolder(@NonNull AppointmentRecyclerViewAdapter.ViewHolder holder, int position) {

        Appointment a = appointmentList.get(position);
        holder.id.setText("" + a.getId());
        holder.name.setText(a.getName());
        holder.number.setText("" + a.getNumber());
        holder.date.setText(a.getDate());
        holder.amount.setText( "Amount:" + (a.getTo_pay()-a.getPaid()));

    }

    @Override
    public int getItemCount() {
        return appointmentList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        public TextView id;
        public TextView name;
        public TextView number;
        public TextView date;
        public TextView amount;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);

            id = itemView.findViewById(R.id.listAppID);
            name = itemView.findViewById(R.id.listAppName);
            number = itemView.findViewById(R.id.listAppNumber);
            date = itemView.findViewById(R.id.listAppDate);
            amount = itemView.findViewById(R.id.listAppAmount);

        }

        @Override
        public void onClick(View view) {
            int position = this.getAbsoluteAdapterPosition();
            Appointment a = appointmentList.get(position);

            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            builder.setMessage("ID: " + a.getId() + "\n" +
                            "Name: " + a.getName() + "\n" +
                            "Number: " + a.getNumber() + "\n" +
                            "Date: " + a.getDate() + "\n" +
                            "Procedure: " + a.getProcedure() + "\n" +
                            "Amount to pay: " + a.getTo_pay() + "\n" +
                            "Amount Paid: " + a.getPaid() + "\n" +
                            "Amount Remaining: " + (a.getTo_pay()-a.getPaid()) + ".")
                    .setPositiveButton("ok",null).setCancelable(false);

            AlertDialog alert = builder.create();
            alert.show();

        }
    }
}
