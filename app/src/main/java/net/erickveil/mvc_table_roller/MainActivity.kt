package net.erickveil.mvc_table_roller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import net.erickveil.mvc_table_roller.mvc.model.LootTable
import kotlinx.serialization.json.Json

class MainActivity : AppCompatActivity() {
    private lateinit var lootTable: LootTable

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Load the loot table from the JSON file
        lootTable = loadLootTable(this)

        // Find the button and text view by their IDs
        val rollButton: Button = findViewById(R.id.but_rollOnTable)
        val outputTextView: TextView = findViewById(R.id.tv_output)

        // Set a click listener on the button to roll on the loot table and update the text view
        rollButton.setOnClickListener {
            val selectedItem = lootTable.getRandomItem()
            outputTextView.text = selectedItem
        }
    }

    private fun loadLootTable(mainActivity: MainActivity): LootTable {
        val jsonString = assets.open("lootTable.json").bufferedReader().use { it.readText() }
        return Json.decodeFromString(LootTable.serializer(), jsonString)
    }
}