package com.unigran.appdecadastro.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.unigran.appdecadastro.R;
import com.unigran.appdecadastro.dataBase.DBHelper;
import com.unigran.appdecadastro.dataBase.DBProduto;
import com.unigran.appdecadastro.entities.Produto;

import java.util.ArrayList;
import java.util.List;

public class ListarProduto extends Fragment {

    static DBProduto dbProduto;
    ListView listaDados;
    static List<Produto> listaProdutos;
    static ArrayAdapter adapter;

    public ListarProduto() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    protected static void atualizarLista() {
        dbProduto.listar(listaProdutos);
        adapter.notifyDataSetChanged();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_listar_produto, container, false);

        listaDados = view.findViewById(R.id.listViewProduto);

        DBHelper dbHelper = new DBHelper(getActivity());
        dbProduto = new DBProduto(dbHelper);
        listaProdutos = new ArrayList<>();
        adapter = new ArrayAdapter(getActivity(), androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, listaProdutos);
        listaDados.setAdapter(adapter);

        atualizarLista();

        return view;
    }

}