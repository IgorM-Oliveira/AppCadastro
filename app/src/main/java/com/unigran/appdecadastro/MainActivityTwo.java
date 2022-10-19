package com.unigran.appdecadastro;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.unigran.appdecadastro.fragments.CadastroCliente;
import com.unigran.appdecadastro.fragments.CadastroFornecedor;
import com.unigran.appdecadastro.fragments.CadastroProduto;
import com.unigran.appdecadastro.fragments.ListarCliente;
import com.unigran.appdecadastro.fragments.ListarFornecedor;
import com.unigran.appdecadastro.fragments.ListarProduto;

public class MainActivityTwo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_two);

        Integer op = getIntent().getIntExtra("op", -1);
        Button buttonLista = findViewById(R.id.buttonLista);
        Button buttonCadastrar = findViewById(R.id.buttonCadastro);

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        switch (op) {
            case 0: {
                transaction.add(R.id.mainFrame, new ListarCliente());
                break;
            }
            case 1: {
                transaction.add(R.id.mainFrame, new ListarFornecedor());
                break;
            }
            case 2: {
                transaction.add(R.id.mainFrame, new ListarProduto());
                break;
            }
        }
        transaction.commit();

        buttonLista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (op) {
                    case 0: {
                        getSupportFragmentManager().beginTransaction().replace(R.id.mainFrame, new ListarCliente()).commit();
                        break;
                    }
                    case 1: {
                        getSupportFragmentManager().beginTransaction().replace(R.id.mainFrame, new ListarFornecedor()).commit();
                        break;
                    }
                    case 2: {
                        getSupportFragmentManager().beginTransaction().replace(R.id.mainFrame, new ListarProduto()).commit();
                        break;
                    }
                }
            }
        });

        buttonCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (op) {
                    case 0: {
                        getSupportFragmentManager().beginTransaction().replace(R.id.mainFrame, new CadastroCliente()).commit();
                        break;
                    }
                    case 1: {
                        getSupportFragmentManager().beginTransaction().replace(R.id.mainFrame, new CadastroFornecedor()).commit();
                        break;
                    }
                    case 2: {
                        getSupportFragmentManager().beginTransaction().replace(R.id.mainFrame, new CadastroProduto()).commit();
                        break;
                    }
                }
            }
        });
    }
}