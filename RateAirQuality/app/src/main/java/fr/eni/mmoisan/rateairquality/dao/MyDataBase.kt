package fr.eni.mmoisan.rateairquality.dao

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import fr.eni.mmoisan.rateairquality.entities.AirQuality

@Database(entities = [AirQuality::class], version = 2)
abstract class MyDataBase : RoomDatabase() {

    abstract fun AirQualityDao(): AirQualityDao

    companion object {
        @Volatile
        private var INSTANCE: MyDataBase? = null

        fun getInstance(context: Context): MyDataBase {

            synchronized(this) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        MyDataBase::class.java,
                        "la_base_de_donnees"
                    )
                        .fallbackToDestructiveMigration()
                        .allowMainThreadQueries()
                        .build()
                }
                return INSTANCE as MyDataBase
            }
        }
    }
}