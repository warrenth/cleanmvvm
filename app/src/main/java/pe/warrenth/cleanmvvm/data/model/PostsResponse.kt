package pe.warrenth.cleanmvvm.data.model

import pe.warrenth.cleanmvvm.core.Status
import pe.warrenth.cleanmvvm.domain.entity.PostEntity


class PostsResponse  {
    var status: Status
    var posts: List<PostEntity>? = null
    var error: Throwable? = null

    private constructor(status: Status, posts: List<PostEntity>?, error: Throwable?) {
        this.status = status
        this.posts = posts
        this.error = error
    }

    companion object {

        fun loading(): PostsResponse {
            return PostsResponse(Status.LOADING, null, null)
        }

        fun success(posts: List<PostEntity>): PostsResponse {
            return PostsResponse(Status.SUCCESS, posts, null)
        }

        fun error(error: Throwable): PostsResponse {
            return PostsResponse(Status.ERROR, null, error)
        }

    }

}