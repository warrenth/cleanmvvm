package pe.warrenth.cleanmvvm.presentation.main

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.shiftweather.core.presentation.inflate
import com.shiftweather.core.presentation.inflate2
import pe.warrenth.cleanmvvm.R
import pe.warrenth.cleanmvvm.data.datasource.entity.Post
import pe.warrenth.cleanmvvm.databinding.ItemPostBinding
import timber.log.Timber

class MainAdapter : RecyclerView.Adapter<MainAdapter.PostHolder>() {
    private val posts = mutableListOf<Post>()

    fun addPosts(posts: List<Post>) {
        this.posts.addAll(posts)
        notifyDataSetChanged()

        Timber.e("Posts count: $itemCount")
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, p1: Int): PostHolder {
        return PostHolder(viewGroup.inflate2(R.layout.item_post))
    }

    override fun getItemCount(): Int = posts.size

    override fun onBindViewHolder(p0: PostHolder, p1: Int) {
        p0.bind(posts[p1])
    }

    class PostHolder(private val binding: ItemPostBinding): RecyclerView.ViewHolder(binding.root) {

        fun bind(post: Post) {
            binding.post = post
        }

    }

}