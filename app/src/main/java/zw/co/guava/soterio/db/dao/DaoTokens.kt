package zw.co.guava.soterio.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import zw.co.guava.soterio.db.entity.EntityToken

@Dao
interface DaoTokens {
    @Query("SELECT * FROM tokens ORDER BY tul")
    fun getAllTokens(): List<EntityToken>

    @Query("SELECT * FROM tokens WHERE tll <= :time AND :time <= tul")
    suspend fun getActiveToken(time: Long): EntityToken

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveToken(token: EntityToken)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveAllTokens(tokens: List<EntityToken>)

    @Query("DELETE FROM tokens WHERE tul < :time")
    suspend fun cleanUp(time: Long)

    @Query("DELETE FROM tokens")
    suspend fun nukeTokens()
}