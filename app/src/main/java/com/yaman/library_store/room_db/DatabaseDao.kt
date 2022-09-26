package com.yaman.library_store.room_db

import androidx.room.*
import io.realm.RealmObject
import io.realm.annotations.Required
import org.bson.types.ObjectId

@Dao
interface DatabaseDao {

    @Query("SELECT * FROM User")
    fun getAllUsers(): List<User>

    @Query("SELECT * FROM Test")
    fun getAllTests(): List<Test>

    @Query("SELECT * FROM User WHERE uid IN (:userIds)")
    fun loadAllByIds(userIds: IntArray): List<User>

    @Query(
        "SELECT * FROM User WHERE first_name LIKE :first AND " +
                "last_name LIKE :last LIMIT 1"
    )
    fun findByName(first: String, last: String): User

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg users: User)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll2(vararg users: User)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll3(vararg users: User)


}


@Entity
data class User(
    @PrimaryKey var uid: Int? = 0,
    @ColumnInfo(name = "first_name") var firstName: String? = "",
    @ColumnInfo(name = "last_name") var lastName: String? = ""
)

open class User2 : RealmObject() {
    var id: String = ObjectId().toHexString()
    @Required
    var firstName: String? = ""
    var lastName: String? = ""
}

@Entity
data class Test(
    @PrimaryKey val uid: Int,
    @ColumnInfo(name = "test_name") val firstName: String?,
    @ColumnInfo(name = "test_last") val lastName: String?
)

