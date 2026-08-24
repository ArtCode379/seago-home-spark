package seago.household.seagohomespark.di

import androidx.room.Room
import seago.household.seagohomespark.data.database.KGUGNDatabase
import org.koin.dsl.module

private const val DB_NAME = "kgugn_db"

val databaseModule = module {
    single {
        Room.databaseBuilder(
            context = get(),
            klass = KGUGNDatabase::class.java,
            name = DB_NAME
        ).build()
    }

    single { get<KGUGNDatabase>().cartItemDao() }

    single { get<KGUGNDatabase>().orderDao() }
}