package com.example.squaremobilechallenge.ui

import com.example.logic.model.Employee
import com.example.logic.model.EmployeeResult
import com.example.squaremobilechallenge.ui.employeelist.interactor.EmployeeListInteractor
import com.example.squaremobilechallenge.ui.employeelist.router.EmployeeListRouter
import com.example.squaremobilechallenge.ui.employeelist.viewmodel.EmployeeListViewModel
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.mockk.junit4.MockKRule
import io.reactivex.Single
import org.junit.Before
import org.junit.Rule
import org.junit.Test

import org.junit.Assert.*

/**
 * This test class is not finished.  Figured I'd leave it in, in case it's better than nothing.
 */

class EmployeeListViewModelTest {

    @get :Rule
    val mockkRule = MockKRule(this)

    lateinit var sut: EmployeeListViewModel

    @MockK lateinit var interactor: EmployeeListInteractor
    @MockK lateinit var router: EmployeeListRouter

    private val sampleEmployee1 = Employee("", "", "", "", "", "", "", "", "")

    @Before
    fun setup() {
        MockKAnnotations.init(this, relaxed = true, relaxUnitFun = true)
        sut = EmployeeListViewModel(interactor, router)
    }

    @Test
    fun `verify malformed data exists`() {
        every { interactor.getEmployees() } returns Single.just(EmployeeResult(mutableListOf(sampleEmployee1)))
        assertFalse(sut.invalidateMalformedResponses())
    }

}