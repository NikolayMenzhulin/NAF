package com.github.nikolaymenzhulin.naf_service_layer_sample.ui

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import com.github.nikolaymenzhulin.logger.Logger
import com.github.nikolaymenzhulin.naf_service_layer_sample.domain.UserDM
import com.github.nikolaymenzhulin.naf_service_layer_sample.service.network.mapper.UserNetworkMapper
import com.github.nikolaymenzhulin.naf_service_layer_sample.service.repository.UserRepository
import com.github.nikolaymenzhulin.naf_service_layer_sample.service.storage.mapper.UserStorageMapper
import com.github.nikolaymenzhulin.naf_service_layer_sample.utils.MockServer
import com.github.nikolaymenzhulin.naf_service_layer_sample.utils.UserNameGenerator
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    private val networkMapper: UserNetworkMapper by lazy { UserNetworkMapper() }
    private val storageMapper: UserStorageMapper by lazy { UserStorageMapper(filesDir.absolutePath) }
    private val repository: UserRepository by lazy { UserRepository(networkMapper, storageMapper) }

    private val userNameGenerator: UserNameGenerator = UserNameGenerator()

    private lateinit var usersListTv: TextView
    private lateinit var progressBar: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initViews()
        initMockServer()
        loadUsers()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.activity_main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.put_user -> putUser()
            R.id.clear_users -> clearUsers()
        }
        return true
    }

    private fun initViews() {
        usersListTv = findViewById(R.id.users_list_tv)
        progressBar = findViewById(R.id.progress_bar)
    }

    private fun initMockServer() {
        lifecycleScope.launch { MockServer.initRetrofit() }
    }

    private fun loadUsers() {

        fun getUsers(): String =
            if (repository.hasUsers()) {
                repository.getUsers().joinToString(separator = "\n", transform = UserDM::toString)
            } else {
                getString(R.string.users_list_empty_state)
            }

        usersListTv.text = getUsers()
    }

    private fun putUser() {
        val userName: String = userNameGenerator.getUserName()
        MockServer.enqueueResponse(userName)
        repository.putUser(userName)
            .onEach { response ->
                with(response) {
                    progressBar.isVisible = isLoading
                    when {
                        isSuccess -> {
                            val wasUserAdded: Boolean = getData()
                            if (wasUserAdded) showAlreadyExistsUserToast() else loadUsers()
                        }
                        isError -> logError(error = getError())
                    }
                }
            }.launchIn(lifecycleScope)
    }

    private fun clearUsers() {
        repository.clearUsers()
        loadUsers()
    }

    private fun showAlreadyExistsUserToast() {
        Toast.makeText(this@MainActivity, getString(R.string.user_already_exists_state), LENGTH_SHORT).show()
    }

    private fun logError(error: Throwable) {
        Logger.e(error = error)
    }
}