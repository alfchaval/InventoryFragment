package com.example.usuario.inventory;

import android.content.Context;
import android.support.annotation.StringRes;
import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withEffectiveVisibility;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.*;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <edtUser href="http://d.android.com/tools/testing">Testing documentation</edtUser>
 */
@RunWith(AndroidJUnit4.class)
public class LoginInstrumentedTest {

    /**
     * Comprueba que el usuario no esté vacío
     */
    @Test
    public void isUserEmpty(){
        onView(withId(R.id.btnSignUp)).perform(click());
        checkSnackBarDisplayByMessage(R.string.errorUserEmpty);
    }

    /**
     * Comprueba que el email no esté vacío
     */
    @Test
    public void isEmailEmpty(){
        onView(withId(R.id.btnSignUp)).perform(click());
        checkSnackBarDisplayByMessage(R.string.errorPasswordEmpty);
    }

    /**
     * Comprueba que el password no esté vacío
     */
    @Test
    public void isPasswordEmpty(){

    }

    /**
     * Comprueba la longitud del password
     */
    @Test
    public void passwordLength(){
        onView(withId(R.id.edtUser)).perform(typeText("alfchaval"),closeSoftKeyboard());
        onView(withId(R.id.edtPassword)).perform(typeText("fail"),closeSoftKeyboard());
        onView(withId(R.id.btnSignUp)).perform(click());
        checkSnackBarDisplayByMessage(R.string.errorPasswordLength);
    }

    /**
     * Comprueba que escribe el mismo password
     */
    @Test
    public void passwordDoubleCheck(){
        onView(withId(R.id.edtUser)).perform(typeText("alfchaval"),closeSoftKeyboard());
        onView(withId(R.id.edtPassword)).perform(typeText("Aa1111."),closeSoftKeyboard());
        //onView(withId(R.id.edtPassword2)).perform(typeText("Aa1111."),closeSoftKeyboard());
        onView(withId(R.id.btnSignUp)).perform(click());
        //checkSnackBarDisplayByMessage(R.string.errorPasswordDoubleCheck);
    }

    private void checkSnackBarDisplayByMessage(@StringRes int message) {
        onView(withText(message)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)));
    }
}
