package com.xiaohuijun.administrator.mymvp.common.Filepicker.adapters;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.format.Formatter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.xiaohuijun.administrator.mymvp.R;
import com.xiaohuijun.administrator.mymvp.common.Filepicker.PickerManager;
import com.xiaohuijun.administrator.mymvp.common.Filepicker.models.Document;
import com.xiaohuijun.administrator.mymvp.common.Filepicker.views.SmoothCheckBox;

import java.util.List;


/**
 * Created by droidNinja on 29/07/16.
 */
public class FileListAdapter extends SelectableAdapter<FileListAdapter.FileViewHolder, Document> {


    private final Context context;

    public FileListAdapter(Context context, List<Document> items, List<String> selectedPaths) {
        super(items, selectedPaths);
        this.context = context;
    }

    @Override
    public FileViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.item_doc_layout, parent, false);

        return new FileViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final FileViewHolder holder, int position) {
        final Document document = getItems().get(position);

        holder.imageView.setImageResource(document.getTypeDrawable());
        holder.fileNameTextView.setText(document.getTitle());
        holder.fileSizeTextView.setText(Formatter.formatShortFileSize(context, Long.parseLong(document.getSize())));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!holder.checkBox.isChecked() && !PickerManager.getInstance().shouldAdd()){
                    Toast.makeText(context,"最多只能选择"+PickerManager.getInstance().getMaxCount()+"个文件",Toast.LENGTH_SHORT).show();
                }else if(holder.checkBox.isChecked() || PickerManager.getInstance().shouldAdd()) {
                    holder.checkBox.setChecked(!holder.checkBox.isChecked(), true);
                }
            }
        });

        //in some cases, it will prevent unwanted situations
        holder.checkBox.setOnCheckedChangeListener(null);
        holder.checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!holder.checkBox.isChecked() && !PickerManager.getInstance().shouldAdd()) {
                    return;
                }
            }
        });

        //if true, your checkbox will be selected, else unselected
        holder.checkBox.setChecked(isSelected(document));

        holder.itemView.setBackgroundResource(isSelected(document)?R.color.bg_gray:android.R.color.white);

        holder.checkBox.setOnCheckedChangeListener(new SmoothCheckBox.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(SmoothCheckBox checkBox, boolean isChecked) {
                toggleSelection(document);
                holder.itemView.setBackgroundResource(isChecked?R.color.bg_gray:android.R.color.white);

                if(isChecked)
                    PickerManager.getInstance().add(document);
                else
                    PickerManager.getInstance().remove(document);
            }
        });
    }

    @Override
    public int getItemCount() {
        return getItems().size();
    }

    public static class FileViewHolder extends RecyclerView.ViewHolder {
        SmoothCheckBox checkBox;

        ImageView imageView;

        TextView fileNameTextView;

        TextView fileSizeTextView;

        public FileViewHolder(View itemView) {
            super(itemView);
            checkBox = (SmoothCheckBox) itemView.findViewById(R.id.checkbox);
            imageView = (ImageView) itemView.findViewById(R.id.file_iv);
            fileNameTextView = (TextView) itemView.findViewById(R.id.file_name_tv);
            fileSizeTextView = (TextView) itemView.findViewById(R.id.file_size_tv);
        }
    }
}
