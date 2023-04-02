import com.sksamuel.hoplite.ConfigLoaderBuilder
import com.sksamuel.hoplite.addResourceSource

data class Config(
    val bootstrapServersConfig: String,
    val groupIdConfig: String,
    val keyDeserializerClassConfig: String,
    val valueDeserializerClassConfig: String,
    val schemaRegistryUrl: String,
    val autoOffsetResetConfig: String,
)

val config: Config = ConfigLoaderBuilder.default()
    .addResourceSource("/config.yaml")
    .build()
    .loadConfigOrThrow()