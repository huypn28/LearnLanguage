package com.example.learnlanguage.fragment



import com.example.learnlanguage.R
import com.example.learnlanguage.base.BaseFragment
import com.example.learnlanguage.databinding.FragmentStudyBinding
import com.example.learnlanguage.viewmodel.MainViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class StudyFragment : BaseFragment<FragmentStudyBinding>() {
    companion object {
        private val TAG = StudyFragment::class.java.name
    }
    private val viewModel: MainViewModel by viewModel()
    override fun getVM(): MainViewModel = viewModel

   override fun initViews() {

   }

    override fun getLayoutId() = R.layout.fragment_study
}