package pe.warrenth.cleanmvvm.presentation.main

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import pe.warrenth.cleanmvvm.core.extention.inflate
import pe.warrenth.cleanmvvm.core.extention.loadImage
import pe.warrenth.cleanmvvm.R
import pe.warrenth.cleanmvvm.databinding.ItemPostBinding
import pe.warrenth.cleanmvvm.domain.entity.PostEntity
import timber.log.Timber

class MainAdapter : RecyclerView.Adapter<MainAdapter.PostHolder>() {
    private val posts = mutableListOf<PostEntity>()

    fun addPosts(posts: List<PostEntity>) {
        this.posts.addAll(posts)
        notifyDataSetChanged()

        Timber.e("Posts count: $itemCount")
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, p1: Int): PostHolder {
        return PostHolder(viewGroup.inflate(R.layout.item_post))
    }

    override fun getItemCount(): Int = posts.size

    override fun onBindViewHolder(p0: PostHolder, p1: Int) {
        p0.bind(posts[p1])
    }

    class PostHolder(private val binding: ItemPostBinding): RecyclerView.ViewHolder(binding.root) {

        fun bind(post: PostEntity) {
            with(binding) {
                image.loadImage(post.thumbnailUrl)
                title.text = post.title
            }
        }

    }

}