package belajar.kotlin.unit.test.repository

import belajar.kotlin.unit.test.model.Person

// membuat repository, sebagai kontrak dari data model version ke database
interface PersonRepository {

    fun selecteById(id: String): Person?

    fun insert(person: Person): Unit    // unit disini, di java adalah void

}