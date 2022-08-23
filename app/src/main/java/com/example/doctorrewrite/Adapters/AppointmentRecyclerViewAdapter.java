package com.example.doctorrewrite.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
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
        Toast.makeText(context, "reached here", Toast.LENGTH_SHORT).show();
        return new ViewHolder(view);


    }

    @Override
    public void onBindViewHolder(@NonNull AppointmentRecyclerViewAdapter.ViewHolder holder, int position) {

        Toast.makeText(context, "reached here 2", Toast.LENGTH_SHORT).show();

        Appointment a = appointmentList.get(position);
        Toast.makeText(context, "reached here 3", Toast.LENGTH_SHORT).show();
        holder.id.setText("" + a.getId());
        Toast.makeText(context, "reached here 4", Toast.LENGTH_SHORT).show();
        holder.name.setText(a.getName());
        Toast.makeText(context, "reached here 5", Toast.LENGTH_SHORT).show();
        holder.number.setText(a.getNumber());
        Toast.makeText(context, "reached here 6", Toast.LENGTH_SHORT).show();
        holder.date.setText(a.getDate());
        Toast.makeText(context, "reached here 7", Toast.LENGTH_SHORT).show();
        holder.amount.setText( "Amount" + (a.getTo_pay()-a.getPaid()));
        Toast.makeText(context, "reached here 8", Toast.LENGTH_SHORT).show();

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

        }
    }
}
