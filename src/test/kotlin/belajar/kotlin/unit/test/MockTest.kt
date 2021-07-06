package belajar.kotlin.unit.test

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.mockito.Mockito

class MockTest {

    @Test
    fun testMock(){
        // membuat mocking list/ object list tiruan
        val list: List<String> = Mockito.mock(List::class.java) as List<String>

        // mendefined mocking list
        // ketika list[0] dipanggil, maka akan mereturn "Budi"
        Mockito.`when`(list[0]).thenReturn("Budi")
        Mockito.`when`(list[1]).thenReturn("Anto")

        // membandingkan antara ekspektasi dengan aktual
        // "budi" == list[0]/budi
        assertEquals("Budi", list[0])
        assertEquals("Anto", list[1])

        // mockito verify,
        // untuk memastikan bahwa mock object list pernah dipanggil 1 kali. panggil index 0
        Mockito.verify(list, Mockito.times(1))[0]
    }
}