package com.functional.programming

import arrow.core.Either
import arrow.core.extensions.fx


fun main() {
    val freelance = Freelance("Riadh MNASRI", Company("Cool Technologies", Intermediary("Cool Intermediary", Customer("Cool Customer"))))
    val comprehension = MonadComprehension()
    val customer = Either.fx<Any, Customer> {
        val freelanceCompany = MonadComprehension().findFreelanceCompany(freelance).bind()
        val intermediary = MonadComprehension().findIntermediary(freelanceCompany).bind()
        val customer = MonadComprehension().findFreelanceCustomer(intermediary).bind()
        customer
    }

    println(customer.fold({ 1 }, { it }) )
}
