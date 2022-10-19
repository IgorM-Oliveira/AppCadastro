package com.unigran.appdecadastro.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.unigran.appdecadastro.R;
import com.unigran.appdecadastro.dataBase.DBHelper;
import com.unigran.appdecadastro.dataBase.DBProduto;
import com.unigran.appdecadastro.entities.Produto;

public class CadastroProduto extends Fragment {

    public CadastroProduto() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cadastro_produto, container, false);

        DBHelper dbHelper = new DBHelper(getActivity());
        DBProduto dbProduto = new DBProduto(dbHelper);
        EditText editTextNomeProduto = view.findViewById(R.id.editTextNomeProduto);
        EditText editTextMarcaproduto = view.findViewById(R.id.editTextMarcaProduto);
        EditText editTextQuantidadeProduto = view.findViewById(R.id.editTextQuantidadeProduto);
        EditText editTextPrecoProduto = view.findViewById(R.id.editTextPrecoProduto);
        Button buttonSalvarProduto = view.findViewById(R.id.buttonSalvarProduto);

        buttonSalvarProduto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Produto produto = new Produto();

                produto.setNome(editTextNomeProduto.getText().toString());
                produto.setMarca(editTextMarcaproduto.getText().toString());
                produto.setQuantidade(Integer.parseInt(editTextQuantidadeProduto.getText().toString()));
                produto.setPreco(Double.parseDouble(editTextPrecoProduto.getText().toString()));

                dbProduto.inserir(produto);

                Toast.makeText(getActivity(), "Salvo com sucesso!", Toast.LENGTH_LONG).show();
                ListarProduto.atualizarLista();
            }
        });

        return (view);
    }
}