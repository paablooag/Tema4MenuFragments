package com.example.tema4menufragments

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText

class EditarPerfil : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_editar_perfil)
        val editNombreUsuario = findViewById<EditText>(R.id.editNombreUsuario)
        val botonGuardar = findViewById<Button>(R.id.botonGuardar)

        botonGuardar.setOnClickListener {
            val nombreUsuario = editNombreUsuario.text.toString()

            // Crear un Intent para pasar datos a MainActivity
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("nombreUsuario", nombreUsuario)

            // Iniciar la actividad MainActivity
            startActivity(intent)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem):Boolean{
        if(item.itemId == R.id.action_send){
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }else if(item.itemId == R.id.actionSendTemporal) {
            val intent = Intent(this, EditarPerfil::class.java)
            startActivity(intent)
        }
        return super.onOptionsItemSelected(item)
    }
}