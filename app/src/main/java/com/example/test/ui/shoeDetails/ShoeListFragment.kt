package com.example.test.ui.shoeDetails

import android.os.Bundle
import android.view.*
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.onNavDestinationSelected
import com.example.test.model.Shoe
import com.example.test.R
import com.example.test.databinding.FragmentShoeListBinding
import com.example.test.databinding.ItemCardBinding

class ShoeListFragment : Fragment(), MenuProvider {

    private lateinit var shoeListBinding: FragmentShoeListBinding
    private lateinit var cardBinding: ItemCardBinding
    private lateinit var shoeViewModel: ShoeViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        shoeListBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_list, container, false)

        val menuHost: MenuHost = requireActivity()
        menuHost.addMenuProvider(this, viewLifecycleOwner, Lifecycle.State.RESUMED)

        shoeViewModel = ViewModelProvider(requireActivity())[ShoeViewModel::class.java]
        shoeViewModel.shoeList.observe(viewLifecycleOwner) { newShoe ->
            newShoe.forEach { shoe ->
                addCard(shoe)
            }
        }
        shoeListBinding.addShoeFAB.setOnClickListener {
            findNavController().navigate(
                ShoeListFragmentDirections.actionShoeListFragmentToShoeDetailFragment()
            )
        }
        // Inflate the layout for this fragment
        return shoeListBinding.root
    }

    private fun addCard(shoe: Shoe?) {
        val view: View = View.inflate(context, R.layout.item_card, null)
        cardBinding = DataBindingUtil.bind(view)!!
        cardBinding.shoe = shoe
        shoeListBinding.mainLayout.addView(cardBinding.root)
    }

    override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
        menuInflater.inflate(R.menu.logout_menu, menu)
    }

    override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
        return menuItem.onNavDestinationSelected(findNavController()) ||
                super.onOptionsItemSelected(menuItem)
    }

}