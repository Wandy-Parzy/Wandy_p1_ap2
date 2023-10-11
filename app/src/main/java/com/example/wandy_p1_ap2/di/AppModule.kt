package com.example.wandy_p1_ap2.di

import android.content.Context
import androidx.room.Room
import com.example.wandy_p1_ap2.data.local.RoomDividirDb
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn( SingletonComponent::class)
object AppModule {
    @Singleton
    @Provides
    fun provideDataBase(@ApplicationContext context: Context): RoomDividirDb{
        return Room.databaseBuilder(
            context,
            RoomDividirDb::class.java,
            "DividiendoDb.db"
        )
            .fallbackToDestructiveMigration()
            .build()
    }
    @Singleton
    @Provides
    fun provideDividirDao(db: RoomDividirDb) = db.DividirDao

}
