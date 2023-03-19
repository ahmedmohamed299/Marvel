package com.example.marvel.presentation.ui


import android.graphics.*
import android.os.Build
import android.os.Bundle
import android.view.*
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.marvel.R
import com.example.marvel.databinding.FragmentSplashBinding



class SplashFragment : Fragment() {


    private var _binding: FragmentSplashBinding? = null

    private val binding
        get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSplashBinding.inflate(inflater,container,false)

        blurBackground()

        anim()

        return binding.root
    }


    private fun blurBackground() {

        val w: Window = requireActivity().window
        val x =35.0f
        val y =35.0f
        w.setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_BLUR_BEHIND
        )
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            binding.ivBackground.setRenderEffect(
                RenderEffect.createBlurEffect(
                    x, y, Shader.TileMode.REPEAT
                )
            )
        }


    }

    private fun anim() {
        val logoAnim = AnimationUtils.loadAnimation(requireContext(), R.anim.logo_anim)
        binding.ivLogo.animation = logoAnim
        logoAnim.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationStart(animation: Animation?) {
                //do anything when anim start
            }

            override fun onAnimationEnd(animation: Animation?) {
                findNavController().navigate(R.id.action_splashFragment_to_homeFragment)
            }

            override fun onAnimationRepeat(animation: Animation?) {
                //do anything if anim repeat

            }

        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}