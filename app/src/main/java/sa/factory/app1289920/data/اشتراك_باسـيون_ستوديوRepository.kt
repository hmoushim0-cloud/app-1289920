package sa.factory.app1289920.data

import sa.factory.app1289920.model.اشتراك_باسـيون_ستوديو
import sa.factory.app1289920.model.ملاحظة_تواصل_مع_مشتركة_باسـيون
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

interface اشتراك_باسـيون_ستوديوRepository {
    fun getAvailableCatalog(): Flow<List<ملاحظة_تواصل_مع_مشتركة_باسـيون>>
    fun getActiveRequest(): Flow<اشتراك_باسـيون_ستوديو?>
    suspend fun submitRequest(request: اشتراك_باسـيون_ستوديو): Result<String>
}

class InMemoryاشتراك_باسـيون_ستوديوRepository : اشتراك_باسـيون_ستوديوRepository {
    private val _catalog = MutableStateFlow<List<ملاحظة_تواصل_مع_مشتركة_باسـيون>>(listOf(
        ملاحظة_تواصل_مع_مشتركة_باسـيون("1", "خطة رحلة التجديد والاسترجاع", "تصميم قواعد التقسيم والتوقيتات (قبل الانتهاء، بعد التأخير، وإعادة تفعيل المنقطعات) مع قوالب تواصل جاهزة وتحسينات مبنية على النتائج.", 5000L, "verified"),
        ملاحظة_تواصل_مع_مشتركة_باسـيون("2", "لوحات متابعة فريق المبيعات والتواصل", "لوحات تشغيلية لحالات الاشتراك والمستفسرات، سير عمل للمهام، وسجل تواصل موحد يختصر دورة المتابعة ويمنع ضياع الفرص.", 9500L, "bolt")
    ))
    private val _active = MutableStateFlow<اشتراك_باسـيون_ستوديو?>(null)

    override fun getAvailableCatalog(): Flow<List<ملاحظة_تواصل_مع_مشتركة_باسـيون>> = _catalog.asStateFlow()
    override fun getActiveRequest(): Flow<اشتراك_باسـيون_ستوديو?> = _active.asStateFlow()

    override suspend fun submitRequest(request: اشتراك_باسـيون_ستوديو): Result<String> {
        _active.value = request
        return Result.success(request.requestId)
    }
}
