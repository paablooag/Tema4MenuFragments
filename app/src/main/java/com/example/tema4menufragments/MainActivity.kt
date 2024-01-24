package com.example.tema4menufragments

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private lateinit var fotoPerfilImageView: ImageView
    private lateinit var nombreUsuarioTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fotoPerfilImageView = findViewById(R.id.fotoPerfil)
        nombreUsuarioTextView = findViewById(R.id.nombreUsuario)

        // Recuperar el nombre de usuario y la foto de perfil del Intent
        val nombreUsuario = intent.getStringExtra("nombreUsuario")

        // Actualizar la interfaz de usuario con los datos recibidos
        if (nombreUsuario != null && nombreUsuario.isNotEmpty()) {
            // Si hay un nombre de usuario, mostrarlo
            nombreUsuarioTextView.text = nombreUsuario
        } else {
            // Si no hay nombre de usuario, mostrar un valor predeterminado
            nombreUsuarioTextView.text = "Nombre de usuario"
        }
        // Suponiendo que tienes la imagen de perfil en tu recurso @drawable
        fotoPerfilImageView.setImageResource(R.drawable.ic_launcher_background)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }
    override fun onOptionsItemSelected(item:MenuItem):Boolean{
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