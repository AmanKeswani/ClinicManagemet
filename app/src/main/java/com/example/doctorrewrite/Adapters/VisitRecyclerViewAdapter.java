package com.example.doctorrewrite.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.example.doctorrewrite.Classes.Appointment;
import com.example.doctorrewrite.Classes.Visit;
import com.example.doctorrewrite.R;

import java.util.List;

public class VisitRecyclerViewAdapter extends RecyclerView.Adapter<VisitRecyclerViewAdapter.ViewHolder> {
    private Context context;
    private List<Visit> appointmentList;

    public VisitRecyclerViewAdapter(Context context, List<Visit> appointmentList) {
        this.context = context;
        this.appointmentList = appointmentList;
    }

    @NonNull
    @Override
    public VisitRecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.visitcard, parent, false);
        return new ViewHolder(view);


    }
    @Override
    public void onBindViewHolder(@NonNull VisitRecyclerViewAdapter.ViewHolder holder, int position) {


        Visit a = appointmentList.get(position);
        holder.id.setText("" + a.getId());
        holder.name.setText(a.getName());
        holder.date.setText(a.getDate());
        holder.place.setText(a.getPlace());
        holder.amount.setText( "Amount:" + (a.getTo_pay()-a.getPaid()));

    }

    @Override
    public int getItemCount() {
        return appointmentList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        public TextView id;
        public TextView name;
        public TextView place;
        public TextView date;
        public TextView amount;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);

            id = itemView.findViewById(R.id.listVisitID);
            name = itemView.findViewById(R.id.listVisitName);
            place = itemView.findViewById(R.id.listVisitPlace);
            date = itemView.findViewById(R.id.listVisitDate);
            amount = itemView.findViewById(R.id.listVisitAmount);

        }

        @Override
        public void onClick(View view) {
            int position = this.getAbsoluteAdapterPosition();
            Visit a = appointmentList.get(position);

            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            builder.setMessage("ID: " + a.getId() + "\n" +
                            "Name: " + a.getName() + "\n" +
                            "Date: " + a.getDate() + "\n" +
                            "Amount to pay: " + a.getTo_pay() + "\n" +
                            "Amount Paid: " + a.getPaid() + "\n" +
                            "Amount Remaining: " + (a.getTo_pay()-a.getPaid()) + ".")
                    .setPositiveButton("ok",null).setCancelable(false);

            AlertDialog alert = builder.create();
            alert.show();

        }
    }
}
