package pe.warrenth.cleanmvvm.presentation.main

import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.shiftweather.core.presentation.gone
import com.shiftweather.core.presentation.observe
import com.shiftweather.core.presentation.visible
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.androidx.viewmodel.ext.android.viewModel
import pe.warrenth.cleanmvvm.R
import pe.warrenth.cleanmvvm.core.Status
import pe.warrenth.cleanmvvm.core.presentation.ui.BaseActivity
import pe.warrenth.cleanmvvm.data.model.PostsResponse
import pe.warrenth.cleanmvvm.databinding.ActivityMainBinding
import timber.log.Timber

class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>() {

    private val mainViewModel : MainViewModel by viewModel()
    private lateinit var mainAdapter: MainAdapter

    override fun getLayoutId(): Int = R.layout.activity_main
    override fun getViewModel(): MainViewModel = mainViewModel

    override fun setUp(savedInstanceState: Bundle?) {

        mainAdapter = MainAdapter()
        recyclerview.layoutManager = LinearLayoutManager(this)
        recyclerview.adapter = mainAdapter
        getViewDataBinding().recyclerview.setHasFixedSize(true)


        mainViewModel.getTest().observe(this, Observer<PostsResponse> {
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
                mainAdapter.addPosts(response.posts!!)
            }

            Status.ERROR -> {
                Timber.e("Error fetching posts")
                loading.gone()
                error.visible()
            }
        }
    }
}