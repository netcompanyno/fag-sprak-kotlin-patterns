import com.netcompany.sprak.BatchRandomizer
import com.netcompany.sprak.delegator.ABImpl
import com.netcompany.sprak.delegator.AImpl
import com.netcompany.sprak.delegator.BImpl
import com.netcompany.sprak.delegator.RandomCache
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it
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
            // TODO: mock this
            val batchRandomizer = BatchRandomizer()

            val foo = RandomCache(batchRandomizer)

            foo.addMoreRandomNumbers()
            // assertEquals(2, foo.get(0))
            // assertEquals(3, foo.get(1))
            // assertEquals(5, foo.get(2))
            // assertEquals(7, foo.get(3))
        }
    }

})