package net.erickveil.mvc_table_roller.mvc.model

import android.accounts.AuthenticatorDescription
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.random.Random

@Serializable
data class LootTable (
    @SerialName("tableName") val tableName: String,
    @SerialName("description") val description: String,
    @SerialName("results") val results: List<String>
) {
    fun getRandomItem(): String = results[Random.nextInt(results.size)]
}