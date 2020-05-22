package pe.warrenth.cleanmvvm.data.datasource.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "posts")
data class Post(
        @SerializedName("userId")
        @ColumnInfo(name = "user_id")
        var userId: String? = null,

        @PrimaryKey
        @SerializedName("id")
        var id: Int? = null,

        @SerializedName("title")
        var title: String? = null,

        @SerializedName("body")
        var body: String? = null
) {
}