import spock.lang.Specification
import traits.DummyClassSpecificationTrait

class DummyClassSpecification extends Specification implements DummyClassSpecificationTrait {
    def "Run base test case for DummyMethod in DummyClass"() {
        given: "I have DummyClass"
        when: "I execute DummyMethod"
            def result = dummyClass.dummyMethod()
        then: "I should get 0"
            0 == result
    }
}
