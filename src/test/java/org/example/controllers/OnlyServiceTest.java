package org.example.controllers;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.example.services.HelloService;
import org.example.services.HelloService2;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class OnlyServiceTest {

    @Mock
    private HelloService2 helloService2;

    @InjectMocks
    private HelloService helloService;

    @Before
    public void setup () {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void test() {
        Mockito.when(helloService2.test()).thenReturn("True");

        String response = helloService.test("Evandro");
        Assert.assertEquals(response, "Evandro: Hello True");
    }

    @Test
    public void test2() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method privateMethod = HelloService2.class.getDeclaredMethod("hello", null);
        privateMethod.setAccessible(true);
        String returnValue = (String) privateMethod.invoke(helloService2, null);
        Assert.assertEquals("Hello", returnValue);
    }

}
