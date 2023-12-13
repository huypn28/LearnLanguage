package com.example.learnlanguage.fragment

import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.lifecycle.lifecycleScope
import com.bumptech.glide.Glide
import com.example.learnlanguage.R
import com.example.learnlanguage.base.BaseFragment
import com.example.learnlanguage.databinding.FragmentEditprofileBinding
import com.example.learnlanguage.model.User
import com.example.learnlanguage.utils.Resource
import com.example.learnlanguage.viewmodel.EditProfileViewModel
import kotlinx.coroutines.flow.collectLatest
import org.koin.androidx.viewmodel.ext.android.viewModel


class EditProfileFragment: BaseFragment<FragmentEditprofileBinding>() {
    companion object {
        internal val TAG = EditProfileFragment::class.java.name
    }
    private val viewModel: EditProfileViewModel by viewModel()

    override fun getVM(): EditProfileViewModel = viewModel

    private var imageUri : Uri?=null
    private lateinit var imageActivityResultLauncher: ActivityResultLauncher<Intent>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        imageActivityResultLauncher=registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
            imageUri=it.data?.data
            Glide.with(this).load(imageUri).into(binding.ivProfile)
        }
    }


    override fun initViews() {

        lifecycleScope.launchWhenStarted {
            viewModel.user.collectLatest {
                when (it) {

                    is Resource.Success -> {
                        showUserInformation(it.data!!)
                    }
                    is Resource.Error -> {
                        Toast.makeText(requireContext(), it.message, Toast.LENGTH_SHORT).show()
                    }
                    else -> Unit
                }
            }
        }

        lifecycleScope.launchWhenStarted {
            viewModel.updateInfo.collectLatest {
                when (it) {

                    is Resource.Success -> {
                        Toast.makeText(requireContext(), "Update successfully", Toast.LENGTH_SHORT).show()
                    }
                    is Resource.Error -> {
                        Toast.makeText(requireContext(), it.message, Toast.LENGTH_SHORT).show()
                    }
                    else -> Unit
                }
            }
        }


        binding.buttonConfirmEditProfile.setOnClickListener {
            binding.apply {
                val userName=edUserName.text.toString().trim()
                val address=edAddress.text.toString().trim()
                val birth=edBirth.text.toString().trim()
                val user= User(userName, address, birth)
                viewModel.updateUser(user, imageUri)
            }
        }

        binding.buttonCancelEditProfile.setOnClickListener {
            parentFragmentManager.popBackStack()
        }

        binding.ivProfile.setOnClickListener {
            val intent= Intent(Intent.ACTION_GET_CONTENT)
            intent.type="image/*"
            imageActivityResultLauncher.launch(intent)
        }
    }

    private fun showUserInformation(data: User) {
        binding.apply {
            Glide.with(this@EditProfileFragment).load(data.imagePath).error(ColorDrawable(Color.BLACK)).into(ivProfile)
            edUserName.setText(data.userName)
            edAddress.setText(data.address)
            edBirth.setText(data.birth)

        }
    }



    override fun getLayoutId(): Int = R.layout.fragment_editprofile

}