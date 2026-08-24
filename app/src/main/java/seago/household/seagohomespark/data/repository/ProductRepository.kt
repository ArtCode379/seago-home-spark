package seago.household.seagohomespark.data.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import seago.household.seagohomespark.data.model.Product
import seago.household.seagohomespark.data.model.ProductCategory

class ProductRepository {
    private val products = listOf(
        Product(
            id = 1,
            title = "Woven Storage Basket",
            description = "A sturdy handwoven basket that keeps blankets, toys, or laundry beautifully organised.",
            category = ProductCategory.HOME,
            price = 28.00,
            imageUrl = "https://images.unsplash.com/photo-1616486338812-3dadae4b4ace?w=1200",
        ),
        Product(
            id = 2,
            title = "Amber Glass Vase",
            description = "A warm amber vase with a clean silhouette for fresh flowers or sculptural branches.",
            category = ProductCategory.HOME,
            price = 24.50,
            imageUrl = "https://images.unsplash.com/photo-1618220179428-22790b461013?w=1200",
        ),
        Product(
            id = 3,
            title = "Linen Cushion Set",
            description = "Two soft, neutral linen-blend cushion covers designed for relaxed everyday rooms.",
            category = ProductCategory.HOME,
            price = 32.00,
            imageUrl = "https://images.unsplash.com/photo-1586023492125-27b2c045efd7?w=1200",
        ),
        Product(
            id = 4,
            title = "Weekly Desk Planner",
            description = "An undated weekly planner with generous space for priorities, notes, and small wins.",
            category = ProductCategory.STATIONERY,
            price = 12.00,
            imageUrl = "https://images.unsplash.com/photo-1506784983877-45594efa4cbe?w=1200",
        ),
        Product(
            id = 5,
            title = "Hardback Dot Journal",
            description = "A lay-flat dot-grid notebook with smooth ivory pages and a durable cloth cover.",
            category = ProductCategory.STATIONERY,
            price = 16.50,
            imageUrl = "https://images.unsplash.com/photo-1517842645767-c639042777db?w=1200",
        ),
        Product(
            id = 6,
            title = "Brass Pen Set",
            description = "A balanced black-and-brass pen duo presented in a gift-ready case.",
            category = ProductCategory.STATIONERY,
            price = 19.00,
            imageUrl = "https://images.unsplash.com/photo-1583485088034-697b5bc54ccd?w=1200",
        ),
        Product(
            id = 7,
            title = "Canvas Market Tote",
            description = "A roomy heavyweight cotton tote with reinforced handles for everyday errands.",
            category = ProductCategory.ACCESSORIES,
            price = 22.00,
            imageUrl = "https://images.unsplash.com/photo-1594223274512-ad4803739b7c?w=1200",
        ),
        Product(
            id = 8,
            title = "Travel Jewellery Case",
            description = "A compact velvet-lined case with sections for rings, earrings, and necklaces.",
            category = ProductCategory.ACCESSORIES,
            price = 26.00,
            imageUrl = "https://images.unsplash.com/photo-1617038260897-41a1f14a8ca0?w=1200",
        ),
        Product(
            id = 9,
            title = "Scented Candle Trio",
            description = "Three hand-poured candles in cedar, linen, and citrus scents for a thoughtful housewarming.",
            category = ProductCategory.GIFTS,
            price = 29.50,
            imageUrl = "https://images.unsplash.com/photo-1603006905003-be475563bc59?w=1200",
        ),
        Product(
            id = 10,
            title = "Tea Ritual Gift Box",
            description = "A calming gift set with loose-leaf tea, a ceramic infuser, and honey spoon.",
            category = ProductCategory.GIFTS,
            price = 38.00,
            imageUrl = "https://images.unsplash.com/photo-1544787219-7f47ccb76574?w=1200",
        ),
        Product(
            id = 11,
            title = "Ceramic Catchall Tray",
            description = "A glazed oval tray for keys, jewellery, or other small essentials.",
            category = ProductCategory.HOME,
            price = 14.00,
            imageUrl = "https://images.unsplash.com/photo-1610701596007-11502861dcfa?w=1200",
        ),
        Product(
            id = 12,
            title = "Ribbon Gift Wrap Kit",
            description = "Premium paper, cotton ribbon, tags, and twine for six beautifully wrapped presents.",
            category = ProductCategory.GIFTS,
            price = 18.00,
            imageUrl = "https://images.unsplash.com/photo-1513885535751-8b9238bd345a?w=1200",
        ),
    )

    fun observeById(id: Int): Flow<Product?> = flowOf(products.find { it.id == id })

    fun getById(id: Int): Product? = products.find { it.id == id }

    fun observeAll(): Flow<List<Product>> = flowOf(products)
}
