package TestCases;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class checkJunitAnnotationSequence
{
    @BeforeAll
    public static void checkbeforeAll()
    {
        System.out.println("Inside ...BeforeAll Annotated Method...");
    }
    @AfterAll
    public static void checkAfterAll()
    {
        System.out.println("Inside ...AfterAll Annotated Method...");
    }
    @Test() @Order(2)
    public void checkTesta()
    {
        System.out.println("Inside ...checkTest --> 1 Annotated Method...");
    }
    @Test() @Order(1)
    public void checkTest()
    {
        System.out.println("Inside ...checkTest --> 2 Annotated Method...");
    }
    @BeforeEach
    public void checkBeforeEach()
    {
        System.out.println("Inside ...checkBeforeEach Annotated Method...");
    }
}
