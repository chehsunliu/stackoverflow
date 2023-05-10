package io.github.chehsunliu.demo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AppTest {
    @Test void getWhatYouWant() {
        assertEquals("dog", new App().getAnimal().kind());
    }
}
