package com.example.doctorrewrite.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.doctorrewrite.Classes.Patient;
import com.example.doctorrewrite.Classes.Visit;
import com.example.doctorrewrite.PatientDetailActivity;
import com.example.doctorrewrite.R;

import java.util.List;

public class PatientRecyclerViewAdapter extends RecyclerView.Adapter<PatientRecyclerViewAdapter.ViewHolder> {

    public Context context;
    public List<Patient> patientList;

    public PatientRecyclerViewAdapter(Context context, List<Patient> patientList) {
        this.context = context;
        this.patientList = patientList;
    }

    @NonNull
    @Override
    public PatientRecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.patientcard, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PatientRecyclerViewAdapter.ViewHolder holder, int position) {

        Patient a = patientList.get(position);
        holder.name.setText(a.getName());

    }

    @Override
    public int getItemCount() {
        return patientList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        public TextView name;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            name = itemView.findViewById(R.id.patientCardName);
        }

        @Override
        public void onClick(View view) {
            int position = getAbsoluteAdapterPosition();
            Patient p = patientList.get(position);

            Intent intent = new Intent(context, PatientDetailActivity.class);
            intent.putExtra("PATIENT", p);
            context.startActivity(intent);

        }
    }

}
