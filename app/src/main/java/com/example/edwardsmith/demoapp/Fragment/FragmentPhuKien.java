package com.example.edwardsmith.demoapp.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.edwardsmith.demoapp.Adapter.CustomAdapterPhuKien;
import com.example.edwardsmith.demoapp.DAO.PhuKienDAO;
import com.example.edwardsmith.demoapp.DTO.PhuKienDTO;
import com.example.edwardsmith.demoapp.Database.CreateDatabase;
import com.example.edwardsmith.demoapp.R;

import java.util.List;

/**
 * Created by EdwardSmith on 1/17/17.
 */

public class FragmentPhuKien extends Fragment {
    ListView lvPhuKien;
    CreateDatabase createDatabase;
    List<PhuKienDTO> listPK;
    PhuKienDAO phuKienDAO;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        createDatabase = CreateDatabase.getInstance(getContext());
        phuKienDAO = new PhuKienDAO(createDatabase);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_phu_kien,container,false);
        lvPhuKien = (ListView) view.findViewById(R.id.listViewPK);

        listPK = phuKienDAO.layDanhSachPhuKien();

        CustomAdapterPhuKien customAdapterPhuKien = new CustomAdapterPhuKien(getContext(),listPK);
        lvPhuKien.setAdapter(customAdapterPhuKien);
        customAdapterPhuKien.notifyDataSetChanged();

        ViewCompat.setNestedScrollingEnabled(lvPhuKien,true);

        return view;
    }
}
