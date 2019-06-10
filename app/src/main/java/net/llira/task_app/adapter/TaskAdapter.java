package net.llira.task_app.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import net.llira.task_app.R;
import net.llira.task_app.models.Task;

import java.util.ArrayList;

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.TaskViewHolder> {
    private ArrayList<Task> data;

    public TaskAdapter(ArrayList<Task> data) {
        this.data = data;
    }

    @NonNull
    @Override
    public TaskViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        return new TaskViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_task, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull TaskViewHolder holder, int i) {
        Task task = data.get(i);
        holder.txvTaskKey.setText(task.getTaskKey());
        holder.txvDescription.setText(task.getDescription());
        holder.txvPriority.setText(task.getPriority());
        holder.txvDate.setText(task.getDate());
        holder.txvStatus.setText(task.getStatus());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class TaskViewHolder extends RecyclerView.ViewHolder{
        TextView txvTaskKey, txvDescription, txvPriority, txvDate, txvStatus;

        public TaskViewHolder(View itemView){
            super(itemView);
            txvTaskKey = itemView.findViewById(R.id.txv_task_key);
            txvDescription = itemView.findViewById(R.id.txv_description);
            txvPriority = itemView.findViewById(R.id.txv_priority);
            txvDate = itemView.findViewById(R.id.txv_date);
            txvStatus = itemView.findViewById(R.id.txv_status);
        }
    }



}//End class
