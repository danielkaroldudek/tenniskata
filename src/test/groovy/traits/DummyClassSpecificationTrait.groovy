package traits

import pl.ProjectTemplate.DummyClass

trait DummyClassSpecificationTrait {
    DummyClass dummyClass

    def setup() {
        dummyClass = new DummyClass()
    }
}