import com.netcompany.sprak.BatchRandomizer
import com.netcompany.sprak.delegator.ABImpl
import com.netcompany.sprak.delegator.AImpl
import com.netcompany.sprak.delegator.BImpl
import com.netcompany.sprak.delegator.RandomCache
import com.nhaarman.mockito_kotlin.doReturn
import com.nhaarman.mockito_kotlin.mock
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.platform.runner.JUnitPlatform
import org.junit.runner.RunWith

@RunWith(JUnitPlatform::class)
class DelegatorTest : Spek({

    describe("Simple delegation") {
        it("works") {
            val aImpl = AImpl()
            val bImpl = BImpl()

            val abImpl = ABImpl(aImpl, bImpl)

            abImpl.doA()
            abImpl.doB()
        }
    }

    describe("Hidden delegate") {
        it("is initialized automatically") {
            val batchRandomizer = mock<BatchRandomizer> {
                on { nextBatch() } doReturn listOf(3, 1, 4, 1, 5)
            }

            val foo = RandomCache(batchRandomizer)

            assertEquals(3, foo.get(0))
            assertEquals(1, foo.get(1))
            assertEquals(4, foo.get(2))
            assertEquals(1, foo.get(3))
            assertEquals(5, foo.get(4))
        }
    }

})