package fr.eni.mmoisan.myappwithroom

import androidx.room.Room
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import fr.eni.mmoisan.myappwithroom.dao.MovieDao
import fr.eni.mmoisan.myappwithroom.dao.MyDataBase
import fr.eni.mmoisan.myappwithroom.entities.Movie

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Before

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {

    lateinit var db:MyDataBase
    lateinit var dao: MovieDao

    @Before
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("fr.eni.mmoisan.myappwithroom", appContext.packageName)
        db = Room.inMemoryDatabaseBuilder(appContext, MyDataBase::class.java).allowMainThreadQueries().build()
        dao = db.MovieDao()

        dao.insert(Movie(0, "STAR WARS", 125, "USA"))
        dao.insert(Movie(0, "Parasite", 133, "KOR"))
    }

    @Test
    fun insert() {
        var myMovie = dao.getById(1)

        assertEquals(myMovie.title, "STAR WARS")
        assertEquals(myMovie.duration, 125)
        assertEquals(myMovie.nationality, "USA")
    }

    @Test
    fun getAll() {
        assertTrue(dao.getAll().isNotEmpty())
    }

    @Test
    fun getById() {
        var myMovie = dao.getById(2)

        assertEquals(myMovie.title, "Parasite")
        assertEquals(myMovie.duration, 133)
        assertEquals(myMovie.nationality, "KOR")
    }
}