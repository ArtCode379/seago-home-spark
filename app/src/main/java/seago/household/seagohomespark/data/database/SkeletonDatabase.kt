package seago.household.seagohomespark.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import seago.household.seagohomespark.data.dao.CartItemDao
import seago.household.seagohomespark.data.dao.OrderDao
import seago.household.seagohomespark.data.database.converter.Converters
import seago.household.seagohomespark.data.entity.CartItemEntity
import seago.household.seagohomespark.data.entity.OrderEntity

@Database(
    entities = [CartItemEntity::class, OrderEntity::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(Converters::class)
abstract class KGUGNDatabase : RoomDatabase() {

    abstract fun cartItemDao(): CartItemDao

    abstract fun orderDao(): OrderDao
}