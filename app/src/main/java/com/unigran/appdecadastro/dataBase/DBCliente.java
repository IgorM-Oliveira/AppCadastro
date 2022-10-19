package com.unigran.appdecadastro.dataBase;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.unigran.appdecadastro.entities.Cliente;

import java.util.List;

public class DBCliente {
    private DBHelper dbHelper;
    private SQLiteDatabase conexao;

    public DBCliente(DBHelper dbHelper) {
        this.dbHelper = dbHelper;
    }

    public void inserir(Cliente cliente) {
        conexao = dbHelper.getWritableDatabase();

        ContentValues valores = new ContentValues();
        valores.put("nome", cliente.getNome());
        valores.put("email", cliente.getEmail());
        valores.put("telefone", cliente.getTelefone());

        conexao.insertOrThrow("clientes", null, valores);

        conexao.close();
    }

    public void remover(Integer id) {
        conexao = dbHelper.getWritableDatabase();

        conexao.delete("clientes", "id=?", new String[]{id + ""});

        conexao.close();
    }

    public void listar(List<Cliente> listaClientes) {
        listaClientes.clear();
        conexao = dbHelper.getReadableDatabase();

        String colunas[] = {"id", "nome", "email", "telefone"};
        Cursor query = conexao.query("clientes", colunas, null, null, null, null, "nome");

        while (query.moveToNext()) {
            Cliente cliente = new Cliente();

            cliente.setId(query.getInt(0));
            cliente.setNome(query.getString(1));
            cliente.setEmail(query.getString(2));
            cliente.setTelefone(query.getString(3));

            listaClientes.add(cliente);
        }

        conexao.close();
    }

}
