package pe.warrenth.cleanmvvm.presentation.main

import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.shiftweather.core.presentation.gone
import com.shiftweather.core.presentation.visible
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.androidx.viewmodel.ext.android.viewModel
import pe.warrenth.cleanmvvm.R
import pe.warrenth.cleanmvvm.core.Status
import pe.warrenth.cleanmvvm.databinding.ActivityMainBinding
import pe.warrenth.cleanmvvm.core.presentation.ui.BaseActivity
import pe.warrenth.cleanmvvm.data.datasource.entity.PostsResponse
import timber.log.Timber
import kotlin.error

class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>() {

    private val mainViewModel : MainViewModel by viewModel()

    private lateinit var adapter: MainAdapter

    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }

    override fun getViewModel(): MainViewModel {
        return mainViewModel
    }

    override fun setUp(savedInstanceState: Bundle?) {

        getViewDataBinding().recyclerview.setHasFixedSize(true)
        recyclerview.layoutManager = LinearLayoutManager(this)

        adapter = MainAdapter()
        recyclerview.adapter = adapter


        mainViewModel.getPosts().observe(this, Observer<PostsResponse> {
            handleResponse(it!!)
        })

        mainViewModel.loadPosts()
    }

    private fun handleResponse(response: PostsResponse) {
        when(response.status) {
            Status.LOADING -> {
                Timber.e("Loading posts...")
                loading.visible()
            }

            Status.SUCCESS -> {
                Timber.e("Fetched posts")
                loading.gone()
                adapter.addPosts(response.posts!!)
            }

            Status.ERROR -> {
                Timber.e("Error fetching posts")
                loading.gone()
                error.visible()
            }
        }
    }
}