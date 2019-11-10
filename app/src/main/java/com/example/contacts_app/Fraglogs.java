package com.example.contacts_app;

import android.Manifest;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.CallLog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;


public class Fraglogs extends Fragment
{
   


   
    public Fraglogs()
    {

}
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v= inflater.inflate(R.layout.contacts_log,container,false);
        RecyclerView recyclerView=v.findViewById(R.id.contactlogs_recycler);
        LinearLayoutManager linearL=new LinearLayoutManager(getContext());
        RecyclerView.LayoutManager layoutMa=linearL;
        recyclerView.setLayoutManager(layoutMa);

        RecyclerLogsAdapter adapter=new RecyclerLogsAdapter(getContext(),getCallLogs());
        recyclerView.setAdapter(adapter);
        return v;
    }
    private List<ModelClass> getCallLogs()
    {
        List<ModelClass> list=new ArrayList<>();
        if(ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.READ_CALL_LOG)!=
        PackageManager.PERMISSION_GRANTED)
        {
            ActivityCompat.requestPermissions(getActivity(),new String[]{Manifest.permission.READ_CALL_LOG},1);
        }

        Cursor c=getContext().getContentResolver().query(CallLog.Calls.CONTENT_URI,
                null,null,null,CallLog.Calls.DEFAULT_SORT_ORDER);
        int number=c.getColumnIndex(CallLog.Calls.NUMBER);
        int nameIndex=c.getColumnIndex(CallLog.Calls.CACHED_NAME);
        int duration=c.getColumnIndex(CallLog.Calls.DURATION);
        c.moveToFirst();
        while(c.moveToNext())
        {
            list.add(new ModelClass(c.getString(nameIndex),c.getString(number),c.getString(duration)));
        }
        c.close();
        return list;


}

}





