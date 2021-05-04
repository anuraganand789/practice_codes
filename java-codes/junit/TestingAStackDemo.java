import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.EmptyStackException;
import java.util.Stack;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayName("A Stack")
class TestingAStackDemo {
    
    Stack<Object> stack;

    @Test
    @DisplayName("is instantiated with new Stack()")
    void isInstantiatedWithNew(){
        new Stack<>();
    }

    @Nested
    @DisplayName("when new")
    class WhenNew{
        @BeforeEach
        void createNewStack(){
            stack = new Stack<>();
        }

        @Test
        @DisplayName("is empty")
        void isEmpty(){
            assertTrue(stack.isEmpty());
        }

        @Test
        @DisplayName("throws EmptyStackExeption when popped")
        void throwsExceptionWhenPopped(){
            assertThrows(EmptyStackException.class, stack::pop);
        }

        @Test
        @DisplayName("throws EmptyStackException when peeked")
        void throwsExceptionWhenPeeked(){
            assertThrows(EmptyStackException.class, stack::peek);
        }

        @Nested
        @DisplayName("after pusing an element")
        class AfterPushing{
            final String anElement = "an element";

            @BeforeEach
            void pushAnElement(){
                stack.push(anElement);
            }

            @Test
            @DisplayName("it is no longer empty")
            void isNotEmpty(){
                assertFalse(stack.isEmpty());
            }

            @Test
            @DisplayName("returns the element when popped and is empty")
            void returnElemenWhenPopped(){
                assertEquals(anElement, stack.pop());
                assertTrue(stack.isEmpty());
            }
        }
    }
}
