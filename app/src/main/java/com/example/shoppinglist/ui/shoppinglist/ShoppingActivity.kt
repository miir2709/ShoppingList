package com.example.shoppinglist.ui.shoppinglist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.example.shoppinglist.ShoppingDatabase
import com.example.shoppinglist.data.repositories.ShoppingRepository
import com.example.shoppinglist.ui.theme.ShoppingListTheme

class ShoppingActivity : ComponentActivity() {

    val shoppingDatabase = ShoppingDatabase(this)
    val shoppingRepository = ShoppingRepository(db = shoppingDatabase)
    val factory = ShoppingViewModelFactory(shoppingRepository = shoppingRepository)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ShoppingListTheme {
                Scaffold( modifier = Modifier.fillMaxSize() ) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }

        val viewModel = ViewModelProvider(this, factory)[ShoppingViewModel::class.java]
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ShoppingListTheme {
        Greeting("Android")
    }
}