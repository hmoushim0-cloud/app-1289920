package sa.factory.app1289920.model

import kotlinx.serialization.Serializable

@Serializable
data class ملاحظة_تواصل_مع_مشتركة_باسـيون(
    val id: String,
    val title: String,
    val description: String,
    val priceMinorUnits: Long,
    val iconVector: String = "verified"
)

@Serializable
data class اشتراك_باسـيون_ستوديو(
    val requestId: String,
    val items: List<ملاحظة_تواصل_مع_مشتركة_باسـيون>,
    val customerPhone: String,
    val totalAmountMinorUnits: Long,
    val status: اشتراك_باسـيون_ستوديوStatus = اشتراك_باسـيون_ستوديوStatus.PENDING,
    val createdAtEpochMs: Long = System.currentTimeMillis()
)

enum class اشتراك_باسـيون_ستوديوStatus {
    PENDING,
    ACCEPTED,
    IN_PROGRESS,
    COMPLETED,
    CANCELLED
}
