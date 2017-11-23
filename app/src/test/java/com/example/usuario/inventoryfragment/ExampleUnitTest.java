package com.example.usuario.inventoryfragment;

import com.example.usuario.inventoryfragment.pojo.User;
import com.example.usuario.inventoryfragment.db.repository.UserRepository;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import java.util.ArrayList;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <edtUser href="http://d.android.com/tools/testing">Testing documentation</edtUser>
 */
public class ExampleUnitTest {

    private ArrayList<User> users = new ArrayList<>();

    @Mock
    private UserRepository userRepository = mock(UserRepository.class);

    @Before
    public void initilize() {
        users.add(new User(1, "alfchaval", "Aa1.", "Alfonso Chamorro","alfchaval@hotmail.com", true, true));
        users.add(new User(1, "user1", "Uu1.", "User 1","user1@user.com", false, false));
        users.add(new User(1, "user2", "Uu2.", "User 2","user2@user.com", false, false));
    }

    //1. El usuario introduce un usuario (Instrumentales)

    //2. El usuario introudce una contraseña (Instrumentales)

    //3. El usuario existe en la base de datos (Repository)
    //Para realizar esta prueba se tienen que comparar dos objetos User
    @Test
    public void userExist_isCorrect() {
        //Cuando se llame al método isUserExist, devuelva un valor predeterminado.
        when(userRepository.userExist(users.get(0))).thenReturn(true);
        assertTrue(userRepository.userExist(users.get(0)));
    }

    @Test
    public void getUsers_isCorrect() {
        when(userRepository.getUsers()).thenReturn(users);
        assertEquals(users.get(0), userRepository.getUsers().get(0));
    }

    //4. Que la contraseña sea correcta (Repository)
    @Test
    public void signIn_isCorrect() throws Exception {

    }

    //1. El usuario introduce un usuario (Instrumentales)

    //2. El usuario introudce una contraseña (Instrumentales)

    //3. El usuario introduce un email (Instrumental)

    //4. la contraseña tiene al menos 6 caractéres

    //5. El no usuario existe en la base de datos (Repository)

    //6. El email no existe en la base de datos (Repository)


}