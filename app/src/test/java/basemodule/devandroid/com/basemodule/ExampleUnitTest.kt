package basemodule.devandroid.com.basemodule

import com.devandroid.basemodule.utils.printll
import org.junit.Test
import java.text.DateFormatSymbols
import java.util.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {

    @Test
    fun name() {

        val formatSymbols = DateFormatSymbols.getInstance(Locale.forLanguageTag("ch"))
        val months = formatSymbols.shortMonths

        printll("Months :")
        for (month in months) {
            if (!month.toString().isEmpty()) {
                printll(month.toString())
            }
        }
    }
}
