package com.example.commonui.base

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

open class BaseViewHolder<T : ViewDataBinding>(val binding: T) : RecyclerView.ViewHolder(binding.root)