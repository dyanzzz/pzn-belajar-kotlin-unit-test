package belajar.kotlin.unit.test

import org.junit.jupiter.api.*

// TestMethodOrder memiliki beberapa method order
// Alphanumeric => default (order alpha numeric dari nama functionnya)
// OrderAnnotation => order by annotation. menggunakan annotation @Order(value/int/1)
// random => mengacak order function. ga perlu annotation helper
@TestMethodOrder(value = MethodOrderer.OrderAnnotation::class)
// defaultnya, siklus hidup test itu per function/method, maka sulit untuk membuat variable/property lain didalam class
// bisa diubah menjadi PER_CLASS, agar lebih mudah untuk mengakses property/variable lain dengan class
@TestInstance(value = TestInstance.Lifecycle.PER_CLASS)
class OrderTest{

    var counter: Int = 0

    // kelebihan menggunakan lifecycle PER_CLASS
    // bisa menggunakan beforeAll dan afterAll secara langsung, tanpa membuat companion object static
    @BeforeAll
    fun beforeAll(){
        println()
    }

    @AfterAll
    fun adterAll(){

    }

    @Test
    @Order(3)
    fun testA(){
        // increment counter akan terus bertambah ketika menggunakan lifecycle.PER_CLASS
        // karena semua function menggunakan 1 object/hash code yg sama
        // jika menggunakan PER_METHOD, maka increment counter pada masing" counter akan berbeda", dan membuat increment tidak berjalan
        counter++
        println(counter)
        println(this.hashCode())
    }

    @Test
    @Order(1)
    fun testC(){
        counter++
        println(counter)
        println(this.hashCode())
    }

    @Test
    @Order(2)
    fun testB(){
        counter++
        println(counter)
        println(this.hashCode())
    }
}