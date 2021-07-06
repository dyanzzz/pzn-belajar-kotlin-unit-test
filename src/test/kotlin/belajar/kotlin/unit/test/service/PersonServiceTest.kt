package belajar.kotlin.unit.test.service

import belajar.kotlin.unit.test.model.Person
import belajar.kotlin.unit.test.repository.PersonRepository
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.api.extension.ExtendWith
import org.junit.jupiter.api.extension.Extensions
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.jupiter.MockitoExtension

@Extensions(value = [
    ExtendWith(MockitoExtension::class)
])
class PersonServiceTest {

    // dengan membuat mock ke extension tsb, maka akan dibuat tiruan dari person repository seolah koneksi ke database
    // jadi ga perlu melakukan manual mocking, cukup dengan annotation mock
    @Mock
    lateinit var personRepository: PersonRepository

    lateinit var personService: PersonService

    @BeforeEach
    fun beforeEch(){
        personService = PersonService(personRepository)
    }

    @Test
    fun testPersonIdIsNotValid(){
        assertThrows<IllegalArgumentException> {
            personService.get("            ")
        }
    }

    @Test
    fun testPersonNotFound(){
        assertThrows<Exception> {
            personService.get("Not Found")
        }
    }

    @Test
    fun testPersonSuccess(){
        // untuk menambhakan behaviour mockito
        // mengisi class data person
        Mockito.`when`(personRepository.selecteById("budi")).thenReturn(Person("budi", "Budianto"))

        val person = personService.get("budi")
        assertEquals("budi", person.id)
        assertEquals("Budianto", person.name)
    }

    // untuk validasi register person
    @Test
    fun testRegisterPersonNameIsBlank(){
        assertThrows<IllegalArgumentException> {
            personService.register("     ")
        }
    }

    @Test
    fun testRegisterSuccess(){
        val person = personService.register("Budi")

        assertEquals("Budi", person.name)
        assertNotNull(person.id)

        // verifikasi bahwa insert itu dipanggil
        // personRepository itu berapa kali dipanggil. dengan Mockito.times
        // function apa yg dipanggil ? insert()
        // parameternya menggunakan apa ? Person(person.id, person.name)
        Mockito.verify(personRepository, Mockito.times(1)).insert(Person(person.id, person.name))
    }
}